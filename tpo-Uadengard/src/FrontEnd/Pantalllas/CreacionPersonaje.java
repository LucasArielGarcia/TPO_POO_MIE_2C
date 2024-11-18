package FrontEnd.Pantalllas;

import FrontEnd.Controlador.ControladorFront;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionPersonaje extends JFrame {
    JTextField campoNombrePersonaje;
    JComboBox<String> comboClase;
    public CreacionPersonaje(){
        super("Creacion Personaje");
        this.setLayout(new BorderLayout());

        JPanel panelCrearPersonaje=new JPanel();
        panelCrearPersonaje.setLayout(new GridLayout(4,1,2,2));

        Container contNombre=new Container();
        contNombre.setLayout(new GridLayout(1,2,2,2));
        JLabel labelNombre=new JLabel("Nombre");
        campoNombrePersonaje=new JTextField();
        contNombre.add(labelNombre);
        contNombre.add(campoNombrePersonaje);
        panelCrearPersonaje.add(contNombre);

        Container contClase=new Container();
        contClase.setLayout(new GridLayout(1,2,2,2));
        JLabel labelClase = new JLabel("Selecciona una clase:");
        panelCrearPersonaje.add(labelClase);
        String[] clases = {"Guerrero", "Arquero", "Mago"};
        comboClase = new JComboBox<>(clases);
        contClase.add(labelClase);
        contClase.add(comboClase);
        panelCrearPersonaje.add(contClase);

        JButton btnCrear=new JButton("Crear Personaje");


        class HandlerBtnCrear implements ActionListener{
            ControladorFront controladorFront = new ControladorFront();
            @Override
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) comboClase.getSelectedItem();
                controladorFront.crearPersonaje(campoNombrePersonaje.getText(),tipo);
                JOptionPane.showMessageDialog(null, "Que empiece la aventura", "Info", JOptionPane.INFORMATION_MESSAGE);
                dispose();
                ControladorFront.getinstancia().viajarZonaDescanso();
                ZonaDescansoPantalla.getInstancia().setVisible(true);

            }
        }

        HandlerBtnCrear handlerBtnCrear = new HandlerBtnCrear();
        btnCrear.addActionListener(handlerBtnCrear);



        panelCrearPersonaje.add(btnCrear);
        this.add(panelCrearPersonaje,BorderLayout.CENTER);



    }

}



/*
* // Configurar la ventana
        setTitle("Creador de Personajes");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Etiqueta para el nombre
        JLabel labelNombre = new JLabel("Nombre del personaje:");
        labelNombre.setBounds(10, 10, 150, 25);
        add(labelNombre);

        // Campo de texto para el nombre
        textNombre = new JTextField();
        textNombre.setBounds(150, 10, 120, 25);
        add(textNombre);

        // Etiqueta para la clase
        JLabel labelClase = new JLabel("Selecciona una clase:");
        labelClase.setBounds(10, 40, 150, 25);
        add(labelClase);

        // Combo box para elegir la clase
        String[] clases = {"Guerrero", "Arquero", "Mago"};
        comboClase = new JComboBox<>(clases);
        comboClase.setBounds(150, 40, 120, 25);
        add(comboClase);

        // Botón para crear el personaje
        JButton botonCrear = new JButton("Crear Personaje");
        botonCrear.setBounds(75, 80, 150, 30);
        add(botonCrear);

        botonCrear.addActionListener(botonCrear.getAction());


        class botonAceptar implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombrePersonaje = textNombre.getText();
                String tipoPersonaje = (String) comboClase.getSelectedItem();
                System.out.println(nombrePersonaje + "aaaa" + tipoPersonaje);
                ControladorFront controladorFront = new ControladorFront();
                controladorFront.crearPersonaje(nombrePersonaje,tipoPersonaje);

            }
        }
* */