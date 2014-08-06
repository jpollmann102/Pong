import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Pong extends BasicGame {
	
	static final int screenX = 750;
	static final int screenY = 500;
	
	Component player = new Component("player", 200, 20, screenX - 50, screenY / 4, 5.0);
	Component ball = new Component("ball", 15, 15, screenX / 2, screenY / 2, 2.0);
	
	Component component;
	
	public Pong(String title) {
		super(title);
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.fillRect((float) player.getXPos(), player.getYPos(), player.getWidth(), player.getHeight());
		g.fillRect((float) ball.getXPos(), ball.getYPos(), ball.getWidth(), ball.getHeight());
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		player.move(gc);
		ball.moveBall(player, gc);

	}

	public static void main(String[] args){
		try{
			AppGameContainer app = new AppGameContainer(new Pong("Pong"));
			app.setDisplayMode(screenX, screenY, false);
			app.setTargetFrameRate(60);
			app.start();
		}catch(SlickException e){
			System.out.println(e);
		}
	}
}
