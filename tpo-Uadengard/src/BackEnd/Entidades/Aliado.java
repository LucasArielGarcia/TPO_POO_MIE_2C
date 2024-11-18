package BackEnd.Entidades;

import BackEnd.Entidades.objectView.MisionView;

import java.util.ArrayList;
import java.util.List;

public class Aliado {
    private List<Mision> misionList = new ArrayList<>();
    private Mision misionAceptadas ;

    public Aliado(List<Mision> misionList) {
        this.misionList = misionList;
    }

    public List<MisionView> misionList (){
        List<MisionView> misionViewList = new ArrayList<>();
        for (Mision mision: misionList){
            misionViewList.add(mision.toView());
        }
        return misionViewList;
    }

    public Items reclamarRecompensa(Mision mision){
        return mision.misionCompleta() ? mision.darRecompensa(): null; // es un if despues del "?" retornaria si el if es true y despues del ":" si es false
    }

    public void aceptarMision(Heroe heroe, int idMision){
        Mision misionAceptar = buscarMision(idMision);
        heroe.aceptarMision(misionAceptar);
        misionAceptadas = misionAceptar;
        borrarMision(idMision);
    }

    public Items reclamarRecompensa(){
        try {
            if (misionAceptadas.misionCompleta()){
                Items recompensa = misionAceptadas.darRecompensa();
                misionAceptadas = null;
                return recompensa;
            }
            return null;
        }catch (NullPointerException e){
            System.out.println("No hay mision aceptada");
            return null;
        }

    }

    public Mision buscarMision(int idMision){
        for (Mision mision: this.misionList){
            if(mision.soyMision(idMision))
                return mision;
        }
        return null;
    }

    public void borrarMision(int idMision){
        for (int i = 0; i<= misionList.size() -1 ;i++){
            if(misionList.get(i).soyMision(idMision))
                this.misionList.remove(i);
        }

    }

}
