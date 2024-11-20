package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.HeroeToview;
import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.PersonajeView;
import BackEnd.Entidades.objectView.UbicacionView;
import BackEnd.Juego.Juego;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class PeleaPantalla extends JFrame {
    Image imagenFondo;
    JPanel panelFondo;

    public PeleaPantalla() {
        super("Pelea");
        UbicacionPantalla.getInstancia().setVisible(false);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de fondo con imagen
         panelFondo = new JPanel() {
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
        HeroeToview heroe = ControladorFront.getinstancia().getHeroe();
        JLabel labelHeroe = new JLabel("| Heore |" + " Vida: " + heroe.getVida()+ " defensa: " + heroe.getDefensa());
        //JButton btonHeroe = new JButton("Curarse");

        panelHeroe.add(labelHeroe);
        //panelHeroe.add(btonHeroe);
        panelFondo.add(panelHeroe);

        // Panel de enemigos
        JPanel panelEnemigo = new JPanel();
        for (PersonajeView personajeView : ControladorFront.getinstancia().getEnemigos()) {

            panelEnemigo.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel labelEnemigo = new JLabel(personajeView.getNombre() + " Vida: " + personajeView.getVida() + " Defensa: "+ personajeView.getDefensa());
            JButton btonEnemigo = new JButton("Atacar");
            btonEnemigo.addActionListener(e -> {
                if(estadoPersonaje(personajeView)) {
                    ControladorFront.getinstancia().atacarEnemigo(personajeView.getIdPersonaje());
                    actualizarPantallaEnemigo(labelEnemigo, personajeView.getIdPersonaje());
                    actualizarPantallaHeroe(labelHeroe);
                }
                else{throw new RuntimeException("el personaje ya esta muerto");}
            });
            panelEnemigo.add(labelEnemigo);
            panelEnemigo.add(btonEnemigo);
            panelFondo.add(panelEnemigo);
        }

        // Agregar el panel de fondo al JFrame
        add(panelFondo, BorderLayout.CENTER);

        // Hacer visible la ventana
        setVisible(true);

    }

    public void actualizarPantallaEnemigo(JLabel labels, int id){
        for (PersonajeView personajeView : Juego.getInstancia().estadisticasEnemigos()){
            if (personajeView.getIdPersonaje() == id){
                if (estadoPersonaje(personajeView))
                    labels.setText(personajeView.getNombre() + " Vida: " + personajeView.getVida() + " Defensa: "+ personajeView.getDefensa());
                else
                    labels.setText("El personaje murio");

            }
        }
        panelFondo.updateUI();
        if (!ControladorFront.getinstancia().existeUnaPelea()) {
            if (ControladorFront.getinstancia().existeCofre()) {
                JButton abrirCofre = new JButton("Abrir Cofre");
                abrirCofre.addActionListener(e -> {
                    ItemView itemView = ControladorFront.getinstancia().abrirCofre();
                    JOptionPane.showMessageDialog(null, "Abriste el cofre, en este se encuentra el objeto: " + itemView.getDescripcion() + " ,Se agregara a tu mochila", "Mensage", JOptionPane.PLAIN_MESSAGE);
                    ControladorFront.getinstancia().terminarMision();
                    ControladorFront.getinstancia().viajarZonaDescanso();
                    dispose();
                    ZonaDescansoPantalla.getInstancia().setVisible(true);
                });
                panelFondo.add(abrirCofre);
            } else {
                JButton volverZonaDescanso = new JButton("volver Zona Desanso");
                volverZonaDescanso.addActionListener(e -> {
                    ControladorFront.getinstancia().terminarMision();
                    ControladorFront.getinstancia().viajarZonaDescanso();
                    dispose();
                    ZonaDescansoPantalla.getInstancia().setVisible(true);
                });
                panelFondo.add(volverZonaDescanso);
            }
        }
    }
    public boolean estadoPersonaje(PersonajeView personajeView){
        return personajeView.getVida()>0;
    }
    public void actualizarPantallaHeroe(JLabel label){
        HeroeToview heroe = ControladorFront.getinstancia().getHeroe();
        if (heroe.getVida()>0)
            label.setText("| Heore |" + " Vida: " + heroe.getVida()+ " defensa: " + heroe.getDefensa());
        else {
            JOptionPane.showMessageDialog(null, "GAME OVER", "Mensage", JOptionPane.PLAIN_MESSAGE);
            dispose();
        }

    }

}
