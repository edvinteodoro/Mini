
import java.io.File;

public class ArchivoCodigo {

    String nombre;
    String contenido;

    public ArchivoCodigo(String nombre, String contenido) {
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return contenido;
    }

    public void setArchivo(String archivo) {
        this.contenido = archivo;
    }
    
}
