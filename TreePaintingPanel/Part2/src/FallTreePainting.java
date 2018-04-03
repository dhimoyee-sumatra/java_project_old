import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D; /** optional, for drawing lines with varying thickness */
import java.awt.BasicStroke; /** optional, for drawing lines with varying thickness */
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

public class FallTreePainting extends TreePainting implements MouseListener
{
	public FallTreePainting ()
	{
		super(); /** calls the construct of the superclass */
		addMouseListener(this);
		
	}

	/** overrides the method of the superclass */
	public void paintBackground( Graphics m)
    {
    	m.setColor(Color.ORANGE); /** sets the background to different color */
    	m.fillRect(0,0, getWidth(), getHeight());
    }
}