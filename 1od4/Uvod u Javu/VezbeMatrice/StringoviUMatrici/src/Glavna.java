
import java.util.Scanner;

	//Program koji ucitava Stringove u matricu dimenzija mxn,
	//Vrati najduzi string i stampa ga, i zatim stampa celu matricu formatiranu
	//i sa svim Stringovima velikim slovima



public class Glavna {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			
			
			//Unos m i n
			int m,n;
			System.out.println("Unesite dimenzije za matricu dimenzijja mxn");
			System.out.print("Unesite m:");
			m = sc.nextInt();
			System.out.print("Unesite n:");
			n = sc.nextInt();
			
			
			//Kreacija matrice sa dimenzijama
			String[][] matrica = new String[m][n];
			
			//Ucitavanje stringova u matricu
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.println("Unesite String na poziciji " + i + ", " + j);
					matrica[i][j] = sc.next();
				}
			}
			sc.close();
			//Iteriramo kroz matricu i trazimo najduzi string
			//kasnije ce nam trebati duzina najduzeg radi formatiranja, pa cemo odmah i to da uzmemo
			String najduziString = ""; //Moramo da ga instanciramo jer cemo zvati metodu .length na njemu,
									   //a to ne moze ako je string null;
			int duzinaNajduzeg = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(najduziString.length() < matrica[i][j].length()) {
						najduziString = matrica[i][j];
						duzinaNajduzeg = najduziString.length() + 1; //Treba nam +1 da bismo imali mesto razmaka
																	 //u ispisu posle formatiranja
					}
				}
			}
			
			System.out.println("Najduzi unet string je: " + najduziString);
			
			//sad fomatiramo izlaz prema duzini najduzeg
			String format = "%" + duzinaNajduzeg + "s";
			//Za vise o formatiranju mozete ovde videti: https://www.baeldung.com/java-printstream-printf
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					System.out.printf(format, matrica[i][j].toUpperCase()); //Po zadatku vracamo uppercase
				}
			System.out.println();
			}
					
			
			
			
			
			
			
	}

}
