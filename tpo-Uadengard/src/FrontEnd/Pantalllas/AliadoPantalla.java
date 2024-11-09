package FrontEnd.Pantalllas;

import javax.swing.*;
import java.awt.*;

public class AliadoPantalla extends JFrame {
    Image imagenFondo ;
    public AliadoPantalla(){
        super("Aliado");
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido viajero que deseas? ", "Mensage", JOptionPane.PLAIN_MESSAGE);

        imagenFondo = new ImageIcon("E:\\git\\POO\\TPO\\TPO_POO_MIE_2C\\tpo-Uadengard\\src\\FrontEnd\\Imagenes\\aliado.png").getImage();
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
        contBotones.setLayout(new GridLayout(2, 2, 2, 2));
        contBotones.setBounds(40, 85, 200, 60);


        panelFondo.setLayout(null);



        this.add(panelFondo, BorderLayout.CENTER);
    }
}
