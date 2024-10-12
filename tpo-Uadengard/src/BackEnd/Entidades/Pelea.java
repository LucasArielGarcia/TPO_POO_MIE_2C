package BackEnd.Entidades;

public class Pelea {
    Heroe heroe;
    Enemigo enemigo;
    public void peleaPersonajes(){
        while (heroe.personajeVivo() && enemigo.personajeVivo()){
            heroe.atacar(enemigo,heroe);
            System.out.println("Estadistica de nuestro Heroe");
            enemigo.mostrarEstadistica();
            System.out.println("Estadistica de nuestro Enemigo");
            enemigo.atacar(heroe,enemigo);
            heroe.mostrarEstadistica();
        }
    }

    public Pelea(Heroe heroe, Enemigo enemigo) {
        this.heroe = heroe;
        this.enemigo = enemigo;
    }
}
