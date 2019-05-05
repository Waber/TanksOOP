public class Tank extends Vehicle {

    static final char tank = 't';

    public Tank (){
        super();

        for(int i = 0; i < 2; i++){
            for (int j = 0; j < 2; j++){
                if(super.getBoard().destinationCheck(i,j)){
                    super.getBoard().destination();
                }
                super.getBoard().setBoard(i,j,tank);
            }
        }
    }

    public char move(char direction){
        super.vehiclePositionCheck();
        char moveValue = 0;
        switch (direction){
            case 'g':
                super.setVehiclePositionX(super.getVehiclePositionX()-1);
                if(super.getVehiclePositionX() < 0 ){
                    return 'b';
                }
                else if(super.getBoard().destinationCheck(super.getVehiclePositionX(), super.getVehiclePositionY())){
                    moveValue = 'p';
                }

                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY(),tank);
                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY()+1,tank);
                super.getBoard().setBoard(super.getVehiclePositionX()+2,super.getVehiclePositionY(),super.getEmptyField());
                super.getBoard().setBoard(super.getVehiclePositionX()+2,super.getVehiclePositionY()+1,super.getEmptyField());
                break;
        }

        return   (moveValue == 'p') ? 'p' : 'm';
    }
}
