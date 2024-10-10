package BackEnd.Entidades;

abstract class  Personaje {
    private int vida;
    private int nvlAtaque;
    private int nvlDefensa;

    public abstract void atacar();
}
