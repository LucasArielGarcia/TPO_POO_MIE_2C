package BackEnd.Entidades;

public class Ubicacion {
    private String nombreUbicacion;
    private Mision mision;
    private Enemigo enemigo;
    private Heroe heroe;

    public Ubicacion(String nombreUbicacion, Mision mision, Enemigo enemigo) {
        this.nombreUbicacion = nombreUbicacion;
        this.mision = mision;
        this.enemigo = enemigo;
    }
    public void llegadaUbicacion(Heroe heroe){
        this.heroe = heroe;
    }
    public void empezarMision(){

    }



}
