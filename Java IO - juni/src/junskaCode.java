/*Потребно е да ја имплементирате функцијата manage(String in, String out) која врши организација на 
 *текстуалните датотеки (*.dat) од именикот in според нивните привилегии на следниот начин:

доколку датотеката има привилегии за запишување тогаш таа треба да се премести во out именикот. 
При преместувањето, во конзола испечатете pomestuvam и апсолутното име на датотеката која се копира.

доколку датотеката нема привилегии за запишување тогаш нејзината содржина додадете ја на крај од датотеката 
writable-content.txt во resources именикот. При додавањето, во конзола испечатете dopisuvam и апсолутното име 
на датотеката. Сметајте дека овие датотеки може да бидат многу поголеми од физичката меморија на компјутерот.

доколку датотеката е скриена (hidden), тогаш избришете ја од in именикот, и во конзола испечатете zbunet sum и 
апсолутното име на датотеката.
Доколку in именикот не постои, испечатете на екран ne postoi.

Доколку out именикот веќе постои, избришете ја неговата содржина. Претпоставете дека во out именикот има само датотеки.*/
import java.io.*;
public class junskaCode {
	
	public static void manage(String in, String out) throws IOException {
		File input = new File(in);
		File output = new File(out);
		
		if(output.exists()) {
			File [] files = output.listFiles();
			for(File f : files) {
				f.delete();
			}
		}else {
			output.mkdir();
		}
		
		
		if(input.exists()) {
			File [] dat = input.listFiles();
			for(File d : dat) {
				if(d.getName().endsWith(".dat")) {
					if(d.canWrite()) {
						
						d.renameTo(new File(output.getPath()+"\\"+d.getName()));
						System.out.println("premestuvam"+ d.getAbsolutePath());
						
					}else {
						
						File fajl = new File(input.getAbsolutePath()+"\\"+"writable-content.txt");
						FileInputStream fis = null;
						RandomAccessFile rout = null;
						try {
							fis = new FileInputStream(d.getAbsolutePath());
							rout = new RandomAccessFile(fajl.getAbsolutePath(), "rw");
							rout.seek(fajl.length());
							int c;
							while((c = fis.read()) != -1) {
								rout.write(c);
						}
						}catch(Exception ex) {
							
						}finally {
							if(fis != null) {
								fis.close();
							}
							
							if(rout != null) {
								rout.close();	
							}
						}
						System.out.println("dopisuvam"+d.getAbsolutePath());
					}
					
					if(d.isHidden()) {
						d.delete();
						System.out.println("zbunet sum"+d.getAbsolutePath());
					}
				}
			}
		}else {
			System.out.println("Ne postoi!");
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		
	}

}
