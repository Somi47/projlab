package SkeletonApp;

import GameLogic.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Utility.FunctionLogger;

public class Program {
	
	public static void cls() throws IOException {  
	    System.out.print("\033[H\033[2J");  
	    System.out.print("\033[H\033[2J");	    
	}  
	
	public static void nl(int n)
	{
		for(int i = 1; i < n; i++)
		{
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) throws IOException {
		//Objektumok l�trehoz�sa
		Warehouse warehouse = new Warehouse();
		Worker worker1 = new Worker();
		Worker worker2 = new Worker();		
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while(true)
		{
			nl(1);
			System.out.println("1. J�t�k inicializ�l�sa");
			System.out.println("2. Munk�s mozgat�sa");
			System.out.println("3. J�t�k befejez�se");
			System.out.println("4. Kil�p�s");
			input = br.readLine();
			switch(input)
			{
			case "1":
				System.out.println("1. P�lya bet�lt�se");
				System.out.println("2. J�t�kosok sz�m�nak be�ll�t�sa");
				System.out.println("3. J�t�kos(ok) nev�nek be�ll�t�sa");
				input = br.readLine();
				switch(input)
				{
				case "1":
					System.out.println("P�lya bet�lt�se");
					// Load map?
					warehouse.Initialize();
					break;
				case "2":
					System.out.println("J�t�kosok sz�m�nak be�ll�t�sa");
					// Set worker number
					System.out.println("J�t�kosok sz�ma: (1-2)");
					input = br.readLine();
					
					if(input.equals("1"))
					{
						System.out.println("J�t�kosok sz�ma: 1");					
						warehouse.SetWorkerNumber(1);
						break;
					}					
					if(input.equals("2"))
					{
						System.out.println("J�t�kosok sz�ma: 2");
						warehouse.SetWorkerNumber(2);
						break;
					}					
					else
					{
						System.out.println("Hib�s bemenet!");
						break;
					}					
				case "3":
					System.out.println("J�t�kos(ok) nev�nek be�ll�t�sa");
					// Set worker's name
					if(warehouse.GetWorkerNumber() == 1)
					{
						System.out.println("1. j�t�kos neve: ");
						input = br.readLine();
						worker1.SetName(input);												
					}
					if(warehouse.GetWorkerNumber() == 2)
					{
						System.out.println("1. j�t�kos neve: ");
						input = br.readLine();
						worker1.SetName(input);
						System.out.println("2. j�t�kos neve: ");
						input = br.readLine();
						worker2.SetName(input);
					}
					break;
				default:
					System.out.println("Hib�s bemenet!");
				}
				break;
			case "2":
				System.out.println("�tk�zik valamivel? (T/F)");
				input = br.readLine();
				if(input.equalsIgnoreCase("t"))
				{
					System.out.println("1. Fallal �tk�zik");
					System.out.println("2. L�d�val �tk�zik");
					System.out.println("3. Lyukkal �tk�zik");
					System.out.println("4. Munk�ssal �tk�zik");
					System.out.println("5. Kapcsol�val �tk�zik");
					input = br.readLine();
					switch(input)
					{
					case "1":
						System.out.println("Fallal �tk�zik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit wall fgv
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem �tk�zik fallal");
							break;
						}
						break;
					case "2":
						System.out.println("L�d�val �tk�zik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							// Worker hit box
							System.out.println("El tudja tolni? (T/F)");
							input = br.readLine();
							if(input.equalsIgnoreCase("t"))
							{
								// Worker move box
								System.out.println("1. M�sik doboznak tolja");
								System.out.println("2. Munk�snak tolja");
								System.out.println("3. Falnak tolja");
								System.out.println("4. Lyukba tolja");
								System.out.println("5. Dar�l�ba tolja");
								System.out.println("6. Kapcsol�ra tolja");
								input = br.readLine();
								switch(input)
								{
								case "1":
									System.out.println("Doboznak tolja");
									// Worker move box hit box
									break;
								case "2":
									System.out.println("Munk�snak tolja");
									// Worker move box hit worker 
									break;
								case "3":
									System.out.println("Falnak tolja");
									// Worker move box hit wall
									break;
								case "4":
									System.out.println("Lyukba tolja");
									// Worker move box hit pit
									break;
								case "5":
									System.out.println("Dar�l�ba tolja");
									// Worker move box hit grinder
									System.out.println("Szerez pontot? (T/F)");
									input = br.readLine();
									if(input.equalsIgnoreCase("t"))
									{
										System.out.println("Pontot szerez");
										// points++
										break;
									}
									if(input.equalsIgnoreCase("f"))
									{
										System.out.println("Nem szerez pontot");
										break;
									}
									break;
								case "6":
									System.out.println("Kapcsol�ra tolja");
									// Worker move box hit switch
									break;									
								}
							}
							if(input.equalsIgnoreCase("f"))
							{
								System.out.println("Nem tudja eltolni");
								break;
							}
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem �tk�zik l�d�val");
							break;
						}				
						break;
					case "3":
						System.out.println("Lyukkal �tk�zik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit pit
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem �tk�zik lyukkal");
							break;
						}						
						break;
					case "4":
						System.out.println("Munk�ssal �tk�zik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit worker
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem �tk�zik munnk�ssal");
							break;
						}				
						break;
					case "5":
						System.out.println("Kapcsol�val �tk�zik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit switch
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem �tk�zik kapcsol�val");
							break;
						}				
						break;
					default:
						System.out.println("Hib�s bemenet!");						
					}
				}
				if(input.equalsIgnoreCase("f"))
				{
					System.out.println("Nem �tk�zik semmivel");
					break;
				}													
				break;				
			case "3":
				System.out.println("1. J�t�k v�ge");
				System.out.println("2. Eredm�nyek kijelz�se");
				System.out.println("3. �j j�t�k");
				input = br.readLine();
				switch(input)
				{
				case "1":
					System.out.println("J�t�k v�ge");
					// Call EndGame
					warehouse.EndGame();
					break;
				case "2":
					System.out.println("Eredm�nyek kijelz�se");
					// Show points
					if(warehouse.GetWorkerNumber() > 1)
					{
						System.out.println("1. j�t�kos pontjai: " + worker1.GetPoints());
						System.out.println("2. j�t�kos pontjai: " + worker2.GetPoints());
						break;
					}
					else
					{
						System.out.println("1. j�t�kos pontjai: " + worker1.GetPoints());						
						break;
					}
				case "3":
					System.out.println("�j j�t�k");
					// New game
					break;
				default:
					System.out.println("Hib�s bemenet!");
				}								
				break;
			case "4":
				System.out.println("Kil�p�s");
				return;
			default:
				System.out.println("Hib�s bemenet!");
			}
		}
		
		
		/*System.out.println("Hali, ez egy példa a FunctionLogger működésére:");
		
		FunctionLogger.logFunctionCalled("calledName1", "calledFunction1()");
			FunctionLogger.logFunctionCalled("calledName1/1", "calledFunction1/1()");
			FunctionLogger.logFunctionReturnVoid();
			FunctionLogger.logFunctionCalled("calledName1/2", "calledFunction1/2()");
			FunctionLogger.logFunctionRetrun("Down");
		FunctionLogger.logFunctionRetrun("Down");		
		FunctionLogger.logFunctionCalled("calledName2", "calledFunction2()");
			if( FunctionLogger.askUserDecision("Ládával ütközött?") ) {
				FunctionLogger.logFunctionCalled("calledName2/Láda", "calledFunction2/Láda()");
				FunctionLogger.logFunctionReturnVoid();
			}
			else {
				FunctionLogger.logFunctionCalled("calledName2/NemLáda", "calledFunction2/NemLáda()");
				FunctionLogger.logFunctionReturnVoid();
			}
		FunctionLogger.logFunctionReturnVoid();*/
	}
	
}
