package FrontEnd.Pantalllas;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.UbicacionView;
import BackEnd.Juego.Juego;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2, 2, 2, 2));
        contBotones.setBounds(40, 85, 200, 90);

        if (ControladorFront.getinstancia().hayMision()) {
            JButton buttonEmpezarMision = new JButton("Empezar Mision");
            class HandlerBtnEmepzarMision implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    PeleaPantalla peleaPantalla = new PeleaPantalla();
                    peleaPantalla.setVisible(true);

                }
            }
            HandlerBtnEmepzarMision mision = new HandlerBtnEmepzarMision();
            buttonEmpezarMision.addActionListener(mision);

            contBotones.add(buttonEmpezarMision);
            /*
            JOptionPane.showMessageDialog(null, "Empezaremos la mision", "Mensage", JOptionPane.PLAIN_MESSAGE);
            if (ControladorFront.getinstancia().existeUnaPelea()){
                JOptionPane.showMessageDialog(null, "Debemos pelear, preparate", "Mensage", JOptionPane.PLAIN_MESSAGE);
                dispose();
                PeleaPantalla peleaPantalla = new PeleaPantalla();
                peleaPantalla.setVisible(true);
            }
            */
        }
        else {
            JLabel label = new JLabel("Debes volver");
            label.setForeground(Color.WHITE);
            JButton buttonVolverZonaDescanso = new JButton("Volver a zona de descanso");
            class HandlerBtnVolver implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    ZonaDescansoPantalla.getInstancia().setVisible(true);

                }
            }
            HandlerBtnVolver handlerBtnVolver = new HandlerBtnVolver();
            buttonVolverZonaDescanso.addActionListener(handlerBtnVolver);
            contBotones.add(label);
            contBotones.add(buttonVolverZonaDescanso);
        }

        panelFondo.add(contBotones);

        this.add(panelFondo, BorderLayout.CENTER);



    }
}
