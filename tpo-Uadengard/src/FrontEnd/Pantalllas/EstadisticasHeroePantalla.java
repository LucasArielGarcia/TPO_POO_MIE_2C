package FrontEnd.Pantalllas;

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
        JLabel estadisticasLabel = new JLabel(
                "Vida actual: "+personajeView.getVida() +"\n"+
                        "Defensa: " + personajeView.getDefensa()+ "\n"+
                        "Daño: "+ personajeView.getDano()
        );
        Container contBotones = new Container();
        contBotones.setLayout(new GridLayout(2,1 , 2, 2));
        contBotones.setBounds(20, 85, 400, 60);

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(e -> {
            dispose();
            ZonaDescansoPantalla.getInstancia().setVisible(true);
        });
        panelFondo.add(estadisticasLabel);
        contBotones.add(btnVolver);
        panelFondo.add(contBotones);

        add(panelFondo, BorderLayout.CENTER);



    }
}
