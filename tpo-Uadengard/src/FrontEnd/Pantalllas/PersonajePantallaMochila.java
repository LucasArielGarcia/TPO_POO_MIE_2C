package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.ItemView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonajePantallaMochila extends JFrame {
    public PersonajePantallaMochila() {
        super("Personaje");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panelConFondo = new JPanel(new BorderLayout());

        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(8, 8, 1, 1));
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

        // Botón para volver a la zona de descanso
        JButton botonVolver = new JButton("Volver a la Zona de Descanso");
        class HandlerBtnZonaDescanso implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZonaDescansoPantalla zonaDescansoPantalla = new ZonaDescansoPantalla();
                dispose(); // Cerrar la ventana de la mochila
                zonaDescansoPantalla.setVisible(true); // Mostrar la ventana de la zona de descanso
            }
        }
        botonVolver.addActionListener(new HandlerBtnZonaDescanso());

        // Agregar el botón de volver y el botón mejorar
        contBotones.add(mejorar);
        panelConFondo.add(contBotones, BorderLayout.CENTER);
        panelConFondo.add(botonVolver, BorderLayout.SOUTH); // Colocar el botón en la parte inferior

        this.add(panelConFondo, BorderLayout.CENTER);
    }
}
