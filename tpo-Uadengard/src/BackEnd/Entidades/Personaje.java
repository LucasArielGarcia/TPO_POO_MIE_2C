package BackEnd.Entidades;

abstract class  Personaje {
	private String tipo;
    private int vida;
    private int dano;
    private String nombre;
    private int defensa;

    public Personaje(String nombre, int defensa,String tipo) {
        this.vida = 100;
        this.dano = 5;
        this.nombre = nombre;
        this.defensa = defensa;
        this.tipo=tipo;
    }

    public void recibirDano(int golpe) {
    	if (this.defensa > 0)
           this.defensa = this.defensa - golpe;
    		if(golpe>defensa) {
    			golpe=golpe-defensa;
    			this.defensa=0;
    			this.vida=this.vida-golpe;
    		}
       else
          this.vida = this.vida - golpe;
   }
    public abstract void atacar(Personaje personajeAtacar);
    public boolean personajeVivo(){
        return vida > 0;
    }

    public void usarItem(Items item){
        item.usarItem(this);
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
        String estadistica = " ,Nombre: " + this.nombre + " ,Vida del personaje: "+ this.vida+ " ,Defensa del personaje " + this.defensa;
        return estadistica;
    }




}
