package BackEnd.Entidades;

public class PeleaJefe extends Mision{


    public PeleaJefe(Items recompensa, String nombreMision) {
        super(recompensa, nombreMision,null);
    }

    @Override
    public void empezarMision(Heroe heroe) {

    }
}
