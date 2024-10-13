package BackEnd.Juego;

import BackEnd.Entidades.*;

import java.util.List;

public class Juego {
    Mapa mapa;
    Heroe heroe;

    public void crearHeroe(String tipoHeroe, String nombre){
        switch (tipoHeroe){
            case "Guerrero": heroe = new Guerrero(nombre);
            case "Arquero": heroe = new Arquero(nombre);
            case "Mago": heroe= new Mago(nombre);
        }
    }

    public List<Mision> mostrarMisionList(){
        return mapa.mostrarMisionList();
    }
    public List<Items> mostrarItems(){
        return mapa.mostrarItems() ;
    }

    public void aceptarMision(Mision mision){
        heroe.aceptarMision(mision);
    }




    public void hacerMision(Ubicacion ubicacionMision){
        Ubicacion ubicacion = mapa.ubicacionPersonaje();
        ubicacion.empezarMision();
    }

    public void viajarUbicacion(Ubicacion ubicacion){
        ubicacion.llegadaUbicacion(heroe);
    }

    public void viajarZonaDescanso(){
        Ubicacion ubicacion = mapa.ubicacionPersonaje();
        ubicacion
    }




}
