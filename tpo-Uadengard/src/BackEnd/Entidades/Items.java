package BackEnd.Entidades;

public abstract class Items {
    private String descripcion;
    private int idItems;
    private double precio;
    private int nvlItem;
    public boolean sosItem(int idItem){
        return idItem == this.idItems;
    }

    public abstract void usarItem(Personaje personaje);
}
