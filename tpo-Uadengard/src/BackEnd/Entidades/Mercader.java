package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Mercader {
    private List<Items> itemVenta = new ArrayList<>();
    public List<Items> mostrarCatologoItems(){
        return this.itemVenta;
    }

    public Mercader(List<Items> itemVenta) {
        this.itemVenta = itemVenta;
    }
}
