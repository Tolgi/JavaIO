/*Потребно е да имплементирате метод private void work(String in, String out) кој ќе го прави следното:

рекурзивно го листа директориумот претставен преку in
доколку секој излистан директориум има над 5 датотеки во него, избришете ги датотеките
доколку секој излистан директориум има под 5 датотеки во него, преместете ги во директориумот 
претставен преку out

Внимавајте на следните работи:

доколку директориумот претставен преку in не постои, излезете од методот со пораката "prazno" на екран
доколку директориумот претставен преку out не постои, потребно е да го креирате
доколку директориумот претставен преку out постои, потребно е да ја избришете неговата содржина
претпоставете дека нема директориуми во неговата содржина*/
import java.io.*;
public class ListMoveandCopyProblem {
	
	private static void work(String in, String out) {
		
		File input = new File(in);
		File output = new File(out);
		
		File [] files = input.listFiles();
		String ime = input.getName();
		int broj = 0;  
		for(File f : files) {
			if(f.isFile()) {
				broj++;
			}else {		
				work(f.getAbsolutePath(), out);
			}

		}
		
		if(broj > 5) {
			deleteFile(input, output);
		}else {
			renameToFile(input, output);
		}
		//System.out.println("Brojor na files vo "+ime+"e: "+broj);
	
	}
	public static void renameToFile(File in, File out) {
		File [] files = in.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				f.renameTo(new File(out.getAbsoluteFile()+"\\"+f.getName()));
			}
		}
	}
	
	public static void deleteFile(File in, File out) {
		File [] files = in.listFiles();
		for(File f : files) {
			if(f.isFile()) {
				f.delete();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
		File vlez = new File("C:\\Users\\Viktorija\\Desktop\\Test");
		File izlez = new File("C:\\Users\\Viktorija\\Desktop\\out");
		
		if(!vlez.exists()) {
			System.out.println("prazno");
			return;
		}
		
		if(!izlez.exists()) {
			izlez.mkdirs();
		}else {
			File [] files = izlez.listFiles();
			for(File f : files) {
				f.delete();
			}
		}
		
		work(vlez.getAbsolutePath(), izlez.getAbsolutePath());
		

	}

}
