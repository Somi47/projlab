package SkeletonApp;

import GameLogic.*;
import Utility.FunctionLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program 
{	
	static Warehouse warehouse;
	static Worker worker1;
	static Worker worker2;
	static Box box1;
	static Box box2;
	static Grinder grinder1;
	static Pit pit1;
	static Switch switch1;
	static Wall wall1;
	static Floor floor1;
	static Floor floor2;
	static Floor floor3;
	static Floor floor4;
	
	private static void InitializeStatic()
	{
		warehouse = new Warehouse();
		warehouse.SetDbgName("warehouse");
		worker1 = new Worker();
		worker1.SetDbgName("worker1");
		worker2 = new Worker();
		worker2.SetDbgName("worker2");
		floor1 = new Floor();
		floor1.SetDbgName("floor1");
		floor2 = new Floor();
		floor2.SetDbgName("floor2");
		floor3 = new Floor();
		floor3.SetDbgName("floor3");
		floor4 = new Floor();
		floor4.SetDbgName("floor4");
		box1 = new Box();
		box1.SetDbgName("box1");
		box2 = new Box();
		box2.SetDbgName("box2");
		grinder1 = new Grinder();
		grinder1.SetDbgName("grinder1");
		pit1 = new Pit();
		pit1.SetDbgName("pit1");
		switch1 = new Switch();
		switch1.SetDbgName("switch1");
		wall1 = new Wall();
		wall1.SetDbgName("wall1");
	}

	
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
	
	public static void InitMenu(String input) throws IOException
	{			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inner_input;
		
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
			inner_input = br.readLine();
			
			if(inner_input.equals("1"))
			{
				System.out.println("Játékosok száma: 1");					
				warehouse.SetWorkerNumber(1);
				break;
			}					
			if(inner_input.equals("2"))
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
				inner_input = br.readLine();
				worker1.SetName(inner_input);												
			}
			if(warehouse.GetWorkerNumber() == 2)
			{
				System.out.println("1. játékos neve: ");
				inner_input = br.readLine();
				worker1.SetName(inner_input);
				System.out.println("2. játékos neve: ");
				inner_input = br.readLine();
				worker2.SetName(inner_input);
			}
			break;
		default:
			System.out.println("Hibás bemenet!");
		}
	}
	
	public static void MainMenu()
	{
		System.out.println("1. Játék inicializálása");
		System.out.println("2. Munkás mozgatása");
		System.out.println("3. Játék befejezése");
		System.out.println("4. Kilépés");
	}
	
	private static void AdminMenu()
	{
		System.out.println(worker1.GetName());
		System.out.println(worker2.GetName());
	}
	
	public static void WorkerMoveMenu(String input) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inner_input;	
		
		if(input.equalsIgnoreCase("t"))
		{
			System.out.println("1. Fallal ütközik");
			System.out.println("2. Ládával ütközik");
			System.out.println("3. Lyukkal ütközik");
			System.out.println("4. Munkással ütközik");
			System.out.println("5. Kapcsolóval ütközik");
			inner_input = br.readLine();
			switch(inner_input)
			{
			case "1":
				System.out.println("Fallal Ütközik");						
				
				//Worker hit wall
				
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, floor2);
				floor2.SetNeighbor(Direction.Down, floor1);
				
				floor2.Add(wall1);
				wall1.SetField(floor2);
				
				wall1.HitBy(Direction.Right, worker1);
				worker1.Move(Direction.Up);
				
				break;
			case "2":
				System.out.println("Ládával ütközik");
				// Worker hit box
				
				// Worker move box
				System.out.println("1. Másik doboznak tolja");
				System.out.println("2. Munkásnak tolja");
				System.out.println("3. Falnak tolja");
				System.out.println("4. Lyukba tolja");
				System.out.println("5. Darálóba tolja");
				System.out.println("6. Kapcsolóra tolja");
				System.out.println("7. Üres padlóra tolja");
				inner_input = br.readLine();
				switch(inner_input)
				{
				case "1":
					System.out.println("Másik doboznak tolja");
					// Worker move box hit box
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor2.Add(box1);					
					box1.SetField(floor2);
					box1.SetStucked(false);
					
					
					floor3.Add(box2);
					box2.SetField(floor3);
					
					if(FunctionLogger.askUserDecision("El tudja-e tolni?"))
					{
						box2.SetStucked(false);
					}
					else
					{
						box2.SetStucked(true);
					}									
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, floor3);
					floor4.SetNeighbor(Direction.Down, floor3);
					floor3.SetNeighbor(Direction.Up, floor4);
					
					worker1.Move(Direction.Up);																			
					break;
				case "2":
					System.out.println("Munkásnak tolja");
					// Worker move box hit worker 
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor2.Add(box1);					
					box1.SetField(floor2);
					box1.SetStucked(false);					
					
					floor3.Add(worker2);
					worker2.SetField(floor3);
					
					if(FunctionLogger.askUserDecision("El tudja-e tolni?"))
					{
						worker2.SetStucked(false);
					}
					else
					{
						worker2.SetStucked(true);
					}
															
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, floor3);
					floor4.SetNeighbor(Direction.Down, floor3);
					floor3.SetNeighbor(Direction.Up, floor4);
					
					worker1.Move(Direction.Up);	
					
					break;
				case "3":
					System.out.println("Falnak tolja");
					// Worker move box hit wall
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up,floor3);
					
					floor3.Add(wall1);
					wall1.SetField(floor3);
					
					floor2.Add(box1);
					box1.SetField(floor2);
					
					worker1.Move(Direction.Up);
					break;
				case "4":
					System.out.println("Lyukba tolja");
					// Worker move box hit pit
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					pit1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up,pit1);
										
					floor2.Add(box1);
					box1.SetField(floor2);
					
					worker1.Move(Direction.Up);					
					break;
				case "5":
					System.out.println("Darálóba tolja");
					// Worker move box hit grinder
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					grinder1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, grinder1);
										
					floor2.Add(box1);
					box1.SetField(floor2);
					
					worker1.Move(Direction.Up);
					
					System.out.println("Szerez pontot? (T/F)");
					inner_input = br.readLine();
					if(inner_input.equalsIgnoreCase("t"))
					{
						System.out.println("Pontot szerez");
						// points++
						worker1.AddPoint();									
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
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					switch1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, switch1);
										
					floor2.Add(box1);
					box1.SetField(floor2);									
					
					worker1.Move(Direction.Up);
					break;									
				case "7":
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, floor3);
					
					floor2.Add(box1);
					box1.SetField(floor2);
					
					worker1.Move(Direction.Up);
					break;
				default:
					System.out.println("Hibás bemenet!");
				}
				
				break;
			case "3":
				System.out.println("Lyukkal Ütközik");
				//Worker hit pit	
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, pit1);
				pit1.SetNeighbor(Direction.Down, floor1);
												
				worker1.Move(Direction.Up);				
				break;
			case "4":
				System.out.println("Munkással Ütközik");
				//Worker hit worker		
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, floor2);
				floor2.SetNeighbor(Direction.Down, floor1);
				
				floor2.Add(worker2);
				worker2.SetField(floor2);
							
				worker1.Move(Direction.Up);
				break;
			case "5":
				System.out.println("Kapcsolóval Ütközik");					
				// Worker hit switch	
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, switch1);
				switch1.SetNeighbor(Direction.Down, floor1);
												
				worker1.Move(Direction.Up);
				break;
			default:
				System.out.println("Hibás bemenet!");						
			}
		}
		if(input.equalsIgnoreCase("f"))
		{
			floor1.Add(worker1);
			worker1.SetField(floor1);
			
			floor1.SetNeighbor(Direction.Up, floor2);
			floor2.SetNeighbor(Direction.Down, floor1);
			floor2.Remove();
			
			worker1.Move(Direction.Up);
			System.out.println("Nem Ütközik semmivel");
		}																
	}
	
	public static void EndGameMenu(String input)
	{	
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
	}
	
	public static void main(String[] args) throws IOException 
	{
		InitializeStatic();		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
					
		MainMenu();
		input = br.readLine();
		switch(input)
		{
		case "1":								
			System.out.println("1. Pálya betöltése");
			System.out.println("2. Játékosok számának beállítása");
			System.out.println("3. Játékos(ok) nev�nek beállítása");
			input = br.readLine();
			InitMenu(input);
			nl(2);
			break;
		case "2":
			System.out.println("Ütközik valamivel? (T/F)");
			input = br.readLine();
			WorkerMoveMenu(input);
			nl(2);
			break;
		case "3":
			System.out.println("1. Játék vége");
			System.out.println("2. Eredmények kijelzése");
			System.out.println("3. Új játék");
			input = br.readLine();
			EndGameMenu(input);
			nl(2);
			break;
		case "4":
			nl(2);
			System.out.println("Kiléptél!");
			nl(2);
			return;
		case "asdasd":
			AdminMenu();
			break;
		default:
			nl(2);
			System.out.println("Hibás bemenet!");
			nl(2);
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
