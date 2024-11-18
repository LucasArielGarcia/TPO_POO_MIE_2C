package BackEnd.Entidades;

import java.util.ArrayList;

import java.util.List;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.MercaderView;

public class Mercader {
    private List<Items> itemVenta = new ArrayList<>();
    
    public Mercader(List<Items> itemVenta) {
        this.itemVenta = itemVenta;
    }
    
    public List<Items> mostrarCatologoItems(){
        return this.itemVenta;
    }
    public MercaderView toView(){
        return new MercaderView(this.itemVenta);
    }

    public Items comprarItem(int idItem, double monedas){
        Items items = buscarItem(idItem);
        ItemView itemView = items.toView();
        if (items != null){
            if (itemView.getPrecio() <= monedas){
                eliminarItemStock(idItem);
                return items;
            }
            throw new IllegalArgumentException("Error: El item con ID " + idItem + " no tienes suficientes monedas.");
        }
        throw new IllegalArgumentException("Error: El item con ID " + idItem + " no existe.");
    }
    public Items buscarItem(int idItem){
        for (Items items : itemVenta){
            if(items.sosItem(idItem)) {
                return items;
            }
        }
        return null;
    }

    public void eliminarItemStock(int idItem){
        for (int i = 0; i<this.itemVenta.size();i++){
            if(itemVenta.get(i).sosItem(idItem))
                itemVenta.remove(i);
        }
    }
    
}
