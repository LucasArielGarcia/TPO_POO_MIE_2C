package BackEnd.Entidades;

import java.util.List;

public abstract class Mision {
    private static int contador = 0;
    private int idMision;
    private Items recompensa;
    private String nombreMision;
    private boolean objetivoCompletado;
    private List<Enemigo> enemigosList;
    private Pelea pelea;
    private Items cofre;


    public Mision(Items recompensa, String nombreMision) {
        this.idMision = ++contador;
        this.recompensa = recompensa;
        this.nombreMision = nombreMision;
        this.objetivoCompletado = false;
    }
    public void cargarEnemigos(List<Enemigo>listaEnemigos){
        this.enemigosList = listaEnemigos;
    }


    public abstract void empezarMision(Heroe heroe);




    public void marcarMisionCompletada(){
        this.objetivoCompletado = true;
    }

    public boolean misionCompleta(){
        return this.objetivoCompletado == true;
    }

    public Items darRecompensa(){
        return this.recompensa;
    }


    public boolean hayEnemigos(){
        return !enemigosList.isEmpty();
    }


    public List<Enemigo> getEnemigosList() {
        return enemigosList;
    }


    public void emepezarPelea(Pelea empiezaPelea){
        this.pelea = empiezaPelea;
    }
    public void peleaHeroe(Heroe heroe, int opcion){
        if (this.pelea != null) {
            this.pelea.peleaPersonajes(heroe, opcion);
        }
    }

    public List<String>mostrarEstadisticasEnemigos(){
        return pelea.mostrarEstadisticaEnemigos();
    }

    public String mostrarEstadisticaHeroe(){
        return pelea.mostrarEstadisticasHeroe();
    }

    public boolean existePelea(){
        try {
            return this.pelea.hayEnemigos();
        }
        catch (NullPointerException e){
            return false;
        }

    }
    public void terminarPelea(){
        this.pelea =null;
    }

    public String getNombreMision() {
        return nombreMision;
    }

    public void agregarItemAlCofre(Items items){
        this.cofre = items;
    }

    public boolean hayCofre(){
        return this.cofre != null;
    }

    public String abrirCofre(Heroe heroe){
        heroe.agregarItemMochila(this.cofre);
        return "En el cofre hay: " +cofre.infoItem();
    }
}
