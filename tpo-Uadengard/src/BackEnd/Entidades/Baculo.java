package BackEnd.Entidades;

public class Baculo extends Items {

    private int aumentoDaño;

    public Baculo(String descripcion, double precio, int nvlItem, int aumentoDaño) {
        super(descripcion, precio, nvlItem);
        this.aumentoDaño = aumentoDaño;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDaño(aumentoDaño);
    }
}
