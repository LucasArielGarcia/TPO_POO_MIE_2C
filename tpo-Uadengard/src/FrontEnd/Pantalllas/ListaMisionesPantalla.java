package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.MisionView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class ListaMisionesPantalla extends JFrame {
    Image imagenFondo ;
    public ListaMisionesPantalla(){
        super("Lista de misiones");
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        imagenFondo = new ImageIcon("../Imagenes/libroMisiones.png").getImage();
        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };



        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(4, 1, 2, 2));
        contBotones.setBounds(60, 65, 150, 100);

        for (MisionView misionView: ControladorFront.getinstancia().getMisiones()){
            JButton boton = new JButton(misionView.getNombreMision());
            contBotones.add(boton);

            boton.addActionListener(e -> {
                ControladorFront.getinstancia().aceptarMision(misionView.getIdMision());
                dispose();
                JOptionPane.showMessageDialog(null, "Aceptaste la mision " + misionView.getNombreMision(), "Mensage", JOptionPane.PLAIN_MESSAGE);
                ZonaDescansoPantalla.getInstancia().setVisible(true);
            });

        }
        panelFondo.add(contBotones);
        panelFondo.setLayout(null);
        this.add(panelFondo, BorderLayout.CENTER);

    }
}
