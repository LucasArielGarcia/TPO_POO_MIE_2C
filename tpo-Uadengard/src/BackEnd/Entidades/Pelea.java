package BackEnd.Entidades;

public class Pelea {
    Heroe heroe;
    Enemigo enemigo;
    public void peleaPersonajes(){
        while (heroe.personajeMuerto() && enemigo.personajeMuerto()){
            heroe.atacar(enemigo,heroe);
            enemigo.mostrarEstadistica();
            enemigo.atacar(heroe,enemigo);
            heroe.mostrarEstadistica();

        }
    }

    public Pelea(Heroe heroe, Enemigo enemigo) {
        this.heroe = heroe;
        this.enemigo = enemigo;
    }
}
