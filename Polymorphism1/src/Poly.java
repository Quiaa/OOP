public class Poly{
    public double area(Shape shape){
        return shape.area();
    }

    public void areaOfAllObjects(Shape list[]){
        for(int i = 0; i < list.length; i++){
            System.out.println("The area of "+ list[i].getClass().getName()+ ": "+ list[i].area());
        }
    }
    public static void main(String[] args){
        Shape shapes[] = new Shape[]{
            new Circle(1),
            new Rectangle(3, 2),
            new Triangle(2, 5)
        };

        Poly poly = new Poly();

        System.out.println("The area of circle is " + poly.area(shapes[0])); // tests area method
        poly.areaOfAllObjects(shapes); // tests areaOfAllObjects method
    }
}
