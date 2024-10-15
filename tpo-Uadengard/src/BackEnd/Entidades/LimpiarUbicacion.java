package BackEnd.Entidades;

public class LimpiarUbicacion extends Mision {


    public LimpiarUbicacion(Items recompensa, String nombreMision) {
        super(recompensa, nombreMision);
    }

    @Override
    public void empezarMision(Heroe heroe) {
        System.out.println("Tienes enemigos con los que pelear te recomendamos que te prepares");

        if (super.hayEnemigos()){
            System.out.println("Hay enemigos preparate");
            Pelea pelea = new Pelea(heroe, super.getEnemigosList());
            super.emepezarPelea(pelea);
        }
        else {
            System.out.println("Donde estan los enemigos...");
        }


    }






}
