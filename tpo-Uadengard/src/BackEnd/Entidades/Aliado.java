package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Aliado {
    private List<Mision> misionList = new ArrayList<>();

    public List<Mision> misionList (){
        return this.misionList;
    }
}
