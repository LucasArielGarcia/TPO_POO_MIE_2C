package FrontEnd.Pantalllas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

import BackEnd.Entidades.ZonaDescanso;
import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.MercaderView;
import FrontEnd.Controlador.ControladorFront;

public class MercaderPantalla extends JFrame{
	Image imagenFondo;
	public MercaderPantalla(){
		super("Mercader");
		setSize(400, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido al viajero, es hora de adquirir algunas armas ", "Mensage", JOptionPane.PLAIN_MESSAGE);
        
        imagenFondo = new ImageIcon("E:\\git\\POO\\TPO\\TPO_POO_MIE_2C\\tpo-Uadengard\\src\\FrontEnd\\Imagenes\\mercader.jpg").getImage();
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
        contBotones.setBounds(40, 85, 300, 60);
        
        MercaderView mercaderView = ControladorFront.getinstancia().getItems();
        List<ItemView> itemList = mercaderView.getMostrarCatologoItems();
        for(ItemView item: itemList) {
        	JButton boton = new JButton(item.getDescripcion());
            contBotones.add(boton);
            
            boton.addActionListener(e -> {
                ControladorFront.getinstancia().comprarItem(item.getIdItems());
                JOptionPane.showMessageDialog(null, "Compraste el arma " + item.getDescripcion(), "Mensage", JOptionPane.PLAIN_MESSAGE);

            });
            panelFondo.add(contBotones);
            panelFondo.setLayout(null);

        }
        JButton botonZonaDescanso = new JButton("volver a zona descanso");
        contBotones.add(botonZonaDescanso);

        botonZonaDescanso.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);

        });
        panelFondo.add(botonZonaDescanso);
        this.add(panelFondo, BorderLayout.CENTER);
	}
}