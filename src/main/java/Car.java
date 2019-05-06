public class Car implements Vehicle {

    static final char car = 'c';
    static final char emptyField = 'o';
    private int vehiclePositionX = 0;
    private int vehiclePositionY = 0;
    private int fuel;
    private GameBoard gameBoard = new GameBoard();

    public Car(){
        gameBoard.setBoard(vehiclePositionX,vehiclePositionY,car);
        fuel = 10;
    }


    public void vehiclePositionCheck(){
        outerloop: //etykieta dzięki której możliwe jest wyjście z zewnętrznej pętli
        for (int i = 0 ; i < gameBoard.getBoard().length; i++){
            for(int j = 0; j < gameBoard.getBoard()[i].length; j++){
                if(gameBoard.getBoard()[i][j] != 'o' && gameBoard.getBoard()[i][j] != 'x'){
                    vehiclePositionX = i;
                    vehiclePositionY = j;
                    System.out.println(i+" "+j);
                    break outerloop;
                }
            }
        }
    }
    //b - oznacza blokadę jazdy w tym kierunku ponieważ pojazd jest na krawędzi planszy, m oznacza ruch, p oznacza osiągnięcie celu i zatankowanie
    public char move(char direction){
        vehiclePositionCheck();
        char moveValue = 0;

        switch (direction){
            case 'g':
                vehiclePositionX--;
                if(vehiclePositionX < 0 ){
                    return 'b';
                }
                else if(gameBoard.destinationCheck(vehiclePositionX, vehiclePositionY)){
                    moveValue = 'p';
                }

                gameBoard.setBoard(vehiclePositionX, vehiclePositionY, car);
                gameBoard.setBoard(vehiclePositionX+1, vehiclePositionY, emptyField);
                break;
            case 'd':
                vehiclePositionX++;
                if (vehiclePositionX > 9){
                    return 'b';
                }
                else if(gameBoard.destinationCheck(vehiclePositionX, vehiclePositionY)){
                    moveValue = 'p';
                }

                gameBoard.setBoard(vehiclePositionX, vehiclePositionY, car);
                gameBoard.setBoard(vehiclePositionX-1, vehiclePositionY, emptyField);
                break;
            case 'l':
                vehiclePositionY--;
                if(vehiclePositionY < 0){
                    return 'b';
                }
                else if (gameBoard.destinationCheck(vehiclePositionX, vehiclePositionY)){
                    moveValue = 'p';
                }

                gameBoard.setBoard(vehiclePositionX, vehiclePositionY, car);
                gameBoard.setBoard(vehiclePositionX, vehiclePositionY+1, emptyField);
                break;
            case 'p':
                vehiclePositionY++;
                if (vehiclePositionY > 9){
                    return 'b';
                }
                else if (gameBoard.destinationCheck(vehiclePositionX, vehiclePositionY)){
                    moveValue = 'p';
                }

                gameBoard.setBoard(vehiclePositionX, vehiclePositionY, car);
                gameBoard.setBoard(vehiclePositionX, vehiclePositionY-1, emptyField);
                break;
        }
        fuel--;
        if (moveValue == 'p'){
            gameBoard.destination();
            fuel += 5;
        }
        return   (moveValue == 'p') ? 'p' : 'm';

    }

    public int getFuel() {
        return fuel;
    }

    public void getPrintBoard(){
        gameBoard.printBoard();
    }

    public GameBoard getBoard(){
        return gameBoard;
    }

    public int getVehiclePositionX() {
        return vehiclePositionX;
    }

    public int getVehiclePositionY() {
        return vehiclePositionY;
    }

    public void setVehiclePositionX(int vehiclePositionX) {
        this.vehiclePositionX = vehiclePositionX;
    }

    public void setVehiclePositionY(int vehiclePositionY) {
        this.vehiclePositionY = vehiclePositionY;
    }

    public void setFuel(int fuel) {//wygenerowany przez IDE ale w rzeczywistości dodaje paliwo
        this.fuel += fuel;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public static char getEmptyField() {
        return emptyField;
    }
}
