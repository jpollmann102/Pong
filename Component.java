import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;



public class Component {

	static final int screenX = 750;
	static final int screenY = 500;
	
	private int myHeight;
	private int myWidth;
	private int myYPos;
	
	private double myXPos;
	private double mySpeed;
	
	String myName;
	
	public Component(String name, int height, int width, double xPos, int yPos, double speed){
		myName = name;
		myHeight = height;
		myWidth = width;
		myXPos = xPos;
		myYPos = yPos;
		mySpeed = speed;
	}
	
	public Component(){
		
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
	
	public boolean isMovingUp(GameContainer gc){
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_UP)){
			return true;
		} else{
			return false;
		}
	}
	
	public boolean isMovingDown(GameContainer gc){
		Input input = gc.getInput();
		
		if(input.isKeyDown(Input.KEY_DOWN)){
			return true;
		} else{
			return false;
		}
	}
	
	public void move( GameContainer gc){
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
	
	public void moveBall(Component player, GameContainer gc){
		Input input = gc.getInput();
		
		boolean done = false;
		boolean playing = true;
		
		//problem code
		while(playing){
			if(!done){
				myXPos += mySpeed;
				done = true;
			}
			if(myXPos + 15 > player.getXPos() && myXPos + 15 < player.getXPos() + 200){
				if(player.isMovingUp(gc)){
					myXPos -= mySpeed;
					myYPos -= mySpeed;
				} else if(player.isMovingDown(gc)){
					myXPos -= mySpeed;
					myYPos += mySpeed;
				}
			}
			if(myYPos == 0){
				myXPos -= mySpeed;
				myYPos += mySpeed;
			} else if(myYPos == screenY){
				myXPos -= mySpeed;
				myYPos -= mySpeed;
			}
			if(myXPos == -5 || myXPos == 505){
				playing = false;
			}
		}
	}
}
