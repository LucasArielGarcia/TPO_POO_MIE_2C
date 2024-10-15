package BackEnd.Juego;

import BackEnd.Entidades.*;

import java.util.List;

public class Juego {
    private Mapa mapa;
    private Heroe heroe;
    private ZonaDescanso zonaDescanso;
    private Ubicacion ubicacion;
    private Mision mision;

    public Juego(Mapa mapa, ZonaDescanso zonaDescanso) {
        this.mapa = mapa;
        this.zonaDescanso = zonaDescanso;
    }

    public Heroe crearHeroe(int tipoHeroe, String nombre){
        switch (tipoHeroe){
            case 1:
                this.heroe = new Guerrero(nombre);
                break;
            case 2:
                this.heroe = new Arquero(nombre);
                break;
            case 3:
                this.heroe = new Mago(nombre);
                break;
            default:
                System.out.println("Tipo de héroe no válido.");
        }

        return this.heroe;
    }


    public List<Mision> mostrarMisionList(){
        return mapa.mostrarMisionList();
    }
    public List<Items> mostrarCatalogoMercaderItems(){
        return mapa.mostrarItems() ;
    }

    public void aceptarMision(int opcion, Heroe heroe){
        mapa.aceptarMision(opcion,heroe);
    }




    public void empezarMision(){
        if (this.ubicacion.personajeSeEncuentra() && (this.ubicacion.tengoMision() && heroe.misionSonIguales(this.ubicacion.getMision()))){
            this.ubicacion.empezarMision();
        }
    }

    public boolean hayMision(){
        if (this.ubicacion.tengoMision() &&(this.ubicacion.tengoMision() && heroe.misionSonIguales(this.ubicacion.getMision())))
            return true ;
        else
            return false;
    }
    public boolean hayPelea(){
        return this.ubicacion.hayPelea();
    }

    public void pelea(int opcion){
        if (hayPelea())
            ubicacion.pelea(heroe,opcion);
    }

    public String viajarUbicacion(int opcion, Heroe heroe){
        this.ubicacion=mapa.viajarUbicacionMapa(opcion, heroe);
        return "nuestro heroe se encuentra en"+ ubicacion.getNombreUbicacion();
    }

    public void viajarZonaDescanso(Mapa mapa, ZonaDescanso zonaDescanso){
        Ubicacion ubicacion = mapa.ubicacionPersonaje();
        if (ubicacion != null)
            ubicacion.sacarPersonaje();
        zonaDescanso.llegarZonaDescanso(heroe);
    }

    public List<Ubicacion> abrirMapa(){
        return mapa.abrirMapa();
    }

    public void comprarItem(){

    }
    public List<String> estadisticasEnemigos(){
        return this.ubicacion.estadisticasEnemigos();
    }

    public void cerrarMision(){
        ubicacion.terminarMision();
    }

    public boolean reclamarRecompensa(){return zonaDescanso.reclamarRecompensa();}
    public List<String>abrirMochila(){return heroe.abrirMochila();}



}


/*
* public static void viajarZonaJuego(int opcion, Juego juego, Heroe heroe, Scanner scanner){
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

    }*/