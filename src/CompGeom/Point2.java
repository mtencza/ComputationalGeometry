package CompGeom;

public class Point2 {
    private Double x;
    private Double y;

    public Point2(Double x,Double y){
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public static double Distance(Point2 A, Point2 B) //returns the distance of two points
    {
        double distance = Math.sqrt(Math.pow((A.getX()-B.getX()),2)+Math.pow((A.getY()-B.getY()),2));
        return distance;
    }


}