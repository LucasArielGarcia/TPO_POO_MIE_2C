package BackEnd.Entidades;

public class Dragon extends Enemigo {
	private int cont=1;
    public Dragon(String nombre, int defensa) {
        super(nombre, 70,"Dragon");
    }
    @Override
    public void atacar(Personaje personajeAtacar) {
    	if (personajeAtacar.tipoPersonaje()=="Guerrero" && cont==1) {
    		super.sumarDano(30*super.golpePersonaje()/super.golpePersonaje());
    		cont++;
    	}
    		personajeAtacar.recibirDano(super.golpePersonaje());
    }

    @Override
    public void habilidadPersonajeExtra(Personaje heroe) {

    }
}
