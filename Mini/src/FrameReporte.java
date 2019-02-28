
import javax.swing.JEditorPane;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teodoro
 */
public class FrameReporte extends javax.swing.JFrame {

    public FrameReporte() {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        ventana();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editorPane = new javax.swing.JEditorPane();

        setTitle("Reporte");

        jScrollPane1.setViewportView(editorPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void ventana(){
        
        String texto = "hola mundo jaja";
        editorPane.setContentType("text/html");
        

        String textoRojo = "<font color=\"brown\">" + texto +"</font><br>";
        String textoAzul = "<font color=\"blue\">color rojo</font><br>";
        String textoRojoGrande = "<font size=\"18\" color=\"cafe\">color rojo</font><br>";

        editorPane.setText(textoRojo + textoAzul + textoRojoGrande);

        editorPane.setBounds(20, 20, 260, 160);
        editorPane.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane editorPane;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
