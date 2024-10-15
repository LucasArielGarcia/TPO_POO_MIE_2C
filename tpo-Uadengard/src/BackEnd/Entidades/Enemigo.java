package BackEnd.Entidades;

public abstract class Enemigo extends Personaje{
    public Enemigo(String nombre, int defensa,String tipo) {
        super(nombre, defensa,tipo);
    }

    public abstract void dropearItem();



}
