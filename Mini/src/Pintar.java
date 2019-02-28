import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Pintar {

    int posicion;
    public String tabulacion;
    public JTextPane caja2;
    public StyleContext sc;
    public DefaultStyledDocument doc;

    Pintar(JTextPane caja2) {
        this.caja2 = caja2;
        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);
        tabulacion = "";
    }

    public void tabular() {
        this.tabulacion += "     ";
    }

    public void insTab() {
        posicion = caja2.getText().length();
        caja2.setDocument(doc);
        try {
            doc.insertString(posicion, tabulacion, null);

        } catch (Exception ex) {
            System.out.println("ERROr: no se pudo establecer estilo de documento");
        }

    }

    public void resTabular() {
        this.tabulacion = this.tabulacion.substring(0, this.tabulacion.length() - 5);
    }

    public void insertar(String texto) {
        posicion = caja2.getText().length();
        caja2.setDocument(doc);
        try {
            doc.insertString(posicion, texto, null);

        } catch (Exception ex) {
            System.out.println("ERROr: no se pudo establecer estilo de documento");
        }

    }

    public void pintaRojo(int posini, int posfin) {
        Style rojo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(rojo, Color.red);
        doc.setCharacterAttributes(posicion + posini, posfin, rojo, false);
    }

    public void pintaAmarillo(int posini, int posfin) {
        Style amarillo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(amarillo, Color.YELLOW);
        doc.setCharacterAttributes(posicion + posini, posfin, amarillo, false);

    }

    public void pintaVerde(int posini, int posfin) {
        Style verde = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(verde, Color.green);
        doc.setCharacterAttributes(posicion + posini, posfin, verde, false);
    }

    public void pintaAzul(int posini, int posfin) {
        Style azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.blue);
        doc.setCharacterAttributes(posicion + posini, posfin, azul, false);

    }
    public void pintaNaranja(int posini, int posfin){
            Style azul = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azul, Color.ORANGE);
        doc.setCharacterAttributes(posicion + posini, posfin, azul, false);

    }

    public void pintaAzulO(int posini, int posfin) {
        Style azulo = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(azulo, Color.getHSBColor(240, 100, 55));
        doc.setCharacterAttributes(posini, posfin, azulo, false);

    }

    public void pintaCafe(int posini, int posfin) {
        Style cafe = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(cafe, Color.getHSBColor(0, 75, 65));
        doc.setCharacterAttributes(posini, posfin, cafe, false);
    }

    public void pintaMora(int posini, int posfin) {
        Style mora = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(mora, Color.MAGENTA);
        doc.setCharacterAttributes(posicion + posini, posfin, mora, false);
    }

    public void pintaNara(int posini, int posfin) {
        Style nara = sc.addStyle("ConstantWidth", null);
        StyleConstants.setForeground(nara, Color.getHSBColor(33, 100, 100));
        doc.setCharacterAttributes(posini, posfin, nara, false);
    }

}
