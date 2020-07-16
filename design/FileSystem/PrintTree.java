package FileSystem;

public class PrintTree {
	
	
	public static String printDirectoryTree(Directory folder) {
	    if (!folder.isDirectory()) {
	        throw new IllegalArgumentException("folder is not a Directory");
	    }
	    int indent = 0;
	    StringBuilder sb = new StringBuilder();
	    printDirectoryTree(folder, indent, sb);
	    return sb.toString();
	}

	private static void printDirectoryTree(Entry folder, int indent,
	        StringBuilder sb) {
	    if (!folder.isDirectory()) {
	        throw new IllegalArgumentException("folder is not a Directory");
	    }
	    sb.append(getIndentString(indent));
	    sb.append("+--");
	    sb.append(folder.getFullFilePath().toString());
	    sb.append("/");
	    sb.append("\n");
	    for (Entry file : folder.listFiles()) {
	        if (file.isDirectory()) {
	            printDirectoryTree(file, indent + 1, sb);
	        } else {
	            printFile(file, indent + 1, sb);
	        }
	    }

	}

	private static void printFile(Entry file, int indent, StringBuilder sb) {
	    sb.append(getIndentString(indent));
	    sb.append("+--");
	    sb.append(file.getFullFilePath().toString());
	    sb.append("\n");
	}

	private static String getIndentString(int indent) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < indent; i++) {
	        sb.append("|  ");
	    }
	    return sb.toString();
	}
	

}
