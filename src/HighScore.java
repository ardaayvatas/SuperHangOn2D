import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HighScore {
	File dosyascore = new File ("HighScore.txt");
	Scanner sc=new Scanner(System.in);
	String scorenamecontrol;
	int scorecontrol;
	int max=0;
	String maxscorename;
	public void scorewriter() {
		try {
			FileWriter myscorewriter = new FileWriter ("HighScore.txt",true);
			PrintWriter forscorewriter = new PrintWriter(myscorewriter);
			forscorewriter.println(Login.namecontrol);
			forscorewriter.println(GameStart.skor);
			myscorewriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void scoredisplay() {
		Scanner scforscorefile;
		try {
			scforscorefile = new Scanner(dosyascore);
			while(scforscorefile.hasNext()) {
				scorenamecontrol=scforscorefile.next();
				scorecontrol=scforscorefile.nextInt();
				if(max<scorecontrol) {
					max=scorecontrol;
					maxscorename=scorenamecontrol;
				}
			}
			if(max>0) {
				JOptionPane.showMessageDialog(null, "1."+maxscorename+"->"+max+"\n"+"Your score is ->"+GameStart.skor,"SCOREBOARD",JOptionPane.INFORMATION_MESSAGE);
			}
			else if(max==0) {
				JOptionPane.showMessageDialog(null, "Scorbard is empty!","SCOREBOARD",JOptionPane.WARNING_MESSAGE);
			}
			scforscorefile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
