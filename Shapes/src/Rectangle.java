public class Rectangle{
    private double length;
    private double width;

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double Area(){
        return length * width;
    }
    public double Circumference(){
        return length*2 + width*2;
    }

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }
}
