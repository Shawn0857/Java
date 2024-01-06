package ObjectClass3.Data;

// Fig. 15.10: CreateSequentialFile.java
// Writing objects sequentially to a file with class ObjectOutputStream.
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import javax.swing.JOptionPane;


public class WriteSequentialFile<T> {
	private ObjectOutputStream output; // outputs data to file
	private String sFileName ;
	
	public WriteSequentialFile(String _sFileName) {
		sFileName = _sFileName;
	}
	
	public void fnWSF(ArrayList<T> _rd) {
		try {
			openFile();
			addRecords(_rd);
			closeFile();
			JOptionPane.showMessageDialog(null, "Writing File Successful!!", "Writing Success!!",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage(), "Writing Error!!",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}

	// open file clients.ser
	public void openFile() throws IOException {
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(sFileName)));
		} catch (IOException ioException) {
			throw new IOException("Error opening file. Terminating.");
		}
	}

	// add records to file
	public void addRecords(ArrayList<T> _rd) throws Exception {
		try {
			// serialize record object into file
			output.writeObject(_rd);
		} catch (NoSuchElementException elementException) {
			throw new Exception("Invalid input. Please try again.");
		} catch (IOException ioException) {
			throw new Exception("Error writing to file. Terminating.");
		}
	}

	// close file and terminate application
	public void closeFile() throws Exception {
		try {
			if (output != null)
				output.close();
		} catch (IOException ioException) {
			throw new Exception("Error closing file. Terminating.");
		}
	}
} // end class CreateSequentialFile

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