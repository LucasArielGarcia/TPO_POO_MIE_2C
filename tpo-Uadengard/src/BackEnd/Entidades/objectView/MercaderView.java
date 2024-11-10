package BackEnd.Entidades.objectView;

import java.util.ArrayList;
import java.util.List;

import BackEnd.Entidades.Items;

public class MercaderView {
	private List<Items> itemVenta = new ArrayList<>();
	
    public MercaderView(Items itemVenta) {
    	this.itemVenta.add(itemVenta);
	}
	public List<Items> getMostrarCatologoItems(){
		return this.itemVenta;
	}
    
}
