public class Tank extends Car implements Vehicle {

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
        setFuel(20);
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
                else if(checkIfPointReached()){
                    moveValue = 'p';
                }

                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY(),tank);
                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY()+1,tank);
                super.getBoard().setBoard(super.getVehiclePositionX()+2,super.getVehiclePositionY(),super.getEmptyField());
                super.getBoard().setBoard(super.getVehiclePositionX()+2,super.getVehiclePositionY()+1,super.getEmptyField());
                break;

            case 'd':
                super.setVehiclePositionX(super.getVehiclePositionX()+1);
                if(super.getVehiclePositionX() > 8){
                    return 'b';
                }
                else if(checkIfPointReached()){
                    moveValue = 'p';
                }

                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY(),tank);
                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY()+1,tank);
                super.getBoard().setBoard(super.getVehiclePositionX()-1,super.getVehiclePositionY(),super.getEmptyField());
                super.getBoard().setBoard(super.getVehiclePositionX()-1,super.getVehiclePositionY()+1,super.getEmptyField());
                break;

            case 'l':
                super.setVehiclePositionY(super.getVehiclePositionY()-1);
                if(super.getVehiclePositionY() < 0){
                    return 'b';
                }
                else if(checkIfPointReached()){
                    moveValue = 'p';
                }

                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY(),tank);
                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY(),tank);
                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY()+2,super.getEmptyField());
                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY()+2,super.getEmptyField());
                break;

            case 'p':
                super.setVehiclePositionY(super.getVehiclePositionY()+1);
                if(super.getVehiclePositionY() > 8){
                    return 'b';
                }
                else if(checkIfPointReached()){
                    moveValue = 'p';
                }

                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY()+1,tank);
                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY()+1,tank);
                super.getBoard().setBoard(super.getVehiclePositionX(),super.getVehiclePositionY()-1,super.getEmptyField());
                super.getBoard().setBoard(super.getVehiclePositionX()+1,super.getVehiclePositionY()-1,super.getEmptyField());
                break;
        }

        setFuel(-2);

        if(moveValue == 'p'){
            super.getBoard().destination();
            setFuel(10);
        }

        return   (moveValue == 'p') ? 'p' : 'm';
    }


    public void setFuel(int fuel){
        super.setFuel(fuel);
    }

    public void vehiclePositionCheck(){
        super.vehiclePositionCheck();
    }

    private boolean checkIfPointReached(){
        if (super.getBoard().destinationCheck(super.getVehiclePositionX(), super.getVehiclePositionY())
                || super.getBoard().destinationCheck(super.getVehiclePositionX()+1, super.getVehiclePositionY())
                || super.getBoard().destinationCheck(super.getVehiclePositionX()+1, super.getVehiclePositionY()+1)
                || super.getBoard().destinationCheck(super.getVehiclePositionX(), super.getVehiclePositionY()+1)){
            return true;
        }
        return false;
    }
}
