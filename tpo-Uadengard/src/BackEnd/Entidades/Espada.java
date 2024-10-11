package BackEnd.Entidades;

public class Espada extends Items {
    private int aumentoDaño;

    public Espada(int aumentoDaño) {
        this.aumentoDaño = aumentoDaño;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDaño(aumentoDaño);
    }
}
