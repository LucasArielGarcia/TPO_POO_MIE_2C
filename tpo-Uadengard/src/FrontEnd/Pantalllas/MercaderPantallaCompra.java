package FrontEnd.Pantalllas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.*;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.MercaderView;
import FrontEnd.Controlador.ControladorFront;

public class MercaderPantallaCompra extends JFrame{
	Image imagenFondo;
	public MercaderPantallaCompra(){
		super("Mercader");
		setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido al viajero, es hora de adquirir algunas armas ", "Mensage", JOptionPane.PLAIN_MESSAGE);
        
        imagenFondo = new ImageIcon("src/FrontEnd/Imagenes/mercader.jpg").getImage();
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
        contBotones.setLayout(new GridLayout(4,1 , 2, 2));
        contBotones.setBounds(40, 85, 300, 100);
        
        MercaderView mercaderView = ControladorFront.getinstancia().getItems();
        List<ItemView> itemList = mercaderView.getMostrarCatologoItems();
        for(ItemView item: itemList) {
        	JButton boton = new JButton(item.getDescripcion());
            contBotones.add(boton);
            
            boton.addActionListener(e -> {
                ControladorFront.getinstancia().comprarItem(item.getIdItems());
                JOptionPane.showMessageDialog(null, "Compraste el arma " + item.getDescripcion(), "Mensage", JOptionPane.PLAIN_MESSAGE);

            });


        }
        JButton botonZonaDescanso = new JButton("volver ");
        contBotones.add(botonZonaDescanso);

        botonZonaDescanso.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);

        });
        contBotones.add(botonZonaDescanso);
        panelFondo.add(contBotones);
        panelFondo.setLayout(null);
        this.add(panelFondo, BorderLayout.CENTER);
	}
}