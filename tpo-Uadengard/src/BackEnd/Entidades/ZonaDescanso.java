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


}
