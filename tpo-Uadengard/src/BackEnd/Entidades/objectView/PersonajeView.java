package BackEnd.Entidades.objectView;

public class PersonajeView {
    private String tipo;
    private int vida;
    private int dano;
    private String nombre;
    private int defensa;


    public PersonajeView(String tipo, int vida, int dano, String nombre, int defensa) {
        this.tipo = tipo;
        this.vida = vida;
        this.dano = dano;
        this.nombre = nombre;
        this.defensa = defensa;
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
}
