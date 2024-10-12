package BackEnd.Entidades;

public class Guerrero extends Heroe {

    @Override
    public void curarse() {

    }


    @Override
    public void atacar(Personaje personajeAtacar, Personaje personaje) {
        personajeAtacar.recibirDaño(personaje.golpePersonaje());
    }


    public Guerrero(String nombre) {
        super(nombre, 80);
    }
}
