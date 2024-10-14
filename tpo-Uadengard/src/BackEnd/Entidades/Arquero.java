package BackEnd.Entidades;

public class Arquero extends Heroe {

    private int agilidad;
    private int apunteria;

    public Arquero(String nombre) {
        super(nombre,60 );
        this.agilidad = 10;
        this.apunteria = 10;
    }

    @Override
    public void curarse() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {

    }

}
