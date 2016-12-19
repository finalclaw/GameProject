package test;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
	public static Music sent;
	public Music[] original;
	public Music[] rival;
	public Music[] jules;
	public Music[] girlfriend;
	public Music[] virt;
	
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
	songs[16] = "Deep Blues";
	songs[17] = "MetalDancer";
	}
	String[] author = new String[5]; {
		author[0] = "Original OST";
		author[1] = "A_Rival";
		author[2] = "Familyjules7x";
		author[3] = "Girlfriend Studios";
		author[4] = "Virt";
	}
	static int songName = 0;
	int authorName = 0;
	int menu = 0;
	@SuppressWarnings("unchecked")
	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		original = new Music[] {
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
				new Music("res/boss_3.ogg"),
				new Music("res/boss_2.ogg"),
		};
		rival = new Music[] {
				new Music("res/zone1_1_1.ogg"),
				new Music("res/zone1_2_1.ogg"),
				new Music("res/zone1_3_1.ogg"),
				new Music("res/zone2_1_1.ogg"),
				new Music("res/zone2_2_1.ogg"),
				new Music("res/zone2_3_1.ogg"),
				new Music("res/zone3_1_1c.ogg"),
				new Music("res/zone3_1_1h.ogg"),
				new Music("res/zone3_2_1c.ogg"),
				new Music("res/zone3_2_1h.ogg"),
				new Music("res/zone3_3_1c.ogg"),
				new Music("res/zone3_3_1h.ogg"),
				new Music("res/zone4_1_1.ogg"),
				new Music("res/zone4_2_1.ogg"),
				new Music("res/zone4_3_1.ogg"),
				new Music("res/lobby_1.ogg"),
				new Music("res/boss_3_1.ogg"),
				new Music("res/boss_2_1.ogg"),
		};
		jules = new Music[] {
				new Music("res/zone1_1_2.ogg"),
				new Music("res/zone1_2_2.ogg"),
				new Music("res/zone1_3_2.ogg"),
				new Music("res/zone2_1_2.ogg"),
				new Music("res/zone2_2_2.ogg"),
				new Music("res/zone2_3_2.ogg"),
				new Music("res/zone3_1_2c.ogg"),
				new Music("res/zone3_1_2h.ogg"),
				new Music("res/zone3_2_2c.ogg"),
				new Music("res/zone3_2_2h.ogg"),
				new Music("res/zone3_3_2c.ogg"),
				new Music("res/zone3_3_2h.ogg"),
				new Music("res/zone4_1_2.ogg"),
				new Music("res/zone4_2_2.ogg"),
				new Music("res/zone4_3_2.ogg"),
				new Music("res/lobby_2.ogg"),
				new Music("res/boss_3_2.ogg"),
				new Music("res/boss_2_2.ogg"),
		};
		girlfriend = new Music[] {
				new Music("res/zone1_1_3.ogg"),
				new Music("res/zone1_2_3.ogg"),
				new Music("res/zone1_3_3.ogg"),
				new Music("res/zone2_1_3.ogg"),
				new Music("res/zone2_2_3.ogg"),
				new Music("res/zone2_3_3.ogg"),
				new Music("res/zone3_1_3c.ogg"),
				new Music("res/zone3_1_3h.ogg"),
				new Music("res/zone3_2_3c.ogg"),
				new Music("res/zone3_2_3h.ogg"),
				new Music("res/zone3_3_3c.ogg"),
				new Music("res/zone3_3_3h.ogg"),
				new Music("res/zone4_1_3.ogg"),
				new Music("res/zone4_2_3.ogg"),
				new Music("res/zone4_3_3.ogg"),
				new Music("res/lobby_3.ogg"),
				new Music("res/boss_3_3.ogg"),
				new Music("res/boss_2_3.ogg"),
		};
		virt = new Music[] {
				new Music("res/zone1_1_4.ogg"),
				new Music("res/zone1_2_4.ogg"),
				new Music("res/zone1_3_4.ogg"),
				new Music("res/zone2_1_4.ogg"),
				new Music("res/zone2_2_4.ogg"),
				new Music("res/zone2_3_4.ogg"),
				new Music("res/zone3_1_4c.ogg"),
				new Music("res/zone3_1_4h.ogg"),
				new Music("res/zone3_2_4c.ogg"),
				new Music("res/zone3_2_4h.ogg"),
				new Music("res/zone3_3_4c.ogg"),
				new Music("res/zone3_3_4h.ogg"),
				new Music("res/zone4_1_4.ogg"),
				new Music("res/zone4_2_4.ogg"),
				new Music("res/zone4_3_4.ogg"),
				new Music("res/lobby_4.ogg"),
				new Music("res/boss_3_4.ogg"),
				new Music("res/boss_2_4.ogg"),
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
			g.drawString("Author: " + author[authorName], 460, 360);
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = gc.getInput();
		if(authorName == 0){
		sent = original[songName];
		}
		if(authorName == 1){
			sent = rival[songName];
			}
		if(authorName == 2){
			sent = jules[songName];
			}
		if(authorName == 3){
			sent = girlfriend[songName];
			}
		if(authorName == 4){
			sent = virt[songName];
			}
		if(input.isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(1);
		}
		if(input.isKeyPressed(Input.KEY_W)) {
			if(menu == 0) {
				menu = 1;
			} else {
				menu --;
			}
		}
		if(input.isKeyPressed(Input.KEY_S)) {
			if(menu == 0) {
				menu = 1;
			} else {
				menu --;
			}
		}
		if(input.isKeyPressed(Input.KEY_A)) {
			if(menu == 0){
				if(songName == 0) {
					songName = 17;
				} else {
					songName --;
				} 
			} else {
				if(authorName == 0) {
					authorName = 4;
				} else {
					authorName --;
				}
			} 
		}
		if(input.isKeyPressed(Input.KEY_D)) {
			if(menu == 0){
				if(songName == 17) {
					songName = 0;
				} else {
					songName ++;
				} 
				
			} else {
				if(authorName == 4) {
					authorName = 0;
				} else {
					authorName ++;
				}
			}
		}
	}
	
	
	public int getID() {
		return 0;
	}
}