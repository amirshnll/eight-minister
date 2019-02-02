package Class;

public class EightMinister
{

    /* Private */
    private int[][] arr;

    private void setQueen(int row, int col)
    {
        this.arr[row][col] = 1;
    }

    private int min(int num1, int num2)
    {
        if(num1<num2)
            return num1;
        return num2;
    }

    private int checkline_one(int row, int col)
    {
        // line |
        for(int i=1; i<=8; i++)
        {
            if(this.arr[i][col]==1)
                return 0;
        }
        return 1;
    }

    private int checkline_two(int row, int col)
    {
        // line -
        for(int i=1; i<=8; i++)
        {
            if(this.arr[row][i]==1)
                return 0;
        }
        return 1;
    }

    private int checkline_three(int row, int col)
    {
        // line /
        int x = this.min(row, col) - 1;
        int new_row = row + x;
        int new_col = col - x;

        if(new_row>8)
            new_row=8;
        if(new_col<1)
            new_col=1;

        for(int i=new_col; i<=8; i++)
        {
            if(this.arr[new_row][i]==1)
                return 0;
            new_row-=1;
            if(new_row<0)
                return 1;
        }
        return 1;
    }

    private int checkline_four(int row, int col)
    {
        // line \
        int x = this.min(row, col) - 1;
        int new_row = row  - x;
        int new_col = col - x;

        if(new_row<1)
            new_row=1;
        if(new_col<1)
            new_col=1;

        for(int i=new_row; i<=8; i++)
        {
            if(this.arr[i][new_col]==1)
                return 0;
            new_col+=1;
            if(new_col>8)
                return 1;
        }
        return 1;
    }

    /* Public */
    public EightMinister(int row, int col)
    {
        this.arr = new int[9][9];
        for (int i=1; i<=8; i++)
            this.arr[i][i]=0;
        this.setQueen(row, col);
    }

    public void start()
    {
        for (int i=1; i<=8; i++)
        {
            for (int j=1; j<=8; j++)
            {

                if(this.arr[i][j]==1)
                    continue;

                if(this.checkline_one(i,j)==1 && this.checkline_two(i,j)==1 && this.checkline_three(i,j)==1 && this.checkline_four(i,j)==1)
                    this.setQueen(i,j);
            }
        }
    }

    public int[][] result()
    {
        return this.arr;
    }
}
