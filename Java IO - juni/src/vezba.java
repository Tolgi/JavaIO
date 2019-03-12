import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class vezba {
	
	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Viktorija\\Desktop\\file.txt");
		file.createNewFile();
		
		
		byte [] niza = { 125, 126, 127 };
		FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
		//out.write("viki".getBytes());;
		
		char c1 = 'B';
		int i1 = Character.getNumericValue(c1);
		byte i2 = (byte)c1;
		System.out.println("Numeric value: " +i1);
		System.out.println("Bytes : " +i2);
		
		out.close();
	}

}
