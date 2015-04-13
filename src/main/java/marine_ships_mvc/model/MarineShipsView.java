package marine_ships_mvc.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

class MarineShipsModel {
    public DoubleProperty leftUpLat = new SimpleDoubleProperty(37.34822);
    public DoubleProperty leftUpLng = new SimpleDoubleProperty(-121.9143936);
    public DoubleProperty rightDownLat = new SimpleDoubleProperty(37.39999);
    public DoubleProperty rightDownLng = new SimpleDoubleProperty(-121.9943936);
}
