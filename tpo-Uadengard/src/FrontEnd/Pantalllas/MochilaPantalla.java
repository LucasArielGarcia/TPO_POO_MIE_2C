package FrontEnd.Pantalllas;

import BackEnd.Entidades.Items;
import BackEnd.Entidades.objectView.ItemsMochilaView;
import BackEnd.Juego.Juego;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MochilaPantalla extends JFrame {

    private static MochilaPantalla instancia;
    public static MochilaPantalla getInstancia() {
        if(instancia==null){
            instancia=new MochilaPantalla();
        }
        return instancia;
    }
    private Image imagenFondo;
    public MochilaPantalla(){
        super("Mochila");
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
        ItemsMochilaView listaItems= ControladorFront.getinstancia().getItemsMochila();
        int tamanoLista=listaItems.getMostrarItemsMochila().toArray().length;
        panelConFondo.setLayout(null);
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(1, 2, 2, 2));
        contBotones.setBounds(30, 70, 280, 50);

        JButton btnVerItems = new JButton("Ver Items");
        JButton btnCerrarMochila = new JButton("Cerrar Mochila");
        class HandleerBtnVerItems implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();

            }
        }
        class HandlerBtnCerrarMochila implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                ZonaDescansoPantalla zonaDescanso=new ZonaDescansoPantalla();
                zonaDescanso.setVisible(true);
            }
        }

        HandleerBtnVerItems handlerBtnVerItems=new HandleerBtnVerItems();
        HandlerBtnCerrarMochila handlerBtnCerrarMochila=new HandlerBtnCerrarMochila();
        btnVerItems.addActionListener(handlerBtnVerItems);
        btnCerrarMochila.addActionListener(handlerBtnCerrarMochila);
        contBotones.add(btnVerItems);
        contBotones.add(btnCerrarMochila);

        //agregue
        panelConFondo.add(contBotones);
        this.add(panelConFondo, BorderLayout.CENTER);
    }
}
