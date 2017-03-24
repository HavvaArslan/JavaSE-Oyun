package Proje;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Oyun extends JFrame{
	final static int WINDOW_WIDTH=407;
	final static int WINDOW_HEIGHT=303;
	
	public Oyun(){
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setResizable(false);
		Thread t1=new Thread(new Sesler());
		t1.start();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we)
		{ 
		String ObjButtons[] = {"EVET","HAYIR"};
		int PromptResult = JOptionPane.showOptionDialog(null, 
		    "Çýkmak istediðinize emin misiniz?", "Mesaj", 
		    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
		    ObjButtons,ObjButtons[0]);
		if(PromptResult==1)
		{
		  System.exit(0);          
		  }
		 }
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new OyunPanel());
		setVisible(true);
	
	}
	public static void main(String[] args){
		new Oyun();
	
	}
	

}
