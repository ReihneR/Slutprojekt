
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {

	static boolean reset; 
	
	public static void main(String[] args) 
	
	{
		reset = true;
		
		while (reset)  {
			
						
			
		ArrayList<String> list1 = new ArrayList<>();

		list1.add("paris");
		list1.add("london");
		list1.add("skolan");
		list1.add("häst");
		list1.add("hund");
		list1.add("katt");
		list1.add("råtta");
		list1.add("haj");
		list1.add("elefant");
		list1.add("sverige");
		list1.add("norge");
		list1.add("finnland");


		
		//String ord = "hello world"; // Meningen som spelaren ska gissa på
		int liv = 7; // Hur många försök spelaren får på sig att gissa fram till Meningen
		metod(slump(list1), liv);

		}

	}
	
	public static void metod(String ratt_ord, int liv) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Låt oss spela hängagubbe, välj en bokstav");
		
		
		
		ArrayList<Character> l=new ArrayList<Character>();

		char[] fyllning = new char[ratt_ord.length()]; // Detta är fyllningen för bokstäverna som ännu inte har gissats rätt
													// på
		int i = 0;

		while (i < ratt_ord.length()) {
			fyllning[i] = '*';
			
			if (ratt_ord.charAt(i) == ' ') {
				fyllning[i] = ' ';

			}
			i++;
		}
		System.out.print(fyllning);
		//System.out.println("      Återstående liv = " + liv);
		

		while (liv > 0) {
			char x = input.next().charAt(0); // spelarens insättning av bokstav och så länge livet inte når 0 kan
												// spelaren fortsätta chansa
			if(l.contains(x)) {
				
				System.out.println("Redan insätt, testa ett annant ord");
				continue;
			}
			
			l.add(x);
			
			
			if (ratt_ord.contains(x + "")) {
				for (int y = 0; y < ratt_ord.length(); y++) { //den här loppen kollar alla index för bokstäverna och byter ut * mot bokstaven
					if (ratt_ord.charAt(y) == x) {
						fyllning[y] = x;
					}
				}
			}
				else {
					liv--; //Om det gissade bokstaven inte finns med i indexet tas ett liv bort
				}
			
			if(ratt_ord.equals(String.valueOf(fyllning))) { //Kollar ifall fyllningen är lika med ordet
				
				System.out.println(fyllning);
				System.out.println("Grattis du vann!!");
				break;
			}
			
			
			System.out.print(fyllning);
			System.out.println("      Återstående liv = " + liv);
			if(liv == 6) {
				System.out.println(
						"                      +---+\r\n" + 
						"                      |   |\r\n" + 
						"                          |\r\n" + 
						"                          |\r\n" + 
						"                          |\r\n" + 
						"                          |");	
				
				
				
			   } else if (liv == 5) {
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                          |\r\n" + 
							"                          |\r\n" + 
							"                          |");
					
				} else if (liv == 4) {
					
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                      |   |\r\n" + 
							"                          |\r\n" + 
							"                          |");
				}
				
				else if (liv == 3) {
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                     /|   |\r\n" + 
							"                          |\r\n" + 
							"                          |");
				}
				else if (liv == 2) {
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                     /|\\  |\r\n" + 
							"                          |\r\n" + 
							"                          | ");
				}
				else if (liv == 1) {
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                     /|\\  |\r\n" + 
							"                     /    |\r\n" + 
							"                          |");
				}
				else if (liv == 0) {
					System.out.println(
							"                      +---+\r\n" + 
							"                      |   |\r\n" + 
							"                      O   |\r\n" + 
							"                     /|\\  |\r\n" + 
							"                     / \\  |\r\n" + 
							"                          |");
					
				}
			}
		
		if(liv == 0) {
			System.out.println("Du förlora hahaha!");
			System.out.println("Det rätta ordet var:  " + ratt_ord);
			
			
		}
		
		System.out.println("vill du spela igen?");
		System.out.println("Ja? tryck 1");
		System.out.println("Nej? tryck 2");
		int restartin = input.nextInt();
		if(restartin == 1 ) {
			reset = true;
		}
		
		else {
			
			reset = false;
			System.out.println("hejdå");
		}
		
		
		}

	public static String slump(ArrayList<String> temp) {
        Random rand = new Random(); 
       
        return temp.get(rand.nextInt(temp.size()));
	}



}
