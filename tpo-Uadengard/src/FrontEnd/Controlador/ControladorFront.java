package FrontEnd.Controlador;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Juego.Juego;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ControladorFront {
    private Juego juego = new Juego();
    public void crearPersonaje(String nombre, String tipoHeroe){
        int tipo;
        if (tipoHeroe.equals("Guerrero")){tipo = 1;}
        else if (tipoHeroe.equals("Arquero")) {tipo = 2;}
        else {tipo = 3;}
        juego.crearHeroe(tipo,nombre);
    }

    public List<Ubicacion> abrirMapa(){
        return juego.abrirMapa();
    }

    public boolean hayMision(Ubicacion ubicacionActual){
        return juego.hayMision();
    }

    public void viajarUbicacion(int opcion){
        juego.viajarUbicacion(opcion);
    }



}
