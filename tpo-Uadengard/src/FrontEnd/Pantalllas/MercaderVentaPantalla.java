package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.ItemView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class MercaderVentaPantalla extends JFrame {
    Image imagenFondo;

    public MercaderVentaPantalla(){
        super("Mercader Venta");
        setSize(350, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        imagenFondo= new ImageIcon().getImage();

        JPanel panelConFondo = new JPanel() {
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
        contBotones.setBounds(40, 85, 200, 100);
        for (ItemView itemView : ControladorFront.getinstancia().abrirMochila()){
            JButton buttonItem = new JButton(itemView.getDescripcion());
            buttonItem.addActionListener(e -> {
                // programar funcion de venta al mercader
            });
            contBotones.add(buttonItem);
        }
        panelConFondo.add(contBotones);
        panelConFondo.setLayout(null);
        this.add(panelConFondo, BorderLayout.CENTER);


    }
}
