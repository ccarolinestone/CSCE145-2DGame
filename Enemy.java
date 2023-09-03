
public class Enemy extends Character {

	
	private float damage; 
	
	public enum State {LEFT, RIGHT, UP, DOWN};
	
	//default state is right
	private State s = State.RIGHT;
	
	public Enemy() {
		super();
		this.damage = 1f;
		
	}

	public Enemy(char displayChar, int posX, int posY, float damage) {
		
		//calling parameterized constructor in the character class
		super(displayChar, posX, posY);
		this.damage = damage;
		
	}
	
	//TODO: Make AI method - needs to know the board, so its given the board as a parameter
	//maybe needs player?
	public void AI(Board b) {
		
		
		
		//if state = ... move ...
		//if(s == State.LEFT)
		//instead of righting 4 if statements - use switch statement - specialized, is this one specific thing equal to this specific thing
		//need to tell when to break out of switch statement - fall through if break is not there
		//every statement needs a break statement
		switch(s) {
		case LEFT:
			//code here
			if(b.getGameBoard()[getPosY()][getPosX()-1] != '#')
				setPosX(getPosX()-1);
				
				else 
					s=State.RIGHT;
			break;
			
		case RIGHT:
			//code here
			if(b.getGameBoard()[getPosY()][getPosX()+1] != '#')
			setPosX(getPosX()+1);
			
			else 
				s=State.LEFT;
			break;
			
		case UP:
			//code here
			break;
			
		case DOWN:
			//code here
			break;
		}
		
		
	}
	
	

}
