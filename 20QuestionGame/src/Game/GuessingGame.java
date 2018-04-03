package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DataStructures.BinaryTree;
import DataStructures.BinaryTreeNode;
import DataStructures.DefaultBinaryTree;
import DataStructures.DefaultBinaryTreeNode;
import DataStructures.LinkedListNode;
import DataStructures.LinkedList;

import XMLfile.XMLReader;


public class GuessingGame extends JPanel implements ActionListener {
	
	private BinaryTree<String> guessingGame;
	private BinaryTreeNode<String> gameNode;
	private JLabel questionPanel= new JLabel();
	private JPanel firstScreen= new JPanel();
	private JPanel secondScreen= new JPanel();

	
	
	public GuessingGame () {
		
		/**
		 * reads the xml file
		 * creates a binary tree called guessing game
		 * stores the xml binary tree in it
		 * the binary tree node gameNode is set to root
		 */
		XMLReader tr = new XMLReader("greys_anatomy.xml");
		guessingGame= new DefaultBinaryTree<String>();
		guessingGame = tr.buildGameTree();
		gameNode= new DefaultBinaryTreeNode<String>();
		gameNode=guessingGame.getRoot();
		
		/**
		 * stores the first and second screens
		 */
		firstScreen= createFirstScreen();
		secondScreen= createSecondScreen();
		
		/**
		 * add them to the main panel
		 * but makes first visible and second invisible
		 */
		this.add(firstScreen).setVisible(true);
		this.add(secondScreen).setVisible(false);
		
		
	}
	
	/**
	 * calls the recursive createlist() and passes it the root and a new linked list
	 * @return
	 */
	public LinkedList<String> createList()
	{
		LinkedList<String> list= new LinkedList<String>();
		BinaryTreeNode<String> tempNode= guessingGame.getRoot(); 
		return createList(tempNode, list);
	}
	
	/**
	 * its the recursive method that returns the linked list
	 * @param tempNode
	 * @param list
	 * @return
	 */
	private LinkedList<String> createList(BinaryTreeNode<String> tempNode, LinkedList<String> list)
	{
		/**
		 * if the node is null it returns the null linkedlist
		 */
		if(tempNode==null)
		{
			return list;
		}
		/**
		 * if the node doesnt have child it enters its data into the linked list
		 */
		if(tempNode.isLeaf())
		{
			list.insertLast(tempNode.getData());
		}
		
		/**
		 * progresses through the tree
		 */
		createList(tempNode.getLeftChild(), list);
		createList(tempNode.getRightChild(), list);
		
		/**
		 * returns the list
		 */
		return list;
		
	}

	public JPanel createCentrePanel()
	{
		/**
		 * it takes the node from the linked list
		 * print the data into a new JLabel
		 * adds them to the JPanel
		 * returns the JPanel
		 */
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(9,2));
		
		 LinkedList<String> list= createList();
		 LinkedListNode<String> node= list.getFirstNode();
		 
		 while(node!=null)
		 {
			 buttonPanel.add(new JLabel(node.getData()));
			 node= node.getNext();		 
		 }
		
		return buttonPanel;
		
	}
	
	/**
	 * creates the first screen
	 * sets it to borderlayout
	 * adds a JLabel to north
	 * calls createCentrePanel() which return a JPanel to be added to the centre
	 * calls createStartButton() which returns a JButton to be added to the south
	 * @return
	 */
	public JPanel createFirstScreen()
	{
		JPanel Screen= new JPanel();
		JLabel text= new JLabel(" Please choose one of the character from the list");
		Screen.setLayout(new BorderLayout());
		Screen.add(text, BorderLayout.NORTH);
		Screen.add(createCentrePanel(), BorderLayout.CENTER);
		Screen.add(createStartButton(), BorderLayout.SOUTH );
		return Screen;
	}
	
	/**
	 * creates the start button
	 * @return
	 */
	public JButton createStartButton()
	{
		JButton startButton = new JButton( "START!" );
		startButton.addActionListener(this);
		
		return startButton;
		
	}
	
	/**
	 * creates the restart button which calls the restart method
	 * @return
	 */
	public JButton createRestartButton()
	{
		JButton restartButton = new JButton( "RESTART!" );
		
		
		restartButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				restartGame();
			    
			}
		    });
		
		return restartButton;
		
	}
	
	/**
	 * returns a JPanel to be added to the north and south of the border layout
	 * @return JPanel
	 */
	public JPanel createButtonFrame()
	{
		JPanel panel= new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(createButtonPanel(), BorderLayout.NORTH);
		panel.add(createRestartButton(), BorderLayout.SOUTH);
		return panel;
	}
	
	/**
	 * restart method() resets the screen to the first screen
	 * rests the gameNode to the root of the tree
	 * repaints the JPanel
	 */
	public void restartGame()
	{
		firstScreen= createFirstScreen();
		gameNode=guessingGame.getRoot();
		secondScreen= createSecondScreen();
		this.removeAll();
		this.add(firstScreen).setVisible(true);
		this.add(secondScreen).setVisible(false);
		
		revalidate();
		repaint();
		
	}
	
	
	/**
	 * sets the first screen to invisible and second screen to visible
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("i am in");
		firstScreen.setVisible(false);
		secondScreen.setVisible(true);
		validate();
		repaint();
		
	}
	
	/**
	 * creates a JPanel
	 * adds the yes and no buttons
	 * @return JPanel
	 */
	public JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,4));
		

		/**
		 * sets the 'no' button
		 */
		JButton noButton = new JButton( "no" );
		noButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				/**
				 * checks if the right child is not null
				 */
				if(gameNode.getRightChild()!=null)
				{
					/**
					 * if the right child is not leaf
					 * it gets the question and set it to questionPanel
					 */
					if(!gameNode.getRightChild().isLeaf())
					{
						gameNode=gameNode.getRightChild();
					    questionPanel.setText(gameNode.getData());
					}
					/**
					 * if the right child is not leaf
					 * it gets the answer
					 */
					else
					{
						gameNode=gameNode.getRightChild();
						questionPanel.setText("Is the character " + gameNode.getData() +" ?");
						return;
					}
				}
					
				/**
				 * if the right child is not null
				 * it shows dialogue boxes to input the character it was thinking, a yes/no question and the answer to the question
				 * it shows a message to display that the inout has been saved
				 * saves the node's data in the replacer
				 * saves the character in answer variable, the question in the question variable and yes/no answer in the option variable
				 */
					if(gameNode.getRightChild()==null)
					{
						JOptionPane.showMessageDialog(null,"Sorry! Game Lost! :(", "Message", JOptionPane.INFORMATION_MESSAGE);
						
					}
			    
				}
			
		    });
		
		/**
		 * creates the yes button 
		 */
		JButton yesButton = new JButton( "yes" );
		yesButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				/**
				 * checks if the left child of the node is null
				 */
				if(gameNode.getLeftChild()!=null)
				{
					/**
					 * checks if the left child is leaf or not
					 * gets the question and set it to the questionPanel
					 */
					if(!gameNode.getLeftChild().isLeaf())
					{
						gameNode=gameNode.getLeftChild();
						questionPanel.setText(gameNode.getData());
					}
					/**
					 * gets the answer
					 */
					else
					{
						gameNode=gameNode.getLeftChild();
						questionPanel.setText("Is the character " + gameNode.getData() +" ?");
						return;
					}
					
					
				}
				
				/**
				 * if the left child is null which mean sthe button is clicked after the answer is displayed 
				 * it shows a message that the game is won
				 */
				if(gameNode.getLeftChild()==null)
				{
					
					JOptionPane.showMessageDialog(null,"Yaay!! Game Won! :)", "Message", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		    });
		
		/**
		 * adds the button to the panel
		 */
		buttonPanel.add( yesButton );
		buttonPanel.add( noButton );

		return buttonPanel;
	}
	
	/**
	 * creates the secondScreen
	 * sets questionPanel to north 
	 * sets the buttonPanel to the south
	 * @return
	 */
	public JPanel createSecondScreen()
	{
		JPanel Screen= new JPanel();
		questionPanel.setText(gameNode.getData());
		Screen.setLayout(new BorderLayout());
		Screen.add(questionPanel, BorderLayout.NORTH);
		Screen.add(createButtonFrame(), BorderLayout.SOUTH);
		return Screen;
	}
	
	/**
	 * sets the frame size and label
	 * sets the frame to visible
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame guiFrame = new JFrame( "Guessing Game- Grey's Anatomy");
		
		guiFrame.setSize( 500, 500 );

		guiFrame.add( new GuessingGame() );

		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		guiFrame.setVisible( true );
		
		


	}
}
