package BackEnd.Entidades;

public class Arco extends Items {
    private int danoSumar;

    public Arco(String descripcion, double precio, int nvlItem, int danoSumar) {
        super(descripcion, precio, nvlItem);
        this.danoSumar = danoSumar;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDano(danoSumar);
    }
}
