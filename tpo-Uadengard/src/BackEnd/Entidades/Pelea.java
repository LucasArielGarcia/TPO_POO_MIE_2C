package BackEnd.Entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pelea {
    private Heroe heroe;
    private List<Enemigo> enemigoList;
    private int ataques = 0;
    public void peleaPersonajes(Heroe heroe, int opcion){

        if (heroe.personajeVivo() && !enemigoList.isEmpty()){
            
            heroe.atacar(this.enemigoList.get(opcion));
            if (!this.enemigoList.get(opcion).personajeVivo()){
                this.enemigoList.remove(opcion);
            }
            if (!enemigoList.isEmpty()){
                Enemigo enenemigoAtaque = elegirEnemigoRandom();
                enenemigoAtaque.atacar(heroe);
            }


        }

    }

    public Enemigo elegirAtaqueEnemigo(int opcion){
        return enemigoList.get(opcion);
    }

    public Pelea(Heroe heroe, List<Enemigo> enemigo) {
        this.heroe = heroe;
        this.enemigoList = enemigo;
    }

    public List<String> mostrarEstadisticaEnemigos(){
        List<String> pilaEstadisticas = new ArrayList<>();
        for (int i = 0; i<enemigoList.size();i++){
            Enemigo enemigo = enemigoList.get(i);
            String estadistica = enemigo.mostrarEstadistica();
            pilaEstadisticas.add(estadistica);
        }
        return pilaEstadisticas;
    }
    public String mostrarEstadisticasHeroe(){
        return heroe.mostrarEstadistica();
    }



    public Enemigo elegirEnemigoRandom (){
        Random random = new Random();
        int enemigoRandom = random.nextInt(enemigoList.size());
        return enemigoList.get(enemigoRandom);
    }

    public boolean hayEnemigos(){
        return !enemigoList.isEmpty();
    }


}
