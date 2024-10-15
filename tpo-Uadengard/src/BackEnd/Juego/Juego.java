package BackEnd.Juego;

import BackEnd.Entidades.*;

import java.util.List;

public class Juego {
    Mapa mapa;
    Heroe heroe;
    ZonaDescanso zonaDescanso;

    public Juego(Mapa mapa, ZonaDescanso zonaDescanso) {
        this.mapa = mapa;
        this.zonaDescanso = zonaDescanso;
    }

    public Heroe crearHeroe(int tipoHeroe, String nombre){
        switch (tipoHeroe){
            case 1:
                heroe = new Guerrero(nombre);
                break;
            case 2:
                heroe = new Arquero(nombre);
                break;
            case 3:
                heroe = new Mago(nombre);
                break;
            default:
                System.out.println("Tipo de héroe no válido.");
        }

        return heroe;
    }


    public List<Mision> mostrarMisionList(){
        return mapa.mostrarMisionList();
    }
    public List<Items> mostrarCatalogoMercaderItems(){
        return mapa.mostrarItems() ;
    }

    public void aceptarMision(int opcion, Heroe heroe){
        mapa.aceptarMision(opcion,heroe);
    }




    public void hacerMision(Ubicacion ubicacion){

        if (ubicacion.personajeSeEncuentra())
            ubicacion.empezarMision();
    }

    public Ubicacion viajarUbicacion(int opcion, Heroe heroe){
        return mapa.viajarUbicacionMapa(opcion, heroe);
    }

    public void viajarZonaDescanso(Mapa mapa, ZonaDescanso zonaDescanso){
        Ubicacion ubicacion = mapa.ubicacionPersonaje();
        if (ubicacion != null)
            ubicacion.sacarPersonaje();
        zonaDescanso.llegarZonaDescanso(heroe);
    }

    public List<Ubicacion> abrirMapa(){
        return mapa.abrirMapa();
    }

    public void comprarItem(){

    }




}
