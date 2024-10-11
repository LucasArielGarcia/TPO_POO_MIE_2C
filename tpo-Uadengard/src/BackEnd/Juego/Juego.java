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
        if (heroe.tengoMision()){
            ubicacionMision.llegadaUbicacion(heroe);
        }
        // agregar logica para que si termina la mision poner la variable mision como null
        heroe.terminarMision();
    }

    public void viajarUbicacion(){


    }




}
