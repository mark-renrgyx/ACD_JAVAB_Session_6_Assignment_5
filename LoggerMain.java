package week1.day6.assignment5;

import java.io.File;

public class LoggerMain {

	public static void main(String[] args) {
		final String FOLDER = "logs" + File.separator + "6-5 Logging";
		final String LOG_FILE_NAME = "log.txt";
		
		File folder = new File (FOLDER);
		if (!folder.exists())
			folder.mkdir();

		File logFile = new File (FOLDER + File.separator + LOG_FILE_NAME);
		LogWriter lw = new LogWriter(logFile);

		try {
			lw.writeToFile("New Session");
			lw.writeToFile("DEBUG", "Beginning execution");
			lw.writeToFile("LOG", "action 1 logged");
			lw.writeToFile("LOG", "action 2 logged");
			lw.writeToFile("LOG", "action 3 logged");
			lw.writeToFile("ERROR", "wait 3?");
			lw.writeToFile("Finished session ...");
		}
		catch (OversizeFileException e) {
			System.err.println("File became too large: " + e.getMessage());
		}
	}
}
