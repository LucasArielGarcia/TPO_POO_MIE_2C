package FrontEnd.Pantalllas;

import BackEnd.Entidades.Ubicacion;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MapaGUI extends JFrame {
    private Image imagenFondo;
    public MapaGUI(List<Ubicacion> ubicacionList){
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
        contBotones.setLayout(new GridLayout(1, 2, 2, 2));
        contBotones.setBounds(40, 85, 200, 40);

        for (Ubicacion ubicacion: ubicacionList){
            JButton boton = new JButton(ubicacion.getNombreUbicacion());
            contBotones.add(boton);
        }


        panelFondo.add(contBotones);
        this.add(panelFondo, BorderLayout.CENTER);

    }
}
