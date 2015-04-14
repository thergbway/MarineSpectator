package marine_ships_mvc;

public class MarineShipsMVC {
    private final MarineShipsModel model = new MarineShipsModel();
    private final MarineShipsView view = new MarineShipsView(model);

    public MarineShipsModel getModel() {
        return model;
    }

    public MarineShipsView getView() {
        return view;
    }
}