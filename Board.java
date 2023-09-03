
public class Board {
	
	private static int DEFAULT_BOARD_SIZE = 10;
	private static int DEFAULT_KEY_POS=1;
	private static int DEFAULT_DOOR_POS = 8;
	
	private char[][] gameBoard;
	private int keyPosX, keyPosY;
	private int doorPosX, doorPosY;
	
	
	//static - only one instance created of it 
	
	public Board() {
		gameBoard = new char[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
		initBoard(DEFAULT_BOARD_SIZE, DEFAULT_BOARD_SIZE);
		keyPosX = DEFAULT_KEY_POS;
		keyPosY=DEFAULT_KEY_POS;
		doorPosX = DEFAULT_DOOR_POS;
		doorPosY= DEFAULT_DOOR_POS;
	}
	
	
	public Board(int sizeX, int sizeY, int keyPosX, int keyPosY, int doorPosX, int doorPosY) {
		//[(size y) how many arrays][(size x)what size are those arrays]
		gameBoard = new char[sizeY][sizeX];
		this.keyPosX = keyPosX;
		this.keyPosY = keyPosY;
		this.doorPosY = doorPosY;
		this.doorPosX = doorPosX;
		initBoard(sizeX, sizeY);
		
	}
	
	
	//this method is only called in this class so set to private
	private void initBoard(int sizeX, int sizeY) {
		for(int i=0; i<sizeY; i++) {
			for(int j=0; j<sizeX; j++) {
				
				//top and bottom pounds (1st and 2nd i), side pounds (1st and 2nd j)
				if(i== 0 || i == sizeY-1 || j==0 || j==sizeX-1) {
					gameBoard[i][j] = '#';
				}
				
				else if(i==keyPosY && j == keyPosX) {
					gameBoard[i][j] = 'k';
				}
				
				else if(i==doorPosY && j ==doorPosX) {
					gameBoard[i][j] = 'd';
				}
				
				else {
				gameBoard[i][j] = '.';
				}
			}
		}
	}
	
	
	
	public boolean pickUpKey(int playerX, int playerY) {
		
		if(playerX == keyPosX && playerY == keyPosY) {
			
			gameBoard[playerY][playerY] = '.';
			return true;
		}
		else {
			return false; 
		}
	}
	
	public boolean isOnDoor(int playerX, int playerY, boolean hasKey) {
		
		if(playerX==doorPosX && playerY==doorPosY && hasKey) {
			return true;
		}
		
		else {
			return false; 
		}
	}
	
	public void drawBoard(Character[] allCharacters) {
		
		//this is being assigned to the same memory address as gameBoard - they are the same and pointing to the same place 
		//char[][] copyGameBoard = gameBoard;
		
		
		//to actually make a copy of gameBoard (these have different memory addresses)
		char[][] copyGameBoard = new char[gameBoard.length][gameBoard[0].length];
		
		for(int i=0; i<gameBoard.length; i++) {
			for(int j=0; j<gameBoard[i].length; j++) {
				copyGameBoard[i][j] = gameBoard[i][j];
			}
		}
		
		//THIS FOR-LOOP IS THE SAME AS THE FOR-EACH LOOP BELOW
			//use this for-loop for modifying purposes
			//for(int i=0; i<allCharacters.length; i++) {
			
				//saved current character into variable "c"
				//Character c = allCharacters[i];
			
				//getting players position 
				//copyGameBoard[c.getPosY()][c.getPosX()] = c.getDisplayChar();
		//	}
		
		
		//use if only care about pulling data out - for each loop
		//for-each loop, specialized for-loop, can be used when do not care about position of array (this loop does not keep track of index)
		//c is set equal to first item of array and runs, then set equal to second item and runs...
		for(Character c : allCharacters) {
			copyGameBoard[c.getPosY()][c.getPosX()] = c.getDisplayChar();
		}
		
		
		for(int i = 0; i< copyGameBoard.length; i++) {
			for(int j=0; j<copyGameBoard[i].length; j++) {
				System.out.print(copyGameBoard[i][j]);
			}
			
			System.out.println();
		}
		
	}


	public static int getDEFAULT_BOARD_SIZE() {
		return DEFAULT_BOARD_SIZE;
	}


	public static void setDEFAULT_BOARD_SIZE(int dEFAULT_BOARD_SIZE) {
		DEFAULT_BOARD_SIZE = dEFAULT_BOARD_SIZE;
	}


	public char[][] getGameBoard() {
		return gameBoard;
	}


	public void setGameBoard(char[][] gameBoard) {
		this.gameBoard = gameBoard;
	}


	

}
