package BackEnd.Entidades;

import java.util.List;

public class LimpiarUbicacion extends Mision {
    private List<Enemigo> enemigosList;

    public LimpiarUbicacion(Items recompensa, String nombreMision, Ubicacion ubicacion, List<Enemigo> enemigosList) {
        super(recompensa, nombreMision, ubicacion);
        this.enemigosList = enemigosList;
    }

    @Override
    public void empezarMision(Heroe heroe) {
        enemigosList.forEach(enemigo -> {
            Pelea pelea = new Pelea(heroe, enemigo);
            pelea.peleaPersonajes();
        });
        if (heroe.personajeVivo()){
            super.marcarMisionCompletada();
        }
    }

}
