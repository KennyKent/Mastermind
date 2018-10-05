import java.util.InputMismatchException;
import java.util.Scanner;

public class MasterMind {
	
	final int lower = 1000, higher = 9999; 
	private int random = (int)(Math.random() * (higher-lower)) + lower;
	private int codeSecret[] = {random / 1000, (random % 1000) /100, (random % 100) / 10, random % 10};
	
	Scanner sc = new Scanner(System.in);
	private int nbEssai = 0;
	private boolean win = false;

	public MasterMind() 
	{
		play();	
	}
	
	private void play() 
	{
		System.out.println("Essayez de deviner le code de 4 chiffres : ");
		
			try 
			{
				for(int i = 1 ; i < 9; i++) 
				{
					int saisiCode = sc.nextInt();
					int saisiCodeTab[] = {saisiCode / 1000, (saisiCode % 1000) /100, (saisiCode % 100) / 10, saisiCode % 10};
					
					if(saisiCode > 9999 || saisiCode < 1000)
					{
						System.out.println("Il faut que votre code soit composé de 4 chiffres !");
						System.out.println("Veuillez retentez votre coup : ");
						i = i-1;
					}
					else 
					{
						System.out.println("Essai n°" +  i +" : ");
			    		
						for(int cpt = 0 ; cpt < codeSecret.length ; cpt++)
						{	
							Boolean malPlace = false;
							Boolean bienPlace = false;
							
							if(codeSecret[cpt] == saisiCodeTab[cpt])
							{
								System.out.print("1 . ");
								bienPlace = true;
							}
							else
							{
								for(int j = 0 ; j < codeSecret.length ; j++)
								{
									if(saisiCodeTab[j] == codeSecret[cpt] && cpt != j)
									{
										System.out.print("0 . ");
										malPlace = true;
										break;
									}
								}
								
								if(!malPlace && !bienPlace)
								{
									System.out.print("X . ");
								}
							}
						}
					}
						
					if(saisiCode == random)
					{
						nbEssai = i;
						win = true;
						break;
					}
	    		}
			}
			catch(InputMismatchException e) 
			{
				System.out.println("Ceci n'est pas un nombre !");
			}
	}
	
	private void toWin()
	{	
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
	
	
	// Method to ask the user for replay the game
	private void ToReplay()
	{
		System.out.println("Voulez vous rejouer ?! Tapez Yes or No");
		String answer = sc.nextLine();
		
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