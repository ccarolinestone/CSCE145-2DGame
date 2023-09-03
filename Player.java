import java.util.Scanner;

public class Player extends Character {
	private int lives;
	private boolean hasKey = false;
	
	
	


	public Player() {
		//the super method calls the default constructor in the Character class
		super();
		lives = 3;
		
	}
	

	public Player(char displayChar, int posX, int posY, int lives) {
		//super method calls the parameterized constructor in the character class
		super(displayChar, posX, posY);
		this.lives = lives;	
	}
	
	
	public boolean getHasKey() {
		return hasKey;
	}


	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}
	
	//TODO: Set up controller method for player
	//does not need parameters because everything it needs is in this class
	public boolean controls(Board b) {
		Scanner k = new Scanner(System.in);
		
		if(getHasKey()) {
			System.out.println("You have a key!");
		}
		
		System.out.println("Input wasd or q to quit: ");
		
		String input = k.nextLine();
		
		int tempPosX = this.getPosX();
		int tempPosY = this.getPosY();
		
		//input == "w" compares memory addresses
		if(input.equals("w")) {
			tempPosY-=1;
			
		}
		
		else if(input.equals("a")) {
			tempPosX -=1;
		}
		
		else if(input.equals("s")) {
			tempPosY +=1;
		}
		
		else if(input.equals("d")){
				tempPosX +=1;
		}
		
		else if(input.equals("q")) {
			return false;
		}
		
		if(b.getGameBoard()[tempPosY][tempPosX] != '#') {
			this.setPosX(tempPosX);
			this.setPosY(tempPosY);
		}
		
		return true; 
		//once return is run - its over and leaves
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}
