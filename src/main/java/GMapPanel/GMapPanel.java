package GMapPanel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class GMapPanel extends Application {

    @Override
    public void start(Stage stage) {
        // create web engine and view
        final WebView webView = new WebView();
        final WebEngine webEngine = webView.getEngine();
        try {
            webEngine.loadContent(IOUtils.toString(getClass().getResourceAsStream("/gmap.html")));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        // create scene
        stage.setTitle("Web Map");
        Scene scene = new Scene(webView, 1000, 700, Color.web("#666970"));
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
