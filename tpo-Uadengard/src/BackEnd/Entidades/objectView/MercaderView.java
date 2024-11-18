package BackEnd.Entidades.objectView;

import java.util.ArrayList;
import java.util.List;

import BackEnd.Entidades.Items;

public class MercaderView {
	private List<Items> itemVenta = new ArrayList<>();
	
    public MercaderView(List<Items> itemVenta) {
    	this.itemVenta = itemVenta;
	}
	public List<Items> getMostrarCatologoItems(){
		return this.itemVenta;
	}
    
}
