package com.netcracker;

public class Ball {

    float x;
    float y;
    int radius;
    float xDelta;
    float yDelta;

    public Ball(float x, float y, int radius, float xDelta, float yDelta) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = xDelta;
        this.yDelta = yDelta;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move(){
        x = x + xDelta;
        y = y + yDelta;
    }

    public void reflectHorizontal(){
        x = x - xDelta;
    }

    public void reflectVertical(){
        y = y - yDelta;
    }

    @Override
    public String toString(){
        return "Ball[("+x+","+y+"),speed=("+xDelta+","+yDelta+")]";
    }

    @Override
    public int hashCode(){
        int hashCode = 59;
        hashCode = 31*hashCode+Float.floatToIntBits(x);
        hashCode = 31*hashCode+Float.floatToIntBits(y);
        hashCode = 31*hashCode+radius;
        hashCode = 31*hashCode+Float.floatToIntBits(xDelta);
        hashCode = 31*hashCode+Float.floatToIntBits(yDelta);

        return hashCode;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || !(object instanceof Ball)) return false;
        return x == ((Ball) object).x && y == ((Ball) object).y && radius == ((Ball) object).radius &&
                xDelta == ((Ball) object).xDelta && yDelta==((Ball) object).yDelta;
    }


}
