package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Guerrero extends Heroe {
	private int cantidadAtaques=1;

    @Override
    public void curarse() {
    	this.sumarDefensa(60);
    }
    @Override
    public void atacar(Personaje personajeAtacar) {
        if(personajeAtacar.tipoPersonaje()=="Troll") {
        	personajeAtacar.recibirDano(super.golpePersonaje() * 100);
            this.cantidadAtaques++;
        }
        else if (cantidadAtaques >= 3) {
            personajeAtacar.recibirDano(super.golpePersonaje() * 2);
        }
        else {
            personajeAtacar.recibirDano(super.golpePersonaje());
            this.cantidadAtaques++;
        }
    }

    public Guerrero(String nombre) {
        super(nombre, 60,"Guerrero");
        equipoComienzo();

    }

    private void equipoComienzo(){
        Items armadura = new Armadura("Armadura de cuero",0,0,5);
        Items espada = new Espada("Espada de metal",0,0,100);
        super.agregarItemMochila(armadura);
        super.agregarItemMochila(espada);
    }
}
