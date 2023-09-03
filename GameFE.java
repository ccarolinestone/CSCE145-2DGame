
//Player
//Enemy
//Goal

//Character Class (parent class)
//visual (char)
//position X and Y
//Getters and Setters (allow us to access and modify class level variables because the variables are set to private
//Draw Character Method

//Player class extends Character(class fields listed below)
//lives (int)
//Controls Method

//Enemy class extends Character (class fields listed below)
//damage (float)
// AI Method 

//Board Class
//2D array (char)
//Draw Method 


//can set up a parent class to hold similar class fields in both of the child classes
public class GameFE {

	public static void main(String[] args) {
		Board b = new Board(10,10, 1,1, 8,8);
		
		Character[] allCharacters = new Character[3];
		
		//creating the player with parameters of (displayChar, posX, posY, lives)
		Player p = new Player('p',1, 2, 3);
		Enemy e1 = new Enemy('e', 5,5, 1f);
		Enemy e2 = new Enemy('e', 3,7,1f);
		
		allCharacters[1] =e1;
		allCharacters[2]=e2;
		allCharacters[0] = p;
		
		boolean isPlaying = true;
		
		while(isPlaying) {
			
			b.drawBoard(allCharacters);
			isPlaying = p.controls(b);
			
			e1.AI(b);
			e2.AI(b);
			
			if(!p.getHasKey()) {
				p.setHasKey(b.pickUpKey(p.getPosX(), p.getPosY()));
			}
		
			boolean win = b.isOnDoor(p.getPosX(), p.getPosY(), p.getHasKey());
			
			if(win) {
				System.out.println("You win!");
				isPlaying = false; 
			}
		}
		

	}

}
