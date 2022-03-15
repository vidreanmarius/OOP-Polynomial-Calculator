package model;

import java.util.ArrayList;
import java.util.List;

public class Operation {
    public Operation() {
    }

    public Polinom add(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        for ( Monom it: p1.a)
            result.a.add(it);

        for (Monom first : p2.a) {
            boolean found = false;
            for (Monom second : result.a) {
                if (first.grad == second.grad) {
                    found = true;
                    second.coeff += first.coeff;
                }
            }
            if (found == false) {
                result.a.add(first);
            }
        }
        result.sortPolinom(result);
        return result;
    }


    public Polinom sub(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        result.a = p1.a;

        for (Monom first : p2.a) {
            boolean found = false;
            for (Monom second : result.a) {
                if (first.grad == second.grad) {
                    found = true;
                    second.coeff -= first.coeff;
                }
            }
            if( found == false){
                first.coeff = first.coeff * (-1);
                result.a.add(first);
            }
        }
        result.sortPolinom(result);
        return result;
    }

    public Polinom derv(Polinom p) {
        for (Monom e : p.a) {
            e.coeff = e.coeff * e.grad;
            e.grad--;
        }
        return p;
    }

    public Polinom integrate(Polinom p) {
        for (Monom e : p.a) {
            e.grad++;
            e.coeff = e.coeff / e.grad;
        }
        return p;
    }

    public Polinom multiply(Polinom p1, Polinom p2) {
        Polinom result = new Polinom();
        Monom inter = new Monom(0, 0);
        Polinom intermediate = new Polinom();
        result.a.add(inter);

        for (Monom first : p1.a) {
            for (Monom second : p2.a) {
                int rGrad = first.grad + second.grad;
                double rCoeff = first.coeff * second.coeff;
                Monom temp = new Monom(rGrad, rCoeff);
                intermediate.a.add(temp);
            }
            result = add(result, intermediate);
            intermediate.a.clear();

        }
        return result;
    }


    //la impartire
    public List<Polinom> division(Polinom n, Polinom d) {
        List<Polinom> res = new ArrayList<Polinom>();
        Monom da = new Monom(0 , 0);
        Polinom q = new Polinom();
        Polinom r = n;
        while (r.getGrad() >= d.getGrad()) {

        }
      return res;
    }
}
