import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
* TreeCollagePanel is a JPanel. It will hold all the 
* seasonal TreePaintings we want to display. It uses
* a GridLayout to specify how they are arranged in the GUI.
* 
*/
public class TreeCollagePanel extends JPanel
{
	 private JLabel instructions;
	 private JPanel mainCollagePanel;
 	 


	 /**
	  * Calls super (the superclass constructor) and sets a BorderLayout.
	  * 
	  * In the NORTH region, adds 'instructions', a JLabel, that will 
	  * display the instructions.
	  * 
	  * In the CENTER panel, adds 'mainCollagePanel', a JPanel, that will
	  * be organized with a GridLayout to hold a basic TreePainting object
	  * plus each of the four seasonal TreePainting subclass objects:
	  * WinterTreePainting, SpringTreePainting, SummerTreePainting, 
	  * FallTreePainting.
	  * 
	  */


	 public TreeCollagePanel(String instructionsText)
	 {
		 super(new BorderLayout());


		 
		 mainCollagePanel= new JPanel( new GridLayout(1,5));
		 mainCollagePanel.add(new TreePainting());
		 mainCollagePanel.add(new WinterTreePainting());
		 mainCollagePanel.add(new SpringTreePainting());
		 mainCollagePanel.add(new SummerTreePainting());
		 mainCollagePanel.add(new FallTreePainting());
		 add (mainCollagePanel, BorderLayout.CENTER);

		instructions = new JLabel(instructionsText);
		instructions.setHorizontalAlignment(JLabel.CENTER);
		add( instructions, BorderLayout.NORTH );
	 

	 	 /* unfinished */

		 /* YOUR CODE HERE */








		 
	 }
}