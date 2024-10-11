package BackEnd.Entidades;

abstract class Enemigo extends Personaje{
    public Enemigo(int vida, int daño, String nombre) {
        super(vida, daño, nombre);
    }

    public abstract void dropearItem();
}
