package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Aliado {
    private List<Mision> misionList = new ArrayList<>();
    private Mision misionAceptadas ;

    public Aliado(List<Mision> misionList) {
        this.misionList = misionList;
    }

    public List<Mision> misionList (){
        return this.misionList;
    }

    public Items reclamarRecompensa(Mision mision){
        return mision.misionCompleta() ? mision.darRecompensa(): null; // es un if despues del "?" retornaria si el if es true y despues del ":" si es false
    }

    public void aceptarMision(Heroe heroe, int opcion){
        heroe.aceptarMision(misionList().get(opcion));
        misionAceptadas = misionList.get(opcion);
        misionList.remove(opcion);
    }

    public Items reclamarRecompensa(){
        if (misionAceptadas.misionCompleta()){
            Items recompensa = misionAceptadas.darRecompensa();
            misionAceptadas = null;
            return recompensa;
        }
        return null;
    }

}
