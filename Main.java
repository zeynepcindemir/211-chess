import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        Game newGame = new Game();

        boolean exitBoole = false;

        String move = "";
        int turn = -1;

        while(!exitBoole){
            newGame.displayGame();

            turn = 0;
            boolean p1WrongMove = false;

            while(!p1WrongMove) {
                move = input.nextLine();
                if (move.equals("exit")){
                    exitBoole = true;
                    p1WrongMove = true;
                }
                else if (newGame.isPlayable(move,turn)) {
                    newGame.play(move);
                    p1WrongMove = true;
                } else {
                    System.out.println("Hatali Hareket!");
                }
            }


            if(newGame.isGameEnded()){
                newGame.displayGame();
                System.out.println("Beyaz oyunu kazandi");
                System.exit(0);
            }
            if(!exitBoole) {
                newGame.displayGame();
                newGame.taslariKaydir();
                newGame.displayGame();
            }

                turn = 1;
                boolean p2WrongMove = false;

                while(!p2WrongMove) {
                    move = input.nextLine();
                    if (move.equals("exit")) {
                        exitBoole = true;
                        p2WrongMove = true;
                    } else if (newGame.isPlayable(move, turn)) {
                        newGame.play(move);
                        p2WrongMove = true;
                    } else {
                        System.out.println("Hatali Hareket!");
                    }
                }


            if(newGame.isGameEnded()){
                newGame.displayGame();
                System.out.println("Siyah oyunu kazandi");
                System.exit(0);
            }

            if(!exitBoole) {
                newGame.displayGame();
                newGame.taslariKaydir();
            }


        }

        newGame.displayPoints();
    }
}
