package BackEnd.Entidades;

public class Espectro extends Enemigo{


    public Espectro(String nombre, int defensa) {
        super(nombre, 30);
    }

    @Override
    public void dropearItem() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
        personajeAtacar.recibirDano(super.golpePersonaje());

    }
}
