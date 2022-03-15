package view;

import controller.MainController;

import javax.swing.*;

public class MainView extends JFrame {
    private JPanel mainPanel;
    private JLabel labelTitle;
    private JTextField insertPolynomTextField;
    private JTextField insertPolynomTextField2;
    private JButton buttonAdd;
    private JTextField resultTextField;
    private JButton buttonSub;
    private JButton buttonMultiply;
    private JButton buttonIntegrate;
    private JButton buttonDerivate;

    public MainView() {


            super("MainView");
            setContentPane(mainPanel);
            setSize(450, 180);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setVisible(true);

        this.buttonAdd.addActionListener(this.mainController);
        this.buttonSub.addActionListener(this.mainController);
        this.buttonMultiply.addActionListener(this.mainController);
        this.buttonIntegrate.addActionListener(this.mainController);
        this.buttonDerivate.addActionListener(this.mainController);
            }
            MainController mainController = new MainController(this);

    public JTextField getInsertPolynomTextField() {
        return this.insertPolynomTextField;
    }
    public JTextField getInsertPolynomTextField2() {
        return this.insertPolynomTextField2;
    }
    public JButton getButtonAdd(){return this.buttonAdd;}
    public JButton getButtonSub(){return this.buttonSub;}
    public JButton getButtonMultiply() {return buttonMultiply;}
    public JButton getButtonIntegrate() {return buttonIntegrate;}
    public JButton getButtonDerivate() {return buttonDerivate;}
    public JTextField getResultTextField(){return this.resultTextField;}

 }



