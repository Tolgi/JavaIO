import java.io.*;
import java.util.List;
/*Со користење на Java I/O да се имплементираат следните методи од класата ExamIO:

(10 поени)void copyLargeTxtFiles(String from, String to, long size)
Ги копира сите датотеки со екстензија .txt од именикот зададен преку from аргументот, во 
именикот зададен преку to аргументот, кои се поголеми од вредноста на size аргументот (во бајти). 
Доколку не постои именикот from да се испише "Ne postoi", a aко не постои именикот to, потребно е да се креира.

(10 поени)void serializeData(String destination, List<byte[]> data)
Низата од податоци зададени со data ја запишува во датотеката destination, без никакви делимитери 
(како континуиран тек од бајти). Сите елементи на листата data имаат иста должина (ист број бајти).

(Бонус 5 поени)byte[] deserializeDataAtPosition(String source, long position, long elementLength)
Го исчитува и враќа податокот на позицијата position од датотеката source, која содржи голем број податоци, 
сите со иста должина во бајти, без никаков делимитер. Секој од податоците има должина зададена со elementLength. 
При имплементацијата да не се чита содржината на целата датотека.*/
public class KolokviumskaGrupa2 {
	
	public static void copyLargeTxtFiles(String from, String to, long size) throws IOException {
		
		File od = new File(from);
		File vo = new File(to);
		
		if(!od.exists()) {
			System.out.println("Ne postoi");
		}else {
			if(!vo.exists()) {
				vo.mkdirs();
			}
			
			File [] files = od.listFiles();
			for(File f : files) {
				System.out.println(f.getTotalSpace());
				System.out.println(f.length());
				if(f.getName().endsWith(".txt") && (f.length() > size)) {
					f.renameTo(new File(vo.getPath().toString()+"\\"+f.getName()));
				}
			}
		}
	}
	
	
	public static void serializeData(String destination, List<byte[]> data) throws IOException {
		
		File dest = new File(destination);
		FileOutputStream out = null;
		try {
		if(dest.exists()) {
			
			out = new FileOutputStream(dest);
			for(int i=0; i<data.size(); i++) {
				byte[] niza = data.get(i);
				out.write(niza);
			}
		}
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}
	
	public static byte[] deserializeDataAtPosition(String source, long position, long elementLength) throws IOException{
		
			File src = new File(source);
			RandomAccessFile in = new RandomAccessFile(src, "r");
			in.seek(position);
			long size = 0;
			while(size <= elementLength) {
				in.read();
				size ++;
			}
		
		return source.getBytes();
	}

	public static void main(String[] args) throws IOException {
		
		
		copyLargeTxtFiles("C:\\Users\\Viktorija\\Desktop\\Test\\Ace\\Gile\\Aleksandar", "C:\\Users\\Viktorija\\Desktop\\kopirani", 8000);
	}

}
