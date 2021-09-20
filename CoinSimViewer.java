import javax.swing.JFrame;
//Contains the main method. Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent. Besides CoinSimComponent, this class does not depend on any of the other classes mentioned here (e.g., if one of those other classes changed, CoinSimViewer would not have to change.) The later section on communicating information between objects will be useful when developing this and the next class listed.
public class CoinSimViewer {
   public static void main(String[] args){
      JFrame frame = new JFrame();

      frame.setSize(800, 500);
      frame.setTitle("Coin Toss");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CoinSimComponent component = new CoinSimComponent();
      frame.add(component);
      frame.setVisible(true);
   }
}
