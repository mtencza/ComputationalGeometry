package App;

import CompGeom.Point2;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Controller {

    double canvasWidth = 1280;
    double canvasHeight = 720;

    public void initialize(Stage primaryStage){

        GridPane grid = initializeGrid();
        Scene primaryScene = new Scene(grid,canvasWidth,canvasHeight);

        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        doStuff(graphicsContext);

        grid.add(canvas,0,0);
        primaryStage.setScene(primaryScene);

    }

    public void show(Stage primaryStage){
        primaryStage.show();
    }



    private GridPane initializeGrid(){
        GridPane grid = new GridPane();
        grid.setHgap(0);
        grid.setVgap(0);

        grid.setPadding(new Insets(0,0,0,0));
        grid.setGridLinesVisible(true);

        return grid;
    }

    double scaleX = 20; //(pixels per unit)
    double scaleY = 20;
    double pointsPerXUnit = 10;//maybe make this change over time based on the function

    private void doStuff(GraphicsContext gc){ //make it draw amt of gridlines based on screenwidth and scale...
        drawAxes(gc);
        drawGridLines(gc);
        drawFunc(gc);
    }

    private double f(double x){
        return Math.pow(x, 2);
    }

    private void cartLine(GraphicsContext gc, double x1, double y1, double x2, double y2){
        gc.strokeLine(scaleX*x1 + canvasWidth /2, canvasHeight -(y1*scaleY) - canvasHeight /2, x2*scaleX + canvasWidth /2, canvasHeight -(y2*scaleY) - canvasHeight /2);
    }

    private void cartPoint(GraphicsContext gc, Point2 p){
        gc.fillOval(scaleX*p.getX() + canvasWidth /2, canvasHeight -(p.getY()*scaleY) - canvasHeight /2, 1, 2);
    }

    private void drawGridLines(GraphicsContext gc){

        gc.setStroke(Color.AQUAMARINE);

        for(double i = -canvasWidth /2*scaleX; i < canvasWidth /2*scaleX; i ++){
            if(i % 5 == 0){
                cartLine(gc, i, canvasHeight /2*scaleY, i, -canvasHeight /2*scaleY);
            }
            else{
                gc.setLineWidth(.5);
                cartLine(gc, i, canvasHeight /2*scaleY, i, -canvasHeight /2*scaleY);
                gc.setLineWidth(1);
            }
        }

        for(double i = -canvasHeight /2*scaleY; i < canvasHeight /2*scaleY; i ++){
            if(i % 5 == 0){
                cartLine(gc, -canvasWidth /2*scaleX, i, canvasWidth /2*scaleX, i);
            }
            else{
                gc.setLineWidth(.5);
                cartLine(gc, -canvasWidth /2*scaleX, i, canvasWidth /2*scaleX, i);
                gc.setLineWidth(1);
            }
        }

        gc.setStroke(Color.BLACK);
    }

    private void drawAxes(GraphicsContext gc) {
        gc.setLineWidth(2);
        cartLine(gc, 0, canvasHeight /2, 0, -canvasHeight /2);
        cartLine(gc, canvasWidth /2, 0, -canvasWidth /2, 0);
        gc.setLineWidth(1);
    }

    private void drawFunc(GraphicsContext gc){
        double xLow = -canvasWidth /2*scaleX;
        double xHigh = canvasWidth /2*scaleX;

        ArrayList<Point2> points = new ArrayList<Point2>();

        for(double i = xLow; i < xHigh; i = i + (1/pointsPerXUnit)){
            points.add(new Point2(i, f(i)));
        }

        for(int i = 0; i < points.size(); i ++){
            cartPoint(gc, points.get(i));
        }

    }
}
