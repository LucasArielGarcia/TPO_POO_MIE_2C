package BackEnd.Entidades;

import java.util.List;

public class Mapa {
    private List<Ubicacion> ubicacionList;
    private ZonaDescanso zonaDescanso;

    public Mapa(ZonaDescanso zonaDescanso, List<Ubicacion> ubicacionList) {
        this.zonaDescanso = zonaDescanso;
        this.ubicacionList = ubicacionList;
    }

    public List<Mision> mostrarMisionList(){
        return zonaDescanso.mostrarMisionesList();
    }
    public List<Items> mostrarItems(){
        return zonaDescanso.mostrarCatologoItems() ;
    }

    public Ubicacion ubicacionPersonaje(){
        for (Ubicacion ubicacion: ubicacionList){
            if (ubicacion.personajeSeEncuentra()){
                return ubicacion;
            }
        }
        return null;
    }

    public List<Ubicacion> abrirMapa(){
        return this.ubicacionList;
    }

    public Ubicacion viajarUbicacionMapa(int opcion, Heroe heroe){
        for (int i = 0; i<ubicacionList.size();i++){
            if (opcion == i){
                Ubicacion ubicacionReturn = ubicacionList.get(i);
                ubicacionReturn.llegadaUbicacion(heroe);
                return ubicacionReturn;
            }
        }
        System.out.println("No se encontro la ubicacion");
        return null ;
    }

    public void aceptarMision(int opcion, Heroe heroe){
        zonaDescanso.aceptarMision(opcion, heroe);
    }




}
