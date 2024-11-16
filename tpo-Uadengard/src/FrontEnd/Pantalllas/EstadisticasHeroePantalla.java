package FrontEnd.Pantalllas;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.PersonajeView;
import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;

public class EstadisticasHeroePantalla extends JFrame {

    public EstadisticasHeroePantalla(){
        super("Personaje");
        setSize(350, 300);
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
        contBotones.setLayout(new GridLayout(2,1 , 2, 2));
        contBotones.setBounds(20, 125, 400, 60);
        Container contEquipo = new Container();
        JLabel label = new JLabel("Equipo heroe");
        contEquipo.add(label);
        for (ItemView itemView : ControladorFront.getinstancia().mostrarEquipoHeroe()){
            JLabel equipo = new JLabel("Descripcion"+ itemView.getDescripcion());
            contEquipo.add(equipo);
        }

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);
        });
        contBotones.add(estadisticasLabel);
        contBotones.add(btnVolver);
        panelFondo.add(contBotones);
        panelFondo.add(contEquipo);

        add(panelFondo, BorderLayout.CENTER);



    }
}
