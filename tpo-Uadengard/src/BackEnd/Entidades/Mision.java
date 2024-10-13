package BackEnd.Entidades;

public abstract class Mision {
    private Items recompensa;
    private String nombreMision;
    private Ubicacion ubicacion;
    private boolean objetivoCompletado;
    private Pelea pelea;

    public Mision(Items recompensa, String nombreMision, Ubicacion ubicacion) {
        this.recompensa = recompensa;
        this.nombreMision = nombreMision;
        this.ubicacion = ubicacion;
        this.objetivoCompletado = false;
    }

    public abstract void empezarMision(Heroe heroe);

    /*
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
    */


    public void marcarMisionCompletada(){
        this.objetivoCompletado = true;
    }

    public boolean misionCompleta(){
        return this.objetivoCompletado == true;
    }

    public Items darRecompensa(){
        return this.recompensa;
    }

}
