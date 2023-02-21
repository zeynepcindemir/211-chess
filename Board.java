public class Board {
    private Item[][] Taslar = new Item[8][8];

    public Board(){
        for(int i = 0; i < 8 ; i = i+7){
            for(int j = 0 ; j < 8 ; j++){
                if(i == 0)
                    Taslar[i][j] = new Piyon(0);
                else
                    Taslar[i][j] = new Piyon(1);
            }
        }

        Taslar[1][0] = new Kale(0);
        Taslar[1][7] = new Kale(0);
        Taslar[6][0] = new Kale(1);
        Taslar[6][7] = new Kale(1);

        Taslar[1][1] = new At(0);
        Taslar[1][6] = new At(0);
        Taslar[6][1] = new At(1);
        Taslar[6][6] = new At(1);

        Taslar[1][2] = new Fil(0);
        Taslar[1][5] = new Fil(0);
        Taslar[6][2] = new Fil(1);
        Taslar[6][5] = new Fil(1);

        Taslar[1][3] = new Vezir(0);
        Taslar[6][3] = new Vezir(1);

        Taslar[1][4] = new Sah(0);
        Taslar[6][4] = new Sah(1);
    }

    public void displayBoard(){
        System.out.println("     1  2  3  4  5  6  7  8" + "\n");

        for(int i = 0 ; i < 8 ; i++){
            System.out.print((char)(i + 97) + "    ");

            for(int j = 0; j < 8 ; j++){
                if(Taslar[i][j] != null)
                    System.out.print(Taslar[i][j].toString() + "  ");
                else
                    System.out.print("-  ");
            }

            System.out.println();
        }
    }

    public boolean isPlayable(String move ,int turn){
        int fX = (int)move.charAt(0) - 97;
        int fY = (int)move.charAt(1) - 49;

        int lX = (int)move.charAt(3) - 97;
        int lY = (int)move.charAt(4) - 49;

        if(Taslar[fX][fY] == null || Taslar[fX][fY].getColorCode() != turn
                || (Taslar[lX][lY] != null && Taslar[fX][fY].getColorCode() == Taslar[lX][lY].getColorCode())){
            return false;
        }
        else{
            return Taslar[fX][fY].isPlayable(fX,fY,lX,lY,Taslar);
        }
    }

    public Item play(String move){
        int fX = (int)move.charAt(0) - 97;
        int fY = (int)move.charAt(1) - 49;

        int lX = (int)move.charAt(3) - 97;
        int lY = (int)move.charAt(4) - 49;

        Item removedItem = removeItem(lX,lY);

        Taslar[lX][lY] = Taslar[fX][fY];
        Taslar[fX][fY] = null;

        return removedItem;
    }

    public Item removeItem(int lX,int lY){
        Item temp = Taslar[lX][lY];
        Taslar[lX][lY] = null;

        return temp;
    }

    public boolean sahKontrol(){
        int sahNum = 0;
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++) {
                if (Taslar[i][j] instanceof Sah)
                    sahNum++;
            }
        }

        if(sahNum != 2)
            return false;

        return true;
    }

    public void taslariKaydir(){
        Item[][] taslarKopya = new Item[8][8];

        for(int i = 0; i < 8 ; i++){
            for(int j = 0; j < 8 ; j++){
                taslarKopya[i][j] = Taslar[i][(j+1)%8];
            }
        }

        Taslar = taslarKopya;
    }
}
