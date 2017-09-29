
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wirasinee
 */
class Knapsack {

    public static void main(String[] args) throws Exception {
        int val[] = {20, 30, 66, 40,60}; //มูลค่าสืนค้า
        int wt[] = {2,2,3,4,5}; //นำ้หนัก
        int W = 10; //ความจุถุงเป
        
        knapsack_Sole(val, wt,(knapsack(val, wt, W)));
    }

    public static int[][] knapsack(int val[], int wt[], int W) {

        int N = wt.length; //ความยาวarr มูลค่า เพือบอกว่ามีของทั้งหมดกี่ชิ้น

        int[][] V = new int[N+1][W+1]; 

/*row col ที่0 เป็น0*/
        for (int col = 0; col <= W; col++) {
            V[0][col] = 0;
        }

        for (int row = 0; row <= N; row++) {
            V[row][0] = 0;
        }

        for (int item=1;item<=N;item++){

            for (int weight=1;weight<=W;weight++){

                if (wt[item-1]<=weight){

                    V[item][weight]=Math.max (val[item-1]+V[item-1][weight-wt[item-1]], V[item-1][weight]);
                }
                else {
                    V[item][weight]=V[item-1][weight];
                }
            }

        }

        for (int[] rows : V) {
            for (int col : rows) {

                System.out.format("%5d", col);
            }
            System.out.println();
        }
        
        

        return V;

    }
    
    public static void knapsack_Sole(int val[],int wt[], int V[][]){
    int i=val.length-1;
    int j=V[0].length-1;
    ArrayList<Integer> arr = new ArrayList<>();
    while(i>0 && j>0){
        if(j>=wt[i] && V[i][j]== val[i-1]+V[i-1][j-wt[i]]){
           arr.add(i);
           j=j-wt[i];
        }
        i--;
    }
    
    for (int rows : arr) {
                System.out.print( (rows+1)+" ");
        }
    
    }
    
}