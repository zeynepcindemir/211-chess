public class Item {
    private int colorCode;
    private int point;

    public Item(int colorCode){
        this.colorCode = colorCode;
        this.point = 0;
    }

    public int getColorCode() {
        return colorCode;
    }

    public int getPoint(){
        return point;
    }

    public void setPoint(int newPoint){
        this.point = newPoint;
    }

    public String toString(){
        if(this.colorCode == 0)
            return "i";
        else
            return "I";
    }

    public boolean isPlayable(int fX, int fY, int lX , int lY, Item[][] Taslar) {
        return false;
    }
}
