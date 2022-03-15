package controller;

import com.sun.tools.javac.Main;
import model.Monom;
import model.Operation;
import model.Polinom;
import view.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.PolicyNode;
import java.sql.SQLOutput;

public class MainController implements ActionListener {
    public Operation op = new Operation();
    private MainView v;
    public MainController(MainView m) {
        v = m;
    }

            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                String polinom1 = this.v.getInsertPolynomTextField().getText();
                String polinom2 = this.v.getInsertPolynomTextField2().getText();

                Polinom pol1 = new Polinom();
                Polinom pol2 = new Polinom();

                pol1 = pol1.parsing(polinom1);
                pol2 = pol2.parsing(polinom2);

                pol1.sortPolinom(pol1);
                pol2.sortPolinom(pol2);

                if (source == this.v.getButtonAdd()) {
                    Polinom result = new Polinom();
                    result = op.add(pol1, pol2);
                    v.getResultTextField().setText(result.toString());
                }

                if (source == this.v.getButtonSub()) {
                    Polinom result = new Polinom();
                    result = op.sub(pol1, pol2);
                    v.getResultTextField().setText(result.toString());
                }

                if(source == this.v.getButtonMultiply()){
                    Polinom result = new Polinom();
                    result = op.multiply(pol1, pol2);
                    v.getResultTextField().setText(result.toString());
                }

                if(source == this.v.getButtonIntegrate()){
                    Polinom result = new Polinom();
                    result = op.integrate(pol1);
                    v.getResultTextField().setText(result.toString());
                }

                if(source == this.v.getButtonDerivate()){
                    Polinom result = new Polinom();
                    result = op.derv(pol1);
                    v.getResultTextField().setText(result.toString());
                }
            }
}
