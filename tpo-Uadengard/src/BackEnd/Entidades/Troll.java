package BackEnd.Entidades;

public class Troll extends Enemigo {
	private int cont=1;
    public Troll(String nombre, int defensa) {
        super(nombre, 50,"Troll");
    }

    @Override
    public void dropearItem() {
        
    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	if (personajeAtacar.tipoEnemigo()=="Mago" && cont==1) {
    		super.sumarDefensa(15*50/100);
    		cont++;
    	}
    	personajeAtacar.recibirDano(super.golpePersonaje());
    }
}
