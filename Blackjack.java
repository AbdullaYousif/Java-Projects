import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        
        scan.nextLine();
       
        int userCard1 = drawRandomCard();
        int userCard2 = drawRandomCard();
        
        
       
        System.out.println("\n You get a \n" + cardString(userCard1) + "\n and a \n" + cardString(userCard2));
     
        int handValue = Math.min(userCard1,10) + Math.min(userCard2,10);
        System.out.println("your total is: " + handValue);
        
    
        int dealerCard1 = drawRandomCard();
        
            System.out.println("\n The dealer shows \n" + cardString(dealerCard1) + "\nand has a card facing down \n" + faceDown());
            System.out.println("\nThe dealer's total is hidden");
            
          
            while(true){
                String choice = hitOrStay();
                int hitCard = drawRandomCard();
                if(choice.equalsIgnoreCase("hit")){
                    
                    System.out.println("\n You get a \n" + cardString(hitCard));
                    handValue += Math.min(hitCard,10);
                    System.out.println("your new total is " +handValue);
                    if(handValue > 21){
                        System.out.println("Bust! Player loses.");
                        System.exit(0);
                    }
                     
                    
                }
                
                if(choice.equalsIgnoreCase("stay")){
                    break;
                }
                
            }
            int dealerCard2 = drawRandomCard();
            
                System.out.println("\n Dealer's turn");
                System.out.println("\n The dealer's cards are \n" + cardString(dealerCard1) + "\n" + "\n" +cardString(dealerCard2));
                int dealerTotal = Math.min(dealerCard1, 10)+ Math.min(dealerCard2, 10);

            while(dealerTotal <17){
                int hitDealerCard = drawRandomCard();
                System.out.println("\nDealer gets a \n" + cardString(hitDealerCard));
                dealerTotal += Math.min(hitDealerCard, 10);
                

                
               
            }
            System.out.println("\nDealer's total is " + dealerTotal);

            if(dealerTotal > 21){
                System.out.println("Bust! Dealer loses");
                System.exit(0);
            }
            if(dealerTotal >=17 && dealerTotal <= 21){
                if(handValue > dealerTotal){
                    System.out.println("Player Wins!");
                }
                if(dealerTotal>handValue){
                    System.out.println("Dealer Wins!");
                }
                if(dealerTotal==handValue){
                    System.out.println("Push! its a Tie!");
                }
                
            }
           
           
            scan.close();
       
        

    }

    public static int drawRandomCard(){
        double randomNumber = (Math.random() * 13) +1;
        return (int) randomNumber;
    }
    

     public static String cardString(int cardNumber){
        switch(cardNumber){

            case 1:
            return "   _____\n"+
                   "  |A _  |\n"+ 
                   "  | ( ) |\n"+
                   "  |(_'_)|\n"+
                   "  |  |  |\n"+
                   "  |____V|\n";

            case 2:

            return  "   _____\n"+              
                    "  |2    |\n"+ 
                    "  |  o  |\n"+
                    "  |     |\n"+
                    "  |  o  |\n"+
                    "  |____Z|\n";
            
            case 3:

            return"   _____\n" +
                  "  |3    |\n"+
                  "  | o o |\n"+
                  "  |     |\n"+
                  "  |  o  |\n"+
                  "  |____E|\n";
            case 4:

            return "   _____\n" +
                   "  |4    |\n"+
                   "  | o o |\n"+
                   "  |     |\n"+
                   "  | o o |\n"+
                   "  |____h|\n";

            case 5:

            return  "   _____ \n" +
                    "  |5    |\n" +
                    "  | o o |\n" +
                    "  |  o  |\n" +
                    "  | o o |\n" +
                    "  |____S|\n";
            case 6:

            return  "   _____ \n" +
                    "  |6    |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  | o o |\n" +
                    "  |____6|\n";

            case 7:

            return  "   _____ \n" +
                    "  |7    |\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |____7|\n";
            case 8:

            return  "   _____ \n" +
                    "  |8    |\n" +
                    "  |o o o|\n" +
                    "  | o o |\n" +
                    "  |o o o|\n" +
                    "  |____8|\n";
            case 9:

            return  "   _____ \n" +
                    "  |9    |\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |____9|\n";
            case 10:

            return  "   _____ \n" +
                    "  |10  o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |o o o|\n" +
                    "  |___10|\n";
            case 11:

            return  "   _____\n" +
                    "  |J  ww|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o% |\n"+ 
                    "  | | % |\n"+ 
                    "  |__%%[|\n";
            case 12:

            return  "   _____\n" +
                    "  |Q  ww|\n"+ 
                    "  | o {(|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%O|\n";
            case 13:

            return  "   _____\n" +
                    "  |K  WW|\n"+ 
                    "  | o {)|\n"+ 
                    "  |o o%%|\n"+ 
                    "  | |%%%|\n"+ 
                    "  |_%%%>|\n";

            default:
            return "this will never run";
        }
     }
    

    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    public static String hitOrStay(){
        System.out.println("Would you like to hit or stay?");
        String choice = scan.nextLine();
       
        
        while(!(choice.equalsIgnoreCase("hit") || choice.equalsIgnoreCase("stay"))){
            System.out.println("Please write 'hit' or 'stay' ");
            choice = scan.nextLine();
            
        }
        
        return choice;

    }
   
    }

