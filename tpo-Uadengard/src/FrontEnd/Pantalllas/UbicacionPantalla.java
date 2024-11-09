package FrontEnd.Pantalllas;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.UbicacionView;
import BackEnd.Juego.Juego;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class UbicacionPantalla extends JFrame {
    Image imagenFondo ;
    public UbicacionPantalla(UbicacionView ubicacion){
        super(ubicacion.getNombreUbicacion());
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido a "+ubicacion.getNombreUbicacion(), "Mensage", JOptionPane.PLAIN_MESSAGE);

        imagenFondo = new ImageIcon(ubicacion.getUrlImagen()).getImage();
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelFondo.setLayout(null);


        while (ControladorFront.getinstancia().hayMision()){
            JOptionPane.showMessageDialog(null, "Empezaremos la mision", "Mensage", JOptionPane.PLAIN_MESSAGE);
            
        }



        this.add(panelFondo, BorderLayout.CENTER);



    }
}
