package BackEnd.Entidades;

public class Dragon extends Enemigo {
	private int cont=1;
    public Dragon(String nombre, int defensa) {
        super(nombre, 70,"Dragon");
    }
    @Override
    public void dropearItem() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	if (personajeAtacar.tipoEnemigo()=="Guerrero" && cont==1) {
    		super.sumarDano(30*super.golpePersonaje()/super.golpePersonaje());
    		cont++;
    	}
    		personajeAtacar.recibirDano(super.golpePersonaje());
    }
}
