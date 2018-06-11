package CompGeom;

public class Driver {

    public static void main(String[] args){
        Driver driver = new Driver();
        driver.drive();
    }

    public void drive(){
        Polygon p = new Polygon();
        p.add(new Vertex(0.0,3.0));
        p.add(new Vertex(0.0,0.0));
        p.add(new Vertex(3.0,0.0));
        p.add(new Vertex(3.0,3.0));
        double area = Polygon.Area(p);

    }
}
