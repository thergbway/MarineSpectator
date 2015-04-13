package marine_ships_mvc.view;

import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

class MarineShipsView extends Region {
    private final WebView webView = new WebView();
    private final WebEngine webEngine = webView.getEngine();
}
