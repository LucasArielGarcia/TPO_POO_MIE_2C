package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.ItemsMochilaView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonajePantallaPrincipal extends JFrame {


    private Image imagenFondo;
    public PersonajePantallaPrincipal(){
        super("Personaje");
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
        contBotones.setLayout(new GridLayout(2, 1, 2, 2));
        contBotones.setBounds(30, 70, 280, 50);

        JButton btnEstadisticas = new JButton("Ver estadisticas del heroe");
        JButton btnVerMochila = new JButton("ver Mochila");
        class HandleerBtnVerEstadisticas implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                EstadisticasHeroePantalla estadisticasHeroePantalla = new EstadisticasHeroePantalla();
                estadisticasHeroePantalla.setVisible(true);

            }
        }
        class HandlerBtnAbrirMochila implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                PersonajePantallaMochila personajePantallaMochila = new PersonajePantallaMochila();
                personajePantallaMochila.setVisible(true);
            }
        }

        HandleerBtnVerEstadisticas handlerBtnVerItems=new HandleerBtnVerEstadisticas();
        HandlerBtnAbrirMochila handlerBtnCerrarMochila=new HandlerBtnAbrirMochila();
        btnEstadisticas.addActionListener(handlerBtnVerItems);
        btnVerMochila.addActionListener(handlerBtnCerrarMochila);
        contBotones.add(btnEstadisticas);
        contBotones.add(btnVerMochila);

        panelConFondo.add(contBotones);
        this.add(panelConFondo, BorderLayout.CENTER);
    }
}
