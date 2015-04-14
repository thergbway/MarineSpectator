package marine_ships_mvc;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import marine_ships_mvc.dto.Ship;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.util.List;

public class MarineShipsView extends BorderPane {
    private final MarineShipsModel model;
    private final WebView webView = new WebView();
    private final WebEngine webEngine = webView.getEngine();

    MarineShipsView(MarineShipsModel model) {
        this.model = model;
        try {
            webEngine.loadContent(IOUtils.toString(getClass().getResourceAsStream("/gmap.html")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        setCenter(webView);

        webView.getEngine().setOnAlert(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> event) {
                Stage popup = new Stage();
                popup.initStyle(StageStyle.UTILITY);
                popup.initModality(Modality.WINDOW_MODAL);

                StackPane content = new StackPane();
                content.getChildren().setAll(
                        new Label(event.getData())
                );
                content.setPrefSize(200, 100);

                popup.setScene(new Scene(content));
                popup.showAndWait();
            }
        });

        addBindings();
    }

    private void addBindings() {
        model.getShipListProperty().addListener((observable, oldValue, newValue) -> {
            updateShipMarkers(newValue);
        });
    }

    private void updateShipMarkers(List<Ship> ships) {
        StringBuilder sb = new StringBuilder();
        sb.append("window.showAllShips([");
        for (int i = 0; i < ships.size(); i++) {
            Ship ship = ships.get(i);
            sb.append(shipToJSInitializationString(ship));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("])");
        webEngine.executeScript(sb.toString());
    }

    private String shipToJSInitializationString(Ship ship) {
        return "new Ship(\"" +
                ship.getName() + "\"," +
                ship.getMmsi() + "," +
                ship.getLatitude() + "," +
                ship.getLongitude() + "," +
                ship.getSpeed() + "," +
                ship.getAngle() + "," +
                ship.getDatetime() +
                ")";
    }
}
