public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(){}

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag){
        setReal(real);
        setImag(imag);
    }

    @Override
    public String toString(){
        return "("+real+"+"+imag+"i)";
    }

    public boolean isReal(){
        return real!=0.0 ? true : false;
    }

    public boolean isImaginary(){
        return imag!=0.0 ? true : false;
    }


    public boolean equals(double real, double imag) {
        return  (real == this.real && imag == this.imag)? true : false;
    }

    public boolean equals(MyComplex another){
        return (another.getReal() == this.real && another.getImag()==this.imag)? true : false;
    }

    public double magnitude(){
        return Math.sqrt(real*real + imag*imag);
    }

    public double argument(){
        if (real > 0){
             return Math.atan(imag/real);
        }
        else if (real < 0 && imag >= 0){
            return Math.PI + Math.atan(imag/real);
        }
        else if (real < 0 && imag < 0 ){
            return - Math.PI + Math.atan(imag/real);
        }
        else if (real == 0 && imag > 0){
            return Math.PI/2;
        }
        else if (real == 0 && imag < 0){
            return - Math.PI/2;
        }
        else {
            return 0;
        }
    }

    public MyComplex add(MyComplex right){
        setValue(real+right.getReal(),imag+right.getImag());
        return this;
    }

    public MyComplex subtract(MyComplex right){
        setValue(real - right.getReal(), imag - right.getImag());
        return this;
    }

    public MyComplex multiply(MyComplex right){
        setValue(real*right.getReal() - imag*right.getImag(), real*right.getImag() + imag*right.getReal());
        return this;
    }

    public MyComplex divide(MyComplex right){
        setValue((real*right.getReal()+imag*right.getImag())/(right.getReal()*right.getReal()+right.getImag()*right.getImag()), (imag*right.getReal()-real*right.getImag())/(right.getReal()*right.getReal()+right.getImag()*right.getImag()));
        return this;

    }

    public MyComplex addNew(MyComplex right){
        return new MyComplex(real+right.getReal(),imag+right.getImag());
    }

    public MyComplex subtractNew(MyComplex right){
        return new MyComplex(real - right.getReal(),imag - right.getImag());
    }

    public MyComplex conjugate(){
        return new MyComplex(real, imag);
    }

}
