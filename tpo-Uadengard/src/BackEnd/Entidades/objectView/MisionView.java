package BackEnd.Entidades.objectView;

import BackEnd.Entidades.Enemigo;
import BackEnd.Entidades.Items;
import BackEnd.Entidades.Pelea;

import java.util.List;

public class MisionView {
    private int idMision;
    private String nombreMision;

    public MisionView(int idMision, String nombreMision) {
        this.idMision = idMision;
        this.nombreMision = nombreMision;
    }

    public int getIdMision() {
        return idMision;
    }

    public String getNombreMision() {
        return nombreMision;
    }
}
