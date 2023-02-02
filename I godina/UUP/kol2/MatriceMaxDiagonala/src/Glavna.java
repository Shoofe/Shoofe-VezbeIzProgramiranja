import java.util.Scanner;

/*
 * Napisati program koji ucitava broj n 1-20, i matricu formata nxn
 * neka m bude broj koji je maksimalan za glavnu dijagonalu, i neka program 
 * ispise sve brojeve van te dijagonale koji su strogo manji od m
 * 
 * 
 * Glavna dijagonala je:
 * 
 * [#	x	x]
 * [x	#	x]
 * [x	x	#]
 * 
 * Sporedna je:
 * 
 * [x	x	#]
 * [x	#	x]
 * [#	x	x]
 * 
 * 
 * 
 * primer: za n = 3  
 * 
 * [4	-2	3]
 * [2	3	4]
 * [-7 	5	4]
 * 
 * broj elemenata manji od maksimuma dijagonale (4) je 4
 */






public class Glavna {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite broj n koji mora biti ceo broj izmedju 1 i 20");
		int n = sc.nextInt(); //Ucitavamo broj n
		
		
		int[][] matrica = new int[n][n]; //kreiramo 2d niz (matricu) formata nxn
		
		//for petljom iteriramo kroz svako polje matrice i unosimo brojeve jedan po jedan
		//napravicu i funkciju drawMatrix() koju vi necete morati praviti na kolokvijumu cisto radi citkosti programa, mozda
		//ociglednije bude samo kako radi
		
		//Iteriramo ovako za svaku vrednost i i j kroz celu matricu (mozete videti kako tacno sa funkcijom drawMatrix()
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.println("Unesite broj na poziciji " + i + ", " + j);
				drawMatrix(i,j,n,matrica);
				//U praksi nebitno kako redjate "i" i "j", samo pazite da nema indexOutOfBounds i da stampate
				//na isti nacin kao sto ste je unosili (ne obrnete ih)
			
				matrica[i][j] = sc.nextInt();								
			}
		}
		
		//Za matricu morate primetiti da samo za njenu glavnu dijagonalu vazi to da su "i" i "j" jednaki
		//Dakle ako nam je i==j true, znamo da smo na glavnoj dijagonali
		
		//Uradicemo ovde odmah i za sporednu dijagonalu isti zadatak cisto da predjemo i to, ali u 
		//sustini samo treba zapamtiti da za sporednu dijagonalu vazi da i + j svakog polja je jednako n 
		//(n je dimenzija matrice minuj jedan jer nizovi pocinju sa 0) samo ako matrica[i][j] 
		//se nalazi na sporednoj dijagonali
		
		//Inace na engleskom se koriste termini main (leading) i anti (counter) diagonal
		
		
		//Dakle, hajde da prvo da nadjemo max glavne dijagonale
		
		//Inicijalizujemo promenjivu maxGlavne da nam bude najmanja moguca vrednost int-a u javi
		int maxGlavne = Integer.MIN_VALUE;
		
		//Iteriramo kroz matricu celu, i kad smo na glavnoj proverimo da li je ta vrednost na glavnoj
		//dijagonali veca od trenutne vrednosti maxGlavne, i ako jeste stavimo nju na maxGlavne
		
		//Mozda je malo varanje ali kad prolazimo kroz glavnu mozemo da idemo sa jednom petljom
		//jer znamo da "i" mora biti jednak "j" tj, mogu biti isti broj, tj mogu biti jedan broj
		
		for(int i = 0; i < n; i++) {
			if (matrica[i][i] > maxGlavne) maxGlavne = matrica[i][i];
		}
		
		//sada nam se u maxGlavne nalazi, jel, max glavne.
		
		//sada moramo da iteriramo kroz celu matricu "zapravo" i proveravamo svako polje koje se
		//ne nalazi na glavnoj, i tu prebrojimo koliko ima polja gde je vrednost < maxGlavne i snimimo
		//koliko ih ima u neku promenjivu
		
		int manjihOdMaxGlavne = 0;
		
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					//dakle gledamo da li ima manjih od maxGLavne samo ako nisu na dijagonali
					//tj nisu jednaki  i = j
					if(matrica[i][j] < maxGlavne) manjihOdMaxGlavne++;
				}
			
			}
		}
		
		//Imamo tu vrednost, hajde da uradimo isto i za sporednu dijagonalu
		//ovde moramo kroz svaku (ne zapravo, al da se ne bunimo bezveze)
		
		int maxSporedne = Integer.MIN_VALUE;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if (i + j == n - 1) {
					//ako je ovo tacno onda smo na sporednoj dijagonali
					if (matrica[i][j] > maxSporedne) maxSporedne = matrica[i][j];
					System.out.println(matrica[i][j]);
				}
			}
		}
		
		int manjihOdMaxSporedne = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if (i + j != n - 1) {
					//ako je ovo tacno onda nismo na sporednoj dijagonali
					if (matrica[i][j] < maxSporedne) manjihOdMaxSporedne++;
				}
		
			}
		}
		
		
		//I sad samo stampamo sve
		
		System.out.println("Manjih od maksimalne vrednosti na glavnoj dijagonali ima: " + manjihOdMaxGlavne +
				" , a manjih od maksimalne vrednosti na sporednoj ima: " + manjihOdMaxSporedne);
		
		
		
		

		
	}
	
	private static void drawMatrix(int x, int y, int z, int[][] matrica) {
		
		System.out.println("Unesite broj koji ce biti upisan u matrici na poziciju X");
		for(int i = 0; i < z; i++) {
			System.out.println();
			for (int j = 0; j < z; j++) {
				if (i == x && y == j) {
					System.out.printf("%5s", "X");
				}
				else System.out.printf("%5d", matrica[i][j]);
			}
		}
		System.out.println();
	}

}
