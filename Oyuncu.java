package Proje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Oyuncu extends BuzHokey {
	private OyunPanel alan;
	private int y=Oyun.WINDOW_HEIGHT/2;
	private int yhizi=0;
	private int width=15;
	private int height=20;
	Top top=new Top();
	
	public Oyuncu(OyunPanel oyun){
		this.alan=oyun;
		
	}
	public void setHiz(int hiz){
		yhizi=hiz;
		
	}
	public void update(){
	if(top.soldeger>=0 || top.soldeger<=6){
	if(getY()<100){
		yhizi=5;
	}
	else if(getY()>Oyun.WINDOW_HEIGHT-130){
		yhizi=-5;
	}
	y=y+yhizi;
	}
	
	else if(top.soldeger>=6 && top.soldeger<=9){
		y=0;
    	if(getY()<100){
    		yhizi=5;
    	}
    	else if(getY()>Oyun.WINDOW_HEIGHT-130){
    		yhizi=-5;
    	}
    	
    	y=y+yhizi;
	}
	
	}
	
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(Oyun.WINDOW_WIDTH-7-(35-width),y, width, height);
		//g.setColor(Color.YELLOW);
		//g.drawString("Puan "+Integer.toString(top.soldeger), 205, 20);
	}
	
	public int getX(){
		return Oyun.WINDOW_WIDTH-7-(35-width);
	}
	public int getY(){
		return y;
	}
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
}
