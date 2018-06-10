package CompGeom;

public class Point2 {
    private Integer x;
    private Integer y;

    public Point2(Integer x,Integer y){
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public static double Distance(Point2 A, Point2 B) //returns the distance of two points
    {
        double distance = Math.sqrt(Math.pow((A.getX()-B.getX()),2)+Math.pow((A.getY()-B.getY()),2));
        return distance;
    }


}