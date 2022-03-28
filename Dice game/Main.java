import java.util.*;

class Main {
  public static void main(String[] args) {

    Boolean end = false;
    int humanScore = 0;
    int computerScore = 0;
    Scanner input = new Scanner(System.in);

    System.out.println("Welcome to the Pig game!");

    //the game continues as long as no one wins:
    while (!end) {

      Boolean humanEnd = false;
      int humanTempScore = 0;
      int humanPrevious = 0;
      int dice = 0;

       //human's turn!
       while (!humanEnd) {
        
         System.out.println("Your turn! Please type \"r\" to roll or type \"h\" to hold.");

         String answer = input.nextLine();

         if (answer.equals("r")) {
           //generate numbers in range [1,6]:
           dice = 1 + (int) (Math.random()*6);
           humanPrevious = dice;
           if (dice == 1) {
             humanEnd = true;
             } else {
               humanTempScore += dice;
             }
           } else {
             humanScore += humanTempScore;
             humanEnd = true;
          }
          if (humanScore < 100) {
            System.out.println("Your score is: " + humanScore + ", and computer's score is: " + computerScore);
            if (humanPrevious != 0) {
              System.out.println("Your previous roll is: " + humanPrevious);
            }
          }
       }
       //human's turn ends.
       
       //computer's turn will start only if human's score is still under 100:
       if (humanScore < 100) {

         System.out.println("Your turn ends. Now computer is rolling...");

         Boolean computerEnd = false;
         int computerTempScore = 0;

         while (!computerEnd) {
           dice = 1 + (int) (Math.random()*6);
           if (dice == 1) {
             computerEnd = true;
           } else {
             computerTempScore += dice;
           }
           if (!computerEnd && computerTempScore >= 20) {
             computerScore += computerTempScore;
             computerEnd = true;
           }
         }
       //if human scores over 100, human wins:
       } else {
         end = true;
         System.out.println("Human wins! The game is over!");
       }

       //check if computer wins:
       if (computerScore >= 100) {
         end = true;
         System.out.println("Sorry, computer wins. The game is over!");
       }

    }
    input.close();
  }
}