import java.util.Scanner;

        /*Ispisati program koji učitava prirodan broj a (a < 100000) i 
		 *proverava da li je taj broj Armstrongov broj.
		 *Armstrongov broj je n-tocifreni prirodni broj koji je jednak zbiru 
		 *n-tih stepena cifara tog broja. Npr. (153).
		 */
public class Glavna {

	public static void main(String[] args) {
		
		//Nemam svetovid pa koristim Scanner klasu za ucitavanje, 
		//sa Svetovidom mozete samo Svetovid.in.readInt()
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite pozitivan ceo broj manji od 10 000");
		
		
		
		int broj = -1; //Ovo moze i bolje, broj inicijalizujemo na -1 jer znamo da ta vrednost ce nas poslati
					   //u while
		
		
		
		//Svaku iteraciju while-a unutar njega pozivamo skener (ili Svetovid)
		//za unos broja i proveravamo uslov < 10 000	
		
		//Nisam ubacio try/catch da ne bunim kolege koji nisu jos to radil, ali program se crashuje ukoliko unesete
		//ne-integer
		while((broj = sc.nextInt()) > 10000 || broj < 0) {
			//Ako uslov nije ispunjen stampamo ovo opet
			System.out.println("Unesite pozitivan ceo broj manji od 10 000");
			}
		
		//Kada izadjemo iz petlje znamo da je broj pozitivan i manji od 10000
		
		//Da bismo izracunali da li je broj Armstrongov treba nam njegov broj cifara
		//i treba da izracunamo da li svaka cifra tog broja dignuta na broj cifara je
		//jednaka tom broju.
		
		
		
		//u brojCifara cemo cuvati broj cifara za kasnije racunanje, inicijalizujemo ga na 0 jer cemo uvecavati
		//mu vrednost u petlji, cifra ce biti cifra koja ce biti
		//cifra koju trenutno obradjujemo u petlji, a tempBroj je promenjiva koja nam je potrebna jer
		//bismo izgubili vrednost broj-a ako baratamo sa njom
		
		int brojCifara = 0, brojTemp = broj, cifra, broj2 = 0;
		
		
		//Gledacemo cifre od jedinice ka desetici pa nadalje pomocu % operatora, i svaki put, da bismo dobili
		//sledecu cifru delimo ga sa 10 (bez ostatka)
		//Znaci ako unesemo broj 123, njegovu prvu cifru (3) cemo dobiti sa cifra = 123 % 10
		//Zatim cemo ga podeliti sa 10 bez ostatka, da bismo dobili brojTemp = brojTemp/10 tj:
		//brojTemp = 123 / 10 = 12, zatim kad uzmemo od njega cifru sa 12 % 10, dobijamo njegovu 2-ku, itd
		//sve dok nam brojTemp ne ostane na nuli
		//Izracunacemo formulom gore zadatom broj2 (zbir svake cifra^broj cifara) i na kraju gledamo
		//da li je broj2 == broj, ukoliko jeste, onda je broj Armstrongov broj
		
		while (brojTemp != 0) {
			brojCifara++; //Racunamo broj cifara, moramo ovako jer ce nam trebati za svaku od cifara
			              //pa ne mozemo u drugoj petlji (ili ja ne provaljujem kako lol)
			brojTemp /= 10;
		}
		//Posto smo koristili brojTemp, moramo opet da mu zadamo vrednost broj-a
		brojTemp = broj;
		
		while(brojTemp != 0) {
			cifra = brojTemp % 10;  //dobijamo zadnju cifru ostatkom od deljenja
			brojTemp = brojTemp / 10; //delimo broj sa 10 (123/10 = 12)
			broj2 = (int) (broj2 + Math.pow(cifra, brojCifara)); //moramo da cast-ujemo u integer jer Math.pow
			                                                     //vraca double
			
		}
		//na kraju izvrsavanja petlje bismo trebali da imamo broj2 koji ukoliko je broj armstrongov broj, je
		//jednak broj-u
		
		if (broj == broj2) {
			System.out.println("Broj " + broj + " je armstrongov broj. ");
		}
		else {
			System.out.println("Broj nije Armstrongov jer "+ broj + " nije jednak " + broj2);
		}
	
	}

}
