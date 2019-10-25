import java.awt.Color;
import java.util.Random;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
//Created by Nola Smith
public class Game {
	
	JFrame window;
	Container con;
	JPanel titleNamePanel, startOverPanel, startButtonPanel, howToPanel,mainTextPanel,choiceButtonPanel,nextButtonPanel, playerPanel, enemyPanel;
	JLabel titleName, hpLabelp, weaponLabelp,hpLabele, weaponLabele,enemyLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	JButton startButton,howToButton,nextButton,choice1,choice2,choice3,choice4,startOverButton;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 25);
	Font choiceFont=new Font("Times New Roman", Font.PLAIN, 22);
	JTextArea mainTextArea;
	String position;
	Player p1 = new Player();//player object
	Enemy e = new Enemy();//enemy object
	
	startScreenHandler startHandler = new startScreenHandler();
	howToScreenHandler howToHandler = new howToScreenHandler();
	mainGameScreenHandler mainGameHandler = new mainGameScreenHandler();
	choiceButtonHandler choiceHandler = new choiceButtonHandler();
	nextButtonHandler nextHandler = new nextButtonHandler();
	startOverScreenHandler startOverHandler = new startOverScreenHandler();
	
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
		 choiceButtonPanel.setLayout(new GridLayout(2,1));
		 con.add(choiceButtonPanel);
		 
		 choice1=new JButton("Attack");
		 choice1.setBackground(Color.black);
		 choice1.setForeground(Color.white);
		 choice1.setFont(choiceFont);
		 choiceButtonPanel.add(choice1);
		 choice1.setFocusPainted(false);
		 choice1.addActionListener(choiceHandler);
		 choice1.setActionCommand("c1");
		 
		 choice2=new JButton("Give him all your stuff");
		 choice2.setBackground(Color.black);
		 choice2.setForeground(Color.white);
		 choice2.setFont(choiceFont);
		 choiceButtonPanel.add(choice2);
		 choice2.setFocusPainted(false);
		 choice2.addActionListener(choiceHandler);
		 choice2.setActionCommand("c2");
		 
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
		 position = "start";
		 
	 }
	 
	 public void attack(){
		 position="attack";
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 
		 e.setHealth(e.getHealth()-p1.weapond());//when player attacks
		 p1.setHealth(p1.getHealth()-e.weapond());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(e.getHealth()>0){
			 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
		 		+ "The bandit did "+ e.weapond() + " damage to you");
			 hpLabele.setText("HP: "+e.getHealth());
			 hpLabelp.setText("HP: "+p1.getHealth());
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
				 		+ "The bandit has been defeated");
				 hpLabele.setText("HP: "+0);
				 hpLabelp.setText("HP: "+p1.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 nextButton = new JButton("==>");
				 nextButton.setBackground(Color.black);
				 nextButton.setForeground(Color.white);
				 nextButton.setFont(buttonFont);
				 nextButton.addActionListener(nextHandler);
				 nextButton.setFocusPainted(false);
				 
				 nextButtonPanel = new JPanel();
				 nextButtonPanel.setBounds(300,400,150,65);
				 nextButtonPanel.setBackground(Color.black);
				 nextButtonPanel.setVisible(true);
				 nextButtonPanel.add(nextButton);
				 con.add(nextButtonPanel);
				 
				 position ="fight1";
		 }
	}
	 
	 public void giveUp(){
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("The bandit takes all your stuff.\n"
		 		+ "Wow a bronze sword now I can win more fights\n"
		 		+ "The bandit throws his wooden sword to the ground and\nleaves with your stuff\n"
		 		+ "You now continue on with your journey with only a\nwooden sword.");
		 
		 mainTextPanel.setBounds(100,100,600,175);
		 mainTextPanel.add(mainTextArea);
		 
		 p1.setWeapon("Wooden Sword");
		 weaponLabelp.setText("Weapon: "+p1.getWeapon());
		 
		 choiceButtonPanel.setVisible(false);
		 
		 nextButton = new JButton("==>");
		 nextButton.setBackground(Color.black);
		 nextButton.setForeground(Color.white);
		 nextButton.setFont(buttonFont);
		 nextButton.addActionListener(nextHandler);
		 nextButton.setFocusPainted(false);
		 
		 nextButtonPanel = new JPanel();
		 nextButtonPanel.setBounds(300,400,150,65);
		 nextButtonPanel.setBackground(Color.black);
		 nextButtonPanel.setVisible(true);
		 nextButtonPanel.add(nextButton);
		 con.add(nextButtonPanel);
		 
		 position="bigTreeText";
		 
		 enemyPanel.setVisible(false);
		 
	 }
	 
	 public void playerSetup(){
		 weaponLabelp.setText("Weapon: "+p1.getWeapon());
		 hpLabelp.setText("HP: "+p1.getHealth());
		 
		 e.setType("Bandit");
		 e.setHealth(15);
		 
		 e.setWeapon("Wooden Sword");
		 enemyLabel.setText(e.getType());
		 weaponLabele.setText("Weapon: "+e.getWeapon());
		 hpLabele.setText("HP: "+e.getHealth());
	 }
	 
	 public void bigTree(){
		 position="bigTree";
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 mainTextArea.setText("\"Hello, would you mind spend some time with an old man  to pass some time. "
		 		+ "I have some dice if you win I will give you the sword\n"
		 		+ "If I win you have to help me with a task.\" says the old man\n"
		 		+ "You decide to play the game so you can get the sword");
		 mainTextPanel.setBounds(100,100,600,150);
		 mainTextPanel.add(mainTextArea);
		 mainTextPanel.setVisible(true);
		 
		 position="play";
		 
	 }
	 
	 public void play(){
		 enemyPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 Random rand = new Random();
		 int nump = 0;
		 int nume = 0;
		
		 while(nump==nume){
			 nump = rand.nextInt(6);
			 nume= rand.nextInt(6);
			 if(nump==0){
				 nump=6;
			 }
			 if(nume==0){
				 nume=6;
			 }
		 }
		 
		 if(nump>nume){
			 nextButtonPanel.setVisible(true);
			 mainTextArea.setText("You rolled a "+nump+".\nThe old man rolled a "+nume
					 +"/You win and the old man easily pulls out the sword from the tree and hands you the sword\n"
					 + "\"I know we had a deal anyway but would you mind helping me still\" the old man askes");
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea);
				 mainTextPanel.setVisible(true);
				
				 position="helpWin";
				 
				 p1.setWeapon("Silver Sword");
				 weaponLabelp.setText(p1.getWeapon());
				
		 }
		 else{
			 choiceButtonPanel.setVisible(true);
			 mainTextArea.setText("You rolled a "+nump+".\nThe old man rolled a "+nume+"Welp a deal is a deal right?");
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea);
				 mainTextPanel.setVisible(true);
				 position="helpLost";
				 
			choice1.setText("Stick to Deal");
			choice2.setText("Break Deal");
		 }
		 
		 
	 }
	 
	 public void dogFightBegin(){
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 mainTextPanel.remove(mainTextArea);
		 mainTextArea.setText("\"I do not like deal breakers and neither does my dog\" syas the old man\n"
		 		+ "A big dog emerges from behind the tree and barks very loudly and shows off his big sharp teeth");
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
			 mainTextPanel.setVisible(true);
			 
			 e.setHealth(30);
			 position="dogFight";
	 }
	 
	 public void dogFight(){
		
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 enemyPanel.setVisible(true);
		 
		 e.setHealth(e.getHealth()-p1.weapond());//when player attacks
		 p1.setHealth(p1.getHealth()-e.weapond());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(e.getHealth()>0){
			 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
		 		+ "The dog did "+ e.weapond() + " damage to you");
			 hpLabele.setText("HP: "+e.getHealth());
			 hpLabelp.setText("HP: "+p1.getHealth());
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
			 
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
				 		+ "The dog has been defeated");
				 hpLabele.setText("HP: "+0);
				 hpLabelp.setText("HP: "+p1.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 nextButton = new JButton("==>");
				 nextButton.setBackground(Color.black);
				 nextButton.setForeground(Color.white);
				 nextButton.setFont(buttonFont);
				 nextButton.addActionListener(nextHandler);
				 nextButton.setFocusPainted(false);
				 
				 nextButtonPanel = new JPanel();
				 nextButtonPanel.setBounds(300,400,150,65);
				 nextButtonPanel.setBackground(Color.black);
				 nextButtonPanel.setVisible(true);
				 nextButtonPanel.add(nextButton);
				 con.add(nextButtonPanel);
				 
				 position="continue";
				 
				 
		 }
	 }
	 
	 public void ogreFight(){
		 
		 titleNamePanel.setVisible(false);
		 howToPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 enemyPanel.setVisible(true);
		 
		 e.setHealth(e.getHealth()-p1.weapond());//when player attacks
		 p1.setHealth(p1.getHealth()-e.weapond());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(p1.getHealth()<=0){
			 hpLabelp.setText("HP: "+p1.getHealth());
			 lose();
		 }
		 else if(e.getHealth()>0){
			 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
		 		+ "The bandit did "+ e.weapond() + " damage to you");
			 hpLabele.setText("HP: "+e.getHealth());
			 hpLabelp.setText("HP: "+p1.getHealth());
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + p1.weapond() + " damage to the enemy\n"
				 		+ "The ogre has been defeated");
				 hpLabele.setText("HP: "+0);
				 hpLabelp.setText("HP: "+p1.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 nextButton = new JButton("==>");
				 nextButton.setBackground(Color.black);
				 nextButton.setForeground(Color.white);
				 nextButton.setFont(buttonFont);
				 nextButton.addActionListener(nextHandler);
				 nextButton.setFocusPainted(false);
				 
				 nextButtonPanel = new JPanel();
				 nextButtonPanel.setBounds(300,400,150,65);
				 nextButtonPanel.setBackground(Color.black);
				 nextButtonPanel.setVisible(true);
				 nextButtonPanel.add(nextButton);
				 con.add(nextButtonPanel);
				 
				 position ="ogreWin";
		 }
	 }
	 
	 public void knightStory(){
		
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("\"Thank you for helping me. Seeing you go on your knighthood has reminded me of mine"
			 		+ "with a fellow knight. This sword was my friend's he never made it past the ogre up ahead. Will you"
			 		+ "please take this sword and bring it to the knighthood\"");
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea);
				 mainTextPanel.setVisible(true);
				  
		position="continue";
	 }
	 
	 public void lose(){
		 nextButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 enemyPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 titleNamePanel.setVisible(true);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 howToPanel.setVisible(false);
		 
		 titleNamePanel.remove(titleName);
		 
		 titleNamePanel.setBounds(100,100,600,150);
		 titleNamePanel.setBackground(Color.black);//color of background
		 titleName=new JLabel("You Died");
		 titleName.setForeground(Color.white);//color of text
		 titleName.setFont(titleFont);
		 titleNamePanel.add(titleName);
		 
		 startOverPanel = new JPanel();
		 startOverPanel.setBounds(300,400,150,65);
		 startOverPanel.setBackground(Color.black);
		 
		 startOverButton = new JButton("START OVER");
		 startOverButton.setBackground(Color.black);
		 startOverButton.setForeground(Color.white);
		 startOverButton.setFont(buttonFont);
		 startOverButton.addActionListener(startOverHandler);
		 startOverButton.setFocusPainted(false);
		
	 }
	 
	 public class startOverScreenHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		new Game();
		 	}
	 }
	 
	 public class nextButtonHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		enemyPanel.setVisible(false);
		 		mainTextPanel.setVisible(false);
		 		mainTextPanel.remove(mainTextArea);
		 		switch(position){
		 		
 					case "fight1":
 						
 						mainTextArea.setText("Wow that was easy but you did take some damage\n"
 							+ "You see a health potion next to him and  pick it up\n"
 							+ "You gained 15 health");
 						mainTextPanel.setBounds(100,100,600,150);
 						mainTextPanel.add(mainTextArea);
 						p1.setHealth(p1.getHealth()+15);
 						hpLabelp.setText("HP: "+p1.getHealth());
 					
 						position="bigTreeText";
 						mainTextPanel.setVisible(true);
 						break;
 				
 					case "bigTreeText":
 					
 						mainTextArea.setText("You continue on and encounter a big oak tree with a"
 					 		+ "long\nsword stuck in it. You tug on it but it is stuck in the tree real good.\n"
 					 		+ "Then a short stubby man comes out from behind the tree");
 						mainTextPanel.setBounds(100,100,600,150);
 						mainTextPanel.add(mainTextArea);
 						mainTextPanel.setVisible(true);
 						position="bigTree";
 						break;
 					
 					case "bigTree":
 						bigTree();
 						break;
 						
 					case "play":
 						play();
 						break;
 						
 					case "helpWin":
 						 knightStory();
 						break;
 						
 					case "dogFight":
 						dogFight();
 						break;
 						
 					case "knightstory":
 						knightStory();
 						break;
 						
 					case "continue":
 						mainTextArea.setText("You continue on until you find a tower. You walk in "
 								+ "and there is an ogre standing there with a big battle axe and he charges straight at you.");
 							 mainTextPanel.setBounds(100,100,600,150);
 							 mainTextPanel.add(mainTextArea);
 							 mainTextPanel.setVisible(true);
 							  
 							 position="ogreFight";
 							e.setHealth(40);
 							 break;
 							 
 					case "ogreFight":
 						
 						ogreFight();
 						break;
 						
 					case "ogreWin":
 						mainTextArea.setText("You Now your journey is finished and you travel to Yullie Town");
 							 mainTextPanel.setBounds(100,100,600,150);
 							 mainTextPanel.add(mainTextArea);
 							 mainTextPanel.setVisible(true);
 						position="town";
 					break;
 					
 					case "town":
 						mainTextArea.setText("As you enter Yullie Town you are greeted with excitement because"
 								+ "you have just finihed your knighthood. Congratulations!!");
						 mainTextPanel.setBounds(100,100,600,150);
						 mainTextPanel.add(mainTextArea);
						 mainTextPanel.setVisible(true);
					position="town";
 					break;
				}
		 			
		 	}
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

	 public class choiceButtonHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		String yourChoice = event.getActionCommand();
		 		
		 			switch(position){
		 				case "attack":
		 					switch(yourChoice){
		 						case "c1":
		 							attack();
		 							break;
		 						case "c2":
		 							giveUp();
		 							break;
		 					}
		 					break;
		 				case "start":
		 					switch(yourChoice){
	 						case "c1":
	 							attack();
	 							break;
	 						case "c2":
	 							giveUp();
	 							break;
	 					}
		 				break;
		 				case "helpLost":
		 					switch(yourChoice){
		 					case "c1":
		 						knightStory();
		 						break;
		 					case "c2":
		 						dogFightBegin();
		 						break;
		 					}
		 					break;
		 			}	
		 	}
	 }
	 
}

