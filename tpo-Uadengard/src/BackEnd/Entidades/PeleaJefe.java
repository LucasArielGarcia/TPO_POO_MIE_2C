package BackEnd.Entidades;

public class PeleaJefe extends Mision{


    public PeleaJefe(Items recompensa, String nombreMision,double moneda) {
        super(recompensa, nombreMision,null,moneda);
    }

    @Override
    public void empezarMision(Heroe heroe) {

    }
}
