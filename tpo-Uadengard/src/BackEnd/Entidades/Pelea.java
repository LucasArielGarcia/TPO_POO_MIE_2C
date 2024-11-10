package BackEnd.Entidades;

import BackEnd.Entidades.objectView.PersonajeView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pelea {
    private Heroe heroe;
    private List<Enemigo> enemigoList;
    private int ataques = 0;
    public Pelea(Heroe heroe, List<Enemigo> enemigos) {
        this.heroe = heroe;
        this.enemigoList = enemigos;
    }
    public void peleaPersonajes(Heroe heroe, int idEnemigo){

        if (heroe.personajeVivo() && !enemigoList.isEmpty()){
            Enemigo enemigo = buscarEnemigo(idEnemigo);
            heroe.atacar(enemigo);
            if (!enemigo.personajeVivo()){
                eliminarEnemigo(idEnemigo);
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

    public Enemigo buscarEnemigo(int idEnemigo){
        for (Enemigo enemigo: enemigoList){
            if(enemigo.soyPersonaje(idEnemigo)){
                return enemigo;
            }
        }
        return null;
    }

    public void eliminarEnemigo(int id){
        for (int i = 0; i<this.enemigoList.size(); i++){
            if (this.enemigoList.get(i).soyPersonaje(id)){
                this.enemigoList.remove(i);
            }
        }
    }

}
