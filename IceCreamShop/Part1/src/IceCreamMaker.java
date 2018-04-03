
// swing 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

//awt
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class IceCreamMaker extends JPanel {
	
	private IceCreamCone cone;
	
	/**
	 * constructor sets the border layout
	 */
	public IceCreamMaker ()
	{
		cone= new IceCreamCone();
	}
	
	
	/**
	 * creates the buttons for the flavors
	 * @return
	 */
	private JPanel createFlavorPanel() 
    {
		
		
    	// Create a panel to hold GUI elements
		JPanel flavorPanel = new JPanel();
		flavorPanel.setLayout(new GridLayout(1,4));

		JButton vanillaButton = new JButton( "vanilla" );
		vanillaButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			    cone.addScoop("vanilla");
			    repaint();
			}
		    });
		
		JButton strawberryButton = new JButton( "strawberry" );
		strawberryButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				cone.addScoop("strawberry");
				repaint();
				
			}
		    });
		
		JButton teaButton = new JButton( "green tea" );
		teaButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				cone.addScoop("green tea");
				repaint();
			}
		    });
		
		JButton caramelButton = new JButton( "burnt caramel" );
		caramelButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				cone.addScoop("burnt caramel");
				repaint();
			}
		    });

		/**
		 * adds according to the layout
		 */
		flavorPanel.add( vanillaButton );
		flavorPanel.add( strawberryButton );
		flavorPanel.add( teaButton );
		flavorPanel.add( caramelButton );

		return flavorPanel;
    }
	
	/**
	 * creates the panel to be added to the frame
	 * @return
	 */
	public JPanel createNorthPanel()
	{
		JPanel topPanel= new JPanel();
		topPanel.setLayout(new BorderLayout());
		topPanel.add(createFlavorPanel(), BorderLayout.NORTH);
		
		JButton trashButton = new JButton( "trash the top scoop!" );
		trashButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				cone.trashScoop();
			}
		    });
		JPanel tempPanel= new JPanel();
		tempPanel.add(trashButton);
		topPanel.add(tempPanel, BorderLayout.SOUTH);
		
		return topPanel;
		
	}
	
	/** 
	 * getter for the cone
	 * @return
	 */
	public JPanel createDisplayPanel()
	{
		JPanel displayPanel= new JPanel();
		displayPanel.setLayout(new BorderLayout());
		displayPanel.add(createNorthPanel(), BorderLayout.NORTH);
		displayPanel.add(cone, BorderLayout.CENTER);
		//repaint();
		return displayPanel;
		
	}


	public static void main(String[] args) {
		
		IceCreamMaker maker= new IceCreamMaker();
		
		
		JFrame guiFrame = new JFrame( "Sumatra's Ice Cream Maker");
		
		guiFrame.setSize( 800, 800 );

		guiFrame.add( maker.createDisplayPanel() );

		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		guiFrame.setVisible( true );

	}
	
	

}
