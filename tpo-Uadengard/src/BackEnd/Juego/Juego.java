package BackEnd.Juego;

import BackEnd.Entidades.*;

import java.util.List;

public class Juego {
    Mapa mapa = new Mapa();
    Heroe heroe;
    ZonaDescanso zonaDescanso;

    public void crearHeroe(String tipoHeroe, String nombre){
        switch (tipoHeroe){
            case "Guerrero": heroe = new Guerrero(nombre);
            case "Arquero": heroe = new Arquero(nombre);
            case "Mago": heroe= new Mago(nombre);
        }
    }

    public List<Mision> mostrarMisionList(){
        return zonaDescanso.mostrarMisionesList();
    }
    public List<Items> mostrarItems(){
        return zonaDescanso.mostrarCatologoItems() ;
    }

    public void aceptarMision(Heroe heroe, Mision mision){
        heroe.aceptarMision(mision);
    }


    public void hacerMision(){
        if (heroe.tengoMision()){
            // viajar a la ubicacion
        }
    }

    public void viajarUbicacion(){

    }




}
