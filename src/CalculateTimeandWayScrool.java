import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class CalculateTimeandWayScrool {
	static int randomspeed=0;
	static int randomx=0;
	static int second=0;
	static int realsecond=0;
	static int carpmax=0;
	static int carpmay=0;
	Timer myTimer = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
			second++;
			if(second%4==0 && MenuSelect.restartornot==0) {
				GameStart.metreforsec=GameStart.speed+GameStart.metreforsec;
				realsecond=realsecond+1;
				//System.out.println(realsecond);
				//System.out.println(GameStart.metreforsec);
				//250 uzerinden gelecek sekilde
				for(int k=0;k<7;k++) {
					Random randomnum= new Random();
					randomspeed=randomnum.nextInt(50);
					randomspeed=(randomspeed+1)*5;
					GameStart.enemybikespeed[k]=randomspeed;
					if(GameStart.checkpoints>=2) {
						GameStart.enemybikespeed[k]=240;
					}
					randomx=randomnum.nextInt(2);
					randomx=randomx+1;
					if(randomx==1 && GameStart.enemybikex[k]<900) {
						GameStart.enemybikex[k]=GameStart.enemybikex[k]+(randomx*5);//sag
					}
					else if(randomx==2 && GameStart.enemybikex[k]>320) {
						GameStart.enemybikex[k]=GameStart.enemybikex[k]-(randomx*5);//sol
					}
				}
			}
			
			else if(second%(3*(MenuSelect.howmanyrestart+1))==0 && MenuSelect.restartornot==1) {
				GameStart.metreforsec=GameStart.speed+GameStart.metreforsec;
				realsecond=realsecond+1;
				//System.out.println(realsecond);
				//System.out.println(GameStart.metreforsec);
				//250 uzerinden gelecek sekilde
				for(int k=0;k<7;k++) {
					Random randomnum= new Random();
					randomspeed=randomnum.nextInt(50);
					randomspeed=(randomspeed+1)*5;
					GameStart.enemybikespeed[k]=randomspeed;
					if(GameStart.checkpoints>=2) {
						GameStart.enemybikespeed[k]=240;
					}
					randomx=randomnum.nextInt(2);
					randomx=randomx+1;
					if(randomx==1 && GameStart.enemybikex[k]<900) {
						GameStart.enemybikex[k]=GameStart.enemybikex[k]+(randomx*5);//sag
					}
					else if(randomx==2 && GameStart.enemybikex[k]>320) {
						GameStart.enemybikex[k]=GameStart.enemybikex[k]-(randomx*5);//sol
					}
				}
			}
			
			for(int k=0;k<7;k++) {
				if(GameStart.enemybikespeed[k]>GameStart.speed) {
					GameStart.enemybikey[k]=GameStart.enemybikey[k]-20;
					GameStart.forallenemybike.get(k).setLocation(GameStart.enemybikex[k], GameStart.enemybikey[k]);
				}
				else {
					GameStart.enemybikey[k]=GameStart.enemybikey[k]+20;
					GameStart.forallenemybike.get(k).setLocation(GameStart.enemybikex[k], GameStart.enemybikey[k]);
				}
			}
			
			//carpma
			for(int k=0;k<7;k++) {
				carpmax=GameStart.enemybikex[k]-GameStart.x;
				carpmay=GameStart.enemybikey[k]-GameStart.y;
				if(carpmax<0) {
					carpmax=carpmax*(-1);
				}
				if(carpmay<0) {
					carpmay=carpmay*(-1);
				}
				if(carpmax<50 && carpmay<50) {
					GameStart.x=620;
					GameStart.y=500;
					GameStart.metreforsec=0;
					GameStart.speed=0;
					for(int a=0;a<7;a++) {
						GameStart.enemybikey[a]=GameStart.enemybikey[a]-400;
					}
				}
			}
			
			if(realsecond>=60 && GameStart.metreforsec<8000) {
				System.out.println("Elendin");
				JOptionPane.showMessageDialog(null, "GAME OVER!","HANG ON",JOptionPane.WARNING_MESSAGE);
				realsecond=60;
				GameStart.speed=0;
				GameStart.skor=0;
				myTimer.cancel();
				myTimer.purge();
				return;//Elenirse skor yazmiyorum
			}
			else if(realsecond<60 && GameStart.metreforsec>8000 && GameStart.checkpoints!=4) {
				GameStart.checkpoints=GameStart.checkpoints+1;
				System.out.println("CheckPoint "+GameStart.checkpoints+"e ulasildi");
				GameStart.metreforsec=0;
				if(GameStart.checkpoints!=4) {
					GameStart.seconds=60;
					realsecond=0;
				}
				else
					GameStart.seconds=60-(realsecond+1);//Checkpoint 4 e gelince Zamani bir eksik yaziyordu
			}
			
			if(GameStart.checkpoints==4) {
				System.out.println("oyun bitti");
				// Timei korumak için
				GameStart.writescore=1;
				HighScore hsw = new HighScore();
				hsw.scorewriter();
				realsecond=0; 
				GameStart.speed=0;
				myTimer.cancel();
				myTimer.purge();
				return;
				//Score yazip cikiyorum
			}
			
			GameStart.skor=GameStart.skor+(GameStart.speed/(MenuSelect.howmanyrestart+1));
			GameStart.myscore.setText("SCORE:"+GameStart.skor);
			GameStart.myspeed.setText("SPEED:"+GameStart.speed);
			GameStart.mytime.setText("TIME:"+(GameStart.seconds-realsecond));
			if(GameStart.roadmove==0 && GameStart.speed>0 && MenuSelect.restartornot==0) {
				GameStart.y=500;
				GameStart.mymotor.setLocation(GameStart.x,GameStart.y);
				GameStart.gamepanel.setBounds(0,-50, 1280, 720);//yol hareketleri
				GameStart.roadmove=1;
			}
			else if((GameStart.roadmove==1 && GameStart.speed>0 && MenuSelect.restartornot==0)) {
				GameStart.y=450;
				GameStart.mymotor.setLocation(GameStart.x,GameStart.y);
				GameStart.gamepanel.setBounds(0,0, 1280, 720);//yol hareketleri
				GameStart.roadmove=0;
			}
			//RESTART icin 
			else if(second%(1*(MenuSelect.howmanyrestart+1))==0 && MenuSelect.restartornot==1 && GameStart.roadmove==0 && GameStart.speed>0) {
				GameStart.y=500;
				GameStart.mymotor.setLocation(GameStart.x,GameStart.y);
				GameStart.gamepanel.setBounds(0,-50, 1280, 720);//yol hareketleri
				GameStart.roadmove=1;
			}
			
			else if(second%(1*(MenuSelect.howmanyrestart+1))==0 && MenuSelect.restartornot==1 && GameStart.roadmove==1 && GameStart.speed>0) {
				GameStart.y=450;
				GameStart.mymotor.setLocation(GameStart.x,GameStart.y);
				GameStart.gamepanel.setBounds(0,0, 1280, 720);//yol hareketleri
				GameStart.roadmove=0;
			}
			
		}
	};
	public void start() {
		myTimer.scheduleAtFixedRate(task, 1000, 250);
	}
}
