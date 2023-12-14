public class RectanglePrism extends Rectangle{
    private double depth;

    public RectanglePrism(double height, double width, double depth){
        super(height, width);
        this.depth=depth;
    }
    public double getDepth() {
        return depth;
    }
    public void setDepth(double depth) {
        this.depth = depth;
    }
    
    public double Volume(){
        return depth*super.Area();
    }

    @Override
    public double Area(){
        return depth*getLength()*2 + depth*getWidth()*2 + super.Area()*2;
    }
    @Override
    public double Circumference(){
        return depth*4 + getLength()*4 + getWidth()*4;        
    }

    
}
