package week1.day6.assignment5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogWriter {
	private File file;				// This gets rid of compiler warning.  It was never used outside of constructor.
	private FileWriter fileWriter;
	
	public LogWriter (File file) {
		this.file = file;
		
		if (file.exists()) {
			String folder = file.getParent();
			String timeStamp = new Date().toString();
			File newFile = new File (folder + File.separator + "log-" + timeStamp + ".txt");
			file.renameTo(newFile);
			
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.err.println("Failed to create a log file");
				e.printStackTrace();
			}
		}
		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			System.err.println("Failed to create writer");
			e.printStackTrace();
		}
	}
	public void writeToFile (String textType, String text) throws OversizeFileException {
		if (file.length() > 5000000)
			throw new OversizeFileException("File too large to be written");
		
		if (textType != null) {
			String tag = "[" + textType + "]";
			text = tag + " : " + text;
		}
		String line = "[" + new Date().toString() + "] : " + text + "\n";
		try {
			fileWriter.append(line);
			fileWriter.flush();
		} catch (IOException e) {
			System.err.println("Failed to write to file");
			e.printStackTrace();
		}
	}
	public void writeToFile (String text) throws OversizeFileException {
		writeToFile(null, text);
	}
}
