package BackEnd.Entidades;

public class Mision {
    private Items recompensa;
    private String nombreMision;
    private Ubicacion ubicacion;
    private Objetivo objetivo;
    private Pelea pelea;

    public Mision(Items recompensa, String nombreMision, Ubicacion ubicacion, Objetivo objetivo) {
        this.recompensa = recompensa;
        this.nombreMision = nombreMision;
        this.ubicacion = ubicacion;
        this.objetivo = objetivo;
    }

    public void empezarMision(Heroe heroe, Enemigo enemigo){
        if (ubicacion.hayEnemigos()){
            pelea = new Pelea(heroe,enemigo);
            pelea.peleaPersonajes();
            if (heroe.personajeVivo()){
                heroe.agregarItemMochila(this.recompensa);
            }
        } else if (this.recompensa != null) {
            heroe.agregarItemMochila(recompensa);
        } else{
            throw new RuntimeException("No hay ningun enemigo o objeto para agarrar");
        }

    }



}
