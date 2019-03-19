package com.netcracker;

import java.util.Objects;

public class MyPolynomial {
    double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = new double[coeffs.length];
        for(int i =0; i < coeffs.length;i++) {
            this.coeffs[i] = coeffs[i];
        }
    }

    public int getDegree(){
        return coeffs.length - 1;
    }

    public double[] getCoeffs(){
        return coeffs;
    }

    @Override
    public String toString(){
        String resultString = "";

        for (int i = coeffs.length-1; i >= 1; i--){
            if (coeffs[i]!=0)
            resultString = resultString + ("("+coeffs[i]+"x^"+i+") + ");
        }
        resultString = resultString + ("("+coeffs[0]+")");
        return resultString;
    }

    public double evaluate(double x){
        double result = 0;
        for(int i =0; i< coeffs.length-1; i++){
            result = result + (coeffs[i]*Math.pow(x,coeffs.length-i-1));
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right){
        double[] newCoeffs = new double[]{};
        if (right.getCoeffs().length > coeffs.length){
            for (int i = 0; i < coeffs.length - 1; i++){
                newCoeffs[i] = coeffs[i]+right.getCoeffs()[i];
            }
            for (int i = coeffs.length; i < right.getCoeffs().length-1; i++)
            {
                newCoeffs[i] = right.getCoeffs()[i];
            }
        }
        else {
            for (int i =0; i < right.getCoeffs().length - 1; i++){
                newCoeffs[i] = coeffs[i]+right.getCoeffs()[i];
            }
            for (int i = right.getCoeffs().length; i < coeffs.length; i++){
                newCoeffs[i] = coeffs[i];
            }
        }
        return  new MyPolynomial(newCoeffs);

    }

    public MyPolynomial multipy(MyPolynomial right){
        int newLength = (right.getCoeffs().length)*(coeffs.length)-1;
        double[] newCoeffs = new double[newLength];

        for (int i = 0; i < newCoeffs.length; i++){
            newCoeffs[i] = 0;
        }
        for (int i = 0; i < coeffs.length; i++){
            for (int j = 0; j < right.getCoeffs().length; j++){
                newCoeffs[i+j] = newCoeffs[i+j] + coeffs[i]*right.getCoeffs()[j];
            }
        }
        return new MyPolynomial(newCoeffs);
    }

    @Override
    public int hashCode(){
        int hashCode = 59;
        for (double item: coeffs) {
            hashCode = 31 * hashCode + (int)(Double.doubleToLongBits(item)^(Double.doubleToLongBits(item)>>>32));
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || !(object instanceof MyComplex)) return false;
        return  Objects.equals(coeffs,((MyPolynomial)object).coeffs);
    }
}
