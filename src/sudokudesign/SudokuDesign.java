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
    public int[][] input(){
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
     System.out.println();
     System.out.println();
     return s;
    }
 }
public class SudokuDesign {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        int[][] s = new SudokuInput().input();
        Set<Integer> test = new HashSet<>();
       do{
       s = calculate(s);
         for(int i=0;i<9;i++){
       for(int j=0;j<9;j++){
       System.out.print(s[i][j]+"  ");
       }System.out.println();
     }
         //Scanner tt = new Scanner(System.in);
         //boolean bb=tt.nextBoolean();
      // test.clear();
        //for(int i=0;i<9;i++){
          //for(int j=0;j<9;j++){
          //test.add(s[i][j]);
         // }
       // }
       }while(true);
       
     
   
    }
   public static Set<Integer> possibleFromRow(int cor1, int[][] s){
   Set<Integer> row = new HashSet<>();
   Set<Integer> set = new HashSet<>();// create a set containing 1 to 9;
   int[] All = {1,2,3,4,5,6,7,8,9};
   for(int i:All) set.add(i);
   for(int i=0;i<9;i++)  row.add(s[cor1][i]); 
   row.remove(0);
   set.removeAll(row);
   System.out.println(set);
   return set;
   }
   
   public static Set<Integer> possibleFromColumn(int cor2, int[][] s){
   Set<Integer> column = new HashSet<>();
   Set<Integer> set = new HashSet<>();// create a set containing 1 to 9;
   int[] All = {1,2,3,4,5,6,7,8,9};
   for(int i:All) set.add(i);
   for(int j=0;j<9;j++)  column.add(s[j][cor2]); 
   column.remove(0);
   set.removeAll(column);
   System.out.println(set);
   return set;
   }
   
   public static Set<Integer> possibleFromMatrix(int cor1, int cor2, int[][] s){
   // divide the entire matrix into 9 sub matrixes, number them from 1 to 9
   int p=0;
   if((cor1>=0&&cor1<=2)&&(cor2>=0&&cor2<=2)){
   p = 1;
   }else if((cor1>=0&&cor1<=2)&&(cor2>=3&&cor2<=5)){
   p = 2;
   }else if((cor1>=0&&cor1<=2)&&(cor2>=6&&cor2<=8)){
   p = 3;
   }else if((cor1>=3&&cor1<=5)&&(cor2>=0&&cor2<=2)){
   p = 4;
   }else if((cor1>=3&&cor1<=5)&&(cor2>=3&&cor2<=5)){
   p = 5;
   }else if((cor1>=3&&cor1<=5)&&(cor2>=6&&cor2<=8)){
   p = 6;
   }else if((cor1>=6&&cor1<=8)&&(cor2>=0&&cor2<=2)){
   p = 7;
   }else if((cor1>=6&&cor1<=8)&&(cor2>=3&&cor2<=5)){
   p = 8;
   }else if((cor1>=6&&cor1<=8)&&(cor2>=6&&cor2<=8)){
   p = 9;
   }else System.out.println("Wrong coordinates, check codes");
   Set<Integer> matrix = new HashSet<>();
   switch(p){
       case 0: System.out.println("Wrong Wrong Wrong!!");break;
       case 1: for(int i=0;i<3;i++){
                 for(int j=0;j<3;j++){
                 matrix.add(s[i][j]);
                 }
                 } break;
       case 2: for(int i=0;i<3;i++){
                 for(int j=3;j<6;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 3: for(int i=0;i<3;i++){
                 for(int j=6;j<9;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 4: for(int i=3;i<6;i++){
                 for(int j=0;j<3;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 5: for(int i=3;i<6;i++){
                 for(int j=3;j<6;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 6: for(int i=3;i<6;i++){
                 for(int j=6;j<9;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 7: for(int i=6;i<9;i++){
                 for(int j=0;j<3;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 8: for(int i=6;i<9;i++){
                 for(int j=3;j<6;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
       case 9: for(int i=6;i<9;i++){
                 for(int j=6;j<9;j++){
                 matrix.add(s[i][j]);
                 }
       }break;
   }
    Set<Integer> set = new HashSet<>();// create a set containing 1 to 9;
   int[] All = {1,2,3,4,5,6,7,8,9};
   for(int i:All) set.add(i);
   matrix.remove(0);
   set.removeAll(matrix);
   System.out.println(set);
   return set;
   }
   
   public static int[][] calculate(int[][] s){
       Set<Integer> row = new HashSet<>();
       Set<Integer> column = new HashSet<>();
       Set<Integer> matrix = new HashSet<>();
   for(int i=0;i<9;i++){
           for(int j=0;j<9;j++){
           if(s[i][j]!=0){continue;}
           row = possibleFromRow(i,s);
           column = possibleFromColumn(j,s);
           matrix = possibleFromMatrix(i,j,s);
           row.retainAll(column);
           row.retainAll(matrix);
           if(row.size()==1){
           s[i][j] = row.iterator().next();
           break;
           }
           row.clear();
           column.clear();
           matrix.clear();
           }
        }
     return s;
   }
}
