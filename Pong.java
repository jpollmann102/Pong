import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Pong extends BasicGame {
	
	static final int screenX = 750;
	static final int screenY = 500;
	
	Paddles player = new Paddles(200, 20, screenX - 50, screenY / 4, 2.0);
	Paddles comp = new Paddles(200, 20, 30, screenY / 4, 2.0);
	Ball ball = new Ball(15, 15, screenX / 2, screenY / 2, 3.0, player, comp);
	
	Paddles component;
	
	static int human = 0;
	static int computer = 0;
	
	public Pong(String title) {
		super(title);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.fillRect((float) player.getXPos(), player.getYPos(), player.getWidth(), player.getHeight());
		g.fillRect((float) ball.getXPos(), ball.getYPos(), ball.getWidth(), ball.getHeight());
		g.fillRect((float) comp.getXPos(), comp.getYPos(), comp.getWidth(), comp.getHeight());
		g.drawString("Player: " + human, 260, 25);
		g.drawString("Computer: " + computer, 360, 25);
		if(human >= 10){
			g.drawString("You win!", screenX / 2, screenY / 2);
		} else if(computer >= 10){
			g.drawString("You lose :(", screenX / 2, screenY / 2);
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		
		player.move(gc);
		comp.moveComp(ball);
		ball.moveBall();
		if(!ball.isInBounds()){
			player.resetPlayer();
			comp.resetComp();
			ball.resetBall();
		}
		if(ball.getXPos() <= 0){
			human++;
		} else if(ball.getXPos() >= screenX){
			computer++;
		}
	}

	public static void main(String[] args){
		try{
			AppGameContainer app = new AppGameContainer(new Pong("Pong"));
			app.setDisplayMode(screenX, screenY, false);
			app.setTargetFrameRate(60);
			app.setShowFPS(false);
			app.start();
		}catch(SlickException e){
			System.out.println(e);
		}
	}
}
