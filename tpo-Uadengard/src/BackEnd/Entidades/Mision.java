package BackEnd.Entidades;

public class Mision {
    private Items recompensa;
    private String nombreMision;
    private Ubicacion ubicacion;
    private Objetivo objetivo;

    public Mision(Items recompensa, String nombreMision, Ubicacion ubicacion, Objetivo objetivo) {
        this.recompensa = recompensa;
        this.nombreMision = nombreMision;
        this.ubicacion = ubicacion;
        this.objetivo = objetivo;
    }
    


}
