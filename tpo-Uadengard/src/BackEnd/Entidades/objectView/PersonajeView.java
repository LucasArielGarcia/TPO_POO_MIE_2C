package BackEnd.Entidades.objectView;

public class PersonajeView {
    private String tipo;
    private int vida;
    private int dano;
    private String nombre;
    private int defensa;
    private int idPersonaje;

    public PersonajeView(int idPersonaje,String tipo, int vida, int dano, String nombre, int defensa) {
        this.tipo = tipo;
        this.vida = vida;
        this.dano = dano;
        this.nombre = nombre;
        this.defensa = defensa;
        this.idPersonaje = idPersonaje;
    }

    public int getVida() {
        return vida;
    }

    public int getDano() {
        return dano;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }
}
