package FrontEnd.Pantalllas;

import BackEnd.Entidades.Items;
import BackEnd.Entidades.objectView.ItemView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class PersonajePantallaMochila extends JFrame {
    public PersonajePantallaMochila(){
    	super("Personaje");
    	setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panelConFondo = new JPanel(new BorderLayout());

        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(8,8 , 1, 1));
        contBotones.setBounds(20, 85, 400, 60);

        JButton mejorar = new JButton("¡Vamos a equipar mejores armas!");
        mejorar.addActionListener(e -> {
            contBotones.removeAll(); // Limpiar botones anteriores para evitar duplicados
            for (ItemView itemView : ControladorFront.getinstancia().abrirMochila()) {
                JButton añadir = new JButton("Descripción: " + itemView.getDescripcion());
                añadir.addActionListener(event -> {
                    boolean agregar = ControladorFront.getinstancia().equiparItem(itemView.getIdItems());
                    if (agregar) {
                        JOptionPane.showMessageDialog(null, "Agregaste un ítem a tu equipo", "Info", JOptionPane.INFORMATION_MESSAGE);
                        dispose();
                        ZonaDescansoPantalla.getInstancia().setVisible(true);
                    }
                });
                contBotones.add(añadir);
            }
            contBotones.revalidate();
            contBotones.repaint();
        });

        contBotones.add(mejorar);
        panelConFondo.add(contBotones);
        this.add(panelConFondo, BorderLayout.CENTER);
    }
}
