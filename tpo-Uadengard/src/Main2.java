import FrontEnd.Pantalllas.CreacionPersonaje;
import FrontEnd.Pantalllas.ZonaDescansoPantalla;

import javax.swing.*;

public class Main2 {

    public static void main(String[] args) {
        crearPersonaje();

    }
    public static void crearPersonaje(){
        CreacionPersonaje interfazCreacionPersonaje =new CreacionPersonaje();
        interfazCreacionPersonaje.setVisible(true);
        interfazCreacionPersonaje.setSize(300,300);
        interfazCreacionPersonaje.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfazCreacionPersonaje.setLocationRelativeTo(null);

        

    }

}
