public class Tank extends Vehicle {

    static final char tank = 't';

    public Tank (){
        super();

        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                super.getBoard().setBoard(i,j,tank);
            }
        }
        super.getPrintBoard();
    }

    public char move(char direction){
        super.getPrintBoard();

        return direction;
    }
}
