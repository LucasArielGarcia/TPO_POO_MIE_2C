package FrontEnd.Controlador;

import BackEnd.Entidades.Items;
import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.*;
import BackEnd.Juego.Juego;

import java.util.List;

public class ControladorFront {

    private static ControladorFront controladorFront;
    public void crearPersonaje(String nombre, String tipoHeroe){
        int tipo;
        if (tipoHeroe.equals("Guerrero")){tipo = 1;}
        else if (tipoHeroe.equals("Arquero")) {tipo = 2;}
        else {tipo = 3;}
        Juego.getInstancia().crearHeroe(tipo,nombre);
    }

    public static ControladorFront getinstancia() {
        if (controladorFront == null)
            controladorFront = new ControladorFront();
        return controladorFront;
    }

    public MapaView abrirMapa(){
        return Juego.getInstancia().getMapa();
    }

    public boolean hayMision(){
        return Juego.getInstancia().hayMision();
    }

    public void viajarUbicacion(int idUbicacion){
        Juego.getInstancia().viajarUbicacion(idUbicacion);
    }

    public List<MisionView> getMisiones(){
        return Juego.getInstancia().mostrarMisionList();
    }

    public void aceptarMision(int idMision){
        Juego.getInstancia().aceptarMision(idMision);
    }

    public boolean existeUnaPelea(){
        return Juego.getInstancia().hayPelea();
    }

    public PersonajeView getHeroe(){
        return Juego.getInstancia().mostrarEstadisticasHeroe();
    }

    public List<PersonajeView> getEnemigos(){
        return Juego.getInstancia().estadisticasEnemigos();
    }

    public void atacarEnemigo(int idEnemigo){
        Juego.getInstancia().pelea(idEnemigo);
    }

    public MercaderView getItems() {
    	return Juego.getInstancia().mostrarCatalogoMercaderItems();
    }

    public ItemsMochilaView getItemsMochila(){ return Juego.getInstancia().mostrarItemsMochila();}
    
    public UbicacionView getUbicacionActual() {
        return Juego.getInstancia().getUbicacionActual();
    }

    public boolean existeCofre(){
        return Juego.getInstancia().hayCofre();
    }

    public ItemView abrirCofre(){
        return Juego.getInstancia().abrirCofre();
    }

    public void viajarZonaDescanso(){
        Juego.getInstancia().viajarZonaDescanso();
    }

    public void terminarMision(){
        Juego.getInstancia().cerrarMision();
    }

}
