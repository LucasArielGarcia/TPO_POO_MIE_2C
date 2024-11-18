package BackEnd.Entidades.objectView;

import java.util.ArrayList;
import java.util.List;

import BackEnd.Entidades.Items;

public class MercaderView {
	private List<ItemView> itemVenta = new ArrayList<>();
	
    public MercaderView(List<Items> itemVentaP) {
    	for (Items items : itemVentaP){
			itemVenta.add(items.toView());
		}
	}
	public List<ItemView> getMostrarCatologoItems(){
		return this.itemVenta;
	}
    
}
