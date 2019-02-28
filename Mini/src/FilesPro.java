

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Formatter;
import java.util.Locale;

/**
 * JFlex_CUP
 * @author jose - 28.02.2018 
 * @Title: EmuledFile
 * @Description: description
 *
 * Changes History
 */
public class FilesPro {
	private static final String WRITE = "w";
	private static final String READ = "r";
	private static final String EXECUTE = "x";
	private static final String IS_DIRECTORY = "d";
	private static final String NO_DATA = "-";
	private static final char ADD_PERISSION = '+';
	private static final char REMOVE_PERISSION = '-';
	
	private String name;
	private int sizeKb;
	private boolean directory;
	private boolean write;
	private boolean read;
	private boolean execute;
	private LocalDate creationDate;

	public FilesPro(String name, int sizeKb, boolean directory) {
		this.name = name;
		this.sizeKb = sizeKb;
		this.directory = directory;
		creationDate = LocalDate.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSizeKb() {
		return sizeKb;
	}

	public boolean isDirectory() {
		return directory;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isExecute() {
		return execute;
	}

	public void setExecute(boolean execute) {
		this.execute = execute;
	}
	
	public boolean isHidden() {
		return this.name.startsWith(".");
	}
	
	@Override
	public String toString() {
		String prefix;
		if (isDirectory()) {
			prefix = "D- ";
		} else {
			prefix = "";
		}
		return prefix + this.name;
	}
	
	public String getInListModeInfo() {
		Formatter formatter = new Formatter();
		return formatter.format("%s%s%s%s\t%d\t%s\t%d\t%d\t%s", getDirectory(), getWrite(),
			   getRead(), getExecute(), this.sizeKb, 
			   creationDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.getDefault()),
			   creationDate.getDayOfMonth(), creationDate.getYear(),
			   this.name).toString();
	}
	
	public String getInNormalModeInfo() {
		return this.name + "\t";
	}
	
	private String getWrite() {
		return getPermissionText(write, WRITE);
	}
	
	private String getRead() {
		return getPermissionText(read, READ);
	}
	
	private String getExecute() {
		return getPermissionText(execute, EXECUTE);
	}
	
	private String getDirectory() {
		return getPermissionText(isDirectory(), IS_DIRECTORY);
	}
	
	private String getPermissionText(boolean permission, String data) {
		return permission ? data : NO_DATA;
	}
	
	public void setPermissions(String permissionOptions) {
		char modifier = permissionOptions.charAt(0);
		switch (modifier) {
			case ADD_PERISSION:
				this.addPermissions(permissionOptions);
				break;
			case REMOVE_PERISSION:
				this.removePermissions(permissionOptions);
				break;
			default:
				throw new AssertionError();
		}
	}
	
	private void addPermissions(String permissionOptions) {
		setWrite(permissionOptions.contains(WRITE));
		setRead(permissionOptions.contains(READ));
		setExecute(permissionOptions.contains(EXECUTE));
	}
	
	private void removePermissions(String permissionOptions) {
		setWrite(!permissionOptions.contains(WRITE));
		setRead(!permissionOptions.contains(READ));
		setExecute(!permissionOptions.contains(EXECUTE));
	}

}