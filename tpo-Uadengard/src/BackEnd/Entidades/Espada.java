package BackEnd.Entidades;

public class Espada extends Items {
    private int aumentoDaño;

    public Espada(String descripcion, double precio, int nvlItem, int aumentoDaño) {
        super(descripcion, precio, nvlItem);
        this.aumentoDaño = aumentoDaño;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDaño(aumentoDaño);
    }
}
