import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import marine_ships_mvc.MarineShipsMVC;
import marine_ships_mvc.MarineShipsModel;
import marine_ships_mvc.MarineShipsView;
import marine_ships_mvc.dto.Ship;
import org.omg.CORBA.DoubleHolder;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    private final MarineShipsMVC marineShipsMVC = new MarineShipsMVC();

    @Override
    public void start(Stage stage) {
        MarineShipsView marineShipsView = marineShipsMVC.getView();
        MarineShipsModel marineShipsModel = marineShipsMVC.getModel();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        marineShipsModel.getShipList().add(new Ship("A", 3456356L, 54.77, 13.94721, 12.0, 44.0, 65165L));
                        marineShipsModel.getShipList().add(new Ship("B", 3456356L, 54.47, 13.94721, 12.0, 44.0, 65165L));
                        marineShipsModel.getShipList().add(new Ship("C", 3456356L, 54.27, 13.97721, 12.0, 44.0, 65165L));
                        marineShipsModel.getShipList().add(new Ship("D", 3456356L, 54.77, 13.90721, 12.0, 44.0, 65165L));
                        marineShipsModel.getShipList().add(new Ship("E", 3456356L, 54.67, 13.90721, 12.0, 44.0, 65165L));
                    }
                });
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final AtomicInteger val = new AtomicInteger(0);
                while (true) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    val.addAndGet(15);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(val.doubleValue()/1000.0);
                            marineShipsModel.getShipList().remove(marineShipsModel.getShipList().size() - 1);
                            marineShipsModel.getShipList().add(new Ship("WOW", 3456356L, 54.77 + val.doubleValue()/1000.0, 13.94721, 12.0, 44.0, 65165L));
                        }
                    });
                }
            }
        }).start();

        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(marineShipsView, 1000, 700, Color.web("#666970"));
        stage.setScene(scene);
        // show stage
        stage.show();
    }

    static { // use system proxy settings when standalone application
        System.setProperty("java.net.useSystemProxies", "true");
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
