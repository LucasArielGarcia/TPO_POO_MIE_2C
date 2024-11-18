package FrontEnd.Pantalllas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AliadoPantalla extends JFrame {
    Image imagenFondo ;
    public AliadoPantalla(){
        super("Aliado");
        setSize(300, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JOptionPane.showMessageDialog(null, "Bienvenido viajero que deseas? ", "Mensage", JOptionPane.PLAIN_MESSAGE);

        imagenFondo = new ImageIcon("C:\\Users\\Nicol\\IdeaProjects\\TPOGrupo4\\tpo-Uadengard\\src\\FrontEnd\\Imagenes\\aliado.png").getImage();
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

        JButton btnAceptarMisiones = new JButton("Aceptar misiones");
        JButton btnReclamarRecompensa = new JButton("Reclamar recompensa");

        class HandlerAceptarMisiones implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListaMisionesPantalla listaMisionesPantalla = new ListaMisionesPantalla();
                listaMisionesPantalla.setVisible(true);

            }
        }

        HandlerAceptarMisiones handlerAceptarMisiones = new HandlerAceptarMisiones();
        btnAceptarMisiones.addActionListener(handlerAceptarMisiones);

        contBotones.add(btnAceptarMisiones);
        contBotones.add(btnReclamarRecompensa);
        panelFondo.setLayout(null);


        panelFondo.add(contBotones);

        this.add(panelFondo, BorderLayout.CENTER);
    }
}
