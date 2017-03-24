package Proje;

import java.awt.Color;
import java.awt.Graphics;

public class BuzHokey  {
	private int y=Oyun.WINDOW_HEIGHT/2;
	private int yhizi=0;
	private int width=15;
	private int height=20;
	
	
	public BuzHokey(){
		
	}
	public void update(){
	
		y=y+yhizi;
		if(y<95){
			y=y+5;
		}
		else if(y>Oyun.WINDOW_HEIGHT-125){
			y=y-5;
		}
	}
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.fillRect(5,y, width, height);
	}
	public void setHiz(int hiz){
		yhizi=hiz;
		
	}
	public int getX(){
		return 10;
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
