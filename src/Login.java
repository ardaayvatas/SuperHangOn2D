import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Login extends JFrame implements ActionListener {

	Scanner sc=new Scanner(System.in);
	File dosya = new File ("User.txt");
	static String namecontrol;
	String passwordcontrol;
	private static JLabel name;
	private static JLabel passw;
	private static JTextField username;
	private static JPasswordField password;
	private static JButton loginbutton;
	private static JButton helpbutton;
	private static JLabel loginornot;
	public static int logincheck=0;
	Login(){
		super("Login");
	}
	public void loginstart(){
		setLayout(null);
		name= new JLabel("Name");
		name.setBounds(50,40,50,10);
		add(name);
		passw=new JLabel("Password");
		passw.setBounds(50,80,100,10);
		add(passw);
		username = new JTextField(20);
		username.setBounds(150,35,200,25);
		add(username);
		password= new JPasswordField();
		password.setBounds(150,70,200,25);
		add(password);
		loginbutton = new JButton("Login");
		loginbutton.setBounds(125,120,70,30);
		add(loginbutton);
		helpbutton = new JButton("Help");
		helpbutton.setBounds(225, 120, 70, 30);
		add(helpbutton);
		loginornot = new JLabel("");
		loginornot.setBounds(170, 150,100,30);
		add(loginornot);
		super.setSize(425,225);
		//super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		super.setVisible(true);
		loginbutton.addActionListener(new Login());
		helpbutton.addActionListener(new Login());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String usernameforlogin = username.getText();
		String passwordforlogin = password.getText();
		
		if(e.getActionCommand()=="Login") {
			int index=0;
			try {
				Scanner scforfile = new Scanner(dosya);
				while(scforfile.hasNext()){
					namecontrol=scforfile.next();
					passwordcontrol=scforfile.next();
					if(namecontrol.equals(usernameforlogin)) {
						if(passwordcontrol.equals(passwordforlogin)) {
							System.out.println(usernameforlogin +" ve "+ passwordforlogin+" eslesti");
							JOptionPane.showMessageDialog(null, "Correct name and password","Login",JOptionPane.INFORMATION_MESSAGE);
							scforfile.close();
							index=1;
							logincheck=1;
							break;
						}
						else
							JOptionPane.showMessageDialog(null, "You have entered an invalid password","Login",JOptionPane.WARNING_MESSAGE);
							index=1;
							scforfile.close();
							logincheck=0;
							break;
					}
				}
				if(index==0) {
					JOptionPane.showMessageDialog(null, "You have entered an invalid username","Login",JOptionPane.WARNING_MESSAGE);
					logincheck=0;
				}
			}
			catch (FileNotFoundException f){
				System.err.println("You have to register first");
				logincheck=0;
				JOptionPane.showMessageDialog(null, "You have to register first","Login",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(e.getActionCommand()=="Help") {
			JOptionPane.showMessageDialog(null, "This is help button","Help",JOptionPane.QUESTION_MESSAGE);
		}
		
	}

}
