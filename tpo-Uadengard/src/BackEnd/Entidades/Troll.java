package BackEnd.Entidades;

public class Troll extends Enemigo {
	private int cont=1;
    public Troll(String nombre, int defensa) {
        super(nombre, 50,"Troll");
    }

    @Override
    public void habilidadPersonajeExtra(Personaje heroe) {
        if (heroe.tipoPersonaje().equals("Mago")){
            int golpe = super.golpePersonaje();
            golpe = (int) (golpe*0.15);
            super.sumarDano(golpe);
        }
        
    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	if (personajeAtacar.tipoPersonaje()=="Mago" && cont==1) {
    		super.sumarDefensa(15*50/100);
    		cont++;
    	}
    	personajeAtacar.recibirDano(super.golpePersonaje());
    }
}
