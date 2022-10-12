import java.util.*;
import java.lang.*;
import java.io.*;
class TransposeMultiplication
{
    
    static void transpose(int A[][], int Y, int Z)
    {
        for (int i = 0; i < Y; i++)
            for (int j = i + 1; j < Z; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
    }
    
    static void printMatrix(int M[][], int rowSize, int colSize)
    {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++)
                System.out.print(M[i][j] + " ");
 
            System.out.println();
        }
    }
 
    static void multiplyMatrix(int row1, int col1, int A[][], int row2, int col2, int B[][])
    {
        int i, j, k;
 
        if (row2 != col1) {
            System.out.println(
                "\nMultiplication Not Possible");
            return;
        }
 
        int C[][] = new int[row1][col2];
 
        for (i = 0; i < row1; i++) {
            for (j = 0; j < col2; j++) {
                for (k = 0; k < row2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
 
        System.out.println("\nResultant Matrix:");
        printMatrix(C, row1, col2);
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
        int p, q, m, n;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of rows in first matrix:");
        p = s.nextInt();
        System.out.print("Enter number of columns in first matrix:");
        q = s.nextInt();
        System.out.print("Enter number of rows in second matrix:");
        m = s.nextInt();
        System.out.print("Enter number of columns in second matrix:");
        n = s.nextInt();
        int a[][] = new int[p][q];
        int b[][] = new int[m][n];
        System.out.println("Enter all the elements of first matrix:");
        for (int i = 0; i < p; i++) 
        {
            for (int j = 0; j < q; j++) 
            {
                a[i][j] = s.nextInt();
            }
        }
        System.out.println("Enter all the elements of second matrix:");
        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                b[i][j] = s.nextInt();
            }
        }
        
        transpose(a, p, q);
        transpose(b, m, n);
        multiplyMatrix(p, q, a, m, n, b);
 
	}
}