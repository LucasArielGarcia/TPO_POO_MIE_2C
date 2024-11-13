package FrontEnd.Pantalllas;

import BackEnd.Entidades.Ubicacion;
import BackEnd.Entidades.objectView.MapaView;
import BackEnd.Entidades.objectView.UbicacionView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MapaGUI extends JFrame {
    private Image imagenFondo;
    UbicacionPantalla ubicacionPantalla;
    public MapaGUI(MapaView mapaView){
        super("Mapa");
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        imagenFondo = new ImageIcon("C:\\Users\\LUCAS\\Downloads\\mapa.png").getImage();
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
        contBotones.setBounds(40, 85, 200, 60);


        for (UbicacionView ubicacion: mapaView.getUbicacionListView()){
            JButton boton = new JButton(ubicacion.getNombreUbicacion());
            contBotones.add(boton);

            boton.addActionListener(e -> {
                ControladorFront.getinstancia().viajarUbicacion(ubicacion.getIdUbicacion());
                dispose();
                UbicacionPantalla.getInstancia().setVisible(true);
            });

        }

        JButton botonVolver = new JButton("Volver");
        class HandlerBtnZonaDescanso implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                ZonaDescansoPantalla zonaDescansoPantalla = new ZonaDescansoPantalla();
                dispose();
                zonaDescansoPantalla.setVisible(true);
            }
        }
        HandlerBtnZonaDescanso handlerBtnZonaDescanso = new HandlerBtnZonaDescanso();
        botonVolver.addActionListener(handlerBtnZonaDescanso);

        contBotones.add(botonVolver);


        panelFondo.add(contBotones);
        this.add(panelFondo, BorderLayout.CENTER);

    }
}
