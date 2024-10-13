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




}
