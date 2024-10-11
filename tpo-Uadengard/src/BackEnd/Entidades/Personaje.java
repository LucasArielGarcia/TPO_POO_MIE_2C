package BackEnd.Entidades;

abstract class  Personaje {
    private int vida;
    private int daño;
    private String nombre;
    private int defensa;

    public Personaje(String nombre, int defensa) {
        this.vida = 100;
        this.daño = 5;
        this.nombre = nombre;
        this.defensa = defensa;
    }

    public abstract void atacar();
    public boolean personajeMuerto(){
        return vida == 0;
    }

    public void usarItem(Items item){
        item.usarItem(this);
    }

    public void sumarDefensa(int cantidadDefensa){
        defensa = cantidadDefensa;
    }
    public void sumarDaño(int cantidadDaño){
        daño = cantidadDaño;
    }


}
