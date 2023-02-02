import java.util.Scanner;

//Program koji racuna faktorijal unesenog broja n
//faktorijal od n = n! = 1 * 2 * 3 * .. * n-1 * n

//Ovo cemo realizovati rekurzijom, za rekurzivno racunanje n! treba da razlozimo
//problem na sledeci nacin:
//Primer: 5! = 1*2*3*4*5
//		  5! = (1*2*3*4)*5   -> 1*2*3*4 = 4!
// 		  5! = 4! * 5
//Sada nam treba 4!, sto dobijamo na identican nacin:
// 4! = (1*2*3)*4 = 3! * 4
//sad trazimo 3! itd...
//kad dodjemo istim postupkom do 2!, koji je jednak 1*2 = 1! * 2, mozemo da
//koristimo to sto znamo da 1! = 1, i sada kad imamo to da je 1! = 1, vracamo se 
//nazad i dobijamo da je 2! = 1! * 2 = 1 * 2 = 2
//						 3! = 2! * 3 = 2 * 3 = 6
//						 4! = 3! * 4 = 6 * 4 = 24
//						 5! = 4! * 5 = 24 * 5 = 120
//I dobili smo resenje da 5! = 120


public class Glavna {

	public static void main(String args[]) {
		
		//definisemo funkciju faktorijal koja ce imati unos broj koji cemo ucitavati
		Scanner sc = new Scanner(System.in);
		System.out.println("Unesite broj ciji ce se faktorijal izracunati");
		System.out.println(factorial(sc.nextInt()));//nextInt nam vraca ucitan broj, i mi to
													//odmah passujemo faktorijal funkciji,
													//a zatim to stampamo sve u istom redu
		
		
		
	}
	//long je kao int samo podrzava mnogo vece brojeve, a faktorijali su cesto veliki pa 
	//to koristimo
	
	private static long factorial(int n) {
		//Posto ce ova funkcija da pozove samu sebe, moramo da joj damo nacin da
		//"izadje" iz rekurzije tj, da u jednom trenutku prestane da poziva sebe
		//To ce se desiti kada dobijemo da je n = 1, jer znamo da je 1! = 1
		//Takodje mozemo uneti da ako je unesen n = 0, po definiciji faktorijala
		//0! = 1, te za ta dva uslova cemo da vratimo 1
		
		if (n == 1 || n == 0) return 1;
		
		//Kada se izvrsi "return" onda znamo da program izlazi iz metode i ne
		//izvrsava se dalje, pa nam ne treba else
		
		//A kada n != 0 ili 1 (sto znamo da jeste ako program dodje do ovde jer 
		//nam je program dospeo do ovde) vracamo n-1 * n (kao sto smo radili gore
		//u primeru, tj recimo, n = 5, mi cemo vratiti 4! * 5, tj n-1! * n, sto
		//ce biti jednako 5!
		
		return factorial(n-1) * n;
		
		//To je to! jednostavno, ali treba skapirati ove dve linije koda i 
		//rekurziju kao radi.
	}
}
