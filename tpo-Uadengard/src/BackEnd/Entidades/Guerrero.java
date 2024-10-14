package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Guerrero extends Heroe {

    @Override
    public void curarse() {

    }


    @Override
    public void atacar(Personaje personajeAtacar) {
        personajeAtacar.recibirDaño(super.golpePersonaje());

    }


    public Guerrero(String nombre) {
        super(nombre, 80);
        equipoComienzo();

    }

    private void equipoComienzo(){
        Items armadura = new Armadura("Armadura de cuero",0,0,20);
        Items espada = new Espada("Espada de metal",0,0,35);
        super.equiparItem(armadura);
        super.equiparItem(espada);
    }
}
