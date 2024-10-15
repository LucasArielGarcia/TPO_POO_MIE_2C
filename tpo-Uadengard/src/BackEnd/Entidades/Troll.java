package BackEnd.Entidades;

public class Troll extends Enemigo {
    public Troll(String nombre, int defensa) {
        super(nombre, 50,"Troll");
    }

    @Override
    public void dropearItem() {
        
    }

    @Override
    public void atacar(Personaje personajeAtacar) {

    }
}
