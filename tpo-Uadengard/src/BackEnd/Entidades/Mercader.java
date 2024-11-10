package BackEnd.Entidades;

import java.util.ArrayList;

import java.util.List;

import BackEnd.Entidades.objectView.MercaderView;

public class Mercader {
    private List<Items> itemVenta = new ArrayList<>();
    public List<Items> mostrarCatologoItems(){
        return this.itemVenta;
    }

    public Mercader(List<Items> itemVenta) {
        this.itemVenta = itemVenta;
    }
    public MercaderView toView(){
        return new MercaderView(this.itemVenta);
    }
    
}
