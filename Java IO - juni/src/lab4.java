import java.io.*;
/*Да се напише Java програма која прима два аргументи: локација на текстуална датотека и збор.
 * Програмата треба да испечати колку пати се сретнува зборот проследен како втор аргумент,
 * во текстуалната датотека проследена како прв аргумент.*/

public class lab4 {
	


	public static void main(String[] args) throws IOException {
		
		File file = new File("C:\\Users\\Viktorija\\Desktop\\file.txt");
		file.createNewFile();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsolutePath()));
		
		System.out.println("Vnesete ja sodrzinata na datotekata: ");
		String tekst = in.readLine();
		out.write(tekst);
		
	
		
		System.out.println("Vnesete go zborot: ");
		String zbor = in.readLine();
		
		in.close();
		out.close();
		
		BufferedReader vlez = new BufferedReader(new FileReader(file.getAbsolutePath()));
		String line = vlez.readLine();
		int broj = 0;
		
		while(line != null) {
			String [] s = line.split(" ");
			for(int i=0; i<s.length; i++) {
				if(s[i].equals(zbor)) {
					broj++;
				}
			}
			
			line = vlez.readLine();
		}
		
		System.out.println("Brojot na pojavuvanja e: " + broj);
		
		vlez.close();
		
		
	}

}
