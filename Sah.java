public class Sah extends Item{
    public Sah(int colorCode) {
        super(colorCode);
    }

    @Override
    public boolean isPlayable(int fX, int fY, int lX, int lY, Item[][] Taslar) {
        int xGapAbs = Math.abs(fX-lX);
        int yGapAbs = Math.abs(fY-lY);

        if(xGapAbs * yGapAbs== 1)
            return true;
        else
            return false;
    }

    @Override
    public String toString(){
        if(this.getColorCode() == 0)
            return "S";
        else
            return "s";
    }
}
