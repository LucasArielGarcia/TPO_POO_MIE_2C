package FrontEnd.Pantalllas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MercaderPantalla extends JFrame{
	Image imagenFondo;
	public MercaderPantalla(){
		super("Mercader");
		setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido viajero, que deseas? ", "Mensage", JOptionPane.PLAIN_MESSAGE);
        
        imagenFondo = new ImageIcon("C:\\Users\\zambr\\OneDrive\\Escritorio\\Documentos\\UADE\\2do_año_Uade\\POO\\git\\TPO_POO_MIE_2C\\tpo-Uadengard\\src\\FrontEnd\\Imagenes").getImage();
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
        contBotones.setBounds(40, 85, 200, 60);

        JButton btnComprarArma = new JButton("Comprar arma");
        
        class HandlerComprarArmas implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                //hacer el objectView de mercader y sus ítem

            }
        }
	
        
	}
}