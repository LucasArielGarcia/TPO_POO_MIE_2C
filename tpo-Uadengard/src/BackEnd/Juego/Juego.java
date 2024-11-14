package BackEnd.Juego;

import BackEnd.Configuracion.ConfiguracionJuego;
import BackEnd.Entidades.*;
import BackEnd.Entidades.objectView.*;

import java.util.List;

public class Juego {
    private Mapa mapa;
    private Heroe heroe;
    private ZonaDescanso zonaDescanso;
    private Ubicacion ubicacion;
    private Mision mision;
    private static Juego juego;
    private Mercader mercader;

    public Juego() {
        ConfiguracionJuego configuracionJuego = new ConfiguracionJuego();
        this.mapa = configuracionJuego.getMapa();
        this.zonaDescanso = configuracionJuego.getZonaDescanso();
        this.mercader = configuracionJuego.getMercader();
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


    public List<MisionView> mostrarMisionList(){
        return mapa.mostrarMisionList();
    }
    public MercaderView mostrarCatalogoMercaderItems(){
        return this.mercader.toView();
    }
    public ItemsMochilaView mostrarItemsMochila(){return this.heroe.itemsToView();}

    public void aceptarMision(int idMision){
        mapa.aceptarMision(idMision,this.heroe);
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
            ubicacion.pelea(this.heroe,opcion);
    }

    public String viajarUbicacion(int id){
        this.ubicacion = mapa.buscarUbicacion(id);
        mapa.viajarUbicacionMapa(this.ubicacion, this.heroe);
        return this.ubicacion != null ?  "nuestro heroe se encuentra en"+ this.ubicacion.getNombreUbicacion(): "No se encontro la ubicacion";
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


    public List<PersonajeView> estadisticasEnemigos(){
        return this.ubicacion.estadisticasEnemigos();
    }

    public void cerrarMision(){
        ubicacion.terminarMision();
    }

    public boolean reclamarRecompensa(){return zonaDescanso.reclamarRecompensa();}
    public List<String>abrirMochila(){return heroe.abrirMochila();}

    public PersonajeView mostrarEstadisticasHeroe(){
        return heroe.toView();
    }

    public boolean hayCofre(){
        return ubicacion.hayCofre();
    }

    public ItemView abrirCofre(){
        return ubicacion.abrirCofre();
    }


    public String mostrarRecompensa() {
        return heroe.mostrarRecompensa();
    }

    public MapaView getMapa(){
        return this.mapa.toView();
    }
    public UbicacionView getUbicacionActual(){return this.ubicacion.toView();}

    public void comprarItem(int idItem){
        this.zonaDescanso.comprarItem(idItem);
    }
}


