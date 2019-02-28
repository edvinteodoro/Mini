
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class Escritorio extends javax.swing.JFrame {

    List<ArchivoCodigo> codigos;
    DefaultMutableTreeNode nodoActual;
    List<Reporte> listErrores;
    String auxRes = "";
    String nomProyecto = "";
    String nomActual = "";
    List<String> contenidoArchivo;
    int pestanias = 0;
    List<Nodo> nodos;
    ManejoArchivos manejoArchivos;
    String PathCreado;
    Pintar pintar;
    String nombre = "";
    JTextArea areaText;
    String path = "";
    List<JTextArea> textAreas = new ArrayList<>();
    List<String> textAreaPath;
    FrameReporte frameReporte;

    public Escritorio(ManejoArchivos manejoArchivos) {
        initComponents();
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        this.manejoArchivos = manejoArchivos;
        pintar = new Pintar(this.paneldeTexto);
        nodos = new ArrayList<>();
        this.codigos = new ArrayList<>();
        listErrores = new ArrayList<>();
        frameReporte = new FrameReporte();
        textAreaPath = new ArrayList<>();
        this.contenidoArchivo = new ArrayList<>();
        this.nodos.add(new Nodo("Proyectos", "Proyectos"));
        popupTree();
        inicializar();
    }

    public void levantarTree(File archivo) {
        try {
            String cadena;
            String textos = "";
            BufferedReader b = new BufferedReader(new FileReader(archivo));
            while ((cadena = b.readLine()) != null) {
                textos = LeerProyecto("Proyectos/" + cadena + ".mpr");
                new parser3(new lexico2(new StringReader(textos)), this).parse();
                this.nodoActual = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            }
            b.close();

        } catch (Exception e) {

        }
    }

    public void inicializar() {
        try {
            File archivo = new File("Proyectos");
            if (!archivo.exists()) {
                archivo.mkdir();
            }
            archivo = new File("Proyectos.dat");
            if (!archivo.exists()) {
                archivo.createNewFile();
            } else {
                tree.setSelectionRow(0);
                this.nodoActual = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                this.levantarTree(archivo);
            }
        } catch (Exception e) {

        }
    }

    public void inserNodoTree(String respuesta) {
        if (nodoActual != null) {

            System.out.println(nodoActual);
            DefaultTreeModel md1 = (DefaultTreeModel) tree.getModel();
            DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(respuesta);
            md1.insertNodeInto(nuevo, nodoActual, 0);
            path(nodoActual, respuesta);
            if (!respuesta.contains(".")) {
                this.nodoActual = nuevo;
            } else {
                this.codigos.add(new ArchivoCodigo(respuesta, path));
            }
            path = "";
        } else {
            this.nodoActual = null;
        }

    }

    public void regresarNodo() {
        try {
            this.nodoActual = (DefaultMutableTreeNode) this.nodoActual.getParent();
        } catch (Exception e) {
            System.out.println("erro regresar nodo");
        }
    }

    public void lineaFilaCursor() {
        textAreas.get(tabbedPane.getSelectedIndex()).addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int pos = e.getDot();
                try {

                    int row = textAreas.get(tabbedPane.getSelectedIndex()).getLineOfOffset(pos) + 1;
                    int col = pos - textAreas.get(tabbedPane.getSelectedIndex()).getLineStartOffset(row - 1) + 1;
                    columnaText.setText(String.valueOf(row));
                    filaText.setText(String.valueOf(col));

                } catch (BadLocationException error) {
                    System.out.println(error);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tree = new javax.swing.JTree();
        jScrollPane3 = new javax.swing.JScrollPane();
        paneldeTexto = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        filaText = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        columnaText = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        nuevoProyect = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini IDE");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Proyectos");
        tree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(tree);

        paneldeTexto.setEditable(false);
        jScrollPane3.setViewportView(paneldeTexto);

        jButton1.setText(">>");

        jButton2.setText(">");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        filaText.setText("-");

        jLabel2.setText("Columna:");

        jLabel3.setText("Fila:");

        columnaText.setText("-");

        jMenu1.setText("Archivo");

        nuevoProyect.setText("Nuevo Proyecto");
        nuevoProyect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoProyectActionPerformed(evt);
            }
        });
        jMenu1.add(nuevoProyect);

        jMenuItem2.setText("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        jMenuItem1.setText("Reporte1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filaText, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(columnaText, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addComponent(tabbedPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(tabbedPane)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(filaText)
                            .addComponent(jLabel3)
                            .addComponent(columnaText))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoProyectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoProyectActionPerformed
        String respuesta = JOptionPane.showInputDialog("Escriba el nombre del proyecto");
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (nodo != null) {
            DefaultTreeModel md1 = (DefaultTreeModel) tree.getModel();
            md1.insertNodeInto(new DefaultMutableTreeNode(respuesta), nodo, md1.getChildCount(nodo));
            path(nodo, respuesta);
            insertarArchivoProyecto(respuesta);
            crearCarpeta(path);
            path = "";
        }
    }//GEN-LAST:event_nuevoProyectActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            pintar.tabulacion = "";
            this.paneldeTexto.setText("");
            int index = tabbedPane.getSelectedIndex();
            //   this.path=this.textAreaPath.get(index);
            new parser(new lexico(new StringReader(this.textAreas.get(index).getText())), pintar).parse();
            this.guardarContenido(index, this.textAreas.get(index).getText());
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.frameReporte.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void abrirArchivo(String nombre) {
        Component panel1 = null;
        this.textAreas.add(new JTextArea());
        this.textAreaPath.add(path);
        textAreas.get(this.textAreas.size() - 1).setText(textoCodigo(nombre));
        tabbedPane.addTab(nombre, textAreas.get(this.textAreas.size() - 1));
        tabbedPane.setSelectedIndex(pestanias);
        lineaFilaCursor();
        pestanias++;
    }

    public void guardarContenido(int index, String texto) {
        try {
            File archivo = new File(this.textAreaPath.get(index));
            archivo.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(texto);
            bw.close();
        } catch (IOException ex) {

        }
    }

    public String textoCodigo(String nombre) {
        int p = 0;
        String texto = "";
        for (int i = 0; i < this.codigos.size(); i++) {
            if (this.codigos.get(i).getArchivo().equals(path)) {
                texto = LeerProyecto(this.codigos.get(i).getArchivo());
                p = 1;
                break;
            }

        }
        path = "";
        return texto;
    }

    public void popupTree() {
        JPopupMenu menu = new JPopupMenu();
        JMenuItem menuItem1 = new JMenuItem("Nueva Carpeta");
        JMenuItem menuItem2 = new JMenuItem("Nuevo archivo");
        JMenuItem menuItem3 = new JMenuItem("Editar");
        menuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (nodo != null) {
                    DefaultTreeModel md1 = (DefaultTreeModel) tree.getModel();
                    if (nodo.getLevel() != 0) {
                        String respuesta = JOptionPane.showInputDialog("Escriba el nombre del Directorio");
                        auxRes = respuesta;
                        md1.insertNodeInto(new DefaultMutableTreeNode(respuesta), nodo, md1.getChildCount(nodo));
                        path(nodo, respuesta);
                        crearCarpeta(path);
                        path = "";
                        path(nodo, "");
                        nuevoParser2(LeerProyecto("Proyectos/" + nomProyecto + ".mpr"));
                        path = "";
                    } else {
                        JOptionPane.showMessageDialog(null, "Necesita crear un proyecto", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (nodo != null) {
                    DefaultTreeModel md1 = (DefaultTreeModel) tree.getModel();
                    if (nodo.getLevel() != 0) {
                        String respuesta = JOptionPane.showInputDialog("Escriba el nombre del archivo");
                        auxRes = respuesta + ".mcf";
                        md1.insertNodeInto(new DefaultMutableTreeNode(respuesta + ".mcf"), nodo, md1.getChildCount(nodo));
                        path(nodo, respuesta + ".mcf");
                        crearArchivo(path);
                        path = "";
                        path(nodo, "");
                        nuevoParser2(LeerProyecto("Proyectos/" + nomProyecto + ".mpr"));
                        path = "";
                    } else {
                        JOptionPane.showMessageDialog(null, "Necesita crear un proyecto", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (nodo != null) {
                    DefaultTreeModel md1 = (DefaultTreeModel) tree.getModel();
                    if (nodo.getLevel() != 0) {
                        if (nodo.toString().contains(".")) {
                            path(nodo, "");
                            abrirArchivo(nodo.toString());
                        } else {
                            JOptionPane.showMessageDialog(null, "no es un archivo", "Error", JOptionPane.WARNING_MESSAGE);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Necesita crear un proyecto", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        menu.add(menuItem1);
        menu.add(menuItem2);
        menu.add(menuItem3);
        this.tree.setComponentPopupMenu(menu);

    }

    public void nuevoParser2(String texto) {
        try {
            System.out.println("text:\n" + texto);
            new parser2(new lexico2(new StringReader(texto)), this).parse();
        } catch (Exception ex) {
            System.out.println("ubo errero");
        }
    }

    public void quitar() {
        this.nodos.remove(this.nodos.size() - 1);
    }

    public void escribir() {
        try {
            File archivo = new File("Proyectos/" + nomProyecto + ".mpr");
            archivo.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("Proyectos/" + nomProyecto + ".mpr"));
            for (int i = 0; i < this.contenidoArchivo.size(); i++) {
                bw.write(this.contenidoArchivo.get(i));
            }
            bw.close();
            this.contenidoArchivo.clear();
            this.nodos.clear();
            this.nodos.add(new Nodo("Proyectos", "Proyectos"));
        } catch (IOException ex) {

        }
    }

    public String LeerProyecto(String nombre) {
        try {
            String cadena;
            String textos = "";
            BufferedReader b = new BufferedReader(new FileReader(nombre));
            while ((cadena = b.readLine()) != null) {
                textos = textos + cadena + "\n";
            }
            b.close();
            return textos;
        } catch (Exception e) {
            return "";
        }
    }

    public void path(DefaultMutableTreeNode nodo, String nombre) {
        if (nodo != null) {
            if (!path.isEmpty()) {
                try {
                    nomProyecto = path.substring(0, path.indexOf("/"));
                    path = nodo.toString() + "/" + path;
                } catch (Exception e) {
                    nomProyecto = path;
                    path = nodo.toString() + "/" + path;
                }

            } else {
                if (nombre.equals("")) {
                    path = nodo.toString();
                } else {
                    this.nombre = nodo.toString();
                    path = nodo.toString() + "/" + nombre;
                }
            }
            this.path((DefaultMutableTreeNode) nodo.getParent(), "");
        }
    }

    public void crearCarpeta(String Path) {
        System.out.println("path=  " + path);
        File archivo = new File(path);
        if (!archivo.exists()) {
            archivo.mkdir();
        }
    }

    public void crearArchivo(String path) {
        File archivo = new File(path);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (Exception e) {
            }
        }
    }

    public void addFileList(String nombre, int tipo) {
        System.out.println("simple  " + path);
        System.out.println("lita  " + nodos.get(nodos.size() - 1).getPath());
        if (tipo == 0) {
            if (nodos.get(nodos.size() - 1).getPath().equals(path) && auxRes.contains(".")) {
                this.contenidoArchivo.add("<archivo>" + "\n");
                this.contenidoArchivo.add("<nombre>");
                this.contenidoArchivo.add(auxRes);
                this.contenidoArchivo.add("</nombre>" + "\n");
                this.contenidoArchivo.add("<ruta>");
                this.contenidoArchivo.add(this.path + "/" + auxRes);
                this.contenidoArchivo.add("</ruta>" + "\n");
                this.contenidoArchivo.add("</archivo>" + "\n");
            }
        } else {
            if (nodos.get(nodos.size() - 1).getPath().equals(path) && !auxRes.contains(".")) {
                this.contenidoArchivo.add("<paquete>" + "\n");
                this.contenidoArchivo.add("<nombre>");
                this.contenidoArchivo.add(auxRes);
                this.contenidoArchivo.add("</nombre>" + "\n");
                this.contenidoArchivo.add("<archs>");
                this.contenidoArchivo.add("</archs>" + "\n");
                this.contenidoArchivo.add("</paquete>" + "\n");
            }
        }

    }

    public void addNodo(int tipo, String nombre) {
        if (tipo == 0) {
            this.nodos.add(new Nodo(nombre, this.nodos.get(nodos.size() - 1).getPath() + "/" + nombre));
        } else {

        }

    }

    public String pathList(List<Nodo> nodos, String nombre) {
        String retorno = "";
        for (int i = 0; i < nodos.size(); i++) {
            retorno += nodos.get(i).getNombre() + "/";
        }
        retorno += nombre;
        return retorno;
    }

    public void insertarArchivoProyecto(String nombre) {
        try {
            File archivo = new File("Proyectos/" + nomProyecto + ".mpr");
            archivo.createNewFile();
            BufferedWriter bw = new BufferedWriter(new FileWriter("Proyectos/" + nombre + ".mpr"));
            bw.write("<proyecto> " + "\n");
            bw.write("<nombre> ");
            bw.write(nombre);
            bw.write(" </nombre> " + "\n");
            bw.write("<creacion> ");
            bw.write(nombre);
            bw.write(" </creacion> " + "\n");
            bw.write("<archs> " + "\n");
            bw.write("</archs> " + "\n");
            bw.write("</proyecto> " + "\n");
            bw.close();
            archivo = new File("Proyectos.dat");
            FileWriter TextOut = new FileWriter(archivo, true);
            TextOut.write(nombre + "\n");
            TextOut.close();
        } catch (IOException ex) {

        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel columnaText;
    public javax.swing.JLabel filaText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem nuevoProyect;
    private javax.swing.JTextPane paneldeTexto;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTree tree;
    // End of variables declaration//GEN-END:variables
}
