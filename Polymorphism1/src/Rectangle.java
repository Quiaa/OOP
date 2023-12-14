public class Rectangle extends Shape{
    private double width;
    private double height;
    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public double area(){
        return width*height;
    }
}
