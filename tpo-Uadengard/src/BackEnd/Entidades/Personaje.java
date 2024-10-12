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

    public void recibirDaño(int golpe){
        if (this.defensa > 0)
            this.defensa -= golpe;
        this.vida -= golpe;
    }
    public abstract void atacar(Personaje personajeAtacar, Personaje personaje);
    public boolean personajeVivo(){
        return vida > 0;
    }

    public void usarItem(Items item){
        item.usarItem(this);
    }

    public void sumarDefensa(int cantidadDefensa){
        defensa += cantidadDefensa;
    }
    public void sumarDaño(int cantidadDaño){
        daño += cantidadDaño;
    }

    public int golpePersonaje(){
        return this.daño;
    }


    public void mostrarEstadistica(){
        System.out.println(
                "Vida: " + this.vida + "\n"+
                "Defensa: " + this.defensa
        );
    }




}
