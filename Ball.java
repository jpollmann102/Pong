
public class Ball {

	private int myHeight, myWidth, myXPos, myYPos;
	private double mySpeed;
	private Paddles myPaddle;
	private Paddles myPaddle1;
	
	int dx = 1;
	int dy = 1;
	
	static final int screenY = 500;
	static final int screenX = 750;
	
	public Ball(int height, int width, int xPos, int yPos, double speed, Paddles paddle, Paddles paddle1) {
		myHeight = height;
		myWidth = width;
		myXPos = xPos;
		myYPos = yPos;
		mySpeed = speed;
		myPaddle = paddle;
		myPaddle1 = paddle1;
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
	
	// updates the balls coordinates
	public void moveBall(){		
		isCollidedWithWall();
		isCollidedWithPaddle();
		myXPos += dx * mySpeed;
		myYPos -= dy * mySpeed;
	}
	
	// checks if the ball is collided with a wall
	public void isCollidedWithWall(){
		if(myYPos <= 0 || myYPos >= screenY){
			dy *= -1;
			//mySpeed += .3;
		}
	}
	
	// checks if the ball is collided with a paddle
	public boolean isCollidedWithPaddle(){
		if(myXPos == 699 && myYPos >= myPaddle.getYPos() && myYPos <= myPaddle.getYPos() + 200){
			dx *= -1;
			//mySpeed += .3;
			return true;
		} else if(myXPos == 42 && myYPos + myHeight >= myPaddle1.getYPos() && myYPos + myHeight <= myPaddle1.getYPos() + 200){ 
			dx *= -1;
			//mySpeed += .3;
			return true;
		} else{
			return false;
		}
	}
	
	// checks if the ball is still in play
	public boolean isInBounds(){
		if(myXPos < 0 || myXPos > screenX){
			return false;
		} else{
			return true;
		}
	}
	
	// resets the ball
	public void resetBall(){
		myYPos = screenY / 2;
		myXPos = screenX / 2;
		mySpeed = 3.0;
	}
}
