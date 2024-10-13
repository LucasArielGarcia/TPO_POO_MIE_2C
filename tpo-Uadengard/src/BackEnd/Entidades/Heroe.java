package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe extends Personaje{
    private List<Items> mochilaItems = new ArrayList<>();
    private List<Items> equipoItems = new ArrayList<>();
    private int nivelHeroe;
    private Mision mision;


    public Heroe(String nombre, int defensa) {
        super(nombre, defensa);
        this.mochilaItems = null;
        this.equipoItems = null;
        this.nivelHeroe = 1;
    }
    public void aceptarMision(Mision mision){
        this.mision = mision;
    }
    public void terminarMision(){
        this.mision = null;
    }
    public void agregarItemMochila(Items itemNuevo){
        mochilaItems.add(itemNuevo);
    }


    public boolean tengoMision(){
        return this.mision == null;
    }

    public abstract void curarse();

    public void sacarItem(){

    }




}
