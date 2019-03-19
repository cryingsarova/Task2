package com.netcracker;

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

    @Override
    public int hashCode(){
        int hashCode = 59;
        hashCode = 31* hashCode + x1;
        hashCode = 31* hashCode + y1;
        hashCode = 31* hashCode + x2;
        hashCode = 31* hashCode + y2;
        return hashCode;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || !(object instanceof Container)) return false;
        return x1 == ((Container) object).x1 && y1 == ((Container) object).y1 &&
                x2 == ((Container) object).x2 && y2 == ((Container) object).y2;
    }
}
