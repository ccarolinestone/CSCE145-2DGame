
public class Character {
	
 private char displayChar;
 private int posX, posY;
 
 //default constructor for empty characters
 public Character() {
	displayChar = 'd';
	posX = 0;
	posY= 0;
 }
 
 //TODO: needs a draw method to override in the player and enemy
 
 //parameterized constructor
 public Character(char displayChar, int posX, int posY) {
	//class variable set equal to parameter values
	this.displayChar = displayChar;
	this.posX = posX;
	this.posY = posY;
 }
 
 
 //getter for displayChar
 public char getDisplayChar() {
	 return displayChar;
 }


//getter for posX
public int getPosX() {
	return posX;
}

//setter for posX
public void setPosX(int posX) {
	if(posX>=0) {
		this.posX = posX;
	}
}


//getter for posY
public int getPosY() {
	return posY;
}


//setter for posY
public void setPosY(int posY) {
	if(posY >= 0) {
		this.posY = posY;
	}
}


//setter for displayChar
public void setDisplayChar(char displayChar) {
	this.displayChar = displayChar;
}
}


//protected for a method means that only children of the class can access it 
