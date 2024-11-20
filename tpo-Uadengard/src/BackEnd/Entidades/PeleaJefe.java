package BackEnd.Entidades;

import BackEnd.Entidades.objectView.ItemView;

import java.util.ArrayList;
import java.util.List;

public class PeleaJefe extends Mision{
    private Items itemRequerido;

    public PeleaJefe(Items recompensa, String nombreMision,double moneda,Items itemRquerido,Enemigo jefe) {
        super(recompensa, nombreMision,null,moneda);
        this.itemRequerido = itemRquerido;
        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(jefe);
        cargarEnemigos(enemigos);
    }

    public boolean tieneItemRequerido(Heroe heroe) {
        ItemView itemView = itemRequerido.toView();
        return heroe.buscarItem(itemView.getIdItems()) != null;
    }

    @Override
    public void empezarMision(Heroe heroe) {
        ItemView itemView = itemRequerido.toView();
        if (heroe.buscarItem(itemView.getIdItems()) != null){
            heroe.equiparItem(itemView.getIdItems());
            Pelea pelea = new Pelea(heroe, super.getEnemigosList());
            super.emepezarPelea(pelea);
        }
        else {
            throw new RuntimeException("no tienes el item requerido");
        }


    }
}
