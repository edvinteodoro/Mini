public class Reporte {
    String tipo;
    int linea;
    int columna;
    String descripcion;
    public Reporte(String tipo,int linea,int columna,String descripcion){
        this.tipo=tipo;
        this.linea=linea;
        this.columna=columna;
        this.descripcion=descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
