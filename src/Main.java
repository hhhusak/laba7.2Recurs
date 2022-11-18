import java.util.Scanner;


public class Main {

    static void CreateRow(int[][] a, int m, int M, int N, int min, int max, int n){
        a[m][n] = (int) (Math.random() * (max - min) + min);
        if(n < N - 1){
            CreateRow(a, m, M, N, min, max, n + 1);
        }
    }
    static void CreateRows(int[][] a, int M, int N, int min, int max, int m){
        CreateRow(a, m, M, N, min, max, 0);
        if(m < M - 1){
            CreateRows(a, M, N, min, max, m + 1);
        }
    }
    static void PrintRow(int[][] a, int m, int M, int N, int n){
        System.out.printf("%d\t|  ", a[m][n]);
        if(n < N - 1){
            PrintRow(a, m, M, N, n + 1);
        } else {
            System.out.println();
        }
    }
    static void PrintRows(int[][] a, int M, int N, int m){
        PrintRow(a, m, M, N, 0);
        if(m < M - 1){
            PrintRows(a, M, N, m + 1);
        } else {
            System.out.println();
        }
    }
    static int findMinimalOfCol(int[][] a, int N, int minimal, int i, int j){
        if(j < N){
            if(a[i][j] < minimal){
                minimal = a[i][j];
            }
            return findMinimalOfCol(a, N, minimal, i, j + 1);
        } else {
            return minimal;
        }
    }
    static int sumOfMinEls(int[][] a, int M, int N, int sum, int minimal, int i, int j){
        if(i < M){
            if(i % 2 != 0){
                minimal = a[i][0];
                minimal = findMinimalOfCol(a, N, minimal, i, 1);
                sum += minimal;
            }
            return sumOfMinEls(a, M, N, sum, minimal, i + 1, j);
        } else {
           return sum;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Кількість рядків = "); int M = scan.nextInt();
        System.out.print("Кількість стовпців = "); int N = scan.nextInt();
        int[][] a = new int[M][N];
        int min = -5; int max = 20;

        CreateRows(a, M, N, min, max, 0);
        PrintRows(a, M, N, 0);
        int sum = sumOfMinEls(a, M, N, 0, a[0][0], 0, 0);
        System.out.println("Сума = " + sum);
    }
}