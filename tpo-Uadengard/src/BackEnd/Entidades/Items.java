package BackEnd.Entidades;

import BackEnd.Entidades.objectView.ItemView;
import BackEnd.Entidades.objectView.ItemsMochilaView;

public abstract class Items {
    private String descripcion;
    private int idItems;
    private static int contador = 0;
    private double precio;
    private int nvlItem;

    public Items(String descripcion, double precio, int nvlItem) {
        this.descripcion = descripcion;
        this.idItems = ++contador;
        this.precio = precio;
        this.nvlItem = nvlItem;
    }

    public boolean sosItem(int idItem){
        return idItem == this.idItems;
    }

    public abstract void usarItem(Personaje personaje);

    public int getNvlItem() {
        return nvlItem;
    }

    public abstract String infoItem();
    protected String superInfor(){
        return this.descripcion;
    }

    public ItemView toView(){
        return new ItemView(this.descripcion,this.idItems,this.precio,this.nvlItem);
    }
}
