package FrontEnd.Pantalllas;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;

public class MercaderPantalla extends JFrame{
	ImageIcon imagenFondo;
	public MercaderPantalla(){
		super("Mercader");
		setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido viajero, que deseas? ", "Mensage", JOptionPane.PLAIN_MESSAGE);
        
        imagenFondo = new ImageIcon("C:\\Users\\zambr\\OneDrive\\Escritorio\\Documentos\\UADE\\2do_año_Uade\\POO\\git\\TPO_POO_MIE_2C\\tpo-Uadengard\\src\\FrontEnd\\Imagenes");
		
	}
	
	
	
	
}
