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
	
	/* Inicializálja a statikus objektumokat.
	 * Bármely tesztesetet is futtatunk, ezt meg kell hívni.
	 */
	private static void InitializeStatic()
	{
		warehouse = new Warehouse(10,10,2);
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

	/* Kiír a paraméterben kappot számú üres sort
	 */
	public static void nl(int n)
	{			
		for(int i = 1; i < n; i++)
		{
			System.out.println("\n");
		}
	}
	
	/* Inicializációs folyamatokat tesztelő menü.
	 */
	public static void InitMenu(String input) throws IOException
	{			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inner_input;
		
		switch(input)
		{
		case "1":
			System.out.println("Pálya betöltése");
			/* A Warehouse inicializálja a játékot. 
			 */
			warehouse.Initialize();
			break;
		case "2":
			System.out.println("Játékosok számának beállítása");
			/* Játékosok számának beállítása, 1 vagy 2 lehet játékos lehet.
			 */
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
			/* Játékosok neveit állíthatjuk be. 
			 */
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
		case "4":
			System.out.println("Játékos(ok) erejének beállítása");
			/* Játékosok erejét állíthatjuk be. 
			 */
			if(warehouse.GetWorkerNumber() == 1)
			{
				System.out.println("1. játékos ereje: ");
				inner_input = br.readLine();
				worker1.setForce(Integer.parseInt(inner_input));												
			}
			if(warehouse.GetWorkerNumber() == 2)
			{
				System.out.println("1. játékos ereje: ");
				inner_input = br.readLine();
				worker1.setForce(Integer.parseInt(inner_input));
				System.out.println("2. játékos ereje: ");
				inner_input = br.readLine();
				worker2.setForce(Integer.parseInt(inner_input));
			}
			break;
		default:
			System.out.println("Hibás bemenet!");
		}
	}
	
	/* A Skeleton program főmenüje.
	 */
	public static void MainMenu()
	{
		System.out.println("1. Játék inicializálása");
		System.out.println("2. Munkás mozgatása");
		System.out.println("3. Játék befejezése");
		System.out.println("4. Kilépés");
	}
	
	/* Adminisztrátori menü.
	 */
	private static void AdminMenu()
	{
		
	}
	
	/* Munkás mozgatási folyamatokat tesztelő menü.
	 */
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
				
				/* Munkás fallal való ütköztetése.
				 * Hozzáadja a munkást a mezőhöz, beállítja a munkás mezezejét.
				 * Beállítja az 1. mezőt a 2. mező szomszédjának és fordítva is.
				 * A 2. mezőre falat helyez, és a fal mezejét beállítja a 2. mezőre.
				 * Ütközteti a falat a munkással.
				 */
				
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, floor2);
				floor2.SetNeighbor(Direction.Down, floor1);
				
				floor2.Add(wall1);
				wall1.SetField(floor2);
				
				wall1.HitBy(Direction.Right, worker1, worker1.getForce());
				worker1.Move(Direction.Up, worker1.getForce());
				
				break;
			case "2":
				System.out.println("Ládával ütközik");
				
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
					/* A munkás maga elött tol egy dobozt, amit egy másik doboznak tol.					 
					 */
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
					
					worker1.Move(Direction.Up, worker1.getForce());																			
					break;
				case "2":
					System.out.println("Munkásnak tolja");
					
					/* A munkás maga elött tol egy dobozt, amit egy másik munkásnak tol.					 
					 */
					
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor2.Add(box1);					
					box1.SetField(floor2);
					box1.SetStucked(false);					
					
					floor3.Add(worker2);
					worker2.SetField(floor3);
																				
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, floor3);
					floor4.SetNeighbor(Direction.Down, floor3);
					floor3.SetNeighbor(Direction.Up, floor4);
					
					floor3.SetWarehouse(warehouse);
					
					worker1.Move(Direction.Up, worker1.getForce());	
					
					break;
				case "3":
					System.out.println("Falnak tolja");

					/* A munkás maga elött tol egy dobozt, amit egy falnak tol.					 
					 */
					
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
					
					worker1.Move(Direction.Up, worker1.getForce());
					break;
				case "4":
					System.out.println("Lyukba tolja");
					
					/* A munkás maga elött tol egy dobozt, amit egy lyukba tol.					 
					 */
					
					pit1.SetOpen(FunctionLogger.askUserDecision("Nyitva van a lyuk?"));
					
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					pit1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up,pit1);
										
					floor2.Add(box1);
					box1.SetField(floor2);
															
					floor2.SetWarehouse(warehouse);
					
					worker1.Move(Direction.Up, worker1.getForce());					
					break;
				case "5":
					System.out.println("Darálóba tolja");

					/* A munkás maga elött tol egy dobozt, amit egy darálóba tol.									 
					 */
					
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					grinder1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, grinder1);
										
					floor2.Add(box1);
					box1.SetField(floor2);
					floor2.SetWarehouse(warehouse);
					
					worker1.Move(Direction.Up, worker1.getForce());
					
					System.out.println("Szerez pontot? (T/F)");
					inner_input = br.readLine();
					if(inner_input.equalsIgnoreCase("t"))
					{
						System.out.println("Pontot szerez");
						
						/* A munkás pontot kap a darálóba tolt dobozért.						 
						 */
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
					
					/* A munkás maga elött tol egy dobozt, amit egy kapcsolóra tol.			
					 * A kapcsoló aktivál egy lyukat.		 
					 */
					
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					switch1.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, switch1);
										
					floor2.Add(box1);
					box1.SetField(floor2);										
					
					switch1.SetPit(pit1);					
					worker1.Move(Direction.Up, worker1.getForce());
					break;									
				case "7":
					System.out.println("Üres padlóra tolja");
					
					/* A munkás maga elött tol egy dobozt, amit egy üres mezőre tol.				 
					 */
					
					floor1.Add(worker1);
					worker1.SetField(floor1);
					
					floor1.SetNeighbor(Direction.Up, floor2);
					floor2.SetNeighbor(Direction.Down, floor1);
					floor3.SetNeighbor(Direction.Down, floor2);
					floor2.SetNeighbor(Direction.Up, floor3);
					
					floor2.Add(box1);
					box1.SetField(floor2);
					
					worker1.Move(Direction.Up, worker1.getForce());
					break;
				default:
					System.out.println("Hibás bemenet!");
				}
				
				break;
			case "3":
				System.out.println("Lyukkal Ütközik");
				
				/* A munkás rálép egy lyukra.
				 * Ha a lyuk nyitva van, akkor a munkás beleesik és meghal.				 
				 */
				
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				pit1.SetOpen(FunctionLogger.askUserDecision("Nyitva van a lyuk?"));
								
				floor1.SetNeighbor(Direction.Up, pit1);
				pit1.SetNeighbor(Direction.Down, floor1);
				
				floor1.SetWarehouse(warehouse);
												
				worker1.Move(Direction.Up, worker1.getForce());				
				break;
			case "4":
				System.out.println("Munkással Ütközik");
				
				/* A munkás egy másik munkással ütközik.				 				 
				 */
				
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, floor2);
				floor2.SetNeighbor(Direction.Down, floor1);
				
				floor2.Add(worker2);
				worker2.SetField(floor2);
							
				worker1.Move(Direction.Up, worker1.getForce());
				break;
			case "5":
				System.out.println("Kapcsolóval Ütközik");					

				/* A munkás egy kapcsolóval ütközik.				 
				 */
				
				floor1.Add(worker1);
				worker1.SetField(floor1);
				
				floor1.SetNeighbor(Direction.Up, switch1);
				switch1.SetNeighbor(Direction.Down, floor1);
												
				worker1.Move(Direction.Up, worker1.getForce());
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
			
			worker1.Move(Direction.Up, worker1.getForce());
			System.out.println("Nem Ütközik semmivel");
		}																
	}
	/* Játék vége folyamatokat tesztelő menü.
	 */
	public static void EndGameMenu(String input)
	{	
		switch(input)
		{
		case "1":
			System.out.println("Játék vége");
			
			/* A Warehouse véget vet a játéknak
			 */
			
			warehouse.EndGame();
			break;
		case "2":
			System.out.println("Eredmények kijelzése");
			
			/* Lekérdezi a Warehouse-tól az eredményeket.			 
			 */
			
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
			
			/* Új játék indítása			 
			 */
			warehouse.Initialize();
			break;
		default:
			System.out.println("Hibás bemenet!");
		}								
	}
	
	/* SkeletonApp belépési pontja.
	 */
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
			System.out.println("4. Játékos(ok) erejének beállítása");
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
					
		
		/*
		//Writer osztály példa
				Warehouse wh = new Warehouse(3,3,2);
				Writer out = new Writer("txt.txt");
				
				Field f;
				for(int i = 0; i < 3 ; i++)
					for(int j = 0; j < 3 ; j++)
					{
						if(i == 1 && j == 1)
						{
							f = new Grinder();
							f.setcoordinates(i, j);
							f.SetWarehouse(wh);
							wh.AddField(f, i, j);
							out.AddField(f,"Grinder");
						}
						else
						{
							f = new Floor();
							f.setcoordinates(i, j);
							wh.AddField(f, i, j);
							f.SetWarehouse(wh);
							out.AddField(f,"Floor");
						}
					}
				
				Worker w1 = new Worker();
				wh.GetFields()[0][0].Add(w1);
				w1.SetField(wh.GetFields()[0][0]);
				w1.SetName("Gyula");
				w1.AddPoint();
				
				Worker w2 = new Worker();
				wh.GetFields()[2][0].Add(w2);
				w2.SetField(wh.GetFields()[2][0]);
				w2.SetName("Kata");
				w2.AddPoint();
				w2.AddPoint();
				w2.AddPoint();
				
				out.AddWorker(w1);
				out.AddWorker(w2);
				
				Box b1 = new Box();
				wh.GetFields()[2][2].Add(b1);
				b1.SetField(wh.GetFields()[2][2]);
				
				Box b2 = new Box();
				wh.GetFields()[1][0].Add(b2);
				b2.SetField(wh.GetFields()[1][0]);
				
				
				out.AddBox(b1);
				out.AddBox(b2);
				
				Wall w = new Wall();
				wh.GetFields()[0][2].Add(w);
				w.SetField(wh.GetFields()[0][2]);
				out.AddWall(w);
				
				
				out.ListWorkers();
				out.ListFields();
				out.ListBoxes();
				out.ListWalls();
				
				w1.Move(Direction.Right, w1.getForce());
				
				out.ListWorkers();
				out.ListFields();
				out.ListBoxes();
				out.ListWalls();
			
				
				out.Close();
				*/
		
	}	
}
