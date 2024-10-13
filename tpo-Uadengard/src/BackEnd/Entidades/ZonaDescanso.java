package BackEnd.Entidades;

import java.util.List;

public class ZonaDescanso {
    private Mercader mercader;
    private Aliado aliado;
    private Heroe heroe;
    public List<Items> mostrarCatologoItems(){
        return mercader.mostrarCatologoItems();
    }
    public List<Mision> mostrarMisionesList(){
        return aliado.misionList();
    }

    public void reclamarRecompensa(Mision mision){
        if (mision instanceof LimpiarUbicacion){
            heroe.agregarItemMochila(aliado.reclamarRecompensa(mision));
            System.out.println("Se reclamo la recompensa");
        } else if (mision instanceof DevolverItem) {

        }

    }


}
