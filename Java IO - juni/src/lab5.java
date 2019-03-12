import java.io.*;
/*Некој систем за е-учење генерира извештаи за оценки на студенти по предмети во 
 * CSV (Comma Separated Values) формат. Да се напише Java програма, која на екран ќе го отпечати 
 * просекот на секој студент од датотеката rezultati.csv (види слика), како и просечната оценка што 
 * ја имаат студентите по секој од предметите наведени во првата редица. Програмата треба да работи 
 * за произволен број на редици.
 * Бонус: За подобра читливост на извештајот, прочитаната rezultati.csv датотека трансформирајте ја 
 * во TSV (Tab Separated Values) формат и снимете ја како rezultati.tsv.*/
public class lab5 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Viktorija\\Desktop\\rezultati.txt"));
		
		String line = in.readLine();
		line = in.readLine();
		
		float krs = 0;
		float nrs = 0;
		float aok = 0;
		
		int brLinii = 0;
		while(line != null) {
			String [] s = line.split("\\,");
			int zbir = 0;
			for(int i=1; i<s.length; i++) {
				zbir += Integer.parseInt(s[i]);
			}
			
			krs += Integer.parseInt(s[1]);
			nrs += Integer.parseInt(s[2]);
			aok += Integer.parseInt(s[3]);
			brLinii ++;
			
			System.out.println("Prosekot na studentot - "+ s[0] + " e: "+ zbir / (s.length-1));
			line = in.readLine();
		}
		
		System.out.println("Prosecna ocenka po KRS e: "+ krs / brLinii);
		System.out.println("Prosecna ocenka po NRS e: "+ nrs / brLinii);
		System.out.println("Prosecna ocenka po AOK e: "+ aok / brLinii);
	}

}
