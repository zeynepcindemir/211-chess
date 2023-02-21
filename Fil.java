public class Fil extends Item {
    public Fil(int colorCode) {
        super(colorCode);
        this.setPoint(3);
    }

    @Override
    public boolean isPlayable(int fX, int fY, int lX, int lY, Item[][] Taslar) {
        int xGap = Math.abs(fX-lX);
        int yGap = Math.abs(fY-lY);

        if(xGap != yGap) {
            return false;
        }
        else{
            if(fX < lX){
                if(fY > lY) {
                    for (int i = 1 ; i < xGap; i++) {
                        if (Taslar[fX+i][lY+i] != null)
                            return false;
                    }
                }
                else if(fY < lY){
                    for (int i = 1; i < xGap; i++) {
                        if (Taslar[fX+i][fY+i] != null)
                            return false;
                    }
                }
            }
            else if(fX >lX){
                if(fY > lY) {
                    for (int i = 1; i < xGap; i++) {
                        if (Taslar[lX+i][lY+i] != null)
                            return false;
                    }
                }
                else if(fY < lY){
                    for (int i = 1; i < xGap; i++) {
                        if (Taslar[lX+i][fY+i] != null)
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
            return "F";
        else
            return "f";
    }
}
