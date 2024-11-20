package BackEnd.Juego;

import BackEnd.Configuracion.ConfiguracionJuego;
import BackEnd.Entidades.*;
import BackEnd.Entidades.objectView.*;

import java.util.List;

public class Juego {
    private Mapa mapa;
    private Heroe heroe;
    private ZonaDescanso zonaDescanso;
    private Ubicacion ubicacionActual; 
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
        if (this.ubicacionActual.personajeSeEncuentra() && (this.ubicacionActual.tengoMision() && heroe.misionSonIguales(this.ubicacionActual.getMision()))){
            this.ubicacionActual.empezarMision();
        }
    }

    public boolean hayMision(){
        if (this.ubicacionActual.tengoMision() &&(this.ubicacionActual.tengoMision() && heroe.misionSonIguales(this.ubicacionActual.getMision()))) {
            empezarMision();
            return true;
        }
        else
            return false;
    }
    public boolean hayPelea(){
        return this.ubicacionActual.hayPelea();
    }

    public void pelea(int opcion){
        if (hayPelea())
        	ubicacionActual.pelea(this.heroe,opcion);
    }

    public String viajarUbicacion(int id){
        this.ubicacionActual = mapa.buscarUbicacion(id);
        mapa.viajarUbicacionMapa(this.ubicacionActual, this.heroe);
        return this.ubicacionActual != null ?  "nuestro heroe se encuentra en"+ this.ubicacionActual.getNombreUbicacion(): "No se encontro la ubicacion";
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
        return this.ubicacionActual.estadisticasEnemigos();
    }

    public void cerrarMision(){
    	ubicacionActual.terminarMision();
    }

    public ItemView reclamarRecompensa(){
        this.heroe.terminarMision();
        return zonaDescanso.reclamarRecompensa();
    }

    public List<ItemView>abrirMochila(){return heroe.abrirMochila();}

    public HeroeToview mostrarEstadisticasHeroe(){
        return heroe.toview();
    }

    public boolean hayCofre(){
        return ubicacionActual.hayCofre();
    }

    public ItemView abrirCofre(){
        return ubicacionActual.abrirCofre();
    }


    public String mostrarRecompensa() {
        return heroe.mostrarRecompensa();
    }

    public MapaView getMapa(){
        return this.mapa.toView();
    }
    public UbicacionView getUbicacionActual(){return this.ubicacionActual.toView();}

    public void comprarItem(int idItem){
        this.zonaDescanso.comprarItem(idItem);
    }
    public boolean venderItem(int idItem){return this.zonaDescanso.venderItem(idItem);}
    public List<ItemView> mostrarEquipoHeroe(){return this.heroe.mostrarEquipo();}
    public boolean equiparItem(int idItem){return this.heroe.equiparItem(idItem);}
}


