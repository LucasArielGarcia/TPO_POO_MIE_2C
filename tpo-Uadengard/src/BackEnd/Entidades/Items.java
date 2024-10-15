package BackEnd.Entidades;

public abstract class Items {
    private String descripcion;
    private int idItems = 0 ;
    private double precio;
    private int nvlItem;

    public Items(String descripcion, double precio, int nvlItem) {
        this.descripcion = descripcion;
        this.idItems = ++idItems;
        this.precio = precio;
        this.nvlItem = nvlItem;
    }

    public boolean sosItem(int idItem){
        return idItem == this.idItems;
    }

    public abstract void usarItem(Personaje personaje);

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNvlItem() {
        return nvlItem;
    }

    public abstract String infoItem();
    protected String superInfor(){
        return " Descripcion item: "+this.descripcion;
    }
}
