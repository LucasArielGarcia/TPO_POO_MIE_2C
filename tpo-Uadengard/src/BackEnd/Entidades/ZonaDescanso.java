package BackEnd.Entidades;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.MisionView;

import java.util.List;

public class ZonaDescanso {
    private Mercader mercader;
    private Aliado aliado;
    private Heroe heroe;
    public List<Items> mostrarCatologoItems(){
        return mercader.mostrarCatologoItems();
    }
    public List<MisionView> mostrarMisionesList(){
        return aliado.misionList();
    }

    public void reclamarRecompensa(Mision mision){
        if (mision instanceof LimpiarUbicacion){
            heroe.agregarItemMochila(aliado.reclamarRecompensa(mision));
            System.out.println("Se reclamo la recompensa");
        } else if (mision instanceof DevolverItem) {
            Items items = ((DevolverItem) mision).getItemsDevuelta();

        }
    }

    public void llegarZonaDescanso(Heroe heroe){
        this.heroe = heroe;
    }
    public void salirZonaDescanso(){this.heroe = null;}


    public ZonaDescanso(Mercader mercader, Aliado aliado) {
        this.mercader = mercader;
        this.aliado = aliado;
    }
    public boolean personajeEstaEnzona(){
        return this.heroe != null;
    }

    public void aceptarMision(int idMision, Heroe heroe){
        aliado.aceptarMision(heroe, idMision);
    }


    public ItemView reclamarRecompensa(){
        Items recompensa = aliado.reclamarRecompensa();
        if (recompensa != null) {
            heroe.agregarItemMochila(recompensa);
            return recompensa.toView();
        }
        return null;
    }

    public void comprarItem(int idItem){
        Items itemComprado = this.mercader.comprarItem(idItem,this.heroe.getMonedas());
        if (itemComprado != null){
            ItemView itemView = itemComprado.toView();
            this.heroe.descontarMonedasCompra(itemView.getPrecio());
            this.heroe.agregarItemMochila(itemComprado);
        }
    }

    public boolean venderItem(int idItem){
        return this.heroe.venderItem(idItem);
    }

}
