package BackEnd.Entidades.objectView;

import BackEnd.Entidades.Enemigo;
import BackEnd.Entidades.Items;
import BackEnd.Entidades.Pelea;

import java.util.List;

public class MisionView {
    private int idMision;
    private String nombreMision;
    private double monedasAdar;


    public MisionView(int idMision, String nombreMision,double monedasAdar) {
        this.idMision = idMision;
        this.nombreMision = nombreMision;
        this.monedasAdar = monedasAdar;
    }

    public int getIdMision() {
        return idMision;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public double getMonedasAdar() {
        return monedasAdar;
    }
}
