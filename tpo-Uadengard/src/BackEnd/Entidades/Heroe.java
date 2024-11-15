package BackEnd.Entidades;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.ItemsMochilaView;
import BackEnd.Entidades.objectView.MisionView;

import java.util.ArrayList;
import java.util.List;

public abstract class Heroe extends Personaje{
    private List<Items> mochilaItems = new ArrayList<>();
    private List<Items> equipoItems = new ArrayList<>();
    private int nivelHeroe;
    private Mision mision;
    private double monedas;


    public Heroe(String nombre, int defensa,String tipo) {
        super(nombre, defensa,tipo);
        this.nivelHeroe = 1;
        this.monedas= 1;
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
        nivelHeroe += 0.25; //Aumento de experiencia por cada vez que toma un nuevo ítem.
    }
    

    public boolean misionSonIguales(Mision misionComparar){
        return this.mision == misionComparar;
    }
    public abstract void curarse();


    public List<ItemView> abrirMochila(){
        List<ItemView> mochilaReturn = new ArrayList<>();
        for (Items item: mochilaItems){
            mochilaReturn.add(item.toView());
        }
        return mochilaReturn;
    }


    public void devolverItem(){
        mochilaItems.forEach(items -> {

        });
    }

    public ItemsMochilaView itemsToView(){
         return new ItemsMochilaView(this.mochilaItems);
    }


    public String mostrarRecompensa() {
        return "La recompensa es: "+mochilaItems.get(mochilaItems.size()-1).infoItem();
    }

    public void recompensaMonedas(double monedasRecompensa){
        this.monedas = monedasRecompensa;
    }

    public double getMonedas() {
        return monedas;
    }

    public void descontarMonedasCompra(double monedas){
        this.monedas -= monedas;
    }
}
