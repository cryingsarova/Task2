public class Main {
    public static void main(String[] args) {
        Ball ball = new Ball(11,11,10,-1,-1);//создаю мяч с движением в верхний левый угол
        Container container = new Container(0,0,50,50);
        System.out.println(container.collides(ball));
        ball.move();
        System.out.println(container.collides(ball));//проверка границ шара
        MyPolynomial pol = new MyPolynomial(2,1);
        double[] arr = new double [] {};
        MyPolynomial newPoly = pol.multipy(new MyPolynomial(-2,1));
        System.out.println(newPoly.toString());
    }
}
