package BackEnd.Entidades;

public class Armadura  extends Items{
    private int aumentoDefensa;


    public Armadura(String descripcion,double precio, int nvlItem, int aumentoDefensa) {
        super(descripcion, precio, nvlItem);

        this.aumentoDefensa = aumentoDefensa;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDefensa(this.aumentoDefensa);
    }

    @Override
    public void sacarItem(Personaje personaje) {
        personaje.restarDefensa(aumentoDefensa);
    }

    @Override
    public String infoItem() {
        return superInfor() + "defensa item: "+aumentoDefensa;
    }
}
