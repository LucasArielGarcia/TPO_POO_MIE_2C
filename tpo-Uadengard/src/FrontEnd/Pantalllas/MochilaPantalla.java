package FrontEnd.Pantalllas;

import BackEnd.Entidades.Items;
import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.ItemsMochilaView;
import BackEnd.Juego.Juego;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MochilaPantalla extends JFrame {
    Image imagenFondo;
    private static MochilaPantalla instancia;
    public static MochilaPantalla getInstancia() {
        if(instancia==null){
            instancia=new MochilaPantalla();
        }
        return instancia;
    }
    public MochilaPantalla(){
        super("Mochila");
        setSize(300, 300);
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
        ItemsMochilaView itemsMochilaView= ControladorFront.getinstancia().getItemsMochila();
        List<ItemView> inventario=itemsMochilaView.getMostrarItemsMochila();
        panelConFondo.setLayout(null);
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2, 1, 2, 2));
        contBotones.setBounds(40, 85, 200, 90);
       for(ItemView item: inventario) {
           JButton boton = new JButton(item.getDescripcion());
           contBotones.add(boton);

           boton.addActionListener(e -> {
               ControladorFront.getinstancia();
               dispose();
               JOptionPane.showMessageDialog(null, "equipaste el item " + item.getDescripcion(), "Mensage", JOptionPane.PLAIN_MESSAGE);
               ZonaDescansoPantalla.getInstancia().setVisible(true);
           });
           panelConFondo.add(contBotones);
           panelConFondo.setLayout(null);
           this.add(panelConFondo, BorderLayout.CENTER);
       }
    }
}
