import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
public class Game {
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, howToPanel,mainTextPanel,choiceButtonPanel;
	JLabel titleName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	JButton startButton,howToButton;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 25);
	JTextArea mainTextArea;
	
	startScreenHandler startHandler = new startScreenHandler();
	howToScreenHandler howToHandler = new howToScreenHandler();
	
	 public static void main(String[] args){
		new Game();
	 } 
	 
	 public Game(){
		 //creates game window
		 window = new JFrame();
		 window.setSize(800,600);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.getContentPane().setBackground(Color.black);
		 window.setLayout(null);
		 window.setVisible(true);
		 con=window.getContentPane();
		 
		 titleNamePanel= new JPanel();
		 titleNamePanel.setBounds(100,100,600,150);
		 titleNamePanel.setBackground(Color.black);//color of background
		 titleName=new JLabel("A Knight's Quest");
		 titleName.setForeground(Color.white);//color of text
		 titleName.setFont(titleFont);
		 
		 howToPanel = new JPanel();
		 howToPanel.setBounds(280,345,200,100);
		 howToPanel.setBackground(Color.black);
		 
		 howToButton = new JButton("How To Play");
		 howToButton.setBackground(Color.black);
		 howToButton.setForeground(Color.white);
		 howToButton.setFont(buttonFont);
		 howToButton.addActionListener(howToHandler);
		 
		 startButton = new JButton("START");
		 startButton.setBackground(Color.black);
		 startButton.setForeground(Color.white);
		 startButton.setFont(buttonFont);
		 startButton.addActionListener(startHandler);
		 
		 startButtonPanel = new JPanel();
		 startButtonPanel.setBounds(300,400,150,65);
		 startButtonPanel.setBackground(Color.black);
		 
		 titleNamePanel.add(titleName);
		 startButtonPanel.add(startButton);
		 howToPanel.add(howToButton);
		 
		 con.add(titleNamePanel);
		 con.add(startButtonPanel);
		 con.add(howToPanel);
		 window.setVisible(true);
		 
		 //int roll;//to roll dice
		 //String name;//player name
		 //Scanner keyboard = new Scanner(System.in);
		 //name=keyboard.nextLine();
		 //Player p1 = new Player(); 
		 //p1.setName(name);
		
	 }
	 
	 public void createGameScreen(){
		 
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBounds(50,50,700,400);
		 mainTextPanel.setBackground(Color.black);
		 con.add(mainTextPanel);
		 
		 mainTextArea = new JTextArea("You wake up to a loud banging at your bedroom door.\"Knight please wake up\""
		 		+ " You open up the door and before you can speak the servant hands you a letter with the king's seal on it.\n\n"
		 		+ "Knight I am tasking you with something dear. Rescue my daughter,  Princess Marylett. She has been kidnapped by"
		 		+ " an unknown assilent.  All they said is that she will be held by volcano Timbitti. I am giving  you $20 and 1 medium "
		 		+ "potion as that is all I have on me before the   Queen and I go into hiding. I will try and send letters to you to towns "
		 		+ "throughout your journey. Please Knight bring my daughter back        safely.\n\nAnd off you went on your journey.");
		 mainTextArea.setBounds(50,50,700,400);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(textFont);
		 mainTextArea.setLineWrap(true);
		 mainTextArea.setEditable(false); 
		 mainTextPanel.add(mainTextArea);
		 
		 //choiceButtonPanel = new JPanel();
		 //choiceButtonPanel.setBounds(250, 350, 300, 150);
		 //choiceButtonPanel.setBackground(Color.red);
		 //con.add(choiceButtonPanel);
	 }
	 
	 public void howToScreen(){
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBounds(50,50,700,400);
		 mainTextPanel.setBackground(Color.black);
		 con.add(mainTextPanel);
		 
		 mainTextArea = new JTextArea("Luck -> your chances of leaving a fight out of 6\n"
		 		+ "HP -> is your health it is displayed as current health/total health\n"
		 		+ "Weapon -> you will only be able to hold onto one weapon at a time\n"
		 		+ "Money -> is your total amount you are able to spend\n"
		 		+ "Placement -> your position on the map\n\n"
		 		+ "You will a dice of six each turn and move forward\n\n"
		 		+ "If you roll before a town and roll pass it will will have the option to go to the town\n\n"
		 		+ "After leaving a town and your roll is under 4 you will have the option to go back to town or continue forward.\n\n"
		 		+ "You win after you beat the final boss at the final placement.");
		 mainTextArea.setBounds(50,50,700,400);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(textFont);
		 mainTextArea.setLineWrap(true);
		 mainTextArea.setEditable(false); 
		 mainTextPanel.add(mainTextArea);
	 }
	 
	 public class howToScreenHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		howToScreen();
		 	}
}
	 
	 public class startScreenHandler implements ActionListener{
			 	public void actionPerformed(ActionEvent event){
			 		createGameScreen();
			 	}
	 }
	 
	 public static int Dice(){
		 Random rand = new Random(); 
		 int result = rand.nextInt(7);//will return a random integer from 0 to 6
		 return result;
	 }
}
