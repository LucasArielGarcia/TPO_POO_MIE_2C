package BackEnd.Entidades;

public class Espectro extends Enemigo{
	private int cont=1;
    public Espectro(String nombre, int defensa) {
        super(nombre, 30,"Espectro");
    }

    @Override
    public void dropearItem() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	if (personajeAtacar.tipoEnemigo()=="arquero" && cont==1) {
    		super.sumarDano(20*super.golpePersonaje()/super.golpePersonaje());
    		cont++;
    	}
    	if(personajeAtacar.tipoEnemigo()=="Mago") {
    		personajeAtacar.recibirDano(super.golpePersonaje()*0);
    	}
    	else {
    		personajeAtacar.recibirDano(super.golpePersonaje());
    	}

    }
}
