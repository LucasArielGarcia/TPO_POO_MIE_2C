package FrontEnd.Controlador;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.MapaView;
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

    public



}
