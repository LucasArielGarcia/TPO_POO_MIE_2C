package BackEnd.Entidades;

import java.util.List;

public class Ubicacion {
    private String nombreUbicacion;
    private Mision mision;
    private Enemigo enemigo;
    private Heroe heroe;
    private String urlImagen;

    public Ubicacion(String nombreUbicacion, Mision mision, String urlImagen) {
        this.nombreUbicacion = nombreUbicacion;
        this.mision = mision;
        this.urlImagen = urlImagen;
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

   public String mostrarEstadisticasHeroe(){return mision.mostrarEstadisticaHeroe();}

    public boolean hayCofre(){
        return mision.hayCofre();
    }

    public String abrirCofre(){
        return mision.abrirCofre(heroe);
    }

    public String getUrlImagen() {
        return urlImagen;
    }
}
