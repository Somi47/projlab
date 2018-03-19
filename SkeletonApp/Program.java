package SkeletonApp;

import GameLogic.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import Utility.FunctionLogger;

public class Program {
	
	public static void cls() throws IOException 
	{  
	    System.out.print("\033[H\033[2J");  	    
	}  
	
	public static void nl(int n)
	{			
		for(int i = 1; i < n; i++)
		{
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		//Objektumok létrehozása
		Warehouse warehouse = new Warehouse();
		Worker worker1 = new Worker();
		Worker worker2 = new Worker();	
		Floor floor1 = new Floor();
		Floor floor2 = new Floor();
		Box box1 = new Box();
		Box box2 = new Box();
		Grinder grinder1 = new Grinder();
		Pit pit1 = new Pit();
		Switch switch1 = new Switch();
		Wall wall1 = new Wall();
		
		//
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while(true)
		{
			nl(3);
			System.out.println("1. Játék inicializálása");
			System.out.println("2. Munkás mozgatása");
			System.out.println("3. Játék befejezése");
			System.out.println("4. Kilépés");
			input = br.readLine();
			switch(input)
			{
			case "1":
				System.out.println("1. Pálya betöltése");
				System.out.println("2. Játékosok számának beállítása");
				System.out.println("3. Játékos(ok) nevének beállítása");
				input = br.readLine();
				switch(input)
				{
				case "1":
					System.out.println("Pálya betöltése");
					// Load map?
					warehouse.Initialize();
					break;
				case "2":
					System.out.println("Játékosok számának beállítása");
					// Set worker number
					System.out.println("Játékosok száma: (1-2)");
					input = br.readLine();
					
					if(input.equals("1"))
					{
						System.out.println("Játékosok száma: 1");					
						warehouse.SetWorkerNumber(1);
						break;
					}					
					if(input.equals("2"))
					{
						System.out.println("Játékosok száma: 2");
						warehouse.SetWorkerNumber(2);
						break;
					}					
					else
					{
						System.out.println("Hibás bemenet!");
						break;
					}					
				case "3":
					System.out.println("Játékos(ok) nevének beállítása");
					// Set worker's name
					if(warehouse.GetWorkerNumber() == 1)
					{
						System.out.println("1. játékos neve: ");
						input = br.readLine();
						worker1.SetName(input);												
					}
					if(warehouse.GetWorkerNumber() == 2)
					{
						System.out.println("1. játékos neve: ");
						input = br.readLine();
						worker1.SetName(input);
						System.out.println("2. játékos neve: ");
						input = br.readLine();
						worker2.SetName(input);
					}
					break;
				default:
					System.out.println("Hibás bemenet!");
				}
				break;
			case "2":
				System.out.println("Ütközik valamivel? (T/F)");
				input = br.readLine();
				if(input.equalsIgnoreCase("t"))
				{
					System.out.println("1. Fallal ütközik");
					System.out.println("2. Ládával ütközik");
					System.out.println("3. Lyukkal ütközik");
					System.out.println("4. Munkással ütközik");
					System.out.println("5. Kapcsolóval ütközik");
					input = br.readLine();
					switch(input)
					{
					case "1":
						System.out.println("Fallal ütközik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit wall fgv							
							wall1.HitBy(Direction.Right, worker1);
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem ütközik fallal");
							break;
						}
						break;
					case "2":
						System.out.println("Ládával ütközik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							// Worker hit box
							System.out.println("El tudja tolni? (T/F)");
							input = br.readLine();
							if(input.equalsIgnoreCase("t"))
							{
								// Worker move box
								System.out.println("1. Másik doboznak tolja");
								System.out.println("2. Munkásnak tolja");
								System.out.println("3. Falnak tolja");
								System.out.println("4. Lyukba tolja");
								System.out.println("5. Darálóba tolja");
								System.out.println("6. Kapcsolóra tolja");
								input = br.readLine();
								switch(input)
								{
								case "1":
									System.out.println("Doboznak tolja");
									// Worker move box hit box
									break;
								case "2":
									System.out.println("Munkásnak tolja");
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
									System.out.println("Darálóba tolja");
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
									System.out.println("Kapcsolóra tolja");
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
							System.out.println("Nem ütközik ládával");
							break;
						}				
						break;
					case "3":
						System.out.println("Lyukkal ütközik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit pit
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem ütközik lyukkal");
							break;
						}						
						break;
					case "4":
						System.out.println("Munkással ütközik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit worker
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem ütközik munnkással");
							break;
						}				
						break;
					case "5":
						System.out.println("Kapcsolóval ütközik? (T/F)");
						input = br.readLine();
						if(input.equalsIgnoreCase("t"))
						{
							//Worker hit switch
							
							break;
						}
						if(input.equalsIgnoreCase("f"))
						{
							System.out.println("Nem ütközik kapcsolóval");
							break;
						}				
						break;
					default:
						System.out.println("Hibás bemenet!");						
					}
				}
				if(input.equalsIgnoreCase("f"))
				{
					System.out.println("Nem ütközik semmivel");
					break;
				}													
				break;				
			case "3":
				System.out.println("1. Játék vége");
				System.out.println("2. Eredmények kijelzése");
				System.out.println("3. Új játék");
				input = br.readLine();
				switch(input)
				{
				case "1":
					System.out.println("Játék vége");
					// Call EndGame
					warehouse.EndGame();
					break;
				case "2":
					System.out.println("Eredmények kijelzése");
					// Show points
					if(warehouse.GetWorkerNumber() > 1)
					{
						System.out.println("1. játékos pontjai: " + worker1.GetPoints());
						System.out.println("2. játékos pontjai: " + worker2.GetPoints());
						break;
					}
					else
					{
						System.out.println("1. játékos pontjai: " + worker1.GetPoints());						
						break;
					}
				case "3":
					System.out.println("Új játék");
					// New game
					break;
				default:
					System.out.println("Hibás bemenet!");
				}								
				break;
			case "4":
				System.out.println("Kilépés");
				return;
			default:
				System.out.println("Hibás bemenet!");
			}
		}
		
		
		/*System.out.println("Hali, ez egy pÃ©lda a FunctionLogger mÅ±kÃ¶dÃ©sÃ©re:");
		
		FunctionLogger.logFunctionCalled("calledName1", "calledFunction1()");
			FunctionLogger.logFunctionCalled("calledName1/1", "calledFunction1/1()");
			FunctionLogger.logFunctionReturnVoid();
			FunctionLogger.logFunctionCalled("calledName1/2", "calledFunction1/2()");
			FunctionLogger.logFunctionRetrun("Down");
		FunctionLogger.logFunctionRetrun("Down");		
		FunctionLogger.logFunctionCalled("calledName2", "calledFunction2()");
			if( FunctionLogger.askUserDecision("LÃ¡dÃ¡val Ã¼tkÃ¶zÃ¶tt?") ) {
				FunctionLogger.logFunctionCalled("calledName2/LÃ¡da", "calledFunction2/LÃ¡da()");
				FunctionLogger.logFunctionReturnVoid();
			}
			else {
				FunctionLogger.logFunctionCalled("calledName2/NemLÃ¡da", "calledFunction2/NemLÃ¡da()");
				FunctionLogger.logFunctionReturnVoid();
			}
		FunctionLogger.logFunctionReturnVoid();*/
	}
	
}
