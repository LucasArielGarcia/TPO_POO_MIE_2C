package BackEnd.Entidades;

public class DevolverItem extends Mision{
    private Items itemsDevuelta;

    public DevolverItem(Items recompensa, String nombreMision, Items itemsDevuelta) {
        super(recompensa, nombreMision,null);
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
