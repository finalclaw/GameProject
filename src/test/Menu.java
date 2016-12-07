package test;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	public static Music sent;
	public Music[] music;
	
	public Menu() {

	}
	
	UnicodeFont Necro;
	String[] songs = new String[18]; {
	songs[0] = "Zone 1_1";
	songs[1] = "Zone 1_2";
	songs[2] = "Zone 1_3";
	songs[3] = "Zone 2_1";
	songs[4] = "Zone 2_2";
	songs[5] = "Zone 2_3";
	songs[6] = "Zone 3_1 cold";
	songs[7] = "Zone 3_1 hot";
	songs[8] = "Zone 3_2 cold";
	songs[9] = "Zone 3_2 hot";
	songs[10] = "Zone 3_3 cold";
	songs[11] = "Zone 3_3 hot";
	songs[12] = "Zone 4_1";
	songs[13] = "Zone 4_2";
	songs[14] = "Zone 4_3";
	songs[15] = "Lobby";
	songs[16] = "Metalmancer";
	songs[17] = "Deep Blues";
	}
	static int songName = 0;
	int authorName = 0;
	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		music = new Music[] {
				new Music("res/zone1_1.ogg"),
				new Music("res/zone1_2.ogg"),
				new Music("res/zone1_3.ogg"),
				new Music("res/zone2_1.ogg"),
				new Music("res/zone2_2.ogg"),
				new Music("res/zone2_3.ogg"),
				new Music("res/zone3_1c.ogg"),
				new Music("res/zone3_1h.ogg"),
				new Music("res/zone3_2c.ogg"),
				new Music("res/zone3_2h.ogg"),
				new Music("res/zone3_3c.ogg"),
				new Music("res/zone3_3h.ogg"),
				new Music("res/zone4_1.ogg"),
				new Music("res/zone4_2.ogg"),
				new Music("res/zone4_3.ogg"),
				new Music("res/lobby.ogg"),
				new Music("res/boss_2.ogg"),
				new Music("res/boss_3.ogg"),
		};
		
		String fontPath = "res/Necro.ttf";
		Necro = new UnicodeFont(fontPath, 48, true, false);
		Necro.addAsciiGlyphs();
		Necro.addGlyphs(400, 600);
		Necro.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
		Necro.loadGlyphs();
		
	}

	public static Music getSong(){
		return sent;
	}
	
	public static int getBeats(){
		return songName;
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
			g.setFont(Necro);
			g.drawString("Song: " + songs[songName], 460, 260);
			g.drawString("Author: " + "Null", 460, 360);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		sent = music[songName];
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(1);
		}
		if(input.isKeyPressed(Input.KEY_W)) {
			
		}
		if(input.isKeyPressed(Input.KEY_S)) {
			
		}
		if(input.isKeyPressed(Input.KEY_A)) {
			if(songName == 0) {
				songName = 17;
			} else {
				songName --;
			}
		}
		if(input.isKeyPressed(Input.KEY_D)) {
			if(songName == 17) {
				songName = 0;
			} else {
				songName ++;
			}
		}
	}
	
	
	public int getID() {
		return 0;
	}
}