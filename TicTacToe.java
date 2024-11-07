

package com.mycompany.tictactoe;

import java.util.Scanner;
public class TicTacToe {

    public static void main(String[] args) {
       
        //2d array for the board
        
        char[][] board= new char [3][3];
           initializeBoard (board);
       
       char currentplayer='X';
       
       boolean gameWon= false;
       Scanner sc =new Scanner (System.in);
       
     while(!gameWon && !isBoardFull(board)){
         printBoard(board);
         
         int row, col ;
         while(true){
             System.out.println("Player " + currentplayer + ",enter the your move(move row and column):");
             
             row =sc.nextInt();
             col =sc.nextInt();
             
             //check valid row and column
             
             if(row>=0 && row<3 && col>=0 && col<3 && board[row][col]== '-'){
                 
                 break; //valid move
                 
             }else{
                 System.out.println("this move is not valid.Try again.");
             }
         }
         
         board[row][col]=currentplayer;
         
         if(checkWin(board, currentplayer)){
             gameWon =true ;
             printBoard(board);
             System.out.println("Player " + currentplayer + " Wins!");
         }else{
             
             //switch player
             currentplayer =(currentplayer == 'X')? '0':'X';
         }
     }
           
       if(!gameWon){
           printBoard(board);
           System.out.println("The game is draw.");
       }
       
    }


  public static void initializeBoard(char [][] board){
      for(int i = 0; i<3; i++){
        for(int j =0; j<3;j++){
         board [i][j]= '-';
        }
    }

}
  public static void printBoard(char[][] board){
      for( int i= 0; i<3; i++){
          for(int j=0; j<3;j++){
              System.out.print(board[i][j] + " ");
          }
          System.out.println();
      }
  }
   public static boolean checkWin(char[][] board, char player){
       //cheak rows & colum
       
       for(int i = 0; i<3 ; i++){
           
       
           if((board[i][0]==player && board[i][1]== player && board[i][2]== player) ||
                   (board[0][i]== player && board[i][1] == player && board[2][i]==player)){
           return true;
       }
   }
       if((board[0][0]==player && board[1][1]== player && board[2][2]==player)||
               (board[0][2]==player && board[1][1] == player && board[2][0]==player)){
           return true;
        }
       
       return false;
       
    }
   
     //for droaw
     public static boolean isBoardFull(char[] [] board){
         for(int i=0 ; i<3;i++){
             for(int j=0; j<3; j++){
                 if (board[i][j]=='-'){
                     return false;
                 }
             }
         }
         return true;
     }
}