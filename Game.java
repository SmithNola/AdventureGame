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
	JPanel titleNamePanel, startOverPanel, startButtonPanel, mainTextPanel,choiceButtonPanel,nextButtonPanel, playerPanel, enemyPanel;
	JLabel titleName, hpLabelp, weaponLabelp,hpLabele, weaponLabele,enemyLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	JButton startButton,nextButton,choice1,choice2,choice3,choice4,startOverButton;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 25);
	Font choiceFont = new Font("Times New Roman", Font.PLAIN, 22);
	JTextArea mainTextArea;
	String position;
	Character player = new Character("Player");//player object
	Character bandit = new Character("Bandit");//bandit enemy
	Character dog = new Character("Big Dog");//bandit enemy
	Character ogre = new Character("Ogre");//bandit enemy
	
	startScreenHandler startHandler = new startScreenHandler();
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
		 con=window.getContentPane();
		 
		 //Title Screen
		 titleNamePanel = new JPanel();
		 titleNamePanel.setBounds(100,100,600,150);
		 titleNamePanel.setBackground(Color.black);//color of background
		 titleName = new JLabel("A Knight's Journey");
		 titleName.setForeground(Color.white);//color of text
		 titleName.setFont(titleFont);
		 
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
		 
		 mainTextPanel = new JPanel();
		 mainTextPanel.setBackground(Color.black);
		 mainTextArea = new JTextArea();
		 mainTextArea.setEditable(false);
		 mainTextPanel.setVisible(false);
		 
		 con.add(mainTextPanel);
		 con.add(titleNamePanel);
		 con.add(startButtonPanel);
		 window.setVisible(true);
		
	 }
	 
	 public void createGameScreen(){//first screen
		 mainTextPanel.setVisible(true);
		 titleNamePanel.setVisible(false);
		 
		 mainTextPanel.setBounds(50,50,700,400);
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea = new JTextArea("Every new knight has to go through a knighthood "
		 		+ "where they\nadventure out into the world on their own, so you set off "
		 		+ "to begin\nyour journey out of your own kingdom that you have lived in your\n"
		 		+ " entire life until you reach your knighthood town, Yullie.");
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
		 con.add(startButtonPanel);
	 }
	 
	 public void playerSetup(){
		 weaponLabelp.setText("Weapon: " + player.getWeaponName());
		 hpLabelp.setText("HP: " + player.getHealth());
		 
		 enemyLabel.setText(bandit.getType());
		 weaponLabele.setText("Weapon: " + bandit.getWeaponName());
		 hpLabele.setText("HP: " + bandit.getHealth());
	 }
	 
	 public void mainGame(){//first  battle scene
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 playerPanel = new JPanel();
		 playerPanel.setBounds(100,10,600,50);
		 playerPanel.setBackground(Color.black);
		 playerPanel.setLayout(new GridLayout(1,2));
		 con.add(playerPanel);
		 
		 hpLabelp = new JLabel("");
		 hpLabelp.setFont(textFont);
		 hpLabelp.setForeground(Color.white);
		 playerPanel.add(hpLabelp);
		 
		 weaponLabelp = new JLabel("");
		 weaponLabelp.setFont(textFont);
		 weaponLabelp.setForeground(Color.white);
		 playerPanel.add(weaponLabelp);
		 
		 enemyPanel = new JPanel();
		 enemyPanel.setBounds(100,250,600,50);
		 enemyPanel.setBackground(Color.black);
		 enemyPanel.setLayout(new GridLayout(1,3));
		 con.add(enemyPanel);
		 
		 enemyLabel = new JLabel("");
		 enemyLabel.setFont(textFont);
		 enemyLabel.setForeground(Color.white);
		 enemyPanel.add(enemyLabel);
		 
		 hpLabele = new JLabel("");
		 hpLabele.setFont(textFont);
		 hpLabele.setForeground(Color.white);
		 enemyPanel.add(hpLabele);
		 
		 weaponLabele = new JLabel("");
		 weaponLabele.setFont(textFont);
		 weaponLabele.setForeground(Color.white);
		 enemyPanel.add(weaponLabele);
		 
		 playerSetup();//sets up plater stats
		 
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("Right out of the castle you encounter a bandit that likes to\ntarget innocents.\n"
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
		 
		 choiceButtonPanel = new JPanel();
		 choiceButtonPanel.setBounds(250, 400, 300, 150);
		 choiceButtonPanel.setBackground(Color.red);
		 choiceButtonPanel.setLayout(new GridLayout(2,1));
		 con.add(choiceButtonPanel);
		 
		 choice1 = new JButton("Attack");
		 choice1.setBackground(Color.black);
		 choice1.setForeground(Color.white);
		 choice1.setFont(choiceFont);
		 
		 choice1.setFocusPainted(false);
		 choice1.addActionListener(choiceHandler);
		 choice1.setActionCommand("c1");
		 choiceButtonPanel.add(choice1);
		 
		 choice2 = new JButton("Give him all your stuff");
		 choice2.setBackground(Color.black);
		 choice2.setForeground(Color.white);
		 choice2.setFont(choiceFont);
		 
		 choice2.setFocusPainted(false);
		 choice2.addActionListener(choiceHandler);
		 choice2.setActionCommand("c2");
		 choiceButtonPanel.add(choice2);
		 
		 position = "attack"; 
	 }
	 
	 public void attack(){
		 position = "attack";
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 
		 bandit.setHealth(bandit.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - bandit.getWeaponDamage());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(bandit.getHealth()>0){//if enemy has not been defeated
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The bandit did " + bandit.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: " + bandit.getHealth());//shows new stats
			 hpLabelp.setText("HP: " + player.getHealth());//shows new stats
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
		 }else{
				 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 		+ "The bandit has been defeated");
				 hpLabele.setText("HP: " + 0);
				 hpLabelp.setText("HP: " + player.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 nextPage();
				 
				 position = "fight1";
		 }
	}
	 
	 public void giveUp(){
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("The bandit takes all your stuff and says, \"Wow a bronze\nsword now I can win more fights.\"\n"
		 		+ "The bandit throws his wooden sword to the ground and\nleaves with your stuff.\n"
		 		+ "You now continue on with your journey with only a\nwooden sword.");
		 
		 mainTextPanel.setBounds(100,100,600,175);
		 mainTextPanel.add(mainTextArea);
		 
		 player.setWeapon("Wooden Sword");
		 weaponLabelp.setText("Weapon: " + player.getWeaponName());
		 
		 nextPage();
		 
		 position="bigTreeText";
		 
		 enemyPanel.setVisible(false);
		 
	 }
	 
	 public void bigTree(){
		 position = "bigTree";
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 mainTextArea.setText("\"Hello, would you mind spending some time with an old man  to pass some time. "
		 		+ "I have some dice if you win I will give\nyou the sword\n"
		 		+ "If I win you have to help me with a task.\" says the old man.\n"
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
		
		 while(nump == nume){//rerolls if user and old man roll the same number
			 nump = rand.nextInt(6);
			 nume = rand.nextInt(6);
			 //there is not 0 on dice so I change it to a 6 instead
			 if(nump == 0){
				 nump = 6;
			 }
			 if(nume == 0){
				 nume = 6;
			 }
		 }
		 
		 if(nump>nume){//if play wins
			 nextButtonPanel.setVisible(true);
			 mainTextArea.setText("You rolled a " + nump + ".\nThe old man rolled a " + nume
					 +"\nYou win and the old man easily pulls out the sword from the tree and hands you the sword.\n"
					 + "\"I know we had a deal anyway but would you mind helping me still\" the old man askes");
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea);
				 mainTextPanel.setVisible(true);
				
				 position="helpWin";
				 
				 player.setWeapon("Silver Sword");
				 weaponLabelp.setText(player.getWeaponName());
				
		 }
		 else{//if player loses
			 choiceButtonPanel.setVisible(true);
			 mainTextArea.setText("You rolled a "+nump+".\nThe old man rolled a " + nume + ".\nWelp a deal is a deal right?");
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
		 mainTextArea.setText("\"I do not like deal breakers and neither does my dog\" says\nthe old man\n"
		 		+ "A big dog emerges from behind the tree and barks very\nloudly and shows off his big sharp teeth");
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
			 mainTextPanel.setVisible(true);
			 
			 position="dogFight";
	 }
	 
	 public void dogFight(){
		
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 enemyPanel.setVisible(true);
		 choiceButtonPanel.setVisible(true);
		 
		 dog.setHealth(dog.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - dog.getWeaponDamage());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(dog.getHealth()>0){
			 position="dogfight";
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The dog did " + dog.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: " + dog.getHealth());
			 hpLabelp.setText("HP: " + player.getHealth());
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
			 
			 choice1.setText("Attack");
			 choice2.setText("Give In");
			 
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 		+ "The dog has been defeated");
				 hpLabele.setText("HP: " + 0);
				 hpLabelp.setText("HP: " + player.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 position="continue";
				
		 }
	 }
	 
	 public void ogreFight(){
		 
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 enemyPanel.setVisible(true);
		 
		 ogre.setHealth(ogre.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - ogre.getWeaponDamage());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.remove(mainTextArea);
		 
		 if(player.getHealth() <= 0){
			 hpLabelp.setText("HP: "+ogre.getHealth());
			 nextButtonPanel.setVisible(false);
			 lose();
			 position = " ";
		 }
		 else if(ogre.getHealth()>0){
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The ogre did "+ ogre.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: "+ogre.getHealth());
			 hpLabelp.setText("HP: "+player.getHealth());
			 mainTextPanel.setBounds(100,100,600,150);
			 mainTextPanel.add(mainTextArea);
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 		+ "The ogre has been defeated");
				 hpLabele.setText("HP: "+0);
				 hpLabelp.setText("HP: "+player.getHealth());
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea); 
				 
				 position = "ogreWin";
		 }
	 }
	 
	 public void knightStory(){
		
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 mainTextPanel.remove(mainTextArea);
		 
		 mainTextArea.setText("\"Thank you for helping me. Seeing you go on your\nknighthood has reminded me of mine "
			 		+ "with a fellow knight. This \nsword was my friend's he never made it past the ogre up\nahead. Will you"
			 		+ " please take this sword and bring it to the \nknighthood\"");
				 mainTextPanel.setBounds(100,100,600,150);
				 mainTextPanel.add(mainTextArea);
				 mainTextPanel.setVisible(true);
				  
		position = "continue";
	 }
	 
	 public void lose(){//if player dies
		 nextButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 enemyPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 titleNamePanel.setVisible(true);
		 
		 titleNamePanel.remove(titleName);
		 
		 titleNamePanel.setBounds(100,100,600,150);
		 titleNamePanel.setBackground(Color.black);//color of background
		 titleName = new JLabel("You Died");
		 titleName.setForeground(Color.white);//color of text
		 titleName.setFont(titleFont);
		 titleNamePanel.add(titleName);
		 
		 startOverButton = new JButton("START OVER");
		 startOverButton.setBackground(Color.black);
		 startOverButton.setForeground(Color.white);
		 startOverButton.setFont(buttonFont);
		 startOverButton.addActionListener(startOverHandler);
		 startOverButton.setFocusPainted(false);
		 
		 startOverPanel = new JPanel();
		 startOverPanel.setBounds(300,400,225,65);
		 startOverPanel.setBackground(Color.black);
		 startOverPanel.setVisible(true);
		 startOverPanel.add(startOverButton);
		 con.add(startOverPanel);
		 position=" "; 
	
	 }
	 
	 public void nextPage(){
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
 						player.setHealth(player.getHealth() + 15);
 						hpLabelp.setText("HP: " + player.getHealth());
 					
 						position = "bigTreeText";
 						mainTextPanel.setVisible(true);
 						break;
 				
 					case "bigTreeText":
 					
 						mainTextArea.setText("You continue on and encounter a big oak tree with a"
 					 		+ "long\nsword stuck in it. You tug on it but it is stuck in the tree real\ngood.\n"
 					 		+ "Then a short stubby man comes out from behind the tree");
 						mainTextPanel.setBounds(100,100,600,150);
 						mainTextPanel.add(mainTextArea);
 						mainTextPanel.setVisible(true);
 						position = "bigTree";
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
 								+ "and \nthere is an ogre standing there with a big battle axe and he \ncharges straight at you.");
 							 mainTextPanel.setBounds(100,100,600,150);
 							 mainTextPanel.add(mainTextArea);
 							 mainTextPanel.setVisible(true);
 							  
 							 enemyLabel.setText(ogre.getType());
 							 weaponLabele.setText("Weapon: " + ogre.getWeaponName());
 							 hpLabele.setText("HP: " + ogre.getHealth());
 							 position = "ogreFight";
 							 break;
 							 
 					case "ogreFight":
 						ogreFight();
 						break;
 						
 					case "ogreWin":
 						mainTextArea.setText("Now your journey is finished and you travel to Yullie Town");
 							 mainTextPanel.setBounds(100,100,600,150);
 							 mainTextPanel.add(mainTextArea);
 							 mainTextPanel.setVisible(true);
 						position = "town";
 					break;
 					
 					case "town":
 						 nextButton.setVisible(false);
 						 nextButtonPanel.setVisible(false);
 						
 						 mainTextArea.setText("As you enter Yullie Town you are greeted with excitement because"
 								+ " you have just finihed your knighthood. \nCongratulations!!");
						 mainTextPanel.setBounds(100,100,600,150);
						 mainTextPanel.add(mainTextArea);
						 mainTextPanel.setVisible(true);
						 
						 startOverButton = new JButton("START OVER");
						 startOverButton.setBackground(Color.black);
						 startOverButton.setForeground(Color.white);
						 startOverButton.setFont(buttonFont);
						 startOverButton.addActionListener(startOverHandler);
						 startOverButton.setFocusPainted(false);
						 
						 startOverPanel = new JPanel();
						 startOverPanel.setBounds(300,400,225,65);
						 startOverPanel.setBackground(Color.black);
						 startOverPanel.setVisible(true);
						 startOverPanel.add(startOverButton);
						 con.add(startOverPanel);
						 position=" "; 
 					break;
				}	
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
		 					
		 				case "dogfight":
		 					switch(yourChoice){
		 						case "c1":
		 							dogFight();
		 							break;
		 						case "c2":
		 							knightStory();
		 							break;
		 					}
		 					break;
		 			
		 				case "helpLost":
		 					switch(yourChoice){
		 					case "c1":
		 						knightStory();
		 						break;
		 					case "c2":
		 						 enemyLabel.setText(dog.getType());
		 						 weaponLabele.setText("Weapon: " + dog.getWeaponName());
		 						 hpLabele.setText("HP: " + dog.getHealth());
		 						dogFightBegin();
		 						break;
		 					}
		 					break;
		 			}	
		 	}
	 }
}