package FrontEnd.Pantalllas;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.UbicacionView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UbicacionPantalla extends JFrame {
    private Image imagenFondo;
    private JPanel panelFondo;
    private static UbicacionPantalla instancia;

    public static UbicacionPantalla getInstancia() {
        if (instancia == null) {
            instancia = new UbicacionPantalla();
        }
        return instancia;
    }

    public UbicacionPantalla() {
        UbicacionView ubicacion = ControladorFront.getinstancia().getUbicacionActual();
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JOptionPane.showMessageDialog(null, "Bienvenido a " + ubicacion.getNombreUbicacion(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

        imagenFondo = new ImageIcon(ubicacion.getUrlImagen()).getImage();
        panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelFondo.setLayout(null);
        configurarBotones(ubicacion);

        add(panelFondo, BorderLayout.CENTER);
    }

    private void configurarBotones(UbicacionView ubicacion) {
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2, 2, 2, 2));
        contBotones.setBounds(40, 85, 200, 90);

        if (ControladorFront.getinstancia().hayMision()) {
            if (ControladorFront.getinstancia().existeUnaPelea()) {
                JButton buttonEmpezarMision = new JButton("Empezar Pelea");
                buttonEmpezarMision.addActionListener(e -> {

                    PeleaPantalla peleaPantalla = new PeleaPantalla();
                    peleaPantalla.setVisible(true);
                });
                contBotones.add(buttonEmpezarMision);
            } else if (ControladorFront.getinstancia().existeCofre()) {
                JButton buttonAbrirCofre = new JButton("Abrir cofre");
                buttonAbrirCofre.addActionListener(e -> {
                    ItemView itemView = ControladorFront.getinstancia().abrirCofre();
                    JOptionPane.showMessageDialog(null, "Abriste el cofre, en este se encuentra el objeto: "+itemView.getDescripcion()+" ,Se agregara a tu mochila, debes devolverlo al aliado", "Mensage", JOptionPane.PLAIN_MESSAGE);
                    ControladorFront.getinstancia().viajarZonaDescanso();
                    ControladorFront.getinstancia().terminarMision();
                    dispose();
                    ZonaDescansoPantalla.getInstancia().setVisible(true);
                });
                contBotones.add(buttonAbrirCofre);
            }

        } else {
            JLabel label = new JLabel("Debes volver");
            label.setForeground(Color.WHITE);
            JButton buttonVolverZonaDescanso = new JButton("Volver a zona de descanso");
            buttonVolverZonaDescanso.addActionListener(e -> {
                dispose();
                ZonaDescansoPantalla.getInstancia().setVisible(true);
            });
            contBotones.add(label);
            contBotones.add(buttonVolverZonaDescanso);
        }

        panelFondo.add(contBotones);
    }

}
