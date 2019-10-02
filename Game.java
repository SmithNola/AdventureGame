import java.awt.Color;
import java.awt.Container;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
public class Game {
	JFrame window;
	Container con;
	
	 public static void main(String[] args){
		new Game();
	 } 
	 
	 public Game(){
		 window = new JFrame();
		 window.setSize(800,600);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.getContentPane().setBackground(Color.black);
		 window.setLayout(null);
		 window.setVisible(true);
		 con=window.getContentPane();
		 int roll;//to roll dice
		 String name;//player name
		 Scanner keyboard = new Scanner(System.in);
		 name=keyboard.nextLine();
		 Player p1 = new Player(); 
		 p1.setName(name);
	 }
	 
	 public static int Dice (){
		 Random rand = new Random(); 
		 int result = rand.nextInt(7);//will return a random integer from 0 to 6
		 return result;
	 }
}
