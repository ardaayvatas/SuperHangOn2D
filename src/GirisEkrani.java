import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
public class GirisEkrani extends JFrame {
	static int quitornot=0;
	static JLabel background;
	static JPanel backgroundpanel;
	GirisEkrani(){
		super("CSE 212 - Hang On");
		//setSize(1280,720);
		setLayout(null);
		backgroundpanel = new JPanel();
		backgroundpanel.setLayout(null);
		backgroundpanel.setBounds(0,0,1280,720);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setResizable(false);
		ImageIcon img = new ImageIcon("BackgroundHangOn.png");
		background = new JLabel ("",img,JLabel.CENTER);
		background.setSize(1280,720);
		//add(background);
		backgroundpanel.add(background, BorderLayout.CENTER);
		add(backgroundpanel);
		//setVisible(true);
		// Ana menulerim
		JMenuBar mymenu = new JMenuBar();
		mymenu = new JMenuBar();
		JMenu forgame = new JMenu("GAME");
		mymenu.add(forgame);
		JMenu foruser = new JMenu("USER");
		mymenu.add(foruser);
		JMenuItem forquit = new JMenuItem("QUIT");
		mymenu.add(forquit);
		
		//Hepsini setliyorum 
		super.setJMenuBar(mymenu);
		
		// Alt menulerim
		// User icin
		JMenuItem forregister = new JMenuItem("Register");
		foruser.add(forregister);
		JMenuItem forlogin = new JMenuItem("Login");
		foruser.add(forlogin);
		JMenuItem forhighscore = new JMenuItem("High Score");
		foruser.add(forhighscore);
		
		// Game icin
		JMenuItem forstart = new JMenuItem("Start");
		forgame.add(forstart);
		JMenuItem forpause = new JMenuItem("Pause");
		forgame.add(forpause);
		JMenuItem forrestart = new JMenuItem("Restart");
		forgame.add(forrestart);
		
		//Quit
		forquit.addActionListener(new MenuSelect());
		
		//User
		forregister.addActionListener(new MenuSelect());
		forlogin.addActionListener(new MenuSelect());
		forhighscore.addActionListener(new MenuSelect());
		
		//Game
		forstart.addActionListener(new MenuSelect());
		forpause.addActionListener(new MenuSelect());
		forrestart.addActionListener(new MenuSelect());
	}
	
}