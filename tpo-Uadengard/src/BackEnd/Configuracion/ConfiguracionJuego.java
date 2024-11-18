package BackEnd.Configuracion;

import BackEnd.Entidades.*;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionJuego {
    private ZonaDescanso zonaDescanso;
    private List<Enemigo> enemigoList = new ArrayList<>();
    private Enemigo jefe;
    private Aliado aliado;
    private Mercader mercader;
    private List<Mision> misionList = new ArrayList<>();
    private List<Items> itemsList = new ArrayList<>();
    private Mapa mapa;


    public ConfiguracionJuego() {
        Enemigo espectro0 = new Espectro("Especto fantasma",2);
        Enemigo Troll1 = new Troll("troll verde",2);
        this.enemigoList.add(espectro0);
        Troll troll = new Troll("Troll",50);
        this.enemigoList.add(troll);
        Dragon dragon = new Dragon("Dragon", 80);
        this.enemigoList.add(dragon);

        Armadura armadura1 = new Armadura("Armadura de hierro",100,1,100);
        Espada espada1 = new Espada("Espada de hierro",100,1,20);
        Baculo baculo1 = new Baculo("Baculo de pino", 100, 1, 10);
        Arco arco1 = new Arco("Arco de pino",100,1,25);
        itemsList.add(armadura1);
        itemsList.add(espada1);
        itemsList.add(baculo1);
        itemsList.add(arco1);
        this.mercader = new Mercader(itemsList);

        List<Enemigo> enemigosPantano = new ArrayList<>();
        enemigosPantano.add(espectro0);
        enemigosPantano.add(Troll1);

        LimpiarUbicacion limpiarPantano = new LimpiarUbicacion(arco1, "limpiar pantano",espada1); // en caso que no quieran agregar cofre LimpiarUbicacion limpiarPantano = new LimpiarUbicacion(arco1, "limpiar pantano",null);
        limpiarPantano.cargarEnemigos(enemigosPantano);

        this.misionList.add(limpiarPantano);
        DevolverItem devolverItemEnCastillo = new DevolverItem(espada1,"Traer objeto castillo",baculo1);
        this.misionList.add(devolverItemEnCastillo);

        Ubicacion ubicacion1 = new Ubicacion("Pantano",limpiarPantano,"C:\\Users\\LUCAS\\Downloads\\pantano.png");
        Ubicacion ubicacion2 = new Ubicacion("Castillo",devolverItemEnCastillo, "C:\\Users\\LUCAS\\Downloads\\castillo.png");
        List<Ubicacion> ubicacionList = new ArrayList<>();
        ubicacionList.add(ubicacion1);
        ubicacionList.add(ubicacion2);
        this.aliado = new Aliado(this.misionList);
        this.mercader = new Mercader(itemsList);
        this.zonaDescanso = new ZonaDescanso(this.mercader,this.aliado);
        mapa= new Mapa(zonaDescanso,ubicacionList);
    }

    public ZonaDescanso getZonaDescanso() {
        return zonaDescanso;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public Mercader getMercader(){return this.mercader;}
}
