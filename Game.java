import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
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
	JPanel titleNamePanel, startButtonPanel, howToPanel,mainTextPanel,choiceButtonPanel,nextButtonPanel, playerPanel, enemyPanel;
	JLabel titleName, hpLabelp, weaponLabelp,hpLabele, weaponLabele,enemyLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	JButton startButton,howToButton,nextButton,choice1,choice2,choice3,choice4;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 25);
	JTextArea mainTextArea;
	int playerHp,enemyHp;
	String weaponp, weapone,enemy;
	
	
	startScreenHandler startHandler = new startScreenHandler();
	howToScreenHandler howToHandler = new howToScreenHandler();
	mainGameScreenHandler mainGameHandler = new mainGameScreenHandler();
	
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
		 howToButton.setFocusPainted(false);
		 
		 startButton = new JButton("START");
		 startButton.setBackground(Color.black);
		 startButton.setForeground(Color.white);
		 startButton.setFont(buttonFont);
		 startButton.addActionListener(startHandler);
		 startButton.setFocusPainted(false);//gets rid of the square around the button
		 
		 startButtonPanel = new JPanel();
		 startButtonPanel.setBounds(300,400,150,65);
		 startButtonPanel.setBackground(Color.black);
		 
		 titleNamePanel.add(titleName);
		 startButtonPanel.add(startButton);
		 howToPanel.add(howToButton);
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBackground(Color.black);
		 mainTextArea = new JTextArea();
		 mainTextArea.setEditable(false);
		 mainTextPanel.setVisible(false);
		 
		 con.add(mainTextPanel);
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
		 mainTextPanel.setVisible(true);
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 mainTextPanel.setBounds(50,50,700,400);
		 mainTextPanel.remove(mainTextArea);
		 
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
		 
		 startButtonPanel.remove(startButton);//removes previous instance of button since I edited it
		 
		 startButton = new JButton("Begin Your Adventure");
		 startButton.setBackground(Color.black);
		 startButton.setForeground(Color.white);
		 startButton.setFont(buttonFont);
		 startButton.addActionListener(mainGameHandler);
		 startButton.setFocusPainted(false);
		 
		 startButtonPanel.setBounds(175,450,400,100);
		 startButtonPanel.add(startButton);
		 
	 }
	 
	 public void howToScreen(){
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(true);
		 
		 mainTextPanel.setBounds(50,50,700,400);
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
		 
		 startButtonPanel.remove(startButton);
		 
		 startButton = new JButton("Start");
		 startButton.setBackground(Color.black);
		 startButton.setForeground(Color.white);
		 startButton.setFont(buttonFont);
		 startButton.addActionListener(startHandler);
		 startButton.setFocusPainted(false);
		 
		 startButtonPanel.setBounds(300,450,100,100);
		 startButtonPanel.add(startButton);
		 
		 
	 }
	 
	 public void mainGame(){
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 
		 choiceButtonPanel = new JPanel();
		 choiceButtonPanel.setBounds(250, 400, 300, 150);
		 choiceButtonPanel.setBackground(Color.red);
		 choiceButtonPanel.setLayout(new GridLayout(4,1));
		 con.add(choiceButtonPanel);
		 
		 choice1=new JButton("Choice 1");
		 choice1.setBackground(Color.black);
		 choice1.setForeground(Color.white);
		 choice1.setFont(buttonFont);
		 choiceButtonPanel.add(choice1);
		 choice1.setFocusPainted(false);
		 

		 choice2=new JButton("Choice 2");
		 choice2.setBackground(Color.black);
		 choice2.setForeground(Color.white);
		 choice2.setFont(buttonFont);
		 choiceButtonPanel.add(choice2);
		 choice2.setFocusPainted(false);
		 

		 choice3=new JButton("Choice 3");
		 choice3.setBackground(Color.black);
		 choice3.setForeground(Color.white);
		 choice3.setFont(buttonFont);
		 choiceButtonPanel.add(choice3);
		 choice3.setFocusPainted(false);

		 choice4=new JButton("Choice 4");
		 choice4.setBackground(Color.black);
		 choice4.setForeground(Color.white);
		 choice4.setFont(buttonFont);
		 choiceButtonPanel.add(choice4);
		 choice4.setFocusPainted(false);
		 
		 playerPanel = new JPanel();
		 playerPanel.setBounds(100,10,600,50);
		 playerPanel.setBackground(Color.black);
		 playerPanel.setLayout(new GridLayout(1,2));
		 con.add(playerPanel);
		 
		 hpLabelp=new JLabel("");
		 hpLabelp.setFont(textFont);
		 hpLabelp.setForeground(Color.white);
		 playerPanel.add(hpLabelp);
		 
		 weaponLabelp=new JLabel("");
		 weaponLabelp.setFont(textFont);
		 weaponLabelp.setForeground(Color.white);
		 playerPanel.add(weaponLabelp);
		 
		 enemyPanel = new JPanel();
		 enemyPanel.setBounds(100,250,600,50);
		 enemyPanel.setBackground(Color.black);
		 enemyPanel.setLayout(new GridLayout(1,3));
		 con.add(enemyPanel);
		 
		 enemyLabel=new JLabel("");
		 enemyLabel.setFont(textFont);
		 enemyLabel.setForeground(Color.white);
		 enemyPanel.add(enemyLabel);
		 
		 hpLabele=new JLabel("");
		 hpLabele.setFont(textFont);
		 hpLabele.setForeground(Color.white);
		 enemyPanel.add(hpLabele);
		 
		 weaponLabele=new JLabel("");
		 weaponLabele.setFont(textFont);
		 weaponLabele.setForeground(Color.white);
		 enemyPanel.add(weaponLabele);
		 
		 playerSetup();
		 
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("Right out of the castle you encounter a bandit that likes to   target innocents\n"
		 		+ "\"Give me all your money or die\" he says.\n"
		 		+ "What do you do? He looks weak.");
		 mainTextArea.setBounds(100,100,600,150);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(textFont);
		 mainTextArea.setLineWrap(true);
		 mainTextArea.setEditable(false); 
		 
		 mainTextPanel.setBounds(100,100,600,150);
		 mainTextPanel.add(mainTextArea);
	 }
	 
	 public void playerSetup(){
		 playerHp=50;
		 weaponp="Bronze Sword";
		 weaponLabelp.setText("Weapon: "+weaponp);
		 hpLabelp.setText("HP: "+playerHp);
		 
		 enemy="Bandit";
		 enemyHp=15;
		 weapone="Bronze Sword";
		 enemyLabel.setText(enemy);
		 weaponLabele.setText("Weapon: "+weapone);
		 hpLabele.setText("HP: "+enemyHp);
	 }
	 
	 public void postion1(){
		 
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
	 
	 public class mainGameScreenHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		mainGame();
		 	}
}
	 
	 public static int Dice(){
		 Random rand = new Random(); 
		 int result = rand.nextInt(7);//will return a random integer from 0 to 6
		 return result;
	 }
}
