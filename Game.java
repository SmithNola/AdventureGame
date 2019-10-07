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
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
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
		 howToButton.setFont(normalFont);
		 howToButton.addActionListener(howToHandler);
		 
		 startButton = new JButton("START");
		 startButton.setBackground(Color.black);
		 startButton.setForeground(Color.white);
		 startButton.setFont(normalFont);
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
		 
		 int roll;//to roll dice
		 String name;//player name
		 Scanner keyboard = new Scanner(System.in);
		 name=keyboard.nextLine();
		 Player p1 = new Player(); 
		 p1.setName(name);
		
	 }
	 
	 public void createGameScreen(){
		 
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBounds(100,100,600,250);
		 mainTextPanel.setBackground(Color.blue);
		 con.add(mainTextPanel);
		 
		 mainTextArea = new JTextArea();
		 mainTextArea.setBounds(100,100,600,250);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(normalFont);
		 mainTextArea.setLineWrap(true);
		 mainTextArea.setEditable(false); 
		 mainTextPanel.add(mainTextArea);
		 
		 choiceButtonPanel = new JPanel();
		 choiceButtonPanel.setBounds(250, 350, 300, 150);
		 choiceButtonPanel.setBackground(Color.red);
		 con.add(choiceButtonPanel);
	 }
	 
	 public void howToScreen(){
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBounds(100,100,600,250);
		 mainTextPanel.setBackground(Color.blue);
		 con.add(mainTextPanel);
		 
		 mainTextArea = new JTextArea();
		 mainTextArea.setBounds(100,100,600,250);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(normalFont);
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
