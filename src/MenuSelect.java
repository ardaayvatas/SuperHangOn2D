import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
public class MenuSelect implements ActionListener{
	public static int gamestartornot=0;
	public static int restartornot=0;
	public static int howmanyrestart=0;
	File f = new File("HighScore.txt");
	public void actionPerformed (ActionEvent e) {
		//Quit
		if(e.getActionCommand()=="QUIT") {
			GirisEkrani.quitornot=1;
			System.exit(0);
		}
		
		//Game
		else if(e.getActionCommand()=="Start" && Login.logincheck==1 && gamestartornot==0) {
			System.out.println("Start");
			gamestartornot=1;
			Main.myscreen.backgroundpanel.setVisible(false);
			Main.myscreen.remove(GirisEkrani.backgroundpanel);
			GameStart gs = new GameStart();
			gs.gamestarter();
		}
		else if(e.getActionCommand()=="Start" && Login.logincheck==0) {
			System.err.println("U r not login");
			JOptionPane.showMessageDialog(null, "You have to login first","Login",JOptionPane.WARNING_MESSAGE);
			Login z = new Login();
			z.loginstart();
		}
		else if(e.getActionCommand()=="Pause") {
			System.out.println("Pause");
		}
		else if(e.getActionCommand()=="Restart" && gamestartornot==1) {
			System.out.println("Restart");
			restartornot=1;
			howmanyrestart=howmanyrestart+1;
			GameStart.gamepanel.setVisible(false);
			GameStart.gamepanel.remove(GameStart.gamepanel);
			//Eski hallerine getiriyorum
			GameStart.seconds=60;
			GameStart.speed=0;
			GameStart.skor=0;
			GameStart.roadmove=0;
			GameStart.x=620;
			GameStart.y=500;
			GameStart.metreforsec=0;
			GameStart.checkpoints=0;
			GameStart.enemybikeline=100;
			CalculateTimeandWayScrool.second=0;
			CalculateTimeandWayScrool.realsecond=0;
			for(int j=0;j<GameStart.enemybikespeed.length;j++) {
				GameStart.enemybikespeed[j]=0;
				GameStart.enemybikex[j]=0;
				GameStart.enemybikey[j]=500;
			}
			CalculateTimeandWayScrool.randomx=0;
			CalculateTimeandWayScrool.randomspeed=0;
			CalculateTimeandWayScrool.carpmax=0;
			CalculateTimeandWayScrool.carpmay=0;
			GameStart.writescore=0;
			//yazi karisikligi oluyordu
			GameStart.myscore.setBounds(0, 0, 0, 0);
			GameStart.myspeed.setBounds(0, 0, 0, 0);
			GameStart.mytime.setBounds(0, 0, 0, 0);
			GameStart gsrestart = new GameStart();
			gsrestart.gamestarter();
		}
		
		//User
		else if(e.getActionCommand()=="Register") {
			System.out.println("Register");
			Register x = new Register();
			x.registerstart();
		}
		else if(e.getActionCommand()=="Login") {
			System.out.println("Login");
			Login y = new Login();
			y.loginstart();
		}
		else if(e.getActionCommand()=="High Score" && f.exists()) {
			System.out.println("High Score");
			HighScore hs = new HighScore();
			hs.scoredisplay();
		}
	}
}
