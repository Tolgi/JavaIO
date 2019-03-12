/*Со користење на Java I/O да се имплементираат следните методи од класата ExamIO:

(10 поени) moveWritableTxtFiles(String from, String to)
Ги преместува сите датотеки со екстензија .txt од именикот зададен преку from аргументот, 
во именикот зададен преку to аргументот, кои имаат привилегија за запишување. 
Доколку не постои именикот from да се испише "Ne postoi", a aко не постои именикот to, 
потребно е да се креира.

(10 поени) void deserializeData(String source, List<byte[]> data, long elementLength)
Ја исчитува содржината на датотеката source, која содржи голем број податоци,
 сите со иста должина во бајти, без никаков делимитер. Секој од податоците има должина 
 зададена со elementLength. Исчитаните податоци да се запишат во листата зададена преку 
 аргументот data (data.add(readElement)).
 
(Бонус 5 поени) void invertLargeFile(String source, String destination)
Содржината од датотеката source ја запишува во обратен редослед (карактер по карактер) во 
датотеката destination. Содржината на датотеката source е многу голема и не ја собира во меморија.*/

import java.io.*;
import java.util.List;
public class KolokviumskaGrupa1 {
	
	public static void moveWritableTxtFiles(String from, String to) throws IOException{
		File fromm = new File(from);
		File too = new File(to);
		
		if(fromm.exists()) {
			if(!too.exists()) {
				too.mkdir();
			}
			
			File [] files = fromm.listFiles();
			for(File f : files) {
				if(f.getName().endsWith(".txt") && f.canRead()) {
					System.out.println(f.getName());
					f.renameTo(new File(too.getPath().toString()+"\\"+f.getName()));
					
				}
			}
			
		}else {
			System.out.println("Ne postoi");
		}
		
	}
	
	public static void deserializeData(String source, List<byte[]> data, long elementLength) throws IOException{
		
		File file = new File(source);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			int c;
			byte[] niza = new byte[(int)elementLength];
			int i = 0;
			
			while((c = fis.read()) != -1) {
				niza[i] = (byte) c;
				i++;
				
				if(i == (int)elementLength) {
					i = 0;
					data.add(niza);
					niza = new byte[(int)elementLength];
				}
			}
			
		}finally {
			if(fis != null) {
				fis.close();
			}
		}
	}
	
	public static void invertLargeFile(String source, String destination) throws IOException{
		
		File s = new File(source);
		File d = new File(destination);
		
		d.createNewFile();
		//FileInputStream fis = null;
		//FileOutputStream ois = null;
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		try {
			//fis = new FileInputStream(s);
			in = new RandomAccessFile(s.getAbsolutePath(), "r");
			out = new RandomAccessFile(d.getAbsoluteFile(), "rw");
		//	ois = new FileOutputStream(d);

			long position = in.length()-2;
			out.setLength(in.length());

			while(position >= 0){
				char znak = in.readChar();
				//System.out.println(znak+"");
				out.seek(position);
				out.writeChar(znak);
				position -=2;
	
			}
			
		}finally {
			//d.delete();
			if(in != null) {
				in.close();
			}
			
			if(out != null) {
				out.close();
			}
		}
	}

	public static void main(String[] args) throws IOException{
		
		//moveWritableTxtFiles("C:\\Users\\Viktorija\\Desktop\\Test\\Ace\\Gile", "C:\\Users\\Viktorija\\Desktop\\rez");
		invertLargeFile("C:\\Users\\Viktorija\\Desktop\\source.txt","C:\\Users\\Viktorija\\Desktop\\dest.txt");
	}

}
