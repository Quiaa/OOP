public class App {
    public static void main(String[] args){
        Rectangle rec = new Rectangle(3, 2);
        Rectangle sqr = new Square(3);
        RectanglePrism prsm = new RectanglePrism(2, 3, 4);
        RectanglePrism cubic = new Cubic(3);

        System.out.println(prsm.Area());
        System.out.println(prsm.Circumference());
        System.out.println(prsm.Volume());
        System.out.println(cubic.Area());
        System.out.println(cubic.Circumference());
        System.out.println(cubic.Volume());

    }
}
