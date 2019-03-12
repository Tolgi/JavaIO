/*Да се напише Java програма која со користење на I/O стримови ќе ја прочита содржината на датотеката 
 * izvor.txt, а потоа нејзината содржина ќе ја испише превртена во празната датотека destinacija.txt.
 *  Читањето и запишувањето реализирајте го со баферирано читање и запишување
 * Напомена: Сами креирајте ги овие две датотеки и пополнете ја izvor.txt со произволна содржина.*/
import java.io.*;
public class lab3 {

	public static void main(String[] args) throws IOException{
		
		File izvor = new File("C:\\Users\\Viktorija\\Desktop\\izvor.txt");
		izvor.createNewFile();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(izvor.getAbsolutePath()));
		
		System.out.println("Vnesete ja sodrzinata na datotekata: ");
		String tekst = in.readLine();
		out.write(tekst);
		
		in.close();
		out.close();
		
		File destinacija = new File("C:\\Users\\Viktorija\\Desktop\\destinacija.txt");
		destinacija.createNewFile();
		
		BufferedReader vlez = null;
		BufferedWriter izlez = null;
		
		try {
			vlez = new BufferedReader(new FileReader(izvor.getAbsolutePath()));
			izlez = new BufferedWriter(new FileWriter(destinacija.getAbsolutePath()));
			
			String line = vlez.readLine();
			StringBuilder sb = new StringBuilder();

			while(line != null) {
				sb.append(line);
				line = vlez.readLine();
			}
				sb.reverse();
				izlez.write(sb.toString());
				
			
			
			izvor.delete();
			
		}finally {
			
			destinacija.delete();
			if(vlez != null) {
				vlez.close();
			}
			
			if(izlez != null) {
				izlez.close();
			}

		}
		
		

	}

}
