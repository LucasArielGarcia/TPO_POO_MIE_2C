package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.PersonajeView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class EstadisticasHeroePantalla extends JFrame {

    public EstadisticasHeroePantalla(){
        super("Personaje");
        setSize(350, 600);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        PersonajeView personajeView = ControladorFront.getinstancia().getHeroe();
        JPanel panelFondo = new JPanel();
        String estadistica = "Vida actual: "+personajeView.getVida() +"\n"+
                " Defensa: " + personajeView.getDefensa()+ "\n"+
                " Daño: "+ personajeView.getDano();

        JLabel estadisticasLabel = new JLabel(estadistica);
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(8,1 , 2, 2));
        contBotones.setBounds(20, 125, 400, 60);
        JLabel label = new JLabel("Equipo heroe");
        contBotones.add(label);
        for (ItemView itemView : ControladorFront.getinstancia().mostrarEquipoHeroe()){
            JLabel equipo = new JLabel("Descripcion: "+ itemView.getDescripcion());
            contBotones.add(equipo);
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);
        });
        contBotones.add(estadisticasLabel);
        contBotones.add(btnVolver);
        panelFondo.add(contBotones);

        add(panelFondo, BorderLayout.CENTER);



    }
}
