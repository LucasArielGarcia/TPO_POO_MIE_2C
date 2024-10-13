package BackEnd.Entidades;

public abstract class Objetivo {
    private boolean completado;

    public void marcarObjetivo(boolean completado) {
        this.completado = completado;
    }

    public abstract void objetivoCompletado();
}
