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
	
	JFrame window = new JFrame();
	Container con;
	JPanel titleNamePanel, shopPanel, startOverPanel, startButtonPanel, mainTextPanel,choiceButtonPanel,nextButtonPanel, playerPanel, enemyPanel;
	JLabel titleName, hpLabelp, weaponLabelp,hpLabele, weaponLabele,enemyLabel, coinsLabel;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
	JButton startButton, nextButton,choice1,choice2,choice3,choice4, bronzeWeapon, woodenWeapon, silverWeapon, diamondWeapon, apple, leaveShop;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
	Font textFont = new Font("Times New Roman", Font.PLAIN, 25);
	Font choiceFont = new Font("Times New Roman", Font.PLAIN, 22);
	JTextArea mainTextArea = new JTextArea();
	String nextPosition;// for where the next button should go next
	
	Character player = new Character("Player");// player object
	Character bandit = new Character("Bandit");// bandit enemy
	Character dog = new Character("Big Dog");// Big Dog enemy
	Character ogre = new Character("Ogre"); // Ogre enemy
	
	startScreenHandler startHandler = new startScreenHandler();
	mainGameScreenHandler mainGameHandler = new mainGameScreenHandler();
	choiceButtonHandler choiceHandler = new choiceButtonHandler();
	nextButtonHandler nextHandler = new nextButtonHandler();
	startOverScreenHandler startOverHandler = new startOverScreenHandler();
	shopHandler shopHandler = new shopHandler();
	
	 public static void main(String[] args){
		new Game();
	 } 
	 
	 public Game(){
		 //creates game window
		 window.setSize(800,600);
		 window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 window.getContentPane().setBackground(Color.black);
		 window.setLayout(null);
		 con = window.getContentPane();
		 
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
		 
		 mainTextArea.setBounds(50,50,700,400);
		 mainTextArea.setBackground(Color.black);
		 mainTextArea.setForeground(Color.white);
		 mainTextArea.setFont(textFont);
		 mainTextArea.setLineWrap(true);
		 mainTextArea.setEditable(false);
		 mainTextPanel.setVisible(false);
		 
		 con.add(mainTextPanel);
		 con.add(titleNamePanel);
		 con.add(startButtonPanel);
		 window.setVisible(true);
		
	 }
	 
	 private void createGameScreen(){//first game screen
		 mainTextPanel.setVisible(true);
		 titleNamePanel.setVisible(false);
		 
		 mainTextPanel.setBounds(50,50,700,400);
		 
		 mainTextArea.setText("Every new knight has to go through a knighthood "
		 		+ "where they\nadventure out into the world on their own, so you set off "
		 		+ "to begin\nyour journey out of your own kingdom that you have lived in your\n"
		 		+ " entire life until you reach your knighthood town, Yullie.");

		 mainTextPanel.add(mainTextArea);
		 
		 startButtonPanel.remove(startButton);
		 
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
	 
	 private void mainGame(){//first  battle scene
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 
		 playerPanel = new JPanel();
		 playerPanel.setBounds(100,10,600,50);
		 playerPanel.setBackground(Color.black);
		 playerPanel.setLayout(new GridLayout(1,3));
		 con.add(playerPanel);
		 
		 hpLabelp = new JLabel("HP: " + player.getHealth());
		 hpLabelp.setFont(textFont);
		 hpLabelp.setForeground(Color.white);
		 playerPanel.add(hpLabelp);
		 
		 coinsLabel = new JLabel("Coins: " + player.getCoins());
		 coinsLabel.setFont(textFont);
		 coinsLabel.setForeground(Color.white);
		 playerPanel.add(coinsLabel);
		 
		 weaponLabelp = new JLabel("Weapon: " + player.getWeaponName());
		 weaponLabelp.setFont(textFont);
		 weaponLabelp.setForeground(Color.white);
		 playerPanel.add(weaponLabelp);
		 
		 enemyPanel = new JPanel();
		 enemyPanel.setBounds(100,250,600,50);
		 enemyPanel.setBackground(Color.black);
		 enemyPanel.setLayout(new GridLayout(1,3));
		 con.add(enemyPanel);
		 
		 enemyLabel = new JLabel(bandit.getType());
		 enemyLabel.setFont(textFont);
		 enemyLabel.setForeground(Color.white);
		 enemyPanel.add(enemyLabel);
		 
		 hpLabele = new JLabel("HP: " + bandit.getHealth());
		 hpLabele.setFont(textFont);
		 hpLabele.setForeground(Color.white);
		 enemyPanel.add(hpLabele);
		 
		 weaponLabele = new JLabel("Weapon: " + bandit.getWeaponName());
		 weaponLabele.setFont(textFont);
		 weaponLabele.setForeground(Color.white);
		 enemyPanel.add(weaponLabele);
		 
		 mainTextPanel.setVisible(true);
		 
		 mainTextArea.setText("Right out of the castle you encounter a bandit that likes to\ntarget innocents.\n"
		 		+ "\"Give me all your money or die\" he says.\n"
		 		+ "What do you do? He looks weak.");
		 
		 mainTextPanel.setBounds(100,100,800,150);
		 
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
		 
		 nextPosition = "attack"; 
	 }
	 
	 private void attack(){
		 nextPosition = "attack";
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(true);
		 
		 bandit.setHealth(bandit.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - bandit.getWeaponDamage());//when enemy attacks
		 
		 if(bandit.getHealth()>0){//if enemy has not been defeated
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The bandit did " + bandit.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: " + bandit.getHealth());//shows new stats
			 hpLabelp.setText("HP: " + player.getHealth());//shows new stats
			 mainTextPanel.setBounds(150,100,800,150);
		 }else{
				 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 		+ "The bandit has been defeated");
				 hpLabele.setText("HP: " + 0);
				 hpLabelp.setText("HP: " + player.getHealth());
				 mainTextPanel.setBounds(150,100,800,150);
				 
				 nextPage();
				 
				 nextPosition = "banditPlayerWin";
		 }
	}
	 
	 private void giveUp(){
		 titleNamePanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 enemyPanel.setVisible(false);
		 mainTextPanel.setVisible(true);
		 
		 mainTextArea.setText("The bandit takes all your stuff and says, \"Wow a bronze\nsword now I can win more fights.\"\n"
		 		+ "The bandit throws his wooden sword to the ground and\nleaves with your stuff.\n"
		 		+ "You now continue on with your journey with only a\nwooden sword.");
		 
		 mainTextPanel.setBounds(100,100,800,175);
		 
		 player.setWeapon("Wooden Sword");
		 player.setCoins(player.getCoins() - 5);
		 coinsLabel.setText("Coins: " + player.getCoins());
		 weaponLabelp.setText("Weapon: " + player.getWeaponName());
		 
		 nextPage();
		 
		 nextPosition="bigTree";
		 
	 }
	 
	 private void play(){
		 enemyPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 
		 Random rand = new Random();
		 int nump = 0;
		 int nume = 0;
		
		 while(nump == nume){//rerolls if user and old man roll the same number
			 nump = rand.nextInt(6);
			 nume = rand.nextInt(6);
			 //there is no 0 on dice so I change it to a 6 instead
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
					 +"\nYou win and the old man easily pulls out the sword\nfrom the tree and hands you the sword.\n"
					 + "\"I know we had a deal anyway but would you mind\nhelping me still\"the old man askes.");
			mainTextPanel.setBounds(80,100,800,195);
			mainTextPanel.setVisible(true);
				
			nextPosition="helpWin";
				 
			player.setWeapon("Silver Sword");
			weaponLabelp.setText(player.getWeaponName());
				
		 }
		 else{//if player loses
			 choiceButtonPanel.setVisible(true);
			 mainTextArea.setText("You rolled a " + nump + ".\nThe old man rolled a " + nume + ".\nWelp a deal is a deal right?");
			 mainTextPanel.setVisible(true);
			 nextPosition="helpLost";
				 
			choice1.setText("Stick to Deal");
			choice2.setText("Break Deal");
		 }
		 
	 }
	 
	 private void dogFightBegin(){
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 
		 enemyLabel.setText(dog.getType());
		 weaponLabele.setText("Weapon: " + dog.getWeaponName());
		 hpLabele.setText("HP: " + dog.getHealth());
		 
		 mainTextArea.setText("\"I do not like deal breakers and neither does my dog\" says\nthe old man\n"
		 		+ "A big dog emerges from behind the tree and barks very\nloudly and shows off his big sharp teeth");
		 mainTextPanel.setVisible(true);
			 
		 nextPosition="dogFight";
	 }
	 
	 private void dogFight(){
		
		 enemyPanel.setVisible(true);
		 choiceButtonPanel.setVisible(true);
		 
		 dog.setHealth(dog.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - dog.getWeaponDamage());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 
		 if(dog.getHealth()>0){
			 nextPosition="dogfight";
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The dog did " + dog.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: " + dog.getHealth());
			 hpLabelp.setText("HP: " + player.getHealth());
			 
			 choice1.setText("Attack");
			 choice2.setText("Give In");
			 
		 }
		 else{
			 	 choiceButtonPanel.setVisible(false);
				 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 		+ "The dog has been defeated");
				 hpLabele.setText("HP: " + 0);
				 hpLabelp.setText("HP: " + player.getHealth());
				 
				 nextPosition = "bernardTown";
		 }
	 }
	 
	 private void ogreFight(){
		 
		 enemyPanel.setVisible(true);
		 
		 enemyLabel.setText(ogre.getType());
		 weaponLabele.setText("Weapon: " + ogre.getWeaponName());
		 hpLabele.setText("HP: " + ogre.getHealth());
		 
		 ogre.setHealth(ogre.getHealth() - player.getWeaponDamage());//when player attacks
		 player.setHealth(player.getHealth() - ogre.getWeaponDamage());//when enemy attacks
		 mainTextPanel.setVisible(true);
		 mainTextPanel.setBounds(25,100,800,150);
		 
		 if(player.getHealth() <= 0){
			 hpLabelp.setText("HP: " + ogre.getHealth());
			 nextButtonPanel.setVisible(false);
			 lose();
			 nextPosition = " ";
		 }
		 else if(ogre.getHealth()>0){
			 mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
		 		+ "The ogre did "+ ogre.getWeaponDamage() + " damage to you");
			 hpLabele.setText("HP: " + ogre.getHealth());
			 hpLabelp.setText("HP: " + player.getHealth());
		 }
		 else{
			choiceButtonPanel.setVisible(false);
			mainTextArea.setText("You did " + player.getWeaponDamage() + " damage to the enemy\n"
				 	+ "The ogre has been defeated");
			hpLabele.setText("HP: " + 0);
			hpLabelp.setText("HP: " + player.getHealth());
				 
			nextPosition = "ogreWin";
		 }
	 }
	 
	 private void knightStory(){
		
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(true);
		 choiceButtonPanel.setVisible(false);
		 
		 mainTextArea.setText("\"Thank you for helping me. Seeing you go on your\nknighthood has reminded me of mine "
			 		+ "with a fellow knight.\nThis sword was my friend's he never made it past the\nogre up ahead. Will you"
			 		+ " please take this sword and bring\nit to the knighthood.\"\n Here are some extra coins.");
		mainTextPanel.setVisible(true);
		mainTextPanel.setBounds(80,100,800,230);
		player.setCoins(player.getCoins() + 5);
		coinsLabel.setText("Coins: " + player.getCoins());
				  
		nextPosition = "bernardTown";
	 }
	 
	 private void bernardTown(){
		 nextButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(true);
		 
		 mainTextArea.setText("As you contiue on your journey you encounter the town of Bernard.\n"
				 + "You walk on through until you encounter a weapon shop.\n"
				 + "This is a good opportunity to get a new sword.\n"
				 +"Do you want to enter the shop or continue on?");
		 
		 choice1.setText("Enter Shop");
		 choice2.setText("Continue On"); 
	 }
	 
	 private void shop(){
		 mainTextPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 enemyPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 titleNamePanel.setVisible(false);
		 startButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 
		 shopPanel = new JPanel();
		 shopPanel.setBounds(50, 60, 700, 400);
		 shopPanel.setBackground(Color.black);
		 shopPanel.setLayout(new GridLayout(2,2));
		 con.add(shopPanel);
		 
		 woodenWeapon = new JButton("Wooden Sword-5c");
		 woodenWeapon.setBackground(Color.black);
		 woodenWeapon.setForeground(Color.white);
		 woodenWeapon.setFont(choiceFont);
		 
		 woodenWeapon.setFocusPainted(false);
		 woodenWeapon.addActionListener(shopHandler);
		 woodenWeapon.setActionCommand("Wooden Sword");
		 shopPanel.add(woodenWeapon);
		 
		 bronzeWeapon = new JButton("Bronze Sword-10c");
		 bronzeWeapon.setBackground(Color.black);
		 bronzeWeapon.setForeground(Color.white);
		 bronzeWeapon.setFont(choiceFont);
		 
		 bronzeWeapon.setFocusPainted(false);
		 bronzeWeapon.addActionListener(shopHandler);
		 bronzeWeapon.setActionCommand("Bronze Sword");
		 shopPanel.add(bronzeWeapon);
		 con.add(shopPanel);
		 
		 silverWeapon = new JButton("Silver Sword");
		 silverWeapon.setBackground(Color.black);
		 silverWeapon.setForeground(Color.white);
		 silverWeapon.setFont(choiceFont);
		 
		 silverWeapon.setFocusPainted(false);
		 silverWeapon.addActionListener(shopHandler);
		 silverWeapon.setActionCommand("Silver Sword-15c");
		 shopPanel.add(silverWeapon);
		 
		 diamondWeapon = new JButton("Diamond Sword-17c");
		 diamondWeapon.setBackground(Color.black);
		 diamondWeapon.setForeground(Color.white);
		 diamondWeapon.setFont(choiceFont);
		 
		 diamondWeapon.setFocusPainted(false);
		 diamondWeapon.addActionListener(shopHandler);
		 diamondWeapon.setActionCommand("Diamond Sword");
		 shopPanel.add(diamondWeapon);
		 
		 apple = new JButton("Apple-5c");
		 apple.setBackground(Color.black);
		 apple.setForeground(Color.white);
		 apple.setFont(choiceFont);
		 
		 apple.setFocusPainted(false);
		 apple.addActionListener(shopHandler);
		 apple.setActionCommand("Apple");
		 shopPanel.add(apple);
		 
		 leaveShop = new JButton("Leave Shop");
		 leaveShop.setBackground(Color.black);
		 leaveShop.setForeground(Color.white);
		 leaveShop.setFont(choiceFont);
		 
		 leaveShop.setFocusPainted(false);
		 leaveShop.addActionListener(shopHandler);
		 leaveShop.setActionCommand("Leave Shop");
		 shopPanel.add(leaveShop);
		 con.add(shopPanel);
		
	 }
	 
	 private void lose(){//if player dies
		 nextButtonPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 enemyPanel.setVisible(false);
		 choiceButtonPanel.setVisible(false);
		 nextButtonPanel.setVisible(false);
		 mainTextPanel.setVisible(false);
		 titleNamePanel.setVisible(true);
		 startButtonPanel.setVisible(true);
		 
		 titleNamePanel.remove(titleName);
		 
		 titleNamePanel.setBounds(100,100,600,150);
		 titleNamePanel.setBackground(Color.black);//color of background
		 titleName = new JLabel("You Died");
		 titleName.setForeground(Color.white);//color of text
		 titleName.setFont(titleFont);
		 titleNamePanel.add(titleName);
		 
		 startButton.setText("START OVER");
		 startButton.addActionListener(startOverHandler);

		 nextPosition=" "; 
	 }
	 
	 private void nextPage(){
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
		 		window.dispose();
		 		new Game();
		 	}
	 }
	 
	 public class nextButtonHandler implements ActionListener{
		 	public void actionPerformed(ActionEvent event){
		 		enemyPanel.setVisible(false);
		 		switch(nextPosition){
		 		
 					case "banditPlayerWin":
 						
 						mainTextArea.setText("Wow that was easy but you did take some damage\n"
 							+ "You see a health potion and some coins next to him and\npick it up"
 							+ "You gained 10 health");
 						mainTextPanel.setBounds(100,100,800,150);
 						player.setCoins(player.getCoins() + 7);
 						coinsLabel.setText("Coins: " + player.getCoins());
 						player.setHealth(player.getHealth() + 10);
 						hpLabelp.setText("HP: " + player.getHealth());
 					
 						nextPosition = "bigTree";
 						break;
 				
 					case "bigTree":
 					
 						mainTextArea.setText("You continue on and encounter a big oak tree with a"
 					 		+ "long\nsword stuck in it. You tug on it but it is stuck in the tree real\ngood.\n"
 					 		+ "Then a short stubby man comes out from behind the tree");
 						nextPosition = "oldMan";
 						break;
 					
 					case "oldMan":
 						 enemyPanel.setVisible(false);
 						 nextButtonPanel.setVisible(true);
 						 choiceButtonPanel.setVisible(false);
 						 
 						 mainTextArea.setText("\"Hello, would you mind spending some time with an old man\nto pass some time. "
 						 		+ "I have some dice if you win I will give\nyou the sword\n"
 						 		+ "If I win you have to help me with a task.\" says the old man.\n"
 						 		+ "You decide to play the game so you can get the sword.");
 						 mainTextPanel.setBounds(25,100,800,150);
 						 
 						 nextPosition="play";
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
 						
 					case "bernardTown":
 						bernardTown();
 						break;
 						
 					case "ogreFightBegin":
 						mainTextArea.setText("You continue on until you find a tower. You walk in "
 								+ "and \nthere is an ogre standing there with a big battle axe and he \ncharges straight at you.");
 							  
 						nextPosition = "ogreFight";
 						break;
 							 
 					case "ogreFight":
 						ogreFight();
 						break;
 						
 					case "ogreWin":
 						mainTextArea.setText("Now your journey is finished and you travel to Yullie Town");
 						mainTextPanel.setBounds(50,100,800,150);
 						nextPosition = "town";
 					break;
 					
 					case "town":
 						nextButton.setVisible(false);
 						nextButtonPanel.setVisible(false);
 						startButtonPanel.setVisible(true);
 						
 						 mainTextArea.setText("As you enter Yullie Town you are greeted with excitement\nbecause"
 								+ " you have just finihed your knighthood. \nCongratulations!!");
						 
						 startButton.setText("START OVER");
						 startButton.addActionListener(startOverHandler);
						 
						 nextPosition=" "; 
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
		 		
		 			switch(nextPosition){
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
		 						dogFightBegin();
		 						break;
		 					}
		 					break;
		 					
		 				case "bernardTown":
		 					switch(yourChoice){
		 					case "c1":
		 						shop();
		 						break;
		 					case "c2":
		 						choiceButtonPanel.setVisible(false);
		 						nextButtonPanel.setVisible(true);
		 						mainTextArea.setText("You continue on until you find a tower. You walk in "
		 								+ "and \nthere is an ogre standing there with a big battle axe and he \ncharges straight at you.");
		 							  
		 						nextPosition = "ogreFight";
		 						break;
		 					}
		 			}	
		 	}
	 }
	 
	 public class shopHandler implements ActionListener{
		 public void actionPerformed(ActionEvent event){
			 	
		 		String yourChoice = event.getActionCommand();
		 		Weapon choice = new Weapon(yourChoice);
		 		if((player.getWeaponValue() >= choice.getValue()) || player.getWeaponValue() >= 5){
				 	shopPanel.setVisible(false);
				 	mainTextPanel.setVisible(true);
				 	nextButtonPanel.setVisible(true);
		 			if(yourChoice.equals("Apple")){			
		 				mainTextArea.setText("You just purchased a apple and ate it. You gained 5 health.");
		 				player.setHealth(player.getHealth() + 5); 
		 				hpLabelp.setText("HP: " + player.getHealth());
		 				player.setCoins(player.getCoins() - 5);
		 				coinsLabel.setText("Coins: " + player.getCoins());
		 			}
		 			else if(yourChoice.equals("Leave Shop")){
		 				mainTextArea.setText("Just browsed. You didn't purchase anything you.");
		 			}
		 			else if(choice.getName().equals(player.getWeaponName())){
		 				mainTextArea.setText("Don't know why you would buy the same weapon but I guess this\none is shinier.");
		 			}
		 			else if(choice.getDamage() > player.getWeaponDamage()){
		 				mainTextArea.setText("Good choice. You now own a " + choice.getName() + "\nand do " +
		 							choice.getDamage() + " Damage.");
		 				player.setWeapon(yourChoice); 
		 				weaponLabelp.setText("Weapon: " + player.getWeaponName());
		 				player.setCoins(player.getCoins() - choice.getValue());
		 				coinsLabel.setText("Coins: " + player.getCoins());
		 			}
		 			else if(choice.getDamage() < player.getWeaponDamage()){
		 				mainTextArea.setText("You just down graded. You now own a " + choice.getName() + "\nand do " +
		 							choice.getDamage() + " Damage.");
		 				player.setWeapon(yourChoice); 
		 				weaponLabelp.setText("Weapon: " + player.getWeaponName());
		 				player.setCoins(player.getCoins() - choice.getValue());
		 				coinsLabel.setText("Coins: " + player.getCoins());
		 			}
		 		}

		 		nextPosition = "ogreFightBegin";
		 }
	 }
}