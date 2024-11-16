package BackEnd.Entidades;

import BackEnd.Entidades.objectView.PersonajeView;

abstract class  Personaje {
	private String tipo;
    private int vida;
    private int dano;
    private String nombre;
    private int defensa;
    private int idPersonaje;
    private static int contador = 0;


    public Personaje(String nombre, int defensa,String tipo) {
        this.vida = 100;
        this.dano = 5;
        this.nombre = nombre;
        this.defensa = defensa;
        this.tipo=tipo;
        this.idPersonaje = ++contador;
    }

    public void recibirDano(int golpe) {




     	if (this.defensa > 0) {
            this.defensa = this.defensa - golpe;
            if (golpe > (defensa + golpe) && defensa < 0) {
                defensa = defensa < 0 ? Math.abs(defensa) : defensa;
                golpe = golpe - defensa;
                this.defensa = 0;
                this.vida = this.vida - golpe;
            }
        }
        else {
                this.vida = this.vida - golpe;
        }
   }
    public abstract void atacar(Personaje personajeAtacar);
    public boolean personajeVivo(){
        return vida > 0;
    }

    public void usarItem(Items item){
        item.usarItem(this);
    }
    public void sacarItem(Items items){
       items.sacarItem(this);
    }


    public void sumarDefensa(int cantidadDefensa){
        defensa += cantidadDefensa;
    }
    public void sumarDano(int cantidadDano){
        dano += cantidadDano;
    }

    public int golpePersonaje(){
        return this.dano;
    }

    public String tipoPersonaje() {
    	return this.tipo;
    }
    public String mostrarEstadistica(){
        return " Nombre: " + this.nombre + " ,Vida del personaje: "+ this.vida+ " ,Defensa del personaje " + this.defensa;
    }

    public PersonajeView toView(){
        return new PersonajeView(this.idPersonaje,this.tipo,this.vida,this.dano,this.nombre,this.defensa);
    }

    public boolean soyPersonaje(int idPersonaje){
        return this.idPersonaje == idPersonaje;
    }

    public void restarDano(int danoRestar){
        this.dano -= danoRestar;
    }
    public void restarDefensa(int defensaRestar){
        this.defensa -= defensaRestar;
    }



}
