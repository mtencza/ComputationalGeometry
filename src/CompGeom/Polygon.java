package CompGeom;

import java.util.ArrayList;


public class Polygon extends ArrayList<Vertex> {

    public Polygon(){
        super();
    }

    public static double AreaTri(Vertex a,Vertex b,Vertex c){
        return
                (b.getX() - a.getX()) * (c.getY() - a.getY()) -
                (c.getX() - a.getX()) * (b.getY() - a.getY());
    }

    public static double Area(Polygon p){
        double sum = 0;
        Vertex head = p.get(0);
        int length = p.size();

        int currentIndex = 0;
        Vertex current = p.next(currentIndex);
        currentIndex++;

        Vertex next = p.next(currentIndex);

        while(currentIndex < (p.size()-2)){
            sum += AreaTri(head,current,next);

            current = p.next(currentIndex);
            currentIndex++;
            next = p.next(currentIndex);
        }

        return sum;
    }

    public Vertex next(int currentIndex){
        if(this.isEmpty() || this.size() == 1){
            return null;
        }
        else if(this.indexOf(this.getLast()) == currentIndex){
            return null;
        }
        else{
            return this.get(currentIndex + 1);
        }
    }

    public Vertex prev(int currentIndex){
        if(this.isEmpty() || this.size() == 1){
            return null;
        }
        else if(this.indexOf(this.getFirst()) == currentIndex){
            return null;
        }
        else{
            return this.get(currentIndex - 1);
        }
    }

    public Vertex getLast(){
        return this.get(this.size()-1);
    }

    public Vertex getFirst(){
        return this.get(0);
    }

}
