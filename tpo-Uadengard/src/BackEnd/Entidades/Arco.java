package BackEnd.Entidades;

public class Arco extends Items {
    private int dañoSumar;

    public Arco(String descripcion, double precio, int nvlItem, int dañoSumar) {
        super(descripcion, precio, nvlItem);
        this.dañoSumar = dañoSumar;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDaño(dañoSumar);
    }
}
