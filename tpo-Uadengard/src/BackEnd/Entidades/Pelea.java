package BackEnd.Entidades;

import BackEnd.Entidades.objectView.PersonajeView;

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

    public List<PersonajeView> mostrarEstadisticaEnemigos(){
        List<PersonajeView> enemigoViews = new ArrayList<>();
        for (int i = 0; i<enemigoList.size();i++){
            enemigoViews.add(enemigoList.get(i).toView());
        }
        return enemigoViews;
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
        try {
            return !enemigoList.isEmpty();
        }
        catch (NullPointerException e){
            return true;
        }
    }


}
