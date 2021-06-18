import javax.swing.JFrame;

public class Main {
	static GirisEkrani myscreen;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GirisEkrani girisekranim = new GirisEkrani();
		myscreen=new GirisEkrani();
		myscreen.setSize(1280,720);
		myscreen.setResizable(false);
		myscreen.setVisible(true);
		myscreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
