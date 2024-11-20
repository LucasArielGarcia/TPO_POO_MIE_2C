package FrontEnd.Pantalllas;

import javax.swing.*;
import java.awt.*;

public class MercaderPantallaPrincipal extends JFrame {
    Image imagenFondo;
    public MercaderPantallaPrincipal(){
        super("Mercader");
        setSize(400, 300);
        setLocationRelativeTo(null);
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
        contBotones.setLayout(new GridLayout(4,1 , 2, 2));
        contBotones.setBounds(40, 85, 300, 100);

        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(e -> {
            MercaderPantallaCompra mercaderPantallaCompra = new MercaderPantallaCompra();
            dispose();
            mercaderPantallaCompra.setVisible(true);
        });
        JButton btnventa = new JButton("Vender");
        btnventa.addActionListener(e -> {
            MercaderVentaPantalla mercaderPantallaVenta = new MercaderVentaPantalla();
            dispose();
            mercaderPantallaVenta.setVisible(true);
        });
        contBotones.add(btnComprar);
        contBotones.add(btnventa);
        panelFondo.add(contBotones);
        panelFondo.setLayout(null);
        this.add(panelFondo, BorderLayout.CENTER);

    }
}
