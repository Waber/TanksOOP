import java.util.Random;

public class GameBoard {

    private char[][] board;
    private Random random = new Random();

    public GameBoard(){
        board = new char[10][10];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = 'o';
            }
        }

        destination();
    }

    public void destination(){
        int x, y;

        do{
            x = random.nextInt(10);
            y = random.nextInt(10);
        }
        while (board[x][y] != 'o');

        board[x][y] = 'x';
    }

    protected boolean destinationCheck(int x, int y){
        if(board[x][y] == 'x'){
            return true;
        }
        return false;
    }

    public char[][] getBoard() {
        return board;
    }

    protected void setBoard(int x, int y, char v) {
        board[x][y] = v;
    }


   public void printBoard(){
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j]);
                if(j == 9){
                    System.out.println();
                }

            }
        }
    }
}
