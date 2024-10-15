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
                        "4 para viajar a una ubicacion" +"\n"
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
                    System.out.println("Bienvenido aliado, veo que estas emocionado por emprender una nueva aventura. Dime que deseas hacer..."+"\n");
                    mostrarMisiones(juegoControler.mostrarMisionList());
                    System.out.println("ingresa que mision quieres...");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    juegoControler.aceptarMision(opcion, heroeJuego);

                } else if (opcion == 4) {
                    System.out.println("Ingrese la zona en donde queres viajar");
                    int ubicacion = scanner.nextInt();
                    scanner.nextLine();
                    zonaDescanso.salirZonaDescanso();
                    viajarZonaJuego(ubicacion,juegoControler,heroeJuego,scanner);

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
        Ubicacion ubicacionActual =juego.viajarUbicacion(opcion,heroe);
        while (ubicacionActual.personajeSeEncuentra()){
            System.out.println("El heroe se encuentra en: "+ubicacionActual.getNombreUbicacion());
            if (ubicacionActual.tengoMision() && heroe.misionSonIguales(ubicacionActual.getMision())){
                System.out.println("Empecemos la mision");
                Mision misionActual = ubicacionActual.empezarMision();
                while (!misionActual.misionCompleta()){
                    if (misionActual.existePelea()){
                        while (misionActual.hayEnemigos()){
                            mostrarEstadisticas(misionActual.mostrarEstadisticasEnemigos());
                            System.out.println("");
                            System.out.println("Nuestro heroe tiene estas estadisticas: " + misionActual.mostrarEstadisticaHeroe());
                            System.out.println("Debes ingresar a quien quieres atacar...");
                            int opcionPelea = scanner.nextInt();
                            scanner.nextLine();
                            misionActual.peleaHeroe(heroe,opcionPelea);
                            if (!misionActual.hayEnemigos()){
                                System.out.println("Mataste a todos los enemigos enhorabuena.");
                                misionActual.marcarMisionCompletada();
                                misionActual.terminarPelea();
                            }
                        }
                    }

                }
            }
            System.out.println("No tiene que hacer nada por aqui, volvamos a la zona de descanso");
            ubicacionActual.terminarMision();
            ubicacionActual.sacarPersonaje();
        }

    }

    public static void mostrarEstadisticas(List<String> estadisticasList){
        for (int i = 0; i<estadisticasList.size(); i++){
            System.out.println(i +estadisticasList.get(i));
        }
    }

    public static void mostrarMisiones(List<Mision>misionList){
        for (int i = 0; i<misionList.size(); i++){
            System.out.println(i +" Nombre de la mision: "+misionList.get(i).getNombreMision());
        }
    }



}