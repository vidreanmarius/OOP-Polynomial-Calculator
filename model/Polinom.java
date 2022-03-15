package model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Polinom {
    public List<Monom> a = new LinkedList<>();

    @Override
    public String toString() {
        String result = "";
        for(Monom e: a){
            if(e.coeff > 0 && e.grad >=0) {
                if(e.grad == 0){
                    result = result + ("+" + String.format("%.0f", e.coeff));
                }else if (e.grad == 1) {
                    result = result + ("+" + String.format("%.0f", e.coeff) + "x" + " ");
                }else{
                    result = result + ("+" + String.format("%.0f", e.coeff) + "x" + "^" + e.grad + " ");
                }
            }
            if(e.coeff < 0 && e.grad >=0) {
                if(e.grad == 0){
                    result = result + ( String.format("%.0f", e.coeff));
                }else if (e.grad == 1) {
                    result = result + ( String.format("%.0f", e.coeff) + "x" + " ");
                }else {
                    result = result + (String.format("%.0f", e.coeff) + "x" + "^" + e.grad + " ");
                }
            }
            if(e.coeff == 0){
                result = result + "";
            }
        }
        return result;
    }

    public void printPolinom(){
        for(Monom e: a){
            if(e.coeff > 0 && e.grad >=0)
            System.out.print(String.format("%.0f", e.coeff) + "x" + "^" + e.grad + " ");
        }
    }

   public Polinom parsing(String expr){
        Polinom poli = new Polinom();
        int exp;
        double coeff;
        Pattern pattern = Pattern.compile("((?:((?:^|\\s*[+-]\\s*)\\d*)x(?:\\^(\\d+))?)|(?:[+-]\\s*\\d+))");
        Matcher matcher = pattern.matcher(expr);
        while (matcher.find()) {
            if(matcher.group(1).matches("[+-]\\s*\\d+")) {
                // the constant part
                exp = 0;
                coeff = Integer.parseInt(matcher.group(1).replace(" ", ""));
            }
            else {
                // a variable part
                if(matcher.group(2) != ""){
                    coeff = Integer.parseInt(matcher.group(2).replace(" ", ""));
                }else {
                    coeff = 1;
                }

                if(matcher.group(3) != "" && matcher.group(3) != null){
                    exp = Integer.parseInt(matcher.group(3));
                }else{
                    exp = 1;
                }
            }
            Monom m = new Monom(exp, coeff);
            poli.a.add(m);
        }
        return poli;
    }

    public void sortPolinom(Polinom p){
        List <Monom> sortedPolinom = p.a.stream().sorted(Comparator.comparingInt(Monom::getGrad).reversed()).collect(Collectors.toList());
        p.a = sortedPolinom;
    }

    public Monom getMonomWithDegree(int degree){
        for(Monom e : a){
            if(e.grad == degree)
                return e;
        }
        return null;
    }

    public Monom getMonomMax(){
        Monom result = new Monom(0, 0);
        for(Monom e : a){
            if(e.grad > result.grad){
                result.grad = e.grad;
                result.coeff = e.coeff;
            }
        }
        return result;
    }

    public int getGrad(){
        int result = 0;
        for(Monom e : a){
            if(e.grad > result){
                result = e.grad;
            }
        }
        return result;
    }


}
