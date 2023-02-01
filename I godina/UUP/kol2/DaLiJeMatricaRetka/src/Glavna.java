

/*
 * Napisati program koji ucitava broj n, (1 <= n <= 20) i ucitava matricu formata nxn, zatim
 * proverava da li je matrica "retka"
 * Matrica je retka ako sadrzi vise nula elemenata od ne-nula elemenata
 */

import java.util.Scanner;
//Ja radim sa Scanner klasom, samo je drugacije sto umesto Svetovid.in.readInt() koristim drugu metodu koja ce biti
//Scanner.in.readInt(); (Scanner metoda je nebezbedna i baca exeption-e, ako ne znate sta je to to samo znaci da moze
// da crashuje ako primi neodgovarajuc element

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
		sc.close(); //Ignorisite, samo zatvaram skener
		
		//Kada smo ucitali sve brojeve u matricu, samo treba da prodjemo kroz njih i prebrojimo sve ne-nula elemente i
		//sve nula elemente i da vidimo kojih ima vise
		
		//To cemo malo uraditi na neki "pametniji" nacin, imacemo promenjivu koja ce poceti sa vrednoscu 0 i
		//za svaku vrednost iz matrice, ako je ta vrednost 0 cemo da smanjimo promenjivu za 1, a ako je ne-nula, povecamo
		//na kraju cele matrice cemo imati u toj promenjivoj negativan broj samo ako je matrica retka tj ima vise 
		//nula elemenata
		//I da, ovo se moze uraditi u prvoj petlji, al hajd` da uradimo u dve cisto ako nam asistenti budu nesto neraspolozeni
		//pa malo zezaju
		
		int viseManje = 0;
		for(int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
			//obratite paznju da iterirate isto kao sto ste kad ste unosili matricu
			if(matrica[i][j] == 0) viseManje--;
			else viseManje++;
			}
		}
		
		//ovde samo ispisujemo, nista pametno da se kaze
		if (viseManje < 0) System.out.println("Matrica je retka");
		else System.out.println("Matrica nije retka");

		
		
		
		
		
		
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
