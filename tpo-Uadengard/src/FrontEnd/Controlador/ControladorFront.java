package FrontEnd.Controlador;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Juego.Juego;

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



}
