package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe extends Personaje{
    private List<Items> mochilaItems = new ArrayList<>();
    private List<Items> equipoItems = new ArrayList<>();
    private int nivelHeroe;
    private Mision mision;


    public Heroe(String nombre, int defensa,String tipo) {
        super(nombre, defensa,tipo);
        this.nivelHeroe = 1;
    }
    public void equiparItem(Items itemEquipar){
        equipoItems.add(itemEquipar);
        super.usarItem(itemEquipar);
    }
    public abstract void atacar(Personaje personajeAtacar);
    public void aceptarMision(Mision mision){
        this.mision = mision;
    }
    public void terminarMision(){
        this.mision = null;
    }
    public void agregarItemMochila(Items itemNuevo){
        mochilaItems.add(itemNuevo);
    }
    

    public boolean misionSonIguales(Mision misionComparar){
        return this.mision == misionComparar;
    }
    public abstract void curarse();


    public List<String> abrirMochila(){
        List<String> mochilaReturn = new ArrayList<>();
        for (Items item: mochilaItems){
            String itemString = item.infoItem();
            mochilaReturn.add(itemString);
        }
        return mochilaReturn;
    }


    public void devolverItem(){
        mochilaItems.forEach(items -> {

        });
    }




}
