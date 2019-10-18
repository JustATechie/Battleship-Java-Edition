public class shipPieces {
    //private shipPieces airCarrier; //1
    private shipPieces fourpin; //1
    private shipPieces threepin; //2
    private shipPieces twopin; //1

    shipPieces airCarrier = new shipPieces();
    /*
    *Default constructor
     */
    public shipPieces(){
        createPieces(airCarrier);
    }

    public void createPieces(shipPieces shipPieces){
        int length;
        if(shipPieces.this == airCarrier){
            length = 5;
        }
        else if(shipPieces.this == fourpin){
            length = 4;
        }
        else if(shipPieces.this == threepin){
            length = 3;
        }
        else if(shipPieces.this == twopin){
            length = 2;
        }
        else{
            System.out.println("error");
            System.exit(0);
        }

    }








}
