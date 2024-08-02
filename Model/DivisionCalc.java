package Model;

public class DivisionCalc extends Calc {

    @Override
    public double result() {
        return x / y;
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        if (x == 0) {
            System.out.println("На ноль делить нельзя!!");
        }else{
            super.y = value;
        }        
    }
}
