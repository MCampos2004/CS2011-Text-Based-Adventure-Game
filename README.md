/* Group Name: Weronies
 * Name 1: Slok Patel 
 * Name 2: Joseph Acosta
 * Name 3: Miguel Campos
 * Name 4: Steven Yang                  
 * Your Course Number (CS2011) 
 * Your Section Numbers: 01 & 02 & 04 
 * Description: The purpose of our final project was to make an enjoyable game incorporating an rpg style game into a text based adveture game.
 * Other Comments: 
 */
 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	


If using Command Prompt:
	Step 1: Open
		Open command Prompt
	
	Step 2: Set Path:
		set path={[Name of the drive]:\Program Files\Java\jdk-_ _ _._._\bin} (the file location of JDk)
		EX: set path=O:\Program Files\Java\jdk-14.0.21\bin
		
	Step 3: Set File location
		cd [the file location of where you download the CS2011FinalGame.zip file] 
		EX: cd O:\Users\Name\Downloads\CS2011FinalGame
	
	Step 4: Run
		java Main
		
		Extra: Mode
			java Main -help		[This opens help mode]
			java Main -Tips		[This opens Game Tips mode]
			java Main -DEV		[This opens Developer mode]

		
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	


If using Visual Studio Code:
	Step 1: Open
		Open Visual Studio Code
	
	Step 2: Open File
		Click on File [Top left]
		Click on Open  [ShortCut: CTRL + o]
		Open Main.java
		
	Step 3: Run
		Click on Terminal [Top left or Bottom middle (you may already have it open)]
		java Main
		
		Extra: Mode
			java Main -help		[This opens help mode]
			java Main -Tips		[This opens Game Tips mode]
			java Main -DEV		[This opens Developer mode]
			
	
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	

If using Git Bash
	Step 1: Open File
		Open CS2011FinalGame File
		
	Step 2: Git Bash
		Right click and Git Bash Here 
		run 'ls' to check if location is correct it should say a list of files:
				- Character.class  Enemy.java       Main.class    Player.java  Story.java
				- Character.java   GameLogic.class  Main.java     Readme.txt
				- Enemy.class      GameLogic.java   Player.class  Story.class
		or see if your things says " ~.../CS2011FinalGame" (This may look different since my laptop is windows)
		
	Step 3: Run
		java Main
		
		Extra: Mode
			java Main -help		[This opens help mode]
			java Main -Tips		[This opens Game Tips mode]
			java Main -DEV		[This opens Developer mode]

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------	


How to play:
	Step 1: Compile (Skip if you're running from .class) (if you are compile, you may have to do in the following order)
		javac Story.java
		javac Character.java
		javac Player.java
		javac GameLogic.java
		javac Main.java

	Step 2: Run
		java Main
		
		Extra: Mode
			java Main -help		[This opens help mode]
			java Main -Tips		[This opens Game Tips mode]
			java Main -DEV		[This opens Developer mode]

