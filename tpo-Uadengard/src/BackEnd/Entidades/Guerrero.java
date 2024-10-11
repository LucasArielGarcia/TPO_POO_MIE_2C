package BackEnd.Entidades;

import java.util.List;

public class Guerrero extends Heroe {

    @Override
    public void curarse() {

    }


    @Override
    public void atacar() {
    }


    public Guerrero(String nombre) {
        super(nombre, 80);
    }
}
