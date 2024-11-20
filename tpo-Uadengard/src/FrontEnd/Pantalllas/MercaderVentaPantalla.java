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
        setLocationRelativeTo(null);
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
                boolean vendio = ControladorFront.getinstancia().venderItem(itemView.getIdItems());
                if (vendio){
                    JOptionPane.showMessageDialog(null, "Vendiste tu item: " + itemView.getDescripcion(), "Mensaje", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Hubo un error para vender el item:  " + itemView.getDescripcion(), "Mensaje", JOptionPane.PLAIN_MESSAGE);

                }
            });

            contBotones.add(buttonItem);
        }
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);
        });
        contBotones.add(btnVolver);
        panelConFondo.add(contBotones);
        panelConFondo.setLayout(null);
        this.add(panelConFondo, BorderLayout.CENTER);


    }
}
