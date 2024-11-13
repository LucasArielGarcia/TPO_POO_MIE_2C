package BackEnd.Entidades.objectView;

public class ItemView {
    private String descripcion;
    private int idItems = 0 ;
    private double precio;
    private int nvlItem;

    public ItemView(String descripcion, int idItems, double precio, int nvlItem) {
        this.descripcion = descripcion;
        this.idItems = idItems;
        this.precio = precio;
        this.nvlItem = nvlItem;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdItems() {
        return idItems;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNvlItem() {
        return nvlItem;
    }
}
