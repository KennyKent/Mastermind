import java.util.InputMismatchException;
import java.util.Scanner;

public class MasterMind {
	
	private int codeSecret[];
	private int saisiCodeTab[];
	final int lower = 1000; 
	final int higher = 9999; 
	Scanner sc = new Scanner(System.in);
	int nbEssai = 0;


	public MasterMind() 
	{
		play();	
	}
	
	private void play() 
	{
		int random = (int)(Math.random() * (higher-lower)) + lower;
		int codeSecret[] = {random / 1000, (random % 1000) /100, (random % 100) / 10, random % 10};
		
		boolean win = false;
		
		System.out.println("Essayez de deviner le code de 4 chiffres : ");
		System.out.println(random);

		
		for(int i = 1 ; i < 9; i++) 
		{
			int saisiCode = sc.nextInt();
			int saisiCodeTab[] = {saisiCode / 1000, (saisiCode % 1000) /100, (saisiCode % 100) / 10, saisiCode % 10};
			/// try {
				
			// }
			// catch(InputMismatchException e) {
			// 	System.out.println("Ceci n'est pas un nombre !");
			// }
			
			if(saisiCode > 9999 || saisiCode < 1000)
			{
				System.out.println("Il faut que votre code soit composé de 4 chiffres !");
				i = i-1;
			}
			else 
			{
				System.out.println("Essai n°" +  i +" : ");
	    		
	    		for(int cpt = 0 ; cpt < codeSecret.length ; cpt++)
	    		{	
	    			if(codeSecret[cpt] == saisiCodeTab[cpt])
	    			{
	    				System.out.print("1");
	    			}
	    			else if(codeSecret[cpt] != saisiCodeTab[cpt])
	    			{
	    				for(int j = 0 ; j < codeSecret.length ; j++)
	    				{
	    					if(saisiCodeTab[cpt] == codeSecret[j] && cpt != j)
	    					{
	    						System.out.print("0");
	    					}
	    				}
	    			}
	    			}
	    		}
			System.out.println();
    		if(saisiCode == random)
    		{
    			nbEssai = i;
    			win = true;
    			break;
    		}
			}

		if(!win)
		{
			System.out.println("Vous avez perdu !");

			System.out.println("Voilà le code secret : " + random);
			 ToReplay();
		}
		else
		{
			System.out.println("Vous avez gagné en " + nbEssai + " coups");
			 ToReplay();	
		}
		
	}
	
	private boolean comparateTo(int tab[], int tab2[])
	{	
		return true;
	}
	
	private void ToReplay()
	{
		System.out.println("Voulez vous rejouer ?! Tapez Yes or No");
		Scanner sch = new Scanner(System.in);
		String answer = sch.nextLine();
		
		if(answer.equals("Yes"))
		{
			play();
		}
		else if(answer.equals("No"))
		{
			System.out.println("La partie est terminée !");
		}
		else
		{
			System.out.println("Veuillez tapez Yes ou No s'il vous plaît");
			ToReplay();
		}
			
	}
}