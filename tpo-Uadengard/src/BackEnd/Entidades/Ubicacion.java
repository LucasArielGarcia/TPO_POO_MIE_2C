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
    public boolean personajeSeEncuentra(){
        return this.heroe != null;
    }

    public void empezarMision(){
        if (mision != null)
            mision.empezarMision(heroe);
        System.out.println("No hay mision");
    }

   public void sacarPersonaje(){
        this.heroe = null;
   }
   public void terminarMision(){
        mision = null;
   }



}
