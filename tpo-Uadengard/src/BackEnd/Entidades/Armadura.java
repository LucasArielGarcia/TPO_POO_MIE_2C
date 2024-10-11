package BackEnd.Entidades;

public class Armadura  extends Items{
    private int aumentoDefensa;

    public Armadura(int aumentoDefensa) {
        this.aumentoDefensa = aumentoDefensa;
    }


    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDefensa(this.aumentoDefensa);
    }
}
