package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe extends Personaje{
    private List<Items> mochilaItems = new ArrayList<>();
    private List<Items> equipoItems = new ArrayList<>();
    private int nivelHeroe;
    private String nombre;
    public abstract void curarse();
}
