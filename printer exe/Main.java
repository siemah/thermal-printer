
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.File;

import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		String fileContent = readFileContent("ticket.txt");

		PrinterService printerService = new PrinterService();
		
		System.out.println(printerService.getPrinters());
				
		//print some stuff
		printerService.printString("Generic", fileContent);

		// cut that paper!
		byte[] cutP = new byte[] { 0x1d, 'V', 1 };

		printerService.printBytes("Generic", cutP);
		JOptionPane.showMessageDialog( null, fileContent );

	}

	public static String readFileContent(String filePath) {


		String sCurrentLine = "";
		String returnVal = "";

		File fileDir = new File(filePath);

		try(
			BufferedReader br = new BufferedReader(
				new InputStreamReader(
					new FileInputStream(fileDir), "UTF8"
				)
			)
		) {

			while ((sCurrentLine = br.readLine()) != null) {
				returnVal += sCurrentLine + "\n";
			}

		} catch (IOException e) {

			e.printStackTrace();

		}
		returnVal += "\n\n\n\n\n\n\n\n";
		return returnVal;

	}

}
