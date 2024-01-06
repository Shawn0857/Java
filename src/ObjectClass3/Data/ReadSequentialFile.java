package ObjectClass3.Data;

// Fig. 15.11: ReadSequentialFile.java
// Reading a file of objects sequentially with ObjectInputStream
// and displaying each record.
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ReadSequentialFile<T> {
	private ObjectInputStream input;
	private String sFileName = "";
	
	public ReadSequentialFile(String _sFileName) {
		sFileName = _sFileName;
	}
	
	public ArrayList<T> getRSF() {
		ArrayList<T> rd=null; 
		try {
			openFile();
			rd = readRecords();
			closeFile();
			JOptionPane.showMessageDialog(null, "Reading File Successful!!", "Reading Success!!",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage(), "Reading Error!!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
		return rd;
	}

	// enable user to select file to open
	public void openFile() throws IOException {
		try // open file
		{
			input = new ObjectInputStream(Files.newInputStream(Paths.get(sFileName)));
		} catch (IOException ioException) {
			throw new IOException("Error opening file.");
		}
	}

	// read record from file
	public ArrayList<T> readRecords()  throws Exception {
		ArrayList<T> record=null;
		try {
			record= (ArrayList<T>) input.readObject();
		} catch (EOFException endOfFileException) {
			throw new Exception("%nNo more records%n");
		} catch (ClassNotFoundException classNotFoundException) {
			throw new Exception("Invalid object type. Terminating.");
		} catch (IOException ioException) {
			throw new Exception("Error reading from file. Terminating.");
		}
		return record;
	} // end method readRecords

	// close file and terminate application
	public void closeFile() throws Exception{
		try {
			if (input != null)
				input.close();
		} catch (IOException ioException) {
			throw new Exception("Error closing file. Terminating.");
		}
	}
} // end class ReadSequentialFile

/*************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and * Pearson Education,
 * Inc. All Rights Reserved. * * DISCLAIMER: The authors and publisher of this
 * book have used their * best efforts in preparing the book. These efforts
 * include the * development, research, and testing of the theories and programs
 * * to determine their effectiveness. The authors and publisher make * no
 * warranty of any kind, expressed or implied, with regard to these * programs
 * or to the documentation contained in these books. The authors * and publisher
 * shall not be liable in any event for incidental or * consequential damages in
 * connection with, or arising out of, the * furnishing, performance, or use of
 * these programs. *
 *************************************************************************/