/*1ArrayDatabase
Потребно е да имплементирате специјален вид на база на податоци – ArrayDatabase. 
Елементите (редовите) во базата се елементи составени од id на редот – 2 бајти,
 вредност на редот – 128 бајти и статус на редот 1 бајт – T или F. Базата има две операции put и get.
 Датотеката на базата е db.bin и претставува бинарна датотека. Базата може да биде десетици гигабајти 
 во големина.

put методот прима 4 вредности: int rowNum, byte[] id, byte[] value, boolean status. 
Во овој метод вредностите id, value и status се запишуваат во датотека на базата на позиција rowNum. 
Доколку, на пример, базата имала само 10 податоци, а ние сакаме да запишеме 15ти, тогаш податоците 
од 11 до 14 се пополнуваат со нули.

get методот прима 1 вредност – int rowNum. Во овој метод се исчитува позицијата rowNum
од датотеката на базата и се печатат вредностите на овој ред. Доколку се наиде на ред кој е празен 
(составен само од нули), се печати Prazen element. Доколку се наиде на ред кој е поголем од големината 
на базата, се печати Nema takov element.*/
import java.io.*;
public class ArrayDatabase {
	
	public static void put(int rowNum, byte[] id, byte[] value, boolean status) throws IOException {
		
		File baza = new File("C:\\Users\\Viktorija\\Desktop\\db.txt");
		FileOutputStream out = null; 
		
		int brRedBaza = rowNum(baza);
		if(rowNum > brRedBaza) {
			int brPrazni = rowNum - brRedBaza;
			String nuli = "";
			for(int i=0; i<13; i++) {
				nuli = nuli + "0";
			}
			byte [] prazen = nuli.getBytes();
			
			try {
				out = new FileOutputStream(baza, true);
				out.write("\r\n".getBytes());
				for(int i=0; i<brPrazni; i++) {
					out.write(prazen);
					out.write("\r\n".getBytes());
				}
				
				out.write(id);
				out.write(value);
				if(status) {
					out.write((byte)'T');
				}else {
					out.write((byte)'F');
				}

			}finally {
				if(out != null) {
					out.close();
				}
			}
			
		}	
		
	}
	
	public static void get(int rowNum) throws IOException {
		 
		File baza = new File("C:\\Users\\Viktorija\\Desktop\\db.txt");
		int rowNumBaza = rowNum(baza);
		if(rowNum > rowNumBaza) {
			System.out.println("Nema takov element");
		}else {
			
			BufferedReader in = null;
			int count = 0;
			try {
				in = new BufferedReader(new FileReader(baza));
				String line = null;
				while((line = in.readLine()) != null) {
					count ++;
					if(count == rowNum) {
						if(line.contains("0000")) {
							System.out.println("Prazen element");
						}else {
							System.out.println(line);
						}
					}
				}
				
			}finally {
				if(in != null) {
					in.close();
				}
			}
			
			
		}
		
		
		
	}
		
	public static int rowNum(File baza) throws IOException{
		
		BufferedReader in = null; 
		int counter = 0;
		try {
			in = new BufferedReader(new FileReader(baza));
			String line = null;
			while((line = in.readLine()) != null) {
				counter ++;
			}
		}finally {
			if(in != null) {
				in.close();
			}
		}
		
		return counter;
		
	}

	public static void main(String[] args) throws IOException{
		
		byte [] id = {99 ,105};
		byte [] value = {99, 98, 99, 109, 110, 111, 112, 113, 114};
		boolean status = true;
		
	//	put(12, id, value, status);
		get(13);

	}

}
