package FrontEnd.Pantalllas;

import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZonaDescansoPantalla  extends JFrame {

    JTextField campoNombre,campoApellido;
    private Image imagenFondo;

    private static ZonaDescansoPantalla instancia;
    public static ZonaDescansoPantalla getInstancia() {
        if (instancia == null) {
            instancia = new ZonaDescansoPantalla();
        }
        return instancia;
    }

    public ZonaDescansoPantalla(){
        super("Zona de descanso");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        imagenFondo = new ImageIcon("src/FrontEnd/Imagenes/aldea.png").getImage();

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
        class HandlerBtnAliado implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AliadoPantalla aliadoPantalla = new AliadoPantalla();
                aliadoPantalla.setVisible(true);

            }
        }
        class HandlerBtnMercader implements ActionListener {
        	
        	public void actionPerformed(ActionEvent e) {
                dispose();
                MercaderPantallaPrincipal mercaderPantalla = new MercaderPantallaPrincipal();
                mercaderPantalla.setVisible(true);
                }
        	
        }
        class HandlerBtnMochila implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                dispose();
                PersonajePantallaPrincipal personajePantallaPrincipal = new PersonajePantallaPrincipal();
                personajePantallaPrincipal.setVisible(true);
            }

        }


        HandlerBtnViajar handlerBtnViajar = new HandlerBtnViajar();
        HandlerBtnAliado handlerBtnAliado = new HandlerBtnAliado();
        HandlerBtnMercader handlerBtnMercader = new HandlerBtnMercader();
        HandlerBtnMochila handlerBtnMochila = new HandlerBtnMochila();
        btnViajar.addActionListener(handlerBtnViajar);
        btnAliado.addActionListener(handlerBtnAliado);
        btnMercader.addActionListener(handlerBtnMercader);
        btnPersonaje.addActionListener(handlerBtnMochila);

        contBotones.add(btnAliado);
        contBotones.add(btnMercader);
        contBotones.add(btnViajar);
        contBotones.add(btnPersonaje);

        panelConFondo.add(contBotones);

        this.add(panelConFondo, BorderLayout.CENTER);

    }



}
