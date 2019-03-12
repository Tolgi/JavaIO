
import java.io.*;
import java.util.ArrayList;
import java.util.List;
/*Една датотека е составена од следниот тип на податоци:

| 4 | 2 6 5 8 | 3 | 7 4 4 | 4 | 5 7 4 1 | 2 | 3 7 |
На секој податок му претходи еден бајт кој кажува колкава е должината во бајти на податокот.
Во дадениот пример имаме еден бајт со вредност 4, па имаме податок од 4 бајти (2658), потоа имаме 
еден бајт со вредност 3, па имаме податок од 3 бајти (744), па имаме еден бајт со вредност 4 па 
следи податокот од 4 бајти (5741) и на крај имаме еден бајт со вредност 2 и податок од 2 бајти (37).

Реалниот изглед на наведената пример датотека е:
42658374445741237

Имплементирајте метод private List<byte[]> read(String input) кој ќе ја исчита датотеката претставена 
со аргументот input според наведениот формат и ќе врати листа од податоци (листа од низи од бајти). 

Во наведениот пример, листата би изгледала
[[2658], [744], [5741], [37]]
*/
public class CharCountingProblem {
	
	public static List<byte[]> read(String input) throws IOException{
		
		File file = new File(input);
		FileInputStream in = null;
		List<byte[]> lista = new ArrayList<>();
		byte[] podatok;
		
		try {
			in = new FileInputStream(file);
			int c = 0;
			int size = 0;
			while((c = in.read()) != -1) {
			    size = Character.getNumericValue((char)c);
				podatok = new byte[size];
				
				for(int i=0; i<size; i++) {
					int b = in.read();
					if(b != -1) {
						podatok[i] = (byte)b;
					}else {
						System.out.println("Nema bajti za citanje!");
						throw new IllegalStateException();
					}
				}
				lista.add(podatok);
				
			}
			
			return lista;
			
		}finally {
			if(in != null) {
				in.close();
			}
		}
	}

	public static void main(String[] args) throws IOException {
		
		String path = "C:\\Users\\Viktorija\\Desktop\\source.txt";
		
		List<byte[]> rez = read(path);
		
		 for (byte[] element : rez) {
		      System.out.print("[");
		      for(byte b : element) {
		        System.out.print(Character.getNumericValue((char)b));
		      }
		      System.out.print("]"+", ");
		    }
		
		

	}

}
