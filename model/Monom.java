package model;

public class Monom {
    int grad;
    double coeff;

    public Monom(int grad, double coeff) {
        this.grad = grad;
        this.coeff = coeff;
    }

    public int getGrad() {return grad;}

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

    public Monom divide(Monom mi){
        Monom result = new Monom (0, 0);
        result.grad = this.grad - mi.grad;
        result.coeff = this.coeff / mi.coeff;

        return result;
    }

    public void printMonom(){
        System.out.print(String.format("%.0f", this.coeff) + "x" + "^" + this.grad + " ");
    }
}
