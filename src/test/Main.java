package test;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Main extends StateBasedGame{
   
   public static final String gamename = "Necrodancer Demo";
   public static final int menu = 0;
   public static final int play = 1;
   public static final int xSize = 64*19;
   public static final int ySize = 64*12;
   
   public Main(String gamename){
      super(gamename);
      this.addState(new Play());
      this.addState(new Menu());
   }
   
   public void initStatesList(GameContainer gc) throws SlickException{
	  this.getState(menu).init(gc, this);
	  this.enterState(menu);
      this.getState(play).init(gc, this);
      
   }
   
   public static void main(String[] args) {
      AppGameContainer appgc;
      try{
         appgc = new AppGameContainer(new Main(gamename));
         appgc.setDisplayMode(xSize, ySize, false);
         appgc.setTargetFrameRate(60);
         appgc.start();
      }catch(SlickException e){
         e.printStackTrace();
      }
   }
}