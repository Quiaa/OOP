public class Circle extends Shape{
    private double radius;
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    
    @Override
    public double area(){
        return Math.PI*radius*radius;
    }
}

