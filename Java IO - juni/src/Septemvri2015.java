/*Potrebno e rekurzivno da go izminete direktoriumot in. Dokolku pri listanjeto dojdete do datoteka so 
 * ekstenzija .bin potrebno e da gi napravite slednite raboti:
 * 
 * Dokolku goleminata na datotekata e pomala od 10KB, iskopirajte ja datotekata vo direktoriumot out.
 * Dokolku datotekata veke postoi vo direktoriumot out, togas ispisete na ekran "datotekata IME veke postoi".
 * 
 * Dokolku goleminata na datotekata e ednakava ili pogolema od 10KB, togas nejzinata sodrzina dodate ja na 
 * pocetok od datotekata big.bin vo out direktoriumot.
 * 
 * Dokolku direktoriumot in ne postoi, ispecatete poraka "in ne postoi" i zavrsete so rabota.
 * Direktoriumot out na pocetok na rabotata treba da bide prazen.
 * 
 * Imajte vo predvid deka .bin datotekite se binarni datoteki koi moze da bidat mnogu golemi. 
 * Baraniot kod napisete go vo metodata void work(String in_value, String out_value) pri sto navedenite 
 * in i out direktoriumi ke bidat vrednostite na stringovite in_value i out_value.*/
import java.io.*;
public class Septemvri2015 {
	
	public static void work(String in_value, String out_value) throws IOException{
		File in = new File(in_value);
		File out = new File(out_value);
		
		if(!in.exists()) {
			System.out.println("in ne postoi");
			return;
		}
		
		if(out.exists()) {
			rekurzivnoBrisenje(out);
		}else {
			out.mkdirs();
		}
		
		File rezultat = new File(out, "big.bin");
		if(!rezultat.exists()) {
			rezultat.createNewFile();
		}
		
		
		File [] files = in.listFiles();
		for(File f : files) {
			int goleminaKB = (int) f.length() / 1024;
			
			if(f.isFile() && f.getName().endsWith(".txt")) {
				if(goleminaKB < 10) {
					copyFile(f, out);
				}else {
					File tmp = new File(in, "tmp.bin");
					if(!tmp.exists()) {
						tmp.createNewFile();
					}else {
						tmp.delete();
						tmp.createNewFile();
					}
					
					kopirajOdIzvorVoDestinacija(rezultat, tmp);
					rezultat.delete();
					rezultat.createNewFile();
					kopirajOdIzvorVoDestinacija(f, rezultat);
					zalepiOdIzvorVoDestinacija(tmp, rezultat);
					tmp.delete();	
				}
			}
		}
	}
	
	public static void kopirajOdIzvorVoDestinacija(File from, File to) throws IOException{
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		
		try {
			in = new RandomAccessFile(from, "r");
			out = new RandomAccessFile(to, "rw");
			
			int c = 0;
			while((c = in.read()) != -1) {
				out.write(c);
			}
			
		}finally {
			if(in != null) {
				in.close();
			}
			
			if(out != null) {
				out.close();
			}
		}
	}
	
	public static void zalepiOdIzvorVoDestinacija (File from, File to) throws IOException{
		RandomAccessFile in = null;
		RandomAccessFile out = null;
		
		try {
			in = new RandomAccessFile(from, "r");
			out = new RandomAccessFile(to, "rw");
			
			out.seek(out.length());
			int c = 0;
			while((c = in.read()) != -1) {
				out.write(c);
			}
			
		}finally {
			if(in != null) {
				in.close();
			}
			
			if(out != null) {
				out.close();
			}
		}
	}
	
	public static void copyFile(File f, File dest) throws IOException {
		
		File nov = new File(dest, f.getName());
		if(nov.exists()) {
			System.out.println("datotekata "+f.getName()+" veke postoi!");
		}else {
			nov.createNewFile();
			BufferedReader in = null;
			BufferedWriter out = null;
			
			try {
				in = new BufferedReader(new FileReader(f));
				out = new BufferedWriter(new FileWriter(nov));
				String line;
				while((line = in.readLine()) != null) {
					out.write(line);
				}
				
			}finally {
				if(in != null) {
					in.close();
				}
				
				if(out != null) {
					out.close();
				}
			}
			
		}
	}
	
	
	public static void rekurzivnoBrisenje(File papka) {
		
		File [] files = papka.listFiles();
		for(File f : files) {
			
			if(f.isFile()) {
				f.delete();
			}
			
			if(f.isDirectory()) {
				rekurzivnoBrisenje(f);
				f.delete();
			}
		}
		
		
	}

	public static void main(String[] args) {
		
	}

}
