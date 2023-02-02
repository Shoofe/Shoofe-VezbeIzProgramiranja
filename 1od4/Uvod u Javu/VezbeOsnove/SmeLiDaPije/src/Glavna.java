
//Program koji ucitava godine i ispisuje da li osoba sa toliko godina sme da pije u USA i u svetu

public class Glavna {

	public static void main(String[] args) {
		int godine = 17;
		//Mozete koristiti Svetovid za unos godine u While petlji, a moze i neki drugi nacin
		
		if (godine < 18) {
			//Ukoliko ima manje od 18 izvrsava se ova naredba i preskace se na KRAJ
			System.out.println("Ne sme da pije");
		}
		else if(godine < 21) {
			//Ako ima vise od osamnest, a tacno je da ima manje od 21, izvrsava se ova i preskace do KRAJ
			System.out.println("Sme da pije, ali ne sme u Americi");
		}
		else {
			//Ukoliko obe prethodne nisu se izvrsile onda se izvrsava ova i ide dalje do KRAJ
			System.out.println("Sme da pije gde hoce!");
		}
	//KRAJ
	}

}
