import java.util.Scanner;
import java.lang.Math;
public class CoinTossSimulator {
   /**
      Creates a coin toss simulator with no trials done yet.
   */
   private int twoHeads = 0;
   private int twoTails = 0;
   private int headTails = 0;
   private int numTrials = 0;
   
   public CoinTossSimulator() {

   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      this.numTrials = this.numTrials + numTrials;
      int [] currentTrial;
      int occuredTrial = 0;
      while(occuredTrial != numTrials){
        currentTrial = new int[2];
        for (int i =0;i<2;i++){
          currentTrial[i] = (int)(Math.random() * 2);
        }
        //if two are not matching
        if (currentTrial[0] != currentTrial[1]){
          headTails++;
        }
        //if two are matching and @0 it is a tail
        else if (currentTrial[0] == currentTrial[1] && currentTrial[1] == 0){
          twoHeads++;
        }
        else{
          twoTails++;
        }
        occuredTrial++;
      }
   }


   /**
      Get number of trials performed since last reset. getNumTrialsgetTwoHeadsgetTwoTailsgetHeadTails
   */
   public int getNumTrials() { 
       return this.numTrials; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return this.twoHeads; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return this.twoTails; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return this.headTails; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      this.twoHeads = 0;
      this.twoTails = 0;
      this.headTails = 0;
   }
}