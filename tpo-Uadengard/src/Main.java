import BackEnd.Configuracion.ConfiguracionJuego;
import BackEnd.Entidades.*;
import BackEnd.Juego.Juego;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ConfiguracionJuego configuracionJuego = new ConfiguracionJuego();

        Mapa mapa = configuracionJuego.getMapa();
        ZonaDescanso zonaDescanso = configuracionJuego.getZonaDescanso();




        Scanner scanner = new Scanner(System.in);
        Juego juegoControler = new Juego(mapa,zonaDescanso);
        Heroe heroeJuego;
        System.out.println("Bienvenido al mundo Uadegard");
        System.out.println("Empecemos por la basico, creemos el personaje."+
                "\n" + "1 para crear un guerrero"+
                "\n" + "2 para crear un arquero"+
                "\n" + "3 para crear un mago"
        );

        int tipoPersonaje = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Dinos tu nombre viajero");
        String nombre = scanner.nextLine();

        heroeJuego = juegoControler.crearHeroe(tipoPersonaje,nombre);
        System.out.println("Muy bien "+nombre+" ya creamos el personaje" + "\n");

        while (heroeJuego.personajeVivo()){
            System.out.println("Nos encontramos en la zona de descanso aqui puedes elegir hablar con el mercader tambien podemos hablar nuestro aliado para que nos de misiones"+ "\n"+
                    "Abrir el mapa para ver nuestras ubicaciones o viajar a las ubicaciones"+ "\n"
                    );
            juegoControler.viajarZonaDescanso(mapa,zonaDescanso);

            while (zonaDescanso.personajeEstaEnzona()){
                System.out.println("1 para abrir el mapa"+ "\n"+
                        "2 para hablar con el mercader" + "\n"+
                        "3 para hablar con nuestro aliado"+ "\n"+
                        "4 para viajar a una ubicacion" +"\n"+
                        "5 Opciones de personaje" +"\n"
                );
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1){
                    abrirMapaJuego(juegoControler.abrirMapa());
                } else if (opcion == 2) {
                    System.out.println("Bienvenido " + nombre+ " que deseas?"+ "\n");
                    System.out.println("1 para ver el catalogo del mercader" + "\n"+
                            "2 para comprar al mercader");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion == 1)
                        mostrarCatalogo(juegoControler.mostrarCatalogoMercaderItems());
                    else if (opcion == 2)
                        juegoControler.comprarItem();
                } else if (opcion == 3) {
                    System.out.println("Bienvenido aliado, veo que estas emocionado por emprender una nueva aventura. Dime que deseas hacer..."+"\n"+
                                       "1 Para aceptar Misiones "+ "\n"+
                                       "2 para reclamar recompensa");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion == 1){
                        mostrarMisiones(juegoControler.mostrarMisionList());
                        System.out.println("ingresa que mision quieres...");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        juegoControler.aceptarMision(opcion, heroeJuego);
                    } else if (opcion == 2) {
                        boolean reclamoRecompensa = juegoControler.reclamarRecompensa();
                        if (reclamoRecompensa) {
                            System.out.println("Reclamaste tu recompensa");
                            System.out.println(juegoControler.mostrarRecompensa());
                        }
                        else
                            System.out.println("No completaste la mision");
                    }
                } else if (opcion == 4) {
                    System.out.println("Ingrese la zona en donde queres viajar");
                    int ubicacion = scanner.nextInt();
                    scanner.nextLine();
                    zonaDescanso.salirZonaDescanso();
                    viajarZonaJuego(ubicacion,juegoControler,heroeJuego,scanner);

                }
                else if (opcion == 5) {
                    System.out.println("1 Para abrir mochila "+ "\n"+
                                        "2 para equipar item");
                    opcion= scanner.nextInt();
                    scanner.nextLine();
                    if (opcion == 1)
                        abrirMochila(juegoControler);
                    else if (opcion == 2) {

                    }

                }
            }
            System.out.println("¿Deseas volver a la zona de descanso? S/N");
            String opcion = scanner.nextLine();
            if (opcion.equals("S"))
                zonaDescanso.llegarZonaDescanso(heroeJuego);


        }


    }


    public static void abrirMapaJuego(List<Ubicacion> ubicacionList){
        for (int i = 0; i<ubicacionList.size(); i++){
            Ubicacion ubicacion = ubicacionList.get(i);
            System.out.println(i+" Nombre de la ubicacion: "+ubicacion.getNombreUbicacion());
        }
        System.out.println("");
    }

    public static void mostrarCatalogo(List<Items> itemsList){
        for (int i =0; i< itemsList.size(); i++){
            Items item = itemsList.get(i);
            System.out.println(i+"Descripcion: "+ item.getDescripcion() + " Precio: "+item.getPrecio());
        }
        System.out.println("");
    }

    public static void viajarZonaJuego(int opcion, Juego juego, Heroe heroe, Scanner scanner){
        String mensajeReturns = "";
        mensajeReturns = juego.viajarUbicacion(opcion,heroe);
        System.out.println(mensajeReturns);
        if (juego.hayMision()){
            while (juego.hayPelea()){
                System.out.println("Hay enemigos, demos pelear"+"\n");
                System.out.println(juego.mostrarEstadisticasHeroe()+"\n");
                mostrarEstadisticas(juego.estadisticasEnemigos());
                System.out.println("Tienes que elegir un enemigo"+"\n");
                int opcionPelea = scanner.nextInt();
                scanner.nextLine();
                juego.pelea(opcionPelea);
                if (!juego.hayPelea()){
                    System.out.println("Eliminaste a todos los enemigos felicidades");
                }
            }
            if (juego.hayCofre()){
                System.out.println("Hay un cofre vamos a ver que hay adentro");
                System.out.println(juego.abrirCofre());
            }
            System.out.println("Ve al aliado para reclamar tu recompensa");
            juego.cerrarMision();
        }
        else
            System.out.println("No tienes nada que hacer aqui");
    }

    public static void mostrarEstadisticas(List<String> estadisticasList){
        for (int i = 0; i<estadisticasList.size(); i++){
            System.out.println("Opcion de ataque: "+i +estadisticasList.get(i));
        }
    }

    public static void mostrarMisiones(List<Mision>misionList){
        for (int i = 0; i<misionList.size(); i++){
            System.out.println(i +" Nombre de la mision: "+misionList.get(i).getNombreMision());
        }
    }


    public static void abrirMochila(Juego juego){
        for (String item: juego.abrirMochila()){
            System.out.println(item);
        }
        if (juego.abrirMochila().isEmpty())
            System.out.println("No tienes ningun item");
    }



}