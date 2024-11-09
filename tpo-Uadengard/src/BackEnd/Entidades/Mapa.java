package BackEnd.Entidades;

import BackEnd.Entidades.objectView.MapaView;
import BackEnd.Entidades.objectView.UbicacionView;

import java.util.ArrayList;
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

    public void viajarUbicacionMapa(Ubicacion ubicacionViajar, Heroe heroe){
        ubicacionViajar.llegadaUbicacion(heroe);
    }

    public void aceptarMision(int opcion, Heroe heroe){
        zonaDescanso.aceptarMision(opcion, heroe);
    }

    public MapaView toView(){
        List<UbicacionView> ubicacionViewList = new ArrayList<>();
        for (Ubicacion ubicacion: ubicacionList){
            ubicacionViewList.add(ubicacion.toView());
        }
        return new MapaView(ubicacionViewList);
    }


    public Ubicacion buscarUbicacion(int idUbicacion){
        for (Ubicacion ubicacion: ubicacionList){
            if (ubicacion.soyUbicacion(idUbicacion))
                return ubicacion;
        }
        return null;
    }


}
