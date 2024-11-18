package FrontEnd.Pantalllas;

import BackEnd.Entidades.Items;
import BackEnd.Entidades.objectView.ItemView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class PersonajePantallaMochila extends JFrame {
    public PersonajePantallaMochila(){
        super("Personaje");
        setSize(350, 300);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel panelConFondo = new JPanel();

        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2, 4, 2, 2));
        contBotones.setBounds(30, 70, 280, 50);

        for (ItemView itemView: ControladorFront.getinstancia().abrirMochila()){
            JButton jButton = new JButton("Descripcion: "+ itemView.getDescripcion());
            jButton.addActionListener(e -> {
                boolean agregar = ControladorFront.getinstancia().equiparItem(itemView.getIdItems());
                if (agregar){
                    JOptionPane.showMessageDialog(null, "agregaste un item a tu equipo", "Info", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    ZonaDescansoPantalla.getInstancia().setVisible(true);
                }
            });
            contBotones.add(jButton);
        }
        panelConFondo.add(contBotones);
        this.add(panelConFondo, BorderLayout.CENTER);

    }
}
