package BackEnd.Entidades;

public class Mago extends Heroe {
    public Mago(String nombre) {
        super(nombre, 40,"Mago");
        equipoComienzo();
    }

    @Override
    public void curarse() {

    }

    @Override
    public void atacar(Personaje personajeAtacar) {
    	personajeAtacar.recibirDano(super.golpePersonaje());
    }

    private void equipoComienzo(){
        Items baculo = new Baculo("baculo de roble",0,0,25);
        Items armadura = new Armadura("Tunica de principiante",0,0,20);
        super.agregarItemMochila(baculo);
        super.agregarItemMochila(armadura);
    }

}
