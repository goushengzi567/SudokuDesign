/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokudesign;

/**
 * This is my first complex java project. Hope I will success.
 * @author Shaojie
 */
import java.util.*;
 class SudokuInput{
    int[][] s = new int[9][9];
    int x, y;
    Scanner sc = new Scanner(System.in);
    public void input(){
    System.out.println("Enter anything to start. Enter 0 if finished");
     do{
        System.out.print("Please enter the x coordinate: "); 
          
           x = sc.nextInt(); if(x==0) break;
         
        System.out.print("Please enter the y coordinate: ");
           y = sc.nextInt(); 
        System.out.print("Please enter the value located at the coordinates you just entered: ");
           s[x-1][y-1] = sc.nextInt(); 
          
    }while(x!=0);
     System.out.println("The known Sudoku is: ");
    
     for(int i=0;i<9;i++){
       for(int j=0;j<9;j++){
       System.out.print(s[i][j]+"  ");
       }System.out.println();
     }
    }
 }
public class SudokuDesign {
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     new SudokuInput().input();
    }
   
}
