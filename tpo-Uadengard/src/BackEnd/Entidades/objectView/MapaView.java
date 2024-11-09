package BackEnd.Entidades.objectView;

import BackEnd.Entidades.Ubicacion;

import java.util.List;

public class MapaView {
    private List<UbicacionView> ubicacionListView;

    public MapaView(List<UbicacionView> ubicacionListView) {
        this.ubicacionListView = ubicacionListView;
    }

    public List<UbicacionView> getUbicacionListView() {
        return ubicacionListView;
    }
}
