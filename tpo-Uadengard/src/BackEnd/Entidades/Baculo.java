package BackEnd.Entidades;

public class Baculo extends Items {
    private int aumentoDaño;

    public Baculo(int aumentoDaño) {
        this.aumentoDaño = aumentoDaño;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDaño(aumentoDaño);
    }
}
