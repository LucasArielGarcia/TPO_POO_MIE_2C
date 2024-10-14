package BackEnd.Entidades;

public abstract class Enemigo extends Personaje{
    public Enemigo(String nombre, int defensa) {
        super(nombre, defensa);
    }

    public abstract void dropearItem();



}
