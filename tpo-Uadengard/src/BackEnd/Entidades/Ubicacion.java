package BackEnd.Entidades;

public class Ubicacion {
    private String nombreUbicacion;
    private Mision mision;
    private Enemigo enemigo;
    private Heroe heroe;

    public Ubicacion(String nombreUbicacion, Mision mision) {
        this.nombreUbicacion = nombreUbicacion;
        this.mision = mision;
    }
    public void llegadaUbicacion(Heroe heroe){
        this.heroe = heroe;
    }
    public boolean personajeSeEncuentra(){
        return this.heroe != null;
    }

    public Mision empezarMision(){
        if (this.mision != null) {
            this.mision.empezarMision(heroe);
            return this.mision;
        }
        return null;
    }


   public void sacarPersonaje(){
        this.heroe = null;
   }
   public void terminarMision(){
        mision = null;
   }

   public String getNombreUbicacion(){
        return this.nombreUbicacion;
   }

   public boolean tengoMision(){
       return this.mision != null;
   }

}
