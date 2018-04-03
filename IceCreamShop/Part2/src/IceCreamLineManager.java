
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



public class IceCreamLineManager extends JPanel {
	
	private IceCreamLine line;
	
	/**
	 * the constructor sets the layout
	 */
	public IceCreamLineManager ()
	{
		line= new IceCreamLine();
		this.setLayout(new BorderLayout());
		this.add(createSelectionPanel(), BorderLayout.NORTH);
		this.add(line, BorderLayout.CENTER);
	}
	
	/**
	 * creates the button panel
	 * @return
	 */
	private JPanel createSelectionPanel() 
    {
		
		
    	// Create a panel to hold GUI elements
		JPanel flavorPanel = new JPanel();
		flavorPanel.setLayout(new BorderLayout());

		JButton randomButton = new JButton( "Add a random order" );
		randomButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
			    line.generateRandomIceCream();
			}
		    });
		
		JButton nextButton = new JButton( "Serve the next order" );
		nextButton.addActionListener( new ActionListener() {
			public void actionPerformed( ActionEvent e )
			{
				line.removeOrder();

				
			}
		    });
		

		flavorPanel.add( randomButton, BorderLayout.NORTH );
		flavorPanel.add( nextButton, BorderLayout.SOUTH );

		return flavorPanel;
    }
	
	
	
	


	public static void main(String[] args) {
		
		
		
		JFrame guiFrame = new JFrame( "Sumatra's Ice Cream Maker");
		
		guiFrame.setSize( 800, 800 );

		guiFrame.add( new IceCreamLineManager() );

		guiFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		guiFrame.setVisible( true );

	}
	
	

}
