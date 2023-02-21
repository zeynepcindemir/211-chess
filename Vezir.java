public class Vezir extends Item{
    public Vezir(int colorCode) {
        super(colorCode);
        this.setPoint(9);
    }

    @Override
    public boolean isPlayable(int fX, int fY, int lX, int lY, Item[][] Taslar) {
        int xGap = fX-lX;
        int yGap = fY-lY;

        int xGapAbs = Math.abs(xGap);
        int yGapAbs = Math.abs(yGap);

        if((xGap != 0 && yGap != 0) && (xGapAbs != yGapAbs)){
            return false;
        }

        if(xGapAbs == yGapAbs){
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
            else if(fX >lX) {
                if (fY > lY) {
                    for (int i = 1; i < xGap; i++) {
                        if (Taslar[lX + i][lY + i] != null)
                            return false;
                    }
                } else if (fY < lY) {
                    for (int i = 1; i < xGap; i++) {
                        if (Taslar[lX + i][fY + i] != null)
                            return false;
                    }
                }
            }

            return true;
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

            return true;
        }
    }

    @Override
    public String toString(){
        if(this.getColorCode() == 0)
            return "V";
        else
            return "v";
    }
}
