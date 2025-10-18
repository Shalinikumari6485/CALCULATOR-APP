package CALCapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton add, sub, mul, div, dec, equ, del, clr;
    JPanel panel;

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(400, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        add(textField);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equ = new JButton("=");
        del = new JButton("Del");
        clr = new JButton("Clear");

        functionButtons[0] = add;
        functionButtons[1] = sub;
        functionButtons[2] = mul;
        functionButtons[3] = div;
        functionButtons[4] = dec;
        functionButtons[5] = equ;
        functionButtons[6] = del;
        functionButtons[7] = clr;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 18));
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mul);
        panel.add(dec);
        panel.add(numberButtons[0]);
        panel.add(equ);
        panel.add(div);

        add(panel);

        clr.setBounds(50, 420, 145, 50);
        del.setBounds(205, 420, 145, 50);
        add(clr);
        add(del);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == dec) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == sub) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mul) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == div) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equ) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': 
                    if(num2 != 0) result = num1 / num2;
                    else JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clr) {
            textField.setText("");
        }
        if (e.getSource() == del) {
            String text = textField.getText();
            textField.setText(text.length() > 0 ? text.substring(0, text.length() - 1) : "");
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
