
import Class.EightMinister;

public class Main
{
    public static void main(String[] args)
    {
        EightMinister em1 = new EightMinister(1,1);
        em1.start();
        int[][] arr = em1.result();

        for (int i=1; i<=8; i++)
        {
            for (int j=1; j<=8; j++)
            {
                System.out.print(" " + arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
