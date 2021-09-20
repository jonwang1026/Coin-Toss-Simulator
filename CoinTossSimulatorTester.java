public class CoinTossSimulatorTester{
   public static void main(String[] args){
    CoinTossSimulator run1 = new CoinTossSimulator();
    run1.run(15);
    System.out.println("Results for "+ 15+ " trials: ");
    System.out.println("TwoHeads: " + run1.getTwoHeads());
    System.out.println("HeadTails: " + run1.getHeadTails());
    System.out.println("TwoTails: " + run1.getTwoTails());
    int total = run1.getTwoHeads() + run1.getHeadTails() + run1.getTwoTails();
    System.out.println("Total Trials: "+ total);

    System.out.println("No reset");
    run1.run(20);
    System.out.println("Results for "+ 20+ " trials: ");
    System.out.println("TwoHeads: " + run1.getTwoHeads());
    System.out.println("HeadTails: " + run1.getHeadTails());
    System.out.println("TwoTails: " + run1.getTwoTails());
    total = run1.getTwoHeads() + run1.getHeadTails() + run1.getTwoTails();
    System.out.println("Total Trials: "+ total);

    System.out.println("With reset");
    run1.reset();
    run1.run(100);
    System.out.println("Results for "+ 100+ " trials: ");
    System.out.println("TwoHeads: " + run1.getTwoHeads());
    System.out.println("HeadTails: " + run1.getHeadTails());
    System.out.println("TwoTails: " + run1.getTwoTails());
    total = run1.getTwoHeads() + run1.getHeadTails() + run1.getTwoTails();
    System.out.println("Total Trials: "+ total);

   }
}