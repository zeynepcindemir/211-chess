public class Kale extends Item{
    public Kale(int colorCode) {
        super(colorCode);
        this.setPoint(5);
    }
    @Override
    public boolean isPlayable(int fX, int fY, int lX , int lY, Item[][] Taslar) {
        int xGap = fX-lX;
        int yGap = fY-lY;

        if(xGap != 0 && yGap != 0){
            return false;
        }
        else{
            if(xGap == 0){
                if(fY > lY) {
                    for (int i = lY + 1; i < fY; i++) {
                        if (Taslar[fX][i] != null)
                            return false;
                    }
                }
                else if(fY < lY){
                    for (int i = fY + 1; i < lY; i++) {
                        if (Taslar[fX][i] != null)
                            return false;
                    }
                }
            }
            else if(yGap == 0){
                if(fX > lX) {
                    for (int i = lX + 1; i < fX; i++) {
                        if (Taslar[i][fY] != null)
                            return false;
                    }
                }
                else if(fX < lX){
                    for (int i = fX + 1; i < lX; i++) {
                        if (Taslar[i][fY] != null)
                            return false;
                    }
                }
            }
        }

        return true;
    }

    @Override
    public String toString(){
        if(this.getColorCode() == 0)
            return "K";
        else
            return "k";
    }
}
