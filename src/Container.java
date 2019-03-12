public class Container {
    int x1;
    int y1;
    int x2;
    int y2;

    public Container(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1+width;
        this.y2 = y1+height;
    }

    public int getX(){
        return x1;
    }

    public int getY(){
        return y1;
    }

    public int getWidth(){
        return Math.abs(x2 - x1);
    }
    public int getHeight(){
        return Math.abs(y2 - y1);
    }

    public boolean collides(Ball ball){
        if ((ball.getX()-ball.getRadius()) > x1 && (ball.getX()+ball.getRadius()) < x2 && (ball.getY()-ball.getRadius()) > y1 && (ball.getY()+ball.getRadius()) < y2){
            return true;
        }
        else return false;
    }
}
