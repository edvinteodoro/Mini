
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ManejoArchivos {

    LocalDate fecha;
    String path = "";
    File archivo;
    FileReader entradaStream;
    FileWriter archivoWriter;
    BufferedWriter salidaBuf;
    List<File> archivos = new ArrayList<>();

    
    
    
    
    public void ManejoArchivos() throws IOException {
        fecha = LocalDate.now();
        archivo = new File("Memoria");
    }

    public void nuevoProyecto(String nombre){
        
    }
    
    public void leerProyecto() {

    }

    public void pathActual(String nombre) {
        if (path.isEmpty()) {
            this.path = "/".concat(nombre);
        } else {
            this.path = path + "/".concat(nombre);
        }
    }
//    public void nuevoProyecto(String path) {
//        try {
//            archivo = new File(path);
//            if (!archivo.exists()) {
//                //mensaje que ya existe
//            } else {
//                archivo.createNewFile();
//                archivoWriter = new FileWriter(archivo);
//                salidaBuf = new BufferedWriter(archivoWriter);
//                salidaBuf.write("<> "+path+" <>");
//                salidaBuf.newLine();
//                salidaBuf.write(" "+String.valueOf(fecha)+" ");
//                salidaBuf.flush();
//                
//            }
//        } catch (Exception e) {
//            //error al escribir archivo
//        }
//
//    }

    public void insertarNodo(String path,int tipo) {
        try{
        BufferedWriter bw;
        if (tipo==0) {
            //para directorio
            
        } else {
            //para archivo    
            archivo = new File(path);
            if(archivo.exists()){
                //ya existe el archivo
            
            }else{
                bw = new BufferedWriter(new FileWriter(archivo));
            }
        }
        }catch(Exception e){
        
        }
    }

    public void abrirProyecto(String nombre) throws FileNotFoundException {
        archivo = new File(nombre);
        entradaStream = new FileReader(archivo);

    }
}
