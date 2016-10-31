package test;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState {
	private TiledMap map = null;
	Image chara;
	Image green;
	int cX = 256;
	int cY = 256;
	private Music music;
	long timet;
	public boolean timerr = true;
	public boolean test = true;
	long stime = System.nanoTime();
	long ctime;
	long otime = System.nanoTime() - stime;
	double btime;
	boolean inputt;
	boolean itest;
	int itime;
	double x = 1;
	boolean testt = false;
	int l = 3;
	boolean lives = true;


	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		map = new TiledMap("res/test.tmx","res");
		chara = new Image("res/chara.png");
		music = new Music("res/test.wav");
		green = new Image("res/ha.png");
	}


	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
		map.render(0,0);
		if (testt){
			g.drawImage(green,cX,cY);
		} else {
		g.drawImage(chara,cX,cY);
		}
		if (l == 3) {
			g.drawImage(green, 200, 400);
		}
		if (l >= 2) {
			g.drawImage(green, 300, 400);
		}
		if (l >= 1) {
			g.drawImage(green, 400, 400);
		}
		if(ctime > 2){
			if(timerr){
				timerr = false;
			}
			timer(g);
		}
	}
	public void timer(Graphics g){
		g.drawString("Beats : " +(int) btime, 100, 100);
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		otime = (long) System.nanoTime() - stime;
		ctime = (long) ((System.nanoTime() - stime)/1000000000.0);
		timet = (long) (70000000 + otime);
		btime = (timet/((60000.0/130.425)*1000000.0))-6.0;
		itime = (int) btime;
		if (l==-1){
			gc.exit();
		}
		System.out.println(inputt);
		if(ctime > 2.0){
			if(test){
			music.loop();
			}
			test = false;
			if(btime > 1){
			if(btime <= x+.22 && btime >= x-.22){
				inputt = true;
				testt = true;
				
				}
			else {
				inputt = false;
				if (testt) {
					x = (int) btime + 1;
					testt= false;
					itest=true;
					if (!lives) {
						l = l - 1;
					}
					lives = false;
				}
				
				
			}
			
			}
			System.out.println(x + ":  x");
			System.out.println(btime + ":  btime");
			//System.out.println(l);
		}
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_W)&&inputt&&itest) {
			if(cY > 0){
				cY = cY - 64;
				testt = false;
				lives = true;
			}

		}
		if(input.isKeyPressed(Input.KEY_S)&&inputt&&itest) {
			if(cY < 640 - 64){
				cY = cY + 64;
				testt = false;
				lives = true;
			}

		}
		if(input.isKeyPressed(Input.KEY_A)&&inputt&&itest) {
			if(cX > 0){
				cX = cX - 64;
				testt = false;
				lives = true;
			}

		}
		if(input.isKeyPressed(Input.KEY_D)&&inputt&&itest) {
			if(cX < 640 - 64){
				cX = cX + 64;
				testt = false;
				lives = true;
			}

		}

		
	}

	public int getID() {
		return 0;
	}
}