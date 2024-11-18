package BackEnd.Entidades;

public class Espada extends Items {
    private int aumentoDano;

    public Espada(String descripcion, double precio, int nvlItem, int aumentoDano) {
        super(descripcion, precio, nvlItem);
        this.aumentoDano = aumentoDano;
    }

    @Override
    public void usarItem(Personaje personaje) {
        personaje.sumarDano(aumentoDano);
    }

    @Override
    public String infoItem() {
        return superInfor()+ "Aumenta en daño: "+ aumentoDano;
    }
}
