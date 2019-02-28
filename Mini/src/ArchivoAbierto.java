
import javax.swing.JTextArea;

public class ArchivoAbierto {
    public String path;
    public JTextArea textArea;
    public ArchivoAbierto(String path,JTextArea textArea) {
        this.path=path;
        this.textArea=textArea;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    
}
