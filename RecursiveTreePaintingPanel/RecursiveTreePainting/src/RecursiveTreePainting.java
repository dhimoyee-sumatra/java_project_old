import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; /** optional, for drawing lines with varying thickness */
import java.awt.BasicStroke; /** optional, for drawing lines with varying thickness */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class RecursiveTreePainting extends JComponent implements MouseListener
{
    /** Number of generations to create branches. Play with this for coarser/finer detail. **/
    public static final int NUM_GENERATIONS = 8;
 
    /** Number of children for each branch. Play with this for sparser/fluffier trees. **/
    public static final int NUM_CHILDREN = 3; 

	/** Number of branches **/
	public static final int NUM_BRANCHES = 8; 
 
	/** Golden ratio makes the trunk length:branch length ratio aesthetically appealing **/
	public static final double GOLDEN_RATIO = 1.618;
 
	/** Maximum branching angle of a branch from the trunk **/
	public static final double MAX_BRANCHING_ANGLE = .5*Math.PI;
 
	/** Diameter of the blossoms. **/
	public static final int BLOSSOM_DIAM = 4;
 
	/** Thickness of the trunk and branches. **/
    public static final int BRANCH_THICKNESS = 2;

    private double startPointX;
    private double startPointY;
    private double endPointX;
    private double endPointY;
    private double trunkLength;
    
    private double trunkAngle;
    

    public RecursiveTreePainting ()
    {
    	addMouseListener(this);
    }

    public void paint( Graphics g )
	{
            /** paint the background */
            paintBackground( g );

            /** paints the tree when mouse is clicked and the coordinates are set */


             if(!(startPointX==0 && startPointY==0 && endPointX==0 && endPointY==0))
            {
                paintTree((Graphics2D) g );
            }
 
            
    }

    public void paintBackground( Graphics m)
    { 
        /** sets the color to black and colors the rectangle */
    	m.setColor(Color.BLACK);
    	m.fillRect(0,0, getWidth(), getHeight());
    }

    public void mousePressed( MouseEvent e)
    {
        /** stores the coordinates of the start point */
    	startPointX=e.getX();
    	startPointY=e.getY();
    	System.out.println("This was pressed");
    }

    public void mouseReleased( MouseEvent a)
    {
        /** stores the coordinates of the end point */
    	endPointX=a.getX();
    	endPointY=a.getY();
        System.out.println("This was released");
        repaint();
    }

    public void mouseEntered(MouseEvent e) 
    {
       
    }

    public void mouseExited(MouseEvent e) 
    {
       
    }

    public void mouseClicked(MouseEvent e) 
    {
       
    }

    public void paintTree(Graphics2D n) 
    {
        /** sets the basic stroke
        * sets the color
        * draws the trunk */
    	n.setStroke(new BasicStroke(BRANCH_THICKNESS));
    	n.setColor(Color.GREEN);
    	n.drawLine((int)startPointX, (int)startPointY, (int)endPointX, (int)endPointY);

        /** calculates the trunk length
        *calculates the branch length using the golden ratio
        *calculates the slope for the trunk 
        *sets the max and min angles */
        trunkLength=Point2D.distance(startPointX, startPointY, endPointX, endPointY);
        
        double diffX=endPointX- startPointX;
        double diffY=endPointY- startPointY;
        trunkAngle=Math.atan2(diffY, diffX);
        
        Point2D p= new Point2D.Double(endPointX, endPointY);

        /** runs a for loop to draw the branches and blossoms 
        *calcuates a random angle for every branch
        *sets the branch thickness to the stroke 
        *set the color of the branch to green
        *random gives color to the blossoms 
        *draws them to the branches */
        
        paintBranch(n, p, trunkLength, trunkAngle, NUM_GENERATIONS);


    }
    /** computes the endpoint of branches given the starting point, length and angle */
    public Point2D computeEndpoint( Point2D p, double length, double angle )
    {
        return new Point2D.Double( p.getX() + length*Math.cos(angle), /** x is cos*/
                                       p.getY() + length*Math.sin(angle)); /** y is sin*/
    }

    public void paintBranch (Graphics2D n, Point2D startPoint, double length, double angle, int generation )
    {
        double maxAngle= angle+ MAX_BRANCHING_ANGLE;
        double minAngle= angle- MAX_BRANCHING_ANGLE;
        double branchLength=length/GOLDEN_RATIO;

        if (generation==0)
        {
            n.setStroke(new BasicStroke());
            n.setColor(new Color((float) (Math.random()*.6f + .3f), /** more red */
                (float)(.1f+.5f*Math.random()), /** some green */
                (float)(.1f+.1f*Math.random()))); /** low blue */
            n.fillOval((int)(startPoint.getX()-BLOSSOM_DIAM/2), (int)(startPoint.getY()-BLOSSOM_DIAM/2), BLOSSOM_DIAM, BLOSSOM_DIAM);
        }
        else
        {
            
            for (int i= 0; i< NUM_CHILDREN; i++)
            { 
                double angle1 = Math.random()*(maxAngle- minAngle)+ minAngle;
                Point2D  endPoint= computeEndpoint(startPoint, branchLength, angle);
                n.setStroke(new BasicStroke(BRANCH_THICKNESS));
                n.setColor(Color.GREEN);
                n.drawLine( (int)startPoint.getX(), (int)startPoint.getY(), (int)endPoint.getX(), (int)endPoint.getY());
                paintBranch(n, endPoint, branchLength,angle1, generation-1 );
            }
        
        }   
    }
}