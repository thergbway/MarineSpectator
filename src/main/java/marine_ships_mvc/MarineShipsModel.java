package marine_ships_mvc;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import marine_ships_mvc.dto.Ship;

import java.util.LinkedList;
import java.util.List;

public class MarineShipsModel {
    private final ListProperty<Ship> shipListProperty =
            new SimpleListProperty<>(new ObservableListWrapper<>(new LinkedList<>()));

    ListProperty<Ship> getShipListProperty() {
        return shipListProperty;
    }

    public List<Ship> getShipList() {
        return shipListProperty;
    }
}