public class Piyon extends Item{
    public Piyon(int colorCode) {
        super(colorCode);
        this.setPoint(1);
    }

    @Override
    public boolean isPlayable(int fX, int fY, int lX , int lY,Item[][] Taslar){
        if(this.getColorCode() == 1){
            if(fX - lX == 1 && fY == lY)
                return true;
            else if(fX - lX == 1 && (fY - lY == 1 || fY - lY == -1)&& Taslar[lX][lY] != null)
                return true;
            else
                return false;
        }
        else{
            if(fX - lX == -1 && fY == lY)
                return true;
            else if(fX - lX == -1 && (fY - lY == 1 || fY - lY == -1)&& Taslar[lX][lY] != null)
                return true;
            else
                return false;
        }
    }

    @Override
    public String toString(){
        if(this.getColorCode() == 0)
            return "P";
        else
            return "p";
    }
}
