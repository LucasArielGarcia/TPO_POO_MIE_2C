package BackEnd.Entidades;

public class DevolverItem extends Mision{
    private Items itemsDevuelta;

    public DevolverItem(Items recompensa, String nombreMision, Items itemsDevuelta,double moneda) {
        super(recompensa, nombreMision,null,moneda);
        this.itemsDevuelta = itemsDevuelta;
    }
    public Items getItemsDevuelta (){
        return itemsDevuelta;
    }

    @Override
    public void empezarMision(Heroe heroe) {
        super.agregarItemAlCofre(itemsDevuelta);
    }
}
