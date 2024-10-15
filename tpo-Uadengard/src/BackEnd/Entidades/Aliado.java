package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Aliado {
    private List<Mision> misionList = new ArrayList<>();

    public Aliado(List<Mision> misionList) {
        this.misionList = misionList;
    }

    public List<Mision> misionList (){
        return this.misionList;
    }

    public Items reclamarRecompensa(Mision mision){
        if (mision.misionCompleta()){
            return mision.darRecompensa();
        }
        else {
            System.out.println("No se completo la mision");
            return null;
        }
    }

    public void aceptarMision(Heroe heroe, int opcion){
        heroe.aceptarMision(misionList().get(opcion));
        misionList.remove(opcion);
    }

}
