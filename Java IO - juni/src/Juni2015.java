/* Napisete gi slednite metodi koi rabotat so binarnata datoteka api.dat. 
 * Ovaa datoteka sodrzi tipovi na podatoci so fiksna golemina od 2bajti. 
 * Se pretpostavuva deka datoteka moze da bide mnogu golema (merena vo GB).
 * Vlez/izlez operaciite da se implementiraat so pomos na Stream-ovi.
 * 
 * Metod: byte[] read(long i)
 * Opis: Ovoj metod go cita i-tiot objekt od navedenata datoteka i go vrakja kako niza od bajti. 
 * Dokolku i-tiot objekt ne postoi vo datotekata, se vrakja null. Dokolku datotekata ne posti se frla isklucok 
 * od tipot DatabaseNotFound.
 *  
 * Metod: void write(long i, byte[] obj)
 * Opis: Ovoj metod go zapisuva i-tiot objekt vo navedenata datoteka. Dokolku pozicijata na objektot sto 
 * treba da se zapise e ponapred od goleminata na datotekata (na primer datotekata ima 3 objekt, a nie sakame 
 * da go zapiseme 5-tiot), togas od posledniot objekt vo datotekata od i-tiot zapisuvame prazni ogjekti.
 * Prazen objekt e sostaven od 2 nuli. Dokolku datotekata ne postoi, taa se kreira.
 *  */
import java.io.*;
public class Juni2015 {
	
	
	public static byte[] read(long i) throws IOException{
		
		File file = new File("C:\\Users\\Viktorija\\Desktop\\source.txt");
		if(!file.exists()) {
			System.out.println("KRAJ");
		}
		
		FileInputStream in = null; 
		try {
			in = new FileInputStream(file);
			in.skip(i*2);
			
			byte [] niza = new byte[2];
			
			int len = 2;
			int read = 0;
			int off = 0;
			
				read = in.read(niza, off, len);
				if(read == -1) {
					return null;
				}else {
					return niza;
				}

		}finally {
			if(in != null) {
				in.close();
			}
		}
		
		
	}
	
	public static void write(long i, byte[] obj) throws IOException {
		File file = new File("C:\\Users\\Viktorija\\Desktop\\source.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		FileOutputStream out = null;
		long sizeFile = file.length();
		if(sizeFile <= i*2) {
			try {
				out = new FileOutputStream(file, true);
				String nuli = "00";
				byte [] prazenObj = nuli.getBytes();
				int brPrazniObj = (int)((sizeFile - (i*2)) / 2);
				for(int j = 0; j<brPrazniObj; j++) {
						out.write(prazenObj);
				}
				
				out.write(obj);

			}finally {
				
				if(out != null) {
					out.close();
				}
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		byte [] rez = read(2);
		for(byte b : rez) {
			System.out.print((char)b);
		}

	}

}
