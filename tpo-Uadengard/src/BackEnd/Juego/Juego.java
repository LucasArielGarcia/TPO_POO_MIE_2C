package BackEnd.Juego;

import BackEnd.Entidades.*;

public class Juego {
    Mapa mapa = new Mapa();
    Heroe heroe;

    public void crearHeroe(String tipoHeroe, String nombre){
        switch (tipoHeroe){
            case "Guerrero": heroe = new Guerrero(nombre);
            case "Arquero": heroe = new Arquero(nombre);
            case "Mago": heroe= new Mago(nombre);
        }
    }




}
