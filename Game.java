public class Game {
    private Board gameBoard;
    private Player player1;
    private Player player2;

    public Game(){
        gameBoard = new Board();
        player1 = new Player();
        player2 = new Player();

    }

    public void displayGame(){
        gameBoard.displayBoard();
    }

    public boolean isPlayable(String move, int turn){
        if(move.substring(0,1).equals(move.substring(2,4))) //Tasi hareket ettirmezse false doner.
            return false;

        for(int i = 0 ; i < 5 ; i++){   //Notasyona uymayan konum girerse false doner.
            if(i == 2)
                continue;
            else if(i == 0 || i == 3){
                if((int)move.charAt(i) < 97 || (int)move.charAt(i) > 104)
                    return false;
            }
            else if(i == 1 || i == 4){
                if((int)move.charAt(i) < 49 || (int)move.charAt(i) > 56)
                    return false;
            }
        }
        return gameBoard.isPlayable(move,turn);  //Board kontrollerini yap
    }

    public void play(String move){
        Item temp = gameBoard.play(move);
        if(temp != null)
            this.addPoint(2-temp.getColorCode() , temp.getPoint());
    }

    public void addPoint(int playerNum , int point){
        if(playerNum == 1){
            player1.setPoint(player1.getPoint() + point);
        }
        else{
            player2.setPoint(player2.getPoint() + point);
        }
    }
    
    public void displayPoints(){
        System.out.println("player1.getPoint() = " + player1.getPoint());
        System.out.println("player2.getPoint() = " + player2.getPoint());
    }

    public boolean isGameEnded(){
        return !gameBoard.sahKontrol();
    }

    public void taslariKaydir(){
        gameBoard.taslariKaydir();
    }
}
