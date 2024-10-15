package BackEnd.Entidades;

import java.util.List;

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

    public void empezarMision(){
        if (this.mision != null) {
            this.mision.empezarMision(heroe);
        }
    }


   public void sacarPersonaje(){
        this.heroe = null;
   }
   public void terminarMision(){
        mision.marcarMisionCompletada();
        mision = null;
   }

   public String getNombreUbicacion(){
        return this.nombreUbicacion;
   }

   public boolean tengoMision(){
       return this.mision != null;
   }

   public Mision getMision(){
        return this.mision;
   }

   public boolean hayPelea(){
        return mision.existePelea();
   }

   public void pelea(Heroe heroe, int opcion){
        this.mision.peleaHeroe(heroe,opcion);
   }

   public List<String> estadisticasEnemigos(){
        return this.mision.mostrarEstadisticasEnemigos();
   }

}
