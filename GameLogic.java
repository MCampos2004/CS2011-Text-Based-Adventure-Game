import java.util.Scanner; 

public class GameLogic {
	//Creating scanner for number input check
	static Scanner scanner = new Scanner(System.in);
	
	//Creating play and stop
	public static boolean isRunning;
	
	static Player player;
	
	//Storing random encounters
	public static String[] encounters = {"Battle", "Battle", "Battle", "Long Rest", "Shop"};
	
	//Storing enemie's name
	public static String[] enemies = {"Evil Knight", "Goblin", "Wolf", "Spirt Orb", "Wazy With A Long Sword"};
		
	//Creating/Storing area and array act
	public static int area = 0, act = 0;
	public static String[] areas = {"Starting Village", "Evil Forest", "Sky Island", "UnderWater Village", "Boss Room"};
	
	//Check if the user entered an integer
	public static int checkInput(String prompt, int playerInput) {
		int input;
		do {
			System.out.print(prompt);
			try {
				input = Integer.parseInt(scanner.next());
			}catch (Exception e) {
				input = -1;
				System.out.println("Please Enter An Integer");
			}
		}while (input < 1 || input > playerInput);
		return input;
	}
	
	//Creating method to stop until user enters anything
	public static void anythingToContiune() {
		System.out.print("\nEnter Anything to Contiune... ");
		scanner.next();
	}
	
	//Formatting
	//Clearing Console
	public static void clearConsole() {
		for (int i = 0; i <= 10; i++) {
			System.out.println();
		}
	}
	
	//Creating Separator
	public static void printSeparator() {
		for (int i = 0; i <= 78; i++) {
			System.out.print("-");
		}
		System.out.println("");
	}
	
	public static void printHeading(String title) {
		printSeparator();
		System.out.println(title);
		printSeparator();
	}
	
	//Starting the game
	public static void gameStart() {
		//User Input their Player Name
		boolean setName = false;
		String playerName;
		Scanner inputName = new Scanner(System.in);
		do { 
			clearConsole();
			System.out.print("Enter Your PlayerName:");
			playerName = inputName.nextLine();
			clearConsole();
			
			//Check if user wants this name/input their name right
			printHeading("Your PlayerName is " + playerName + ". \nIs that what you want?");
			System.out.println("[1] Yes?\n[2] No, I would like to change my name?!?\n[3] Exit Game");
			int input = checkInput("---> ", 2);
			if (input == 1) {
				setName = true;
			}
		}while (!setName);
		
		//Prints Story Intro
		Story.startingIntro();
		anythingToContiune();
		
		//Creating new player object with the name
		player = new Player(playerName);
		clearConsole();
		
		//Checks if user is trying to enter Developer mode
		if(playerName.equals("DEV MODE 1")) {
			player.pots = 999999999;
			player.hp = 999999999;
			player.maxHp = 999999999;
			player.gold = 999999999;
			player.longRest = 999999999;
			player.devAtk = 999999999;
			player.devDef = 999999999;
			printHeading("Welcome Cheater >.>");
		}
		else {
			printHeading("Welcome " + playerName + " ^_^");
		}
		anythingToContiune();
		Story.actIIntro();
		
		//Setting the Act to 1
		act = 1;
		
		//Setting isRunning to true, so the game loop can continue
		isRunning = true;
		
		//Start main game loop
		gameLoop();
	}
	
	//Method that change the GameStage based on player's xp
	public static void checkAct() {
		//Change acts based on xp
		if(player.xp >= 20 && act == 1) {
			//Increment act and area
			act = 2;
			area = 1;
			
			//Ends current story
			Story.actIOutro();
			
			//let the player "level up"
			player.numAtkUpgrades = 0;
			player.numDefUpgrades = 0;
			player.ChoiceTrait();
			
			//Next story
			Story.actIIIntro();
			
			//Assign new values to enemeies
			enemies[0] = "Evil Knightt";
			enemies[1] = "Goblin";
			enemies[2] = "Wolf";
			enemies[3] = "Spirt Orb";
			enemies[4] = "Wazy With A Long Sword";
			
			//Assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Long Rest";
			encounters[4] = "Shop";
			
			//Randomly heal the player
			player.hp += (int) (Math.random() * 50 + 1);
		}
		else if(player.xp >= 40 && act == 2){
			//Increment act and area
			act = 3;
			area = 2;
			
			//Ending current story
			Story.actIIOutro();
			
			//let the player "level up"
			player.numAtkUpgrades = 0;
			player.numDefUpgrades = 0;
			player.ChoiceTrait();
			
			//Next story
			Story.actIIIIntro();
			
			//Assign new values to enemeies
			enemies[0] = "Evil Knight";
			enemies[1] = "Goblin";
			enemies[2] = "Wolf";
			enemies[3] = "Spirt Orb";
			enemies[4] = "Wazy With A Long Sword";
			
			//Assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Long Rest";
			encounters[4] = "Shop";
			
			//Randomly heal the player
			player.hp += (int) (Math.random() * 50 + 1);
		}
		else if(player.xp >= 60 && act == 3) {
			//Increment act and area
			act = 4;
			area = 3;
			
			//Ending current story
			Story.actIIIOutro();
			
			//let the player "level up"
			player.numAtkUpgrades = 0;
			player.numDefUpgrades = 0;
			player.ChoiceTrait();
			
			//Next story
			Story.actIVIntro();
			
			//Assign new values to enemeies
			enemies[0] = "Evil Knight";
			enemies[1] = "Goblin";
			enemies[2] = "Wolf";
			enemies[3] = "Spirt Orb";
			enemies[4] = "Wazy With A Long Sword";
			
			//Assign new values to encounters
			encounters[0] = "Battle";
			encounters[1] = "Battle";
			encounters[2] = "Battle";
			encounters[3] = "Long Rest";
			encounters[4] = "Shop";
			
			//Randomly heal the player
			player.hp += (int) (Math.random() * 50 + 1);
		}
		else if (player.xp >= 80 && act == 4) {
			//Increment act and place 
			act = 5;
			area = 4;
			
			//Ending story
			Story.actIVOutro();
			
			//let the player "level up"
			player.numAtkUpgrades = 0;
			player.numDefUpgrades = 0;
			player.ChoiceTrait();
			
			//Randomly heal the player
			player.hp += (int) (Math.random() * 50 + 1);
			
			//Final story
			Story.actVIntro();
			
			//Calling the final battle
			finalBattle();
		}
	}
	
	//Method to calculate a random encounters
	public static void randomEncounter() {
		//Random number between 1 and 102
		int encounter = (int) (Math.random() * 102 + 1);
		
		//50% for Battle to spawn
		if(encounter < 50) {
			randomBattle();		
		}
		//30% for Long Rest to spawn
		else if(encounter < 80) {
			useLongRest();		
		}
		//20% for shop to spawn		
		else if (encounter < 100){
			shop();
		}
	}
	
	//method to continue the journey 
	public static void continueJourney() {
		//Check if act must be increased
		checkAct();
		
		//Check if game isn't in last act
		if(act != 5)
			randomEncounter();
	}
	
	//Printing out the most important information about the player character
	public static void characterInfo() {
		clearConsole();
		printHeading("CHARACTER INFO");
		System.out.println("Player's Name: " + player.name + "\tHP: " + player.hp + "/" + player.maxHp);
		printSeparator();
		
		//Player xp and gold 
		System.out.println("XP: " + player.xp + "\tGold: " + player.gold);
		printSeparator();
		
		//Player's Potions and Long Rest
		System.out.println("Number of Long Rest(s): " + player.longRest);
		printSeparator();
		System.out.println("Number of Healing Potion(s): " + player.pots);
		printSeparator();
		
		//Printing the chosen traits
		if(player.numAtkUpgrades >= 1) {
			System.out.println("Offensive Trait: " + player.atkUpgrades[player.numAtkUpgrades]);
			printSeparator();
		}
		if(player.numDefUpgrades >= 1) {
			System.out.println("Defensive trait: " + player.defUpgrades[player.numDefUpgrades]);
			printSeparator();
		}
		anythingToContiune();
	}
	
	//Creating Shop
	public static void shop() {
		clearConsole();
		printHeading("Wandering Trader comes up to you. \nHe offers you something:");
		int price = (int)(Math.random() * (30 + player.pots * 3 ) + 10 + player.pots);
		System.out.println("- Health Potion: " + price + " gold.");
		printSeparator();
		
		//Ask player if they want to buy something
		System.out.println("Do you want to buy one?\n(1) Yes!\n(2) No thanks.");
		int input = checkInput("Enter The Number Of Choice: ", 2);
		
		//Check if player wants to buy
		if(input == 1) {
		clearConsole();
		
		//Check if player has enough gold
			if(player.gold >= price) {
				printHeading("You bought a Health Potion for " + price + " gold.");
				player.pots++;
				player.gold-= price;
				anythingToContiune();
			}
			else {
				printHeading("You're too broke to buy Health Potion");
				anythingToContiune();
			}
		}
		else {
			printHeading("Goodbye");
			anythingToContiune();
		}
	}
	
	//Creating the Gacha System
	public static void gacha() {
		boolean gachaRun = true;
		do{
			clearConsole();
			printSeparator();
			System.out.println("Do you want to try your luck on some potions and long rest?");
			System.out.println("(1) Pull for 100 gold");
			System.out.println("(2) See Pulling Rates");
			System.out.println("(3) No, Exit Gacha Menu");
			printSeparator();
			int input = checkInput("Enter The Number Of Choice: ", 3);
			
			//Checks if player pull and have enough gold
			if(input == 1 && player.gold >= 100) {
				player.gold -= 100;
				int gachaNum = (int)(Math.random() * 104 + 1);
				if(gachaNum >= 1 && gachaNum <= 81) {
					printHeading("You Won 25 Gold");
					player.gold += 25;
				}
				else if(gachaNum >= 82 && gachaNum <= 92) {
					printHeading("You Won 500 Gold");
					player.gold += 500;
				}
				else if(gachaNum >= 93 && gachaNum <= 98) {
					printHeading("You Won Health Potion");
					player.pots++;
				}
				else if(gachaNum >= 93 && gachaNum <= 104) {
					printHeading("You Won Long Rest");
					player.longRest++;
				}
				anythingToContiune();
			}
			else if(input == 1 && player.gold < 100) {
				printSeparator();
				System.out.println("Come back when you have enough gold...");
				printSeparator();
				anythingToContiune();
			}
			//Shows the Pulling rates
			else if(input == 2){
				clearConsole();
				printSeparator();
				printHeading("\t\t\t\tPulling Rates");
				printHeading("You Won 500 Gold");
				System.out.println("25 Gold: 80%");
				System.out.println("Health Potion: 5%");
				System.out.println("Long Rest: 5%");
				System.out.println("500 Gold: 10%");
				printSeparator();
				anythingToContiune();
			}
			//Exits Gacha menu
			else if(input == 3) {
				printHeading("Goodbye");
				anythingToContiune();
				break;
			}
		}while(gachaRun);
	}
	
	//Allow Player to take a rest
	public static void useLongRest() {
		clearConsole();
		if(player.longRest >= 1) {
			printHeading("You want to take a Long Rest? (" + player.longRest + " rest(s) left.)");
			System.out.println("(1) Yes\n(2) No");
			int input = checkInput("->", 3);
			if(input == 1) {
				//Player actually takes Long Rest
				clearConsole();
				if(player.hp < 100) {
					int hpRestored = (int)(Math.random() * 100 + 1 );
					player.hp += hpRestored;
					System.out.println("You took a nap and restored " + hpRestored + " health");
					System.out.println("You're at " + player.hp + "/" + player.maxHp + " health.");
					player.longRest--;
					System.out.println("You have " + player.longRest);
				}
				else {
					System.out.println("You're at full health. You don't need to rest now!");
					anythingToContiune();
				}
			}
			else if(input == 2) {
				System.out.println("GOOD BYE...");
			}
			else if(input <= 3) {
				System.out.println("Please input 1 or 2");
			}
		}	
	}
	
	//Creating a random battle
	public static void randomBattle() {
		clearConsole();
		printHeading("Enemy Has Spawned! YOU WILL Fight it!");
		anythingToContiune();
		//Creating new enemy with random name
		battle(new Enemy(enemies[(int) (Math.random() * enemies.length)], player.xp));
	}
	
	//Main Battle method
	public static void battle(Enemy enemy) {
		//Main battle loop
		while(isRunning) {
			clearConsole();
			printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
			printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
			System.out.println("(1) Fight\n(2) Use Potion\n(3) Run Away (1% Chance)\n(4) Exit Game");
			int input = checkInput("Enter The Number Of Choice: ", 4);
			//React accordingly to player input
			//Fight The emeny
			if(input == 1) {
				//Fight
				int damageDealt = 0;
				int damageTaken = 0;
				clearConsole();
				printHeading("Pick An Action");
				System.out.println("(1) Normal Attack\n(2) Use " + player.atkUpgrades[player.numAtkUpgrades] + "\n(3) Use " + player.defUpgrades[player.numDefUpgrades]);
				input = checkInput("Enter The Number Of Choice: ", 3);
				if(input == 1) {
					//Calculate damage and damageTaken ( damage enemy deals to player)
					damageDealt = (player.attack() + player.devAtk) - enemy.defend();
					damageTaken = enemy.attack() - (player.defend() + player.devDef);
				}
				else if(input == 2) {
					if(player.numAtkUpgrades > 0) {
						damageDealt = (player.attack() + 15) - enemy.defend();
						damageTaken = enemy.attack() - player.defend();
						printHeading("You used: " + player.atkUpgrades[player.numAtkUpgrades] + " + 15 Damage");
						player.numAtkUpgrades = 0;
					}
					else {
						printHeading("You didn't have any skills to use!!!");
						damageDealt = player.attack() - enemy.defend();
						damageTaken = enemy.attack() - player.defend();
					}
				}
				else if(input == 3) {
					if(player.numDefUpgrades > 0) {
						damageDealt = player.attack() - enemy.defend();
						damageTaken = enemy.attack() - (player.defend() + 5);
						printHeading("You used: " + player.defUpgrades[player.numDefUpgrades] + " + 5 Defense");
						player.numDefUpgrades = 0;
					}
					else {
						printHeading("You didn't have any skills to use!!!");
						damageDealt = player.attack() - enemy.defend();
						damageTaken = enemy.attack() - player.defend();
					}
				}
				//Check if numbers aren't zero
				if(damageDealt < 0) {
					damageDealt = 0;
				}
				if(damageTaken < 0) {
					damageTaken = 0;
				}
				//Appling Damage to Both Parties
				//Deal damage tp both parties
				player.hp -= damageTaken;
				enemy.hp -= damageDealt;
				//Print the info of this battle round
				clearConsole();
				printHeading("Battle");
				System.out.println("You dealt " + damageDealt + " damage to the " + enemy.name + ".");
				printSeparator();
				System.out.println("The " + enemy.name + " dealt " + damageTaken + " damage you taken!");
				//Check if player is still alive or dead
				if(player.hp <= 0) {
					//Method to end the game
					playerDied();
					break;
				}
				else if(enemy.hp <= 0) {
					//Tell the player he won
					clearConsole();
					printSeparator();
					System.out.println("You murder " + enemy.name + "?");
					//Increase player xp 
					player.xp += enemy.xp;
					System.out.println("You earned " + enemy.xp + " XP?");
					//Random drops
					boolean addRest = (Math.random() * 5 + 1 <= 2.25);
					int goldEarned = (int) (Math.random() * 100 + 25);
					if(addRest) {
						player.longRest++;
						System.out.println("You gain the additional rest!");
					}
					if(goldEarned > 0 ) {
						player.gold += goldEarned;
						System.out.println("You gain " + goldEarned + " gold from the " + enemy.name + "'s dead as hell body");
					}
					printSeparator();
				break;
				}
				anythingToContiune();
			} 
			//Use Potion
			else if(input == 2) {
				clearConsole();
				if(player.pots > 0 && player.hp < 100) {
					//Player CAN take a potion
					System.out.println("Do you want to drink a potions? (" + player.pots + " left).");
					System.out.println("(1) Yes\n(2) No");
					input = checkInput("Enter The Number Of Choice: ", 2);
					if(input == 1) {
						if(player.pots >= 1) {
						//PLayer actually took it
						int heal = (int)(Math.random() * 50 + 1);
						player.hp += heal;
						if(player.hp > 100) {
							player.hp = 100;
						}
						player.pots--;
						clearConsole();
						printSeparator();
						System.out.println("You took a Health potion. It healed you for " + heal);
						System.out.println("You only have " + player.pots + " left");
						printSeparator();
						anythingToContiune();
						}
						else {
							System.out.println("Get out of here!!! You didn't have any Health Potions left");
							anythingToContiune();
						}
					}
					if(input == 2) {
						System.out.println("Then why you picked Use Potion???");
						anythingToContiune();
					}
				}
				else {
					System.out.println("You're at full Health... Why?");
					anythingToContiune();
				}
			}
			//Run Away
			else if(input == 3) {
				clearConsole();
				//Check that player isn't in last act (final boss battle)
				if(act != 4) {
					//Chance of 1% to escape
					if(Math.random() * 10 + 1 <= 0.1) {
						printHeading("You ran away from the " + enemy.name + " somehow?");
						anythingToContiune();
						printHeading("Game Ended LOL");
						break;
					}
					else {
						printHeading("You didn't manage to escape.");
						//Calculate damage the player takes
						int damageTook = enemy.attack();
						player.hp -= damageTook; 
						System.out.println("You fail run, You took " + damageTook + " damage!");
						anythingToContiune();
						//Check if player's still alive
						if(player.hp <= 0) {
							playerDied();
						}
					}
				}
				else {
					printHeading("YOU FOOL YOU CANNOT ESCAPE THE EVIL EMPEROR!!!");
					anythingToContiune();
				}
			}
			//Exit Game
			else if(input == 4) {
				isRunning = false;
			}
		}
	}
	
	//Printing the main menu
	public static void printMenu() {
		clearConsole();
		printHeading(areas[area]);
		System.out.println("Choose an action:");
		printSeparator();
		System.out.println("(1) Continue on your journey");
		System.out.println("(2) Character Info");
		System.out.println("(3) Gacha");
		System.out.println("(4) Exit Game");
	}
		
	//Final boss 
	public static void finalBattle() {
		//Creating the Fianl boss and letting the player fight against him
		battle(new Enemy("The Creator", 100000));
		//Printing the proper ending
		Story.printEnd(player);
		isRunning = false;
	}
		
	//Method that gets called when the player is dead
	public static void playerDied() { 
		clearConsole();
		printSeparator();
		System.out.println("You Died...?");
		System.out.println("You earned " + player.xp + " xp on your story");
		System.out.println("Thank you for playing. I have no clue on what I am doing. Send help???");
		printSeparator();
		isRunning = false;
	}
	
	//Main game loop
	public static void gameLoop() {
		while(isRunning) {
			printMenu();
			int input = checkInput("Enter The Number Of Choice: ", 4);
			if(input == 1) {
				continueJourney();
			}
			else if(input == 2) {
				characterInfo();
			}
			else if(input == 3) {
				gacha();
			}
			else{
				isRunning = false;
			}
		}
	}
}