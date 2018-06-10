package CompGeom;

public class Driver {

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.drive();
    }

    public void drive(){
        Polygon p = new Polygon();
        p.add(new Vertex(0,3));
        p.add(new Vertex(0,0));
        p.add(new Vertex(3,0));
        p.add(new Vertex(3,3));
        double area = Polygon.Area(p);

    }
}
