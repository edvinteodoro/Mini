import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * JFlex_CUP
 *
 * @author jose - 28.02.2018
 * @Title: EmuladorArbol
 * @Description: description
 *
 * Changes History
 */
public class ControlTree {

	public static final String SEPARATOR = "/";
	public static final String ROOT = "/";
	public static final String PARENT_PATH = "..";

	DefaultMutableTreeNode rootNode;
	DefaultTreeModel model;
	String currentLocation;
	JTree jTree;
        File archivo;
        FileOutputStream salida;

	public ControlTree(JTree jTree) {
		this.jTree = jTree;
		this.rootNode = this.createDirectoryNode(ROOT);
		this.model = new DefaultTreeModel(rootNode);
		this.jTree.setModel(this.model);
		this.jTree.setExpandsSelectedPaths(true);
	}
        public DefaultMutableTreeNode createDirectoryNode(String name) {
		return new DefaultMutableTreeNode(this.crearProyecto(name));
	}
        public DefaultMutableTreeNode crearNodoDirectorio(String name) {
		return new DefaultMutableTreeNode(this.crearProyecto(name));
	}
        public File crearProyecto(String nombre) {
                archivo = new File(nombre);
                if(archivo.exists()){
                    //mensaje ya existe
                }else{
                    //mensaje que 
                }
		return archivo;
	}

}
