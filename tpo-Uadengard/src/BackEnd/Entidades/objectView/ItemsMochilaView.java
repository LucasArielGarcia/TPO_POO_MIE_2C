package BackEnd.Entidades.objectView;

import BackEnd.Entidades.Items;

import java.util.ArrayList;
import java.util.List;

public class ItemsMochilaView {
        private List<Items> itemMochila = new ArrayList<>();

        public ItemsMochilaView(List<Items> itemMochila) {
            this.itemMochila = itemMochila;
        }
        public List<Items> getMostrarItemsMochila(){
            return this.itemMochila;
        }

}
