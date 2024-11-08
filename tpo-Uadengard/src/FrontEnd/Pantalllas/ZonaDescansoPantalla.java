package FrontEnd.Pantalllas;

import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZonaDescansoPantalla  extends JFrame {

    JTextField campoNombre,campoApellido;
    private Image imagenFondo;

    public ZonaDescansoPantalla(){
        super("Zona de descanso");
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        imagenFondo = new ImageIcon("C:\\Users\\LUCAS\\Downloads\\aldea.png").getImage();


        JPanel panelConFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagenFondo != null) {
                    g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panelConFondo.setLayout(null);

        // Crear el contenedor de botones con GridLayout
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2, 2, 2, 2));
        contBotones.setBounds(40, 85, 200, 90);


        JButton btnMercader = new JButton("Mercader");
        JButton btnAliado = new JButton("Aliado");
        JButton btnPersonaje = new JButton("Personaje");
        JButton btnViajar = new JButton("Viajar");


        class HandlerBtnViajar implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MapaGUI mapaGUI = new MapaGUI(ControladorFront.getinstancia().abrirMapa());
                mapaGUI.setVisible(true);

            }
        }
        HandlerBtnViajar handlerBtnViajar = new HandlerBtnViajar();
        btnViajar.addActionListener(handlerBtnViajar);

        contBotones.add(btnAliado);
        contBotones.add(btnMercader);
        contBotones.add(btnViajar);
        contBotones.add(btnPersonaje);

        panelConFondo.add(contBotones);

        this.add(panelConFondo, BorderLayout.CENTER);

    }



}
