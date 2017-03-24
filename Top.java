package Proje;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Top extends BuzHokey {
	private int x=Oyun.WINDOW_WIDTH/2;
	private int y=Oyun.WINDOW_HEIGHT/2;
	
	static int xhizi=-10;
	static int yhizi=10;
	private int r=10;
	int sagdeger=0;
	int soldeger=0;
	int yanýt,yanýt1,yanýt2;
	String detaylar;
	
	
	public void update(){
		x=x+xhizi;
		y=y+yhizi;
		
	
		
		if(x<0){
			xhizi=5;  
		}
		else if(x+r>Oyun.WINDOW_WIDTH-7){
			xhizi=-5;
		}
		if(y<33){
			yhizi=5;
			
		}
		else if(y+r>Oyun.WINDOW_HEIGHT-30){
			yhizi=-5;
		}
		
		if(yanýt==JOptionPane.YES_OPTION){
		  if(soldeger>=3 || soldeger<=6){
			
			if(x<0){
				this.xhizi=5;  
			}
			else if(x+r>Oyun.WINDOW_WIDTH-7){
				this.xhizi=-5;
			}
			if(y<33){
				this.yhizi=5;
				
			}
			else if(y+r>Oyun.WINDOW_HEIGHT-30){
				this.yhizi=-5;
			}			
			}
		  if(soldeger>6 || soldeger==9){
			  if(x<0){
					this.xhizi=8;  
				}
				else if(x+r>Oyun.WINDOW_WIDTH-7){
					this.xhizi=-8;
				}
				if(y<33){
					this.yhizi=8;
					
				}
				else if(y+r>Oyun.WINDOW_HEIGHT-30){
					this.yhizi=-8;
				}
				
		  }
		 /* if(yanýt2==JOptionPane.OK_OPTION){
			  soldeger=0;
			  sagdeger=0;
		  }*/
		
		 
		  
		}
			
			  if(yanýt==JOptionPane.NO_OPTION){
				  if(soldeger>=3 && soldeger<=6){
				if(x<0){
					xhizi=5;  
				}
				else if(x+r>Oyun.WINDOW_WIDTH-7){
					xhizi=-5;
				}
				if(y<33){
					yhizi=5;
					
				}
				else if(y+r>Oyun.WINDOW_HEIGHT-30){
					yhizi=-5;
				}
				soldeger=0;
				sagdeger=0;
				  }
			}
		
		else if (sagdeger>=6){
			 if(yanýt1==JOptionPane.OK_OPTION){
				 
				if(x<0){
					xhizi=5;  
				}
				else if(x+r>Oyun.WINDOW_WIDTH-7){
					xhizi=-5;
				}
				if(y<33){
					yhizi=5;
					
				}
				else if(y+r>Oyun.WINDOW_HEIGHT-30){
					yhizi=-5;
				}
				soldeger=0;
				sagdeger=0;
				 }
			}
			
			
			
		}
		
		/*if((x>0&& x<20) && (y==90)){
			yhizi=-5;
		}
		else if((x>0&& x<20) && (y==200)){
			yhizi=5;
		}
		else if((x>Oyun.WINDOW_WIDTH-30&& x<Oyun.WINDOW_WIDTH) && (y==90)){
			yhizi=-5;
		}
		else if((x>Oyun.WINDOW_WIDTH-30&& x<Oyun.WINDOW_WIDTH) && (y==200)){
			yhizi=5;
		}*/
	
	public void paint(Graphics g){
		g.setColor(Color.PINK);
		g.fillOval(x, y, r, r);
		g.setColor(Color.YELLOW);
		g.drawString("Puan "+Integer.toString(sagdeger), 210, 20);
		g.drawString("Puan "+Integer.toString(soldeger), 150, 20);
		//ImageIcon top=new ImageIcon("ball.gif");
		//JLabel label=new JLabel(top);
		
	}
	private void TersYon(){
		xhizi=-xhizi;
		yhizi=-yhizi;
	}
	public void CarpismaKontrol(BuzHokey player){
		if(this.x>=player.getX() && this.x<=player.getX()+player.getWidth()){
			if(this.y>=player.getY()-player.getHeight() && this.y<=player.getY()+player.getHeight()){
				Sesler.muzikCal();
				TersYon();
			}
		}
		else if(this.y>=player.getY()-player.getHeight() && this.y<=player.getY()+player.getHeight()){
			if(this.x>=player.getX() && this.x<=player.getX()+player.getWidth() && this.x>player.getX()-15){
				Sesler.muzikCal();
				TersYon();
			}
		}
		if(this.getX()<0 &&(this.getY()>100 && this.getY()<190)){
			sagdeger++;
			System.out.println(sagdeger);
			Sesler.muzikCalKayýp();
			if(sagdeger==6){
				 yanýt1=JOptionPane.showConfirmDialog(null, "KAYBETTÝNÝZ!", "Mesaj", -1,0);
			}
			//detaylar=String.format("%d", sagdeger);
			//Oyun.label.setText(detaylar);
		}
		else if(this.getX()>390 && (this.getY()>80 && this.getY()<150)){
			soldeger++;
			System.out.println(soldeger);
			Sesler.muzikCalKayýp();
			if(soldeger==3 || soldeger==6){
				yanýt=JOptionPane.showConfirmDialog(null, "Bir Sonraki Level'a geçtiniz", "Mesaj", 0,1);
			}
			else if(soldeger==9){
				yanýt2=JOptionPane.showConfirmDialog(null, "TEBRÝKLER KAZANDINIZ! :)"," Mesaj", -1,0);
			}
			
		
			
			
		}
		 
		
	}
	public void CarpismaKontrol(Oyuncu player){
		if(this.x+player.getWidth()-5>player.getX() && this.x<player.getX()+player.getWidth()){
			if(this.y>player.getY()-player.getHeight()+10 && this.y<player.getY()+player.getHeight()){
				Sesler.muzikCal();
				TersYon();
			}
		}
		else if(this.y>player.getY()-player.getHeight()+10 && this.y<player.getY()+player.getHeight()){
			if(this.x+player.getWidth()-5>player.getX() && this.x<player.getX()+player.getWidth()){
				Sesler.muzikCal();
				TersYon();
			}
		}
		
		
	}
	
	
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}

}
