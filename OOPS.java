


public class OOPS{

    public static void main(String[] args) {
        Pen p1 = new Pen();

        p1.setColor("blue");
        System.out.println(p1.getcolor());
    }
}


class Pen{
    private  String color;
    private int tip;

    String getcolor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    void setColor(String color){
        this.color = color;
    }

    void setTip(int tip){
        this.tip = tip;
    }
}