// Name:
// USC NetID:
// CS 455 PA1
// Fall 2021

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   
   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale).
  
      @param bottom  location of the bottom of the bar
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param applicationHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label under the bar
   */

   //
   private int bottom;
   private int left;
   private int width;
   private int applicationHeight;
   private double scale;
   private String label;
   private Color color;
   
    //add in Color color, String label for parameters
   public Bar(int left, int bottom, int width, int applicationHeight, double scale, Color color, String label) {
        this.bottom = bottom;
        this.left = left;
        this.width = width;
        this.applicationHeight = applicationHeight;
        this.scale = scale;
        this.label = label;
        this.color = color;
   }
   
   /**
      Draw the labeled bar.
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      int scaledHeight = (int) Math.round(this.applicationHeight * this.scale);
      int scaledBottom = this.bottom - scaledHeight;
      //rectangle configuration
      Rectangle box = new Rectangle(0, 0, this.width, scaledHeight);
      box.translate(left,scaledBottom);

      g2.setColor(this.color);
      g2.fill(box);
      g2.drawString(this.label, (int) box.getX(), 425);
   }
}
