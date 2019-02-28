
import javax.swing.JEditorPane;
import javax.swing.JFrame;

/**
 *
 * @author daniel
 */
public class paraHtml {

    public static void main(String[] args) {
        // TODO code application logic here

        JFrame frame = new JFrame("ColorPane");
        frame.setBounds(20, 20, 500, 400);
        frame.setVisible(true);

        String texto = "hola mundo jaja";
        JEditorPane editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        

        String textoRojo = "<font color=\"brown\">" + texto +"</font><br>";
        String textoAzul = "<font color=\"blue\">color rojo</font><br>";
        String textoRojoGrande = "<font size=\"18\" color=\"cafe\">color rojo</font><br>";

        editorPane.setText(textoRojo + textoAzul + textoRojoGrande);

        editorPane.setBounds(20, 20, 260, 160);
        editorPane.setVisible(true);
        frame.add(editorPane);
    }
}
