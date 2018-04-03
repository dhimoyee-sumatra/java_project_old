import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;

public class IceCreamCone extends JComponent{
	
	private StackLL<String> displayCone;
	private StackLL<String> tempCone;
	private String[] flavors={"vanilla", "strawberry", "green tea", "burnt caramel"} ;
	private int[] coneX= {350, 400, 450};
	private int[] coneY= {550, 650, 550};
	private int CONE_WIDTH=40;
	private int CONE_HEIGTH=50;
	private int x;
	private int y;
	private int SCOOP_DIAMETER=45;
	
	public IceCreamCone()
	{
		super();
		displayCone= new StackLL<String>();
		tempCone= new StackLL<String>();
		
		repaint();
		
	}
	
	/**
	 * the method takes adds scoop without any constructor
	 */
	public void addScoop()
	{
		int num= (int) (Math.random()*4);
		if(num==0)
		{
			addScoop(flavors[0]);
		}
		else if(num==1)
		{
			addScoop(flavors[1]);
		}
		else if(num==2)
		{
			addScoop(flavors[2]);
		}
		else
		{
			addScoop(flavors[3]);
		}
	}
	
	/**
	 * the method that adds scoop with the flavor chosen
	 * @param chosenFlavor
	 */
	public void addScoop(String chosenFlavor)
	{
		if(chosenFlavor.equals(flavors[0]))
		{
			displayCone.push(chosenFlavor);
		}
		else if(chosenFlavor.equals(flavors[1]))
		{
			displayCone.push(chosenFlavor);
		}
		else if(chosenFlavor.equals(flavors[2]))
		{
			displayCone.push(chosenFlavor);
		}
		else if(chosenFlavor.equals(flavors[3]))
		{
			displayCone.push(chosenFlavor);
		}
		repaint();
	}
	
	private void drawCone(Graphics g)
	{
		/**
		 * declares the array for the points of the cone
		 */
		coneX= new int[3];
		coneY= new int[3];
		
		coneX[0]= getWidth()/2;
		coneY[0]= getHeight()-10;
		
		coneX[1]= coneX[0]- (CONE_WIDTH/2);
		coneY[1]= coneY[0]- CONE_HEIGTH;
		
		coneX[2]= coneX[0]+ (CONE_WIDTH/2);
		coneY[2]= coneY[0]- CONE_HEIGTH;
		g.setColor(Color.YELLOW);
		g.fillPolygon(coneX, coneY, 3);
		
	}
	
	
	/**
	 * draws the scoop
	 * @param scoopColor
	 * @param g
	 */
	private void drawScoops(Color scoopColor, Graphics g)
	{
		
		g.setColor(scoopColor);
		g.fillOval(x, y, SCOOP_DIAMETER, SCOOP_DIAMETER);
		
	}
	
	
	/**
	 * paints the jcomponent into the canvas
	 */
	public void paint(Graphics g)
	{
		drawCone(g);
		
		while(!displayCone.isEmpty())
		{
			tempCone.push(displayCone.pop());
		}
		
		x= coneX[1];
		y= coneY[1]-SCOOP_DIAMETER;
		
		while(!tempCone.isEmpty())
		{
			String flavorValue= tempCone.pop();
			
			
			
			if(flavorValue.equals(flavors[0]))
			{
				drawScoops(Color.WHITE, g);
			}
			else if(flavorValue.equals(flavors[1]))
			{
				drawScoops(Color.PINK, g);
			}
			else if(flavorValue.equals(flavors[2]))
			{
				drawScoops(Color.GREEN, g);
			}
			else if(flavorValue.equals(flavors[3]))
			{
				drawScoops(Color.RED, g);
			}
			y=y-SCOOP_DIAMETER;
			displayCone.push(flavorValue);
		}
		
	
	}
	
	/**
	 * trashes the single scoop
	 */
	public void trashScoop()
	{
		displayCone.pop();
		repaint();
	}
	
	/**
	 * trashes all the scoop
	 */
	public void trashAllScoops()
	{
		while(!displayCone.isEmpty())
		{
			displayCone.pop();
		}
		repaint();
	}
	
	/**
	 * gets the display cone which is a stack
	 * @return
	 */
	public StackLL<String> getDisplayCone()
	{
		return displayCone;
	}
	
}


