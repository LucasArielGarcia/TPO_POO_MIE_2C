package BackEnd.Entidades;

import java.util.List;

public class LimpiarUbicacion extends Mision {


    public LimpiarUbicacion(Items recompensa, String nombreMision,Items cofre) {
        super(recompensa, nombreMision, cofre);
    }

    @Override
    public void empezarMision(Heroe heroe) {
        if (super.hayEnemigos()){
            Pelea pelea = new Pelea(heroe, super.getEnemigosList());
            super.emepezarPelea(pelea);
        }
        else {
            System.out.println("Donde estan los enemigos...");
        }
    }
}
