import java.util.*;
import java.lang.*;
import java.io.*;
import java.text.DecimalFormat;

/* Author: Ibsa Ahmed
 * Date Written: 12/3/18
 * Description: Program computes the completion time for the cost of two different methods of sceduling
 */

public class Scheduling
{

   // public static int sums(int ar[],int ar2[])
   // {

    public static void main(String args[]) throws IOException
    {
        DecimalFormat ls = new DecimalFormat("#,###");
        Scanner scan = new Scanner(new File("jobs.txt"));
        int k = scan.nextInt();
        int x = 0;
        int y = 0;
        long sum = 0;
        long sum2 = 0;
        int temp =0;
        double temp2;
        int weight[] = new int[k];
        int weight2[] = new int[k];
        int length[] = new int[k];
        int length2[] = new int[k];
        int difference[] = new int[k];
        double quotient[] = new double[k];

        while(scan.hasNext())
        {
            weight[x] = scan.nextInt();
            length[x] = scan.nextInt();
            weight2[x] = weight[x];
            length2[x] = length[x];
            difference[x] = weight[x] - length[x];
            quotient[x] = (double)weight2[x] / (double)length2[x];
            x++;
        }

          for (int i=0; i<=k-1; i++)
          {  
              for (int j=i; j<=k-1; j++) 
                  {
                      if(difference[j] > difference[i] || 
                              (difference[j]==difference[i] &&
                                  weight[j]>weight[i]))
                      {
                          temp = difference[i];
                          difference[i] = difference[j];
                          difference[j] = temp;
                          temp = length[i];
                          length[i] = length[j];
                          length[j] = temp;
                          temp = weight[i];
                          weight[i] = weight[j];
                          weight[j] = temp;
                      }
                  }
          }
        for(int i=0; i<=k-1; i++)
        {
            y += length[i];
            sum += (weight[i] * y);
        }
        System.out.println("Cost for part a = " + (ls.format(sum)));
        y =0;
        
          for (int i=0; i<=k-1; i++)
          {  
              for (int j=i; j<=k-1; j++) 
                  {
                      if(quotient[j] > quotient[i] || 
                              (quotient[j]==quotient[i] &&
                                  weight2[j]>weight2[i]))
                      {
                          temp2 = quotient[i];
                          quotient[i] = quotient[j];
                          quotient[j] = temp2;
                          temp = length2[i];
                          length2[i] = length2[j];
                          length2[j] = temp;
                          temp = weight2[i];
                          weight2[i] = weight2[j];
                          weight2[j] = temp;
                      }
                }
          }
        for(int i=0; i<=k-1; i++)
        {
            y += length2[i];
            sum2 += (weight2[i] * y);
        }
        System.out.println("");
        System.out.println("Cost for part b = " + (ls.format(sum2)));

         

        //for (int i=0; i<=k-1; i++)
       // {
       //     System.out.print(weight2[i]);
       //     System.out.print(" ");
       //     System.out.print(length2[i]);
       //     System.out.println(quotient[i]);
       // }
       //     System.out.println(sum);
   //         System.out.println(sum2);
    }
}


