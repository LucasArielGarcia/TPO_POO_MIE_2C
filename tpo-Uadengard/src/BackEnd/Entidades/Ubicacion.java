package BackEnd.Entidades;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.PersonajeView;
import BackEnd.Entidades.objectView.UbicacionView;

import java.util.List;

public class Ubicacion {
    private int idUbicacion;
    private static int contador = 0;
    private String nombreUbicacion;
    private Mision mision;
    private Enemigo enemigo;
    private Heroe heroe;
    private String urlImagen;

    public Ubicacion(String nombreUbicacion, Mision mision, String urlImagen) {
        this.idUbicacion = ++contador;
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

   public List<PersonajeView> estadisticasEnemigos(){
        return this.mision.mostrarEstadisticasEnemigos();
   }

   public String mostrarEstadisticasHeroe(){return mision.mostrarEstadisticaHeroe();}

    public boolean hayCofre(){
        return mision.hayCofre();
    }

    public ItemView abrirCofre(){
        return mision.abrirCofre(heroe);
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public UbicacionView toView (){
        return new UbicacionView (this.nombreUbicacion,this.urlImagen,this.idUbicacion);
    }

    public boolean soyUbicacion(int idUbicacion){
        return this.idUbicacion == idUbicacion;
    }
}
