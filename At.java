public class At extends Item{
    public At(int colorCode) {
        super(colorCode);
        this.setPoint(3);
    }

    @Override
    public boolean isPlayable(int fX, int fY, int lX , int lY, Item[][] Taslar) {
        int xGap = Math.abs(fX-lX);
        int yGap = Math.abs(fY-lY);

        if((xGap == 1 && yGap == 2) || (xGap == 2 && yGap == 1)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        if(this.getColorCode() == 0)
            return "A";
        else
            return "a";
    }
}
