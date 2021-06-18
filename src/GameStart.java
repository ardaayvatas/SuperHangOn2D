import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStart extends JLabel implements KeyListener{
	static JPanel gamepanel;
	CalculateTimeandWayScrool ct = new CalculateTimeandWayScrool();
	JLabel myway;
	public static int checkpoints=0;
	public static int metreforsec=0;
	public static int x = 620;
	public static int y = 500;
	public static int seconds=60;
	public static int speed=0;
	public static int skor=0;
	static GameStart myscore;
	static GameStart myspeed;
	static GameStart mytime;
	static GameStart mymotor;
	static GameStart enemybike;
	public static int roadmove=0;
	public static int enemybikeline=100;
	public static int writescore=0;
	public static int[] enemybikex = {0,0,0,0,0,0,0};//yeni
	public static int[] enemybikespeed = {0,0,0,0,0,0,0};//yeni
	public static int[] enemybikey = {500,500,500,500,500,500,500};//yeni
	static ArrayList<GameStart> forallenemybike = new ArrayList<GameStart>();
	public GameStart() {
		setVisible(true);
		setLayout(null);
		//setOpaque(true);
		//setBackground(Color.BLACK);
		setBounds(x, y, 60, 150);
		addKeyListener(this);
	}
	
	public void gamestarter() {
		gamepanel = new JPanel();
		//enemybikes		
		for(int i=0;i<7;i++) {
			enemybike = new GameStart();
			ImageIcon enemiesbikes = new ImageIcon("enemybikes.png");
			enemybike.setIcon(enemiesbikes);
			forallenemybike.add(enemybike);
			forallenemybike.get(i).setBounds(x+enemybikeline,y,60,150);
			gamepanel.add(forallenemybike.get(i));
			enemybikex[i]=x+enemybikeline;
			//siralari ayarliyorum
			if(i==2) {
				enemybikeline=-80;
			}
			else if(i>2) {
				enemybikeline=enemybikeline-80;
			}
			else if(i<2){
				enemybikeline=enemybikeline+100;
			}
		}
		
		mymotor = new GameStart();
		ImageIcon mybike = new ImageIcon("mybike.png");
		mymotor.setIcon(mybike);
		gamepanel.add(mymotor);
		Main.myscreen.addKeyListener(mymotor);
		gamepanel.setLayout(null);
		gamepanel.setBounds(0,-50,1280,720);
		ImageIcon newimg = new ImageIcon("mymap.png");
		myway = new JLabel ("",newimg,JLabel.CENTER);
		myway.setSize(1280,720);
		gamepanel.add(myway, BorderLayout.CENTER);
		gamepanel.setPreferredSize(new Dimension(1280, 720));
		
		//score
		myscore = new GameStart();
		myscore.setText("SCORE:"+skor);
		myscore.setBounds(1150,20,100,30);
		Main.myscreen.add(myscore);
		
		//speed
		myspeed = new GameStart();
		myspeed.setText("SPEED:"+speed);
		myspeed.setBounds(1150,50,100,30);
		Main.myscreen.add(myspeed);
		
		//time
		mytime = new GameStart();
		mytime.setText("TIME:"+seconds);
		mytime.setBounds(1150,80,100,30);
		Main.myscreen.add(mytime);
		
		
		//panele herseyi ekliyorum
		Main.myscreen.add(gamepanel);
		Main.myscreen.setVisible(true);
		System.out.println("username:"+Login.namecontrol);
		ct.start();
	}
	@Override
	public void keyPressed(KeyEvent ev) {
		
		if (ev.getKeyCode() == KeyEvent.VK_UP) {
			BikeVoice bv=new BikeVoice();
			bv.setFile("mybikevoice.wav");
			bv.soundefectplay();
			if(speed!=250) {
				speed=speed+5;
			}
				
		}
		if (ev.getKeyCode() == KeyEvent.VK_LEFT && speed!=0) {
			x=x-10;
			setLocation(x, y);
			//Kenarlara cikarsa
			if(x<275){
			System.out.println("Yolun disina ciktin");
			setLocation(620, 500);
			//x y eski haline guncelliyorum
			x=620;
			y=500;
			speed=0;
			}
		}
		if (ev.getKeyCode() == KeyEvent.VK_DOWN) {
			//setLocation(x, ++y);
			if(speed!=0) {
				speed=speed-5;
			}
		}
		if (ev.getKeyCode() == KeyEvent.VK_RIGHT && speed!=0) {
			x=x+10;
			setLocation(x, y);
			//Kenarlara cikarsa
			if(x>950) {
				System.out.println("Yolun disina ciktin");
				setLocation(620, 500);
				//x y eski haline guncelliyorum
				x=620;
				y=500;
				speed=0;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
