/*Да се напише Java програма која ќе прикаже колкава е просечната големина на
 *датотеките со екстензија .txt во именик зададен како аргумент на командна линија.
Напомена: Користете ја File класата за пристап до содржината на именикот.*/
import java.io.File;
import java.io.IOException;

public class lab1 {

	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Viktorija\\Desktop\\Test\\Ace\\Gile");
		int zbir = 0;
		int br = 0;
		if(file.exists()) {
			
			File [] files = file.listFiles();
			for(File f : files) {
				
				if(f.getName().endsWith(".txt")) {
					zbir += f.length();
					br ++; 
				}
			}
			
			
				
		}
		
		System.out.println(zbir / br );

	}

}
