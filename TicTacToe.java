
import java.util.Scanner;

public class TicTacToe {

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
            System.out.println("\nLet's play tic tac toe");

            

            char [][] gameBoard = {
              {'_', '_', '_' },
              {'_', '_', '_'},
             {'_', '_', '_'}


            };
            
             printBoard(gameBoard);

             for(int i=0; i <9; i++){
              if(i %2 ==0){
                System.out.println("Turn: X");
                int[] position = askUser(gameBoard);
               gameBoard[position[0]][position[1]] = 'X';
               
               
               }
                
              
              if(i %2 ==1){
                System.out.println("Turn: O");
                
                int[] position = askUser(gameBoard);
                gameBoard[position[0]][position[1]] = 'O';
                
                
              }
              printBoard(gameBoard);
              int count = checkWin(gameBoard);
              if(count ==3){
                System.out.println("X Wins!");
                break;
              } else if(count == -3){
                System.out.println("O Wins!");
                break;
              }
              else if(i==8){
                System.out.println("It's a tie!");
              }
             }
             
             scan.close();
            }
             

            
        


        public static void printBoard(char[][] board){
          System.out.print("\n");
          for(int i=0; i<board.length; i++){
            System.out.print("\t");
            for(int j=0; j<board[i].length; j++) {
              System.out.print(board[i][j] + " ");
            }
            System.out.print("\n\n");
          }
         
        }
  


     public static int[] askUser(char[][] board){
      System.out.print("Pick a row and a column number: ");
      
       int rowNumber  = scan.nextInt();
       int columnNumber = scan.nextInt();
      while(board[rowNumber][columnNumber] == 'X' ||board[rowNumber][columnNumber] == 'O' ){
        System.out.print("Spot Taken, try again:");
        rowNumber  = scan.nextInt();
        columnNumber = scan.nextInt();
      }
       return new int[] {rowNumber,columnNumber};
      
      
     }
   


     public static int checkWin(char[][] board){
      int count = 0;
      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
          if(board[i][j] == 'X'){
            count++;
          }else if(board[i][j] == 'O'){
            count--;
          }
        }
        if(count ==3 || count == -3){
          return count;
        } else {
          count = 0;
        }
      }
      for(int i=0; i<board.length; i++){
        for(int j=0; j<board[i].length; j++){
          if(board[j][i] == 'X'){
            count++;
          }
        else if(board[j][i] == 'O'){
          count--;
        }
      }
      if(count ==3 || count == -3){
        return count;
      } else {
        count = 0;
      }
    }
    for(int i =0; i<3; i++){
      if(board[i][i] == 'X'){
        count++;
       } 
       else if(board[i][i] == 'O'){
        count--;
       }
      }
      if(count==3 || count == -3){
        return count;
      }
      else {
        count =0;
      }
     
      for(int i=0; i<3; i++){
        
        if(board[i][3-i-1]  == 'X'){
          count++;
        }
        else if(board[i][3-i-1] == 'O'){
          count --;
        }
      }
      if(count==3 || count == -3){
        return count;
      }
      else {
        count =0;
      }
     return count;
     }

  
     
}



