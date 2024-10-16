package BackEnd.Entidades;

public class Mago extends Heroe {
    public Mago(String nombre) {
        super(nombre, 40,"Mago");
    }

    @Override
    public void curarse() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	personajeAtacar.recibirDano(super.golpePersonaje());
    }

    private void equipoComienzo(){
        Items baculo = new Baculo("baculo de roble",0,0,15);
        Items armadura = new Armadura("Tunica de principiante",0,0,20);
        super.equiparItem(baculo);
        super.equiparItem(armadura);
    }

}
