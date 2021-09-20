import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JComponent;
import java.awt.Color;
import java.util.Scanner;

//Extends JComponent. Constructor initializes any necessary data and runs the simulation. Overrides paintComponent to draw the bar graph, using Bar objects for each bar in the graph. This class uses the CoinTossSimulator and Bar class.


public class CoinSimComponent extends JComponent{
    private double twoHeads;
    private double headTails;
    private double twoTails;
    private double trials;
    private static int WIDTH = 100;
    private static int HEIGHT = 400;
    private static int BOTTOM = 400;


    public CoinSimComponent(){
      //console run
      Scanner scan = new Scanner(System.in);
      CoinTossSimulator trial = new CoinTossSimulator();
      System.out.print("Enter amount of trials: ");
      int numTrials = scan.nextInt();
      scan.nextLine();
      while (numTrials < 0 || numTrials == 0){
        System.out.println("ERROR: Number entered must be greater than 0.");
        System.out.print("Enter amount of trials: ");
        numTrials = scan.nextInt();
        scan.nextLine();
      }
      //run trials and print to console
      trial.run(numTrials);
      System.out.println("Results:");
      System.out.println("TwoHeads: " + trial.getTwoHeads());
      System.out.println("HeadTails: " + trial.getHeadTails());
      System.out.println("TwoTails: " + trial.getTwoTails());

      
      //gui simulation first run
      CoinTossSimulator trial_1 = new CoinTossSimulator();
      trial_1.run(1000);
      trials = (int) trial_1.getNumTrials();
      twoHeads = (int) trial_1.getTwoHeads();
      headTails = (int) trial_1.getHeadTails();
      twoTails = (int) trial_1.getTwoTails();
      
    } 
   public void paintComponent(Graphics g){
      Graphics2D g2 = (Graphics2D) g;
      //find bar placement
      int left = getWidth() - 700;
      //used twoheadscale to scale how tall height of bar should be based
      double twoHeadscale = twoHeads /this.trials;
      Color magenta = new Color(255, 0, 255);
      String twoHeadbarResult = "Two Heads: " + twoHeads + " ("+ (int) (twoHeadscale *100) + "%)";
      //twohead bar implementation
      Bar twoHeadbar = new Bar(left, BOTTOM, this.WIDTH, this.HEIGHT,twoHeadscale, magenta, twoHeadbarResult);
      //used half the width of the window to find middle+ a few shifts to center the bar
      left = getWidth()/2-50;
      //used twoTailScale to scale how tall height of bar should be based
      double twoTailScale = twoTails /this.trials;
      Color blue = new Color(0, 0, 139);
      String twoTailbarResult = "Two Tails: " + twoTails + " ("+(int) (twoTailScale *100) + "%)";
      //twoTail bar implementation
      Bar twoTailbar = new Bar(left, BOTTOM, this.WIDTH, this.HEIGHT,twoTailScale, blue, twoTailbarResult);
      //bar placement for headtail
      left = getWidth() - 200;
      //used headTailscale to scale how tall height of bar should be based
      double headTailscale = headTails /this.trials;
      Color green = new Color(0, 255, 66);
      String headTailbarResult = "Head Tails: " + headTails + " ("+ (int) (headTailscale *100) + "%)";
      //headTail bar implementation
      Bar headTailbar = new Bar(left, BOTTOM, this.WIDTH, this.HEIGHT,headTailscale, green, headTailbarResult);

      //run the drawings
      twoHeadbar.draw(g2);
      twoTailbar.draw(g2);
      headTailbar.draw(g2);

   }
}
