/* Да се напише Java програма која со користење на I/O стримови ќе ја прочита 
 * содржината на датотеката izvor.txt, а потоа нејзината содржина ќе ја испише
 *  превртена во празната датотека destinacija.txt. Читањето и запишувањето 
 *  реализирајте го со стримови кои работат бајт по бајт.
 *  Напомена: Сами креирајте ги овие две датотеки и пополнете ја izvor.txt со 
 *  произволна содржина.*/
import java.io.*;
public class lab2 {

	public static void main(String[] args) throws IOException{
	
		File izvor = new File("C:\\Users\\Viktorija\\Desktop\\izvor.txt");
		izvor.createNewFile();
		
		File destinacija = new File("C:\\Users\\Viktorija\\Desktop\\destinacija.txt");
		destinacija.createNewFile();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new FileWriter(izvor.getAbsolutePath()));
		
		System.out.println("Vnesete ja sodrzinata na datotekata: ");
		String tekst = in.readLine();
		out.write(tekst);
		
		in.close();
		out.close();
		
		FileInputStream vlez = null;
		RandomAccessFile izlez = null;
		
		try {
			
			vlez = new FileInputStream(izvor);
			izlez = new RandomAccessFile(destinacija.getAbsolutePath(), "rw");
			
			izlez.setLength(izvor.length());
			long pozicija = izvor.length();
			int c;
			
			while((c = vlez.read()) != -1) {
				//izlez.write(c);
				pozicija --;
				izlez.seek(pozicija);
				izlez.write(c);

			}
			
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
