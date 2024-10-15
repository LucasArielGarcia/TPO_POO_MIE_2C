package BackEnd.Entidades;
import java.util.Random;
public class Arquero extends Heroe {
	Random random=new Random();
    private int agilidad;
    private int apunteria;

    public Arquero(String nombre) {
        super(nombre,60,"Arquero" );
        this.agilidad = 10;
        this.apunteria = 60;
    }

    @Override
    public void curarse() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {	
    	if(personajeAtacar.tipoEnemigo()=="Dragon") {
    	 personajeAtacar.recibirDano(super.golpePersonaje());
    	}
    	else {
    		int acierto=random.nextInt(101);
    		if(acierto<this.apunteria) {
    			personajeAtacar.recibirDano(super.golpePersonaje());
    		}
    		else {
    			System.out.println("el tiro fallo");
    		}
    	}
    	}
    }
