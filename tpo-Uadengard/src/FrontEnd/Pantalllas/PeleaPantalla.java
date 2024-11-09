package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.PersonajeView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class PeleaPantalla extends JFrame {

    public PeleaPantalla(Image imagenFondo) {
        super("Pelea");
        setSize(600, 600);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de fondo con imagen
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelFondo.setLayout(new BoxLayout(panelFondo, BoxLayout.Y_AXIS));

        // Panel del héroe
        JPanel panelHeroe = new JPanel();
        panelHeroe.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelHeroe = new JLabel(ControladorFront.getinstancia().getHeroe().getNombre() + " Vida: " + ControladorFront.getinstancia().getHeroe().getVida());
        JButton btonHeroe = new JButton("Atacar");

        panelHeroe.add(labelHeroe);
        panelHeroe.add(btonHeroe);
        panelFondo.add(panelHeroe);

        // Panel de enemigos
        for (PersonajeView personajeView : ControladorFront.getinstancia().getEnemigos()) {
            JPanel panelEnemigo = new JPanel();
            panelEnemigo.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel labelEnemigo = new JLabel(personajeView.getNombre() + " Vida: " + personajeView.getVida());
            JButton btonEnemigo = new JButton("Atacar");

            panelEnemigo.add(labelEnemigo);
            panelEnemigo.add(btonEnemigo);
            panelFondo.add(panelEnemigo);
        }

        // Agregar el panel de fondo al JFrame
        add(panelFondo, BorderLayout.CENTER);

        // Hacer visible la ventana
        setVisible(true);
    }
}