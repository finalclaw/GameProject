package test;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
	private TiledMap map = null;
	Image chara;
	int cX = 256;
	int cY = 256;
	public long timeLastMoved = 0;
	
	public Play() {

	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		map = new TiledMap("res/test.tmx","res");
		chara = new Image("res/chara.png");
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.render(0,0);
		
		g.drawImage(chara,cX,cY);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		long timer = System.currentTimeMillis();
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_W)) {
			if(cY > 0){
				cY = cY - 64;
			}
			timeLastMoved = timer;
		}
		if(input.isKeyPressed(Input.KEY_S)) {
			if(cY < 640 - 64){
				cY = cY + 64;
			}
			timeLastMoved = timer;
		}
		if(input.isKeyPressed(Input.KEY_A)) {
			if(cX > 0){
				cX = cX - 64;
			}
			timeLastMoved = timer;
		}
		if(input.isKeyPressed(Input.KEY_D)) {
			if(cX < 640 - 64){
				cX = cX + 64;
			}
			timeLastMoved = timer;
		}
		
		if(timer - timeLastMoved > 1000){
			System.out.println("took longer than a second");
			timeLastMoved = timer;
		}
		
	}

	public int getID() {
		return 0;
	}
}