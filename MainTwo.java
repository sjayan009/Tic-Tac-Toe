/* This code was developed by students (NOT ME!) */

import java.util.Random;
import java.util.Scanner;
public class MainTwo
{
    private static Scanner sc = new Scanner(System.in);
    private static String[] board = new String[9];
    private static String playerChoice = "";
    private static String player2Choice = "";
    private static Random rand = new Random();
    private static String winner = "";
    private static int winnerStatus = 0;
    private static int insta = 0;


    public static void main(String[] args)
    {
        System.out.println("Welcome to Tic Tac Toe");
        chooseLetter();
        
        for (int i = 0; i < 9; i++)
        {
            board[i] = String.valueOf(i);
        }
        
        if(playerChoice.equals("o"))
        {
          player2Choice = "x";
        }
        else 
        {
          player2Choice = "o";
        }  
        
        while (checkIfWinner() != true)
        {
          printBoard();
          playerInput(playerChoice);
          if (checkIfWinner() == true)
          {
            winner = playerChoice;
            break;
          }
          printBoard();
          playerInput(player2Choice);
          if (checkIfWinner() == true)
          {
            winner = player2Choice;
            break;
          }
          
          System.out.println("# Instance: " + insta);
          insta = insta + 1;
        }
        declareWinner();
        printBoard();

    }
    
    public static void declareWinner()
    {
      if (winner.equals(""))
      {
        System.out.println("The game ended in a tie!");
      }
      else
      {
        System.out.println("A player has won the game!");
        System.out.println("The winner is: " + winner);
      }
    }
   
    public static String chooseLetter()
    {
        System.out.print("Choose a letter, x or o: ");
        playerChoice = sc.nextLine().toLowerCase();
        if(playerChoice.equals("x") || playerChoice.equals("o"))
        {
            System.out.println("playerChoice: " + playerChoice);
            return playerChoice;
        }
        else
        {
            while(playerChoice.equals("x") == false || playerChoice.equals("o"))
            {
                System.out.print("Choose a letter, x or o: ");
                playerChoice = sc.nextLine().toLowerCase();
                if(playerChoice.equals("o"))
                {
                    break;
                }
            }
            System.out.println("playerChoice: " + playerChoice);
            return playerChoice;
        }
    }
   
    public static void printBoard()
    {
        System.out.println("|-----------|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|-----------|");
    }
    
    public static void playerInput(String pNum)
    {
        System.out.println("Enter a number: ");
        int playerInput = sc.nextInt();
        if(checkIfPossible(playerInput, pNum))
        {
            System.out.println("Board has been updated and printed.");
        }
    }

    public static boolean checkIfPossible(int playerInput, String pNum)
    {
      if(playerInput >= 0 && playerInput <= 8)
      {
          if(board[playerInput].equals("x") || board[playerInput].equals("o"))
          {
            System.out.println("Pick a slot that doesn't have a letter assigned");
            return false;
          }
          else
          {
            board[playerInput] = pNum;
            return true;
          }
      }
      else
      {
          return false;
      }
    }
    public static boolean checkIfWinner(){
      for(int i = 0; i < 8; i= i+3) 
      // rows
      {
        if(board[i] == board[i+1] && board[i+1] == board[i+2]) 
        {
          winnerStatus = 1;
          return true;
        }
      }
      
      for(int i = 0; i <= 2; i= i+1)
      // columns
      {
        if(board[i] == board[i+3] && board[i+3] == board[i+6])
        {
          winnerStatus = 1;  
          return true;

        }
      
      }
      
      int k = 0;
      // diagonal
      {
        if(board[k] == board[k+4] && board[k+4] == board[k+8])
        {
          winnerStatus = 1;  
          return true;
        }
        if(board[k+2] == board[k+4] && board[k+4] == board[k+6])
        {
          winnerStatus = 1;  
          return true;
        }
      }
      return false;
    }
}


/*
|-----------|
| 0 | 1 | 2 |
| 3 | 4 | 5 |
| 6 | 7 | 8 |
|-----------|
*/
