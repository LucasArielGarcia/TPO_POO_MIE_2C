import BackEnd.Configuracion.ConfiguracionJuego;
import BackEnd.Entidades.*;
import BackEnd.Entidades.objectView.MisionView;
import BackEnd.Entidades.objectView.PersonajeView;
import BackEnd.Entidades.objectView.UbicacionView;
import BackEnd.Juego.Juego;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {






        Scanner scanner = new Scanner(System.in);

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

        Juego.getInstancia().crearHeroe(tipoPersonaje,nombre);
        System.out.println("Muy bien "+nombre+" ya creamos el personaje" + "\n");

        while (Juego.getInstancia().heroejeVivo()){
            System.out.println("Nos encontramos en la zona de descanso aqui puedes elegir hablar con el mercader tambien podemos hablar nuestro aliado para que nos de misiones"+ "\n"+
                    "Abrir el mapa para ver nuestras ubicaciones o viajar a las ubicaciones"+ "\n"
                    );
            Juego.getInstancia().viajarZonaDescanso();

            while (!Juego.getInstancia().jugadorEstaEnZonaDescanso()){
                System.out.println("1 para abrir el mapa"+ "\n"+
                        "2 para hablar con el mercader" + "\n"+
                        "3 para hablar con nuestro aliado"+ "\n"+
                        "4 para viajar a una ubicacion" +"\n"+
                        "5 Opciones de personaje" +"\n"
                );
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 1){
                    abrirMapaJuego(Juego.getInstancia().abrirMapa().getUbicacionListView());
                } else if (opcion == 2) {
                    System.out.println("Bienvenido " + nombre+ " que deseas?"+ "\n");
                    System.out.println("1 para ver el catalogo del mercader" + "\n"+
                            "2 para comprar al mercader");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    /*
                    if (opcion == 1)
                        //mostrarCatalogo(Juego.getInstancia().mostrarCatalogoMercaderItems());
                    else if (opcion == 2)
                        Juego.getInstancia().comprarItem();

                     */
                } else if (opcion == 3) {
                    System.out.println("Bienvenido aliado, veo que estas emocionado por emprender una nueva aventura. Dime que deseas hacer..."+"\n"+
                                       "1 Para aceptar Misiones "+ "\n"+
                                       "2 para reclamar recompensa");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    if (opcion == 1){
                        mostrarMisiones(Juego.getInstancia().mostrarMisionList());
                        System.out.println("ingresa que mision quieres...");
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                        Juego.getInstancia().aceptarMision(opcion);
                    } else if (opcion == 2) {
                        boolean reclamoRecompensa = Juego.getInstancia().reclamarRecompensa();
                        if (reclamoRecompensa) {
                            System.out.println("Reclamaste tu recompensa");
                            System.out.println(Juego.getInstancia().mostrarRecompensa());
                        }
                        else
                            System.out.println("No completaste la mision");
                    }
                } else if (opcion == 4) {
                    System.out.println("Ingrese la zona en donde queres viajar");
                    int ubicacion = scanner.nextInt();
                    scanner.nextLine();
                    Juego.getInstancia().jugadorSaleZonaDescanso();
                    viajarZonaJuego(ubicacion,scanner);

                }
                else if (opcion == 5) {
                    System.out.println("1 Para abrir mochila "+ "\n"+
                                        "2 para equipar item");
                    opcion= scanner.nextInt();
                    scanner.nextLine();
                    if (opcion == 1)
                        abrirMochila();
                    else if (opcion == 2) {

                    }

                }
            }
            System.out.println("¿Deseas volver a la zona de descanso? S/N");
            String opcion = scanner.nextLine();
            if (opcion.equals("S"))
                Juego.getInstancia().viajarZonaDescanso();


        }


    }


    public static void abrirMapaJuego(List<UbicacionView> ubicacionList){
        for (UbicacionView ubicacionView: ubicacionList){

            System.out.println(ubicacionView.getIdUbicacion()+" Nombre de la ubicacion: "+ubicacionView.getNombreUbicacion());
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

    public static void viajarZonaJuego(int opcion, Scanner scanner){
        String mensajeReturns = "";
        mensajeReturns = Juego.getInstancia().viajarUbicacion(opcion);
        System.out.println(mensajeReturns);
        if (Juego.getInstancia().hayMision()){
            while (Juego.getInstancia().hayPelea()){
                System.out.println("Hay enemigos, demos pelear"+"\n");
                System.out.println(Juego.getInstancia().mostrarEstadisticasHeroe()+"\n");
                mostrarEstadisticas(Juego.getInstancia().estadisticasEnemigos());
                System.out.println("Tienes que elegir un enemigo"+"\n");
                int opcionPelea = scanner.nextInt();
                scanner.nextLine();
                Juego.getInstancia().pelea(opcionPelea);
                if (!Juego.getInstancia().hayPelea()){
                    System.out.println("Eliminaste a todos los enemigos felicidades");
                }
            }
            if (Juego.getInstancia().hayCofre()){
                System.out.println("Hay un cofre vamos a ver que hay adentro");
                System.out.println(Juego.getInstancia().abrirCofre());
            }
            System.out.println("Ve al aliado para reclamar tu recompensa");
            Juego.getInstancia().cerrarMision();
        }
        else
            System.out.println("No tienes nada que hacer aqui");
    }

    public static void mostrarEstadisticas(List<PersonajeView> estadisticasList){
        for (int i = 0; i<estadisticasList.size(); i++){
            System.out.println("Opcion de ataque: "+i +estadisticasList.get(i).getVida()+" "+estadisticasList.get(i).getNombre());
        }
    }

    public static void mostrarMisiones(List<MisionView>misionList){
        for (int i = 0; i<misionList.size(); i++){
            System.out.println(misionList.get(i).getIdMision() +" Nombre de la mision: "+misionList.get(i).getNombreMision());
        }
    }


    public static void abrirMochila(){
        for (String item: Juego.getInstancia().abrirMochila()){
            System.out.println(item);
        }
        if (Juego.getInstancia().abrirMochila().isEmpty())
            System.out.println("No tienes ningun item");
    }



}