import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class IceCreamLine extends JPanel {
	
	private QueueLL<IceCreamCone> displayLine;
	private QueueLL<IceCreamCone> tempLine;
	private JPanel boxPanel;
	private BoxLayout boxLayout;

	/**
	 * sets the layout in the constructor
	 */
	public IceCreamLine() {
		displayLine= new QueueLL<IceCreamCone>();
		tempLine= new QueueLL<IceCreamCone>();
		boxLayout= new BoxLayout(this, BoxLayout.Y_AXIS);
		this.setLayout(boxLayout);
		
	}
	
	
	/**
	 * adds icecreams with random scoops to the queue
	 */
	public void generateRandomIceCream()
	{
		IceCreamCone cone= new IceCreamCone();
		int numScoops= (int) (Math.random()*4);
		for(int i=0; i<numScoops+1; i++)
		{
			cone.addScoop();
		}
		
		displayLine.enqueue(cone);
		displayConeLine();
		validate();
		repaint();
	}
	
	/**
	 * adds the icecream to the box layout using two queues
	 */
	public void displayConeLine()
	{
		while(!displayLine.isEmpty())
		{
			tempLine.enqueue(displayLine.dequeue());;
		}
		
		while(!tempLine.isEmpty())
		{
			IceCreamCone iceCream= tempLine.dequeue();
			this.add(iceCream);
			displayLine.enqueue(iceCream);
		}
		
		
	}
	
	/**
	 * removes the first icecream from the queue
	 */
	public void removeOrder()
	{
		displayLine.dequeue();
		this.removeAll();
		displayConeLine();
		validate();
		repaint();
		
	}
	
	/**
	 * gets the display line
	 * @return
	 */
	public QueueLL<IceCreamCone> getDisplayLine()
	{
		return displayLine;
	}
	
	
}
