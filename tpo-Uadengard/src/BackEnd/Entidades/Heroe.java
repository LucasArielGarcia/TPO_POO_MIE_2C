package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe extends Personaje{
    private List<Items> mochilaItems = new ArrayList<>();
    private List<Items> equipoItems = new ArrayList<>();
    private int nivelHeroe;


    public Heroe(String nombre, int defensa) {
        super(nombre, defensa);
        this.mochilaItems = null;
        this.equipoItems = null;
        this.nivelHeroe = 1;
    }

    public abstract void curarse();


}
