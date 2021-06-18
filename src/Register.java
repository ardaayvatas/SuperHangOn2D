import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener {
	
	private static JLabel nameforregister;
	private static JLabel passwforregister;
	private static JTextField usernameforregister;
	private static JPasswordField passwordforregister;
	private static JButton registerbutton;
	File dosyareg = new File ("User.txt");
	Scanner sc=new Scanner(System.in);
	String regnamecontrol;
	String regpasswordcontrol;
	Register() {
		super("Register");
	}
		
	public void registerstart() {
		setLayout(null);
		nameforregister=new JLabel("Name");
		nameforregister.setBounds(50,40,50,10);
		add(nameforregister);
		passwforregister=new JLabel("Password");
		passwforregister.setBounds(50,80,100,10);
		add(passwforregister);
		usernameforregister=new JTextField(20);
		usernameforregister.setBounds(150,35,200,25);
		add(usernameforregister);
		passwordforregister=new JPasswordField();
		passwordforregister.setBounds(150,70,200,25);
		add(passwordforregister);
		registerbutton=new JButton("Register");
		registerbutton.setBounds(140,120,150,30);
		add(registerbutton);
		
		super.setSize(425,225);
		setResizable(false);
		super.setVisible(true);
		
		registerbutton.addActionListener(new Register());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usernameforegister = usernameforregister.getText();
		String passwordforegister = passwordforregister.getText();
		int pw=passwordforegister.length();
		int un=usernameforegister.length();
		
		//bossa eklemiyorum
		
		if(un==0 || pw==0) {
			//JOptionPane eklencek
			JOptionPane.showMessageDialog(null, "Name or Password is incorrect type!","Register",JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		//isim icin " " varsa eklemiyorum
		for(int i=0; i< usernameforegister.length();i++) {
			if(Character.isWhitespace(usernameforegister.charAt(i))) {
				JOptionPane.showMessageDialog(null, "You entered incorrect type for username!","Register",JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		
		//sifre icin " " varsa eklemiyorum
		for(int i=0; i< passwordforegister.length();i++) {
			if(Character.isWhitespace(passwordforegister.charAt(i))) {
				JOptionPane.showMessageDialog(null, "You entered incorrect type for password!","Register",JOptionPane.WARNING_MESSAGE);
				return;
			}
		}
		
		if(e.getActionCommand()=="Register") {
			try {
				FileWriter users = new FileWriter ("User.txt",true);
				PrintWriter forRegister = new PrintWriter(users);
				
				Scanner scforregfile = new Scanner(dosyareg);
				while(scforregfile.hasNext()){
					regnamecontrol=scforregfile.next();
					regpasswordcontrol=scforregfile.next();
					if(regnamecontrol.equals(usernameforegister)) {
						System.err.println("This username already taken");
						JOptionPane.showMessageDialog(null, "This username already taken","Register",JOptionPane.WARNING_MESSAGE);
						scforregfile.close();
						forRegister.close();
						return;
					}
				}
				scforregfile.close();
				
				forRegister.println(usernameforegister);
				forRegister.println(passwordforegister);
				users.close();
				JOptionPane.showMessageDialog(null,"You registered :)","Register",JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch (IOException io) {
				// TODO Auto-generated catch block
				io.printStackTrace();
			}
		}
	}
	
}
