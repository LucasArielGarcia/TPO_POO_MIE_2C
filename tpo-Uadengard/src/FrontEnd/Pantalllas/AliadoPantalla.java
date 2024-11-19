package FrontEnd.Pantalllas;

import BackEnd.Entidades.ZonaDescanso;
import BackEnd.Entidades.objectView.ItemView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AliadoPantalla extends JFrame {
    Image imagenFondo ;
    public AliadoPantalla(){
        super("Aliado");
        setSize(450, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido viajero que deseas? ", "Mensage", JOptionPane.PLAIN_MESSAGE);

        imagenFondo = new ImageIcon("C:\\Users\\Nicol\\IdeaProjects\\TPOGrupo4\\tpo-Uadengard\\src\\FrontEnd\\Imagenes\\aliado.png").getImage();
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
        contBotones.setLayout(new GridLayout(2,1 , 2, 2));
        contBotones.setBounds(20, 85, 400, 60);

        JButton btnAceptarMisiones = new JButton("Aceptar misiones");
        JButton btnReclamarRecompensa = new JButton("Reclamar recompensa");
        JButton btnVolverZonaDescanso = new JButton("Volver a zona descanso");

        class HandlerAceptarMisiones implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaMisionesPantalla listaMisionesPantalla = new ListaMisionesPantalla();
                listaMisionesPantalla.setVisible(true);
            }
        }
        class HandlerReclamarRecompensa implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                ItemView recompensa = ControladorFront.getinstancia().reclamarRecompensa();
                if (recompensa!=null){
                    JOptionPane.showMessageDialog(null, "Reclamaste tu recompensa: "+ recompensa.getDescripcion(), "Mensage", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "No tienes niguna recompensa debes completar una mision", "Mensage", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
        class HandlerVolverZonaDescanso implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ZonaDescansoPantalla.getInstancia().setVisible(true);

            }
        }

        HandlerAceptarMisiones handlerAceptarMisiones = new HandlerAceptarMisiones();
        HandlerReclamarRecompensa handlerReclamarRecompensa = new HandlerReclamarRecompensa();
        HandlerVolverZonaDescanso handlerVolverZonaDescanso = new HandlerVolverZonaDescanso();
        btnReclamarRecompensa.addActionListener(handlerReclamarRecompensa);
        btnAceptarMisiones.addActionListener(handlerAceptarMisiones);
        btnVolverZonaDescanso.addActionListener(handlerVolverZonaDescanso);


        contBotones.add(btnAceptarMisiones);
        contBotones.add(btnReclamarRecompensa);
        contBotones.add(btnVolverZonaDescanso);
        panelFondo.setLayout(null);


        panelFondo.add(contBotones);


        this.add(panelFondo, BorderLayout.CENTER);
    }
}
