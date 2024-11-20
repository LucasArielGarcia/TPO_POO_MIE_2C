package BackEnd.Entidades.objectView;

public class HeroeToview{
    private int vida;
    private int dano;
    private String nombre;
    private int defensa;
    private double monedas;
    private String misionActual;

    public HeroeToview(int vida, int dano, String nombre, int defensa, double monedas, String misionActual) {
        this.vida = vida;
        this.dano = dano;
        this.nombre = nombre;
        this.defensa = defensa;
        this.monedas = monedas;
        this.misionActual = misionActual;
    }

    public double getMonedas() {
        return monedas;
    }

    public String getMisionActual() {
        if (misionActual==null){
            return "no tiene mision";
        }
        return misionActual;
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
