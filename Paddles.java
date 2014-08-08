import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;


public class Paddles {

	static final int screenX = 750;
	static final int screenY = 500;
	
	static int dx = 1;
	static int dy = 1;
	
	private int myHeight;
	private int myWidth;
	private int myYPos;
	
	private double myXPos;
	private double mySpeed;
	
	public Paddles(int height, int width, int xPos, int yPos, double speed){
		myHeight = height;
		myWidth = width;
		myXPos = xPos;
		myYPos = yPos;
		mySpeed = speed;
	}
	
	public Paddles(){
		
	}

	public int getHeight(){
		return myHeight;
	}
	
	public int getWidth(){
		return myWidth;
	}
	
	public double getXPos(){
		return myXPos;
	}
	
	public int getYPos(){
		return myYPos;
	}
	
	public double getSpeed(){
		return mySpeed;
	}
	
	// moves the player's paddle
	public void move(GameContainer gc){
		Input input = gc.getInput();		
		
		if(myXPos >= 0 && myYPos <= 300){
			if(input.isKeyDown(Input.KEY_DOWN)){
				myYPos += mySpeed;
			} else if(input.isKeyDown(Input.KEY_UP)){
				myYPos -= mySpeed;
			}
		}
		if(myYPos < 0){
			myYPos = 0;
		} else if(myYPos > 300){
			myYPos = 300;
		}
	}
	
	// moves the computer's paddle
	public void moveComp(Ball ball){
		if(myYPos <= 0){
			myYPos = 1;
		} else if(myYPos >= 300){
			myYPos = 299;
		}
		if(ball.getYPos() < myYPos + 100){
			myYPos -= mySpeed;
        } else if(ball.getYPos() > myYPos){
            myYPos += mySpeed; 
        }
        
	}
	
	// resets the player paddle
	public void resetPlayer(){
		myYPos = screenY / 4;
		myXPos = screenX - 50;
	}
	
	// resets the computer paddle
	public void resetComp(){
		myYPos = screenY / 4;
		myXPos = 30;
	}
	
	//&& myYPos >= 1
	//&& myYPos + myHeight <= screenY + 10
}
