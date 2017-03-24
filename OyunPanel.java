package Proje;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OyunPanel extends JPanel implements ActionListener,KeyListener{
	BuzHokey hokey=new BuzHokey();
	Top top=new Top();
	Oyuncu oyuncu=new Oyuncu(this);
	
	public OyunPanel(){
		Timer zaman=new Timer(40,this);
		zaman.start();
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}

	public void update(){
	hokey.update();
	top.update();
	oyuncu.update();
	
	top.CarpismaKontrol(hokey);
	top.CarpismaKontrol(oyuncu);
}
public void paintComponent(Graphics g){
	g.setColor(Color.GRAY);
	g.fillRect(0, 0, Oyun.WINDOW_WIDTH, Oyun.WINDOW_HEIGHT);
	hokey.paint(g);
	top.paint(g);
	oyuncu.paint(g);
	
	g.setColor(Color.WHITE);
	g.drawLine(0, 30, Oyun.WINDOW_WIDTH, 30);
	g.drawLine(Oyun.WINDOW_WIDTH/2, 30, Oyun.WINDOW_WIDTH/2, Oyun.WINDOW_HEIGHT);
	g.drawOval(Oyun.WINDOW_WIDTH/2-25, Oyun.WINDOW_HEIGHT/2-25,50 ,50 );
	g.drawLine(0, 90, 20, 90);
	g.drawLine(0, 200, 20, 200);
	g.drawLine(Oyun.WINDOW_WIDTH-30, 90, Oyun.WINDOW_WIDTH, 90);
	g.drawLine(Oyun.WINDOW_WIDTH-30, 200, Oyun.WINDOW_WIDTH, 200);
	g.drawRect(140, 5, 60, 20);
	g.drawRect(205, 5, 60, 20);
	
	
	
	
}

public void actionPerformed(ActionEvent e){
	update();
	repaint();
}
public void keyPressed(KeyEvent e){
	
	if(e.getKeyCode()==KeyEvent.VK_UP){
		hokey.setHiz(-5);
	}
	
	else if(e.getKeyCode()==KeyEvent.VK_DOWN ){
		if(top.soldeger>=0 && top.soldeger<3){
		hokey.setHiz(5);
		oyuncu.setHiz(5);
		}
		else if(top.soldeger>=6 && top.soldeger<=9){
			hokey.setHiz(5);
			oyuncu.setHiz(0);
		}
		if((top.soldeger>=3 || top.soldeger<6 )&& top.yanýt==JOptionPane.YES_OPTION){
			hokey.setHiz(5);
			//oyuncu.setHiz(-5);
		}
		if(top.yanýt==JOptionPane.NO_OPTION){
			hokey.setHiz(0);
			oyuncu.setHiz(0);
			top.xhizi=0;
			top.yhizi=0;
			
		}
		
	}
	if(top.soldeger>6 || top.soldeger<=9){
		if(e.getKeyCode()==KeyEvent.VK_UP){
			hokey.setHiz(-5);
		}
		if(e.getKeyCode()==KeyEvent.VK_S){
			oyuncu.setHiz(5);
		}
		else if(e.getKeyCode()==KeyEvent.VK_DOWN){
			hokey.setHiz(5);
		}
		else if(e.getKeyCode()==KeyEvent.VK_W){
			oyuncu.setHiz(-5);
		}
		
	}
	
}

public void keyReleased(KeyEvent e){
	int keyCode=e.getKeyCode();
	if((keyCode==KeyEvent.VK_UP || keyCode==KeyEvent.VK_DOWN )){
		hokey.setHiz(0);
		//oyuncu.setHiz(0);
	}
	if(top.soldeger>6 || top.soldeger<=9){
		if(keyCode==KeyEvent.VK_S || keyCode==KeyEvent.VK_W){
			oyuncu.setHiz(0);
		}
	}

}

public void keyTyped(KeyEvent e){
	
}



}
