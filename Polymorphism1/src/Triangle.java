public class Triangle extends Shape{
    private double base;
    private double height;

    public void setBase(double base) {
        this.base = base;
    }
    public double getBase() {
        return base;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getHeight() {
        return height;
    }

    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    @Override
    public double area(){
        return 0.5*base*height;
    }
}
