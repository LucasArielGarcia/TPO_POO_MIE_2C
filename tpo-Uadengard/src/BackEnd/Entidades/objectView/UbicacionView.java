package BackEnd.Entidades.objectView;

public class UbicacionView {

    private String nombreUbicacion;
    private String urlImagen;
    private int idUbicacion;

    public UbicacionView(String nombreUbicacion, String urlImagen, int idUbicacion) {
        this.nombreUbicacion = nombreUbicacion;
        this.urlImagen = urlImagen;
        this.idUbicacion = idUbicacion;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public int getIdUbicacion() {
        return idUbicacion;
    }
}
