import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IceCreamShop extends JPanel {
	
	
	private int score=0;
	private QueueLL<IceCreamCone> queue= new QueueLL<IceCreamCone>();
	private IceCreamLineManager westPanel;
	private IceCreamMaker centrePanel;
	private JLabel scoreLabel= new JLabel();

	
	/**
	 * constructor sets out the layout 
	 */
	public IceCreamShop() {
		
		westPanel= new IceCreamLineManager();
		centrePanel= new IceCreamMaker();
		this.setLayout(new BorderLayout());
		this.add(createTopButton(), BorderLayout.NORTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(centrePanel, BorderLayout.CENTER);
	}
	
	/**
	 * compares the two icecreams to update the value
	 * @return
	 */
	private boolean compareIceCream()
	{
		StackLL<String> stack1= centrePanel.getCone().getDisplayCone();
		queue= westPanel.getLine().getDisplayLine();
		System.out.println("i am in compare1");
		
		/**
		 * checks for all the conditions that could make it false
		 */
		if(!queue.isEmpty())
		{
			IceCreamCone dequeuedCone= queue.peek();
			StackLL<String> stack2=dequeuedCone.getDisplayCone();
			if(stack1.isEmpty() || stack2.isEmpty())
			{
				System.out.println("i am in compare3");
				return false;
			}
			
			
			while((!stack1.isEmpty())&&(!stack2.isEmpty()))
			{
				if(!(stack1.pop().equals(stack2.pop())))
				{
					
					System.out.println("i am in compare4");
					return false;
				}
				
				
				
			}
			
			if(stack1.isEmpty() && stack2.isEmpty())
			{
				System.out.println("i am in compare5");
				return true;
			}
			else
			{
				System.out.println("i am in compare");
				return false;
			}
			
			
		}
		return false;
			
		
	}
	
	
	/**
	 * updates the score
	 */
	private void updateScore()
	{
		if(compareIceCream())
		{
			score+=10;
		}
		else
		{
			score-=5;
		}
		System.out.println(score);
	}
	
	
	
	
	/**
	 * creates the panel to be added to the top
	 * @return
	 */
	private JPanel createTopButton()
	{
		JPanel topPanel= new JPanel(new BorderLayout());
		JButton topButton = new JButton( "Serve the next order" );
		scoreLabel.setText("Score: " + score);
		topButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			    updateScore();
			    westPanel.getLine().removeOrder();
			    centrePanel.getCone().trashAllScoops();
			    scoreLabel.setText("Score: " + score);
			}
		    });
		
		
		
		topPanel.add(topButton, BorderLayout.SOUTH);
		topPanel.add(scoreLabel, BorderLayout.NORTH);
		
		return topPanel;
	}
	
	/**
	 * the main puts together all the component to run
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		JFrame guiFrame = new JFrame( "Sumatra's Ice Cream Shop");
		
		guiFrame.setSize( 800, 800 );

		guiFrame.add( new IceCreamShop() );

		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		guiFrame.setVisible( true );

	}

}
