package BackEnd.Juego;

import BackEnd.Configuracion.ConfiguracionJuego;
import BackEnd.Entidades.*;
import BackEnd.Entidades.objectView.MapaView;

import java.util.List;

public class Juego {
    private Mapa mapa;
    private Heroe heroe;
    private ZonaDescanso zonaDescanso;
    private Ubicacion ubicacion;
    private Mision mision;
    private static Juego juego;

    public Juego() {
        ConfiguracionJuego configuracionJuego = new ConfiguracionJuego();
        this.mapa = configuracionJuego.getMapa();
        this.zonaDescanso = configuracionJuego.getZonaDescanso();
    }
    public static Juego getInstancia(){
        if (juego == null)
            return juego = new Juego();
        return juego;
    }

    public void crearHeroe(int tipoHeroe, String nombre) {

        if (tipoHeroe == 1) {
            this.heroe = new Guerrero(nombre);
        } else if (tipoHeroe == 2) {
            this.heroe = new Arquero(nombre);
        } else if (tipoHeroe == 3) {
            this.heroe = new Mago(nombre);
        } else {
            System.out.println("Tipo de héroe no válido.");
        }

    }
    public boolean heroejeVivo(){
        return this.heroe.personajeVivo();
    }


    public List<Mision> mostrarMisionList(){
        return mapa.mostrarMisionList();
    }
    public List<Items> mostrarCatalogoMercaderItems(){
        return mapa.mostrarItems() ;
    }

    public void aceptarMision(int opcion){
        mapa.aceptarMision(opcion,this.heroe);
    }




    private void empezarMision(){
        if (this.ubicacion.personajeSeEncuentra() && (this.ubicacion.tengoMision() && heroe.misionSonIguales(this.ubicacion.getMision()))){
            this.ubicacion.empezarMision();
        }
    }

    public boolean hayMision(){
        if (this.ubicacion.tengoMision() &&(this.ubicacion.tengoMision() && heroe.misionSonIguales(this.ubicacion.getMision()))) {
            empezarMision();
            return true;
        }
        else
            return false;
    }
    public boolean hayPelea(){
        return this.ubicacion.hayPelea();
    }

    public void pelea(int opcion){
        if (hayPelea())
            ubicacion.pelea(heroe,opcion);
    }

    public String viajarUbicacion(int id){
        Ubicacion ubicacionViajar = mapa.buscarUbicacion(id);
        mapa.viajarUbicacionMapa(ubicacionViajar, this.heroe);
        return ubicacionViajar != null ?  "nuestro heroe se encuentra en"+ ubicacion.getNombreUbicacion(): "No se encontro la ubicacion";
    }



    public void viajarZonaDescanso(){
        Ubicacion ubicacion = this.mapa.ubicacionPersonaje();
        if (ubicacion != null)
            ubicacion.sacarPersonaje();
        this.zonaDescanso.llegarZonaDescanso(this.heroe);
    }

    public boolean jugadorEstaEnZonaDescanso(){
        return zonaDescanso.personajeEstaEnzona();
    }
    public void jugadorSaleZonaDescanso(){
         zonaDescanso.salirZonaDescanso();
    }

    public MapaView abrirMapa(){
        return this.mapa.toView();
    }


    public void comprarItem(){

    }
    public List<String> estadisticasEnemigos(){
        return this.ubicacion.estadisticasEnemigos();
    }

    public void cerrarMision(){
        ubicacion.terminarMision();
    }

    public boolean reclamarRecompensa(){return zonaDescanso.reclamarRecompensa();}
    public List<String>abrirMochila(){return heroe.abrirMochila();}

    public String mostrarEstadisticasHeroe(){
        return heroe.mostrarEstadistica();
    }

    public boolean hayCofre(){
        return ubicacion.hayCofre();
    }

    public String abrirCofre(){
        return ubicacion.abrirCofre();
    }


    public String mostrarRecompensa() {
        return heroe.mostrarRecompensa();
    }

    public MapaView getMapa(){
        return this.mapa.toView();
    }
}


