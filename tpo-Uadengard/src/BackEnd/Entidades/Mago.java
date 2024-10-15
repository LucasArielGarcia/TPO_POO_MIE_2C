package BackEnd.Entidades;

public class Mago extends Heroe {
    public Mago(String nombre) {
        super(nombre, 40,"Mago");
    }

    @Override
    public void curarse() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	personajeAtacar.recibirDano(super.golpePersonaje());
    }

}
