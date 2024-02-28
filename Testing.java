import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Testing implements ActionListener {
    JFrame frame;
    JTextField tf1, tf2, answerField, number_system_Field, remainder;
    JLabel label, remainderLabel;
    JButton[] functionButton = new JButton[5];
    JButton[] systemButton = new JButton[5];
    JButton negButton, clrButton;
    JButton addButton, subButton, mulButton, divButton, equButton;
    JButton decimalButton, binaryButton, quartButton, octButton, hexButton;
    JPanel panel;


    Font myFont = new Font("Times New Roman", Font.BOLD, 30);
    int base = 10; //initializing base as 10 so default is decimal


    Testing() {

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 600);
        frame.setLayout(null);
        tf1 = new JTextField();
        tf2 = new JTextField();
        answerField = new JTextField();
        number_system_Field = new JTextField();
        remainder = new JTextField();
        tf1.setBounds(50, 45, 200, 50);
        tf1.setFont(myFont);
        tf1.setEditable(true);
        tf2.setBounds(250, 45, 200, 50);
        tf2.setFont(myFont);
        tf2.setEditable(true);
        answerField.setBounds(50, 150, 400, 50);
        answerField.setFont(myFont);
        answerField.setEditable(true);
        number_system_Field.setBounds(50, 10, 42, 25);
        number_system_Field.setFont(new Font("Times New Roman", Font.BOLD, 15));
        number_system_Field.setEditable(true);
        remainder.setBounds(350, 200, 100, 25);
        remainder.setFont(new Font("Times New Roman", Font.BOLD, 15));
        remainder.setEditable(true);

        label = new JLabel("RESULT: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 20));
        label.setBounds(50, 120, 300, 30);

        remainderLabel = new JLabel("Remainder: ");
        remainderLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
        remainderLabel.setBounds(250, 200, 200, 25);


        negButton = new JButton("( — )");
        clrButton = new JButton("Clear");

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = equButton;


        decimalButton = new JButton("DEC");
        binaryButton = new JButton("BIN");
        quartButton = new JButton("QUA");
        octButton = new JButton("OCT");
        hexButton = new JButton("HEX");

        systemButton[0] = decimalButton;
        systemButton[1] = binaryButton;
        systemButton[2] = quartButton;
        systemButton[3] = octButton;
        systemButton[4] = hexButton;





        for (int i = 0; i < 5; i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for (int i = 0; i < 5; i++) {
            systemButton[i] = new JButton(String.valueOf(i));
            systemButton[i].addActionListener(this);
            systemButton[i].setFont(myFont);
            systemButton[i].setFocusable(false);
        }

        negButton.setBounds(50, 250, 200, 50);
        clrButton.setBounds(250, 250, 200, 50);

        panel = new JPanel();
        panel.setBounds(50, 330, 400, 150);
        panel.setLayout(new GridLayout(2, 5, 5, 5));

        panel.add(functionButton[0]);
        panel.add(functionButton[1]);
        panel.add(functionButton[2]);
        panel.add(functionButton[3]);
        panel.add(functionButton[4]);

        panel.add(decimalButton);
        panel.add(binaryButton);
        panel.add(quartButton);
        panel.add(octButton);
        panel.add(hexButton);


        decimalButton.addActionListener(this);
        binaryButton.addActionListener(this);
        quartButton.addActionListener(this);
        octButton.addActionListener(this);
        hexButton.addActionListener(this);
        negButton.addActionListener(this);
        clrButton.addActionListener(this);


        number_system_Field.setText("DEC");

        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(tf1);
        frame.add(tf2);
        frame.add(answerField);
        frame.add(number_system_Field);
        frame.add(remainder);
        frame.add(label);
        frame.add(remainderLabel);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        new Testing();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int number1;
        int number2;
        int answer;

        if (e.getSource() == decimalButton)
        {
            number_system_Field.setText("DEC");
            //the inputted values converted to decimal. assuming there is input. if statement?
            //base stays the same base as it was last time

            int num1_converted = Convert.toDecimal(base, tf1.getText());
            int num2_converted = Convert.toDecimal(base, tf2.getText());
            int answer_converted = Convert.toDecimal(base, answerField.getText());
            int remainder_converted = Convert.toDecimal(base, remainder.getText());


            //and now the base is changed to the chosen radix
            base = 10;

            tf1.setText(Integer.toString(num1_converted, base));
            tf2.setText(Integer.toString(num2_converted, base));
            answerField.setText(Integer.toString(answer_converted, base));
            remainder.setText(Integer.toString(remainder_converted, base));

        }
        if (e.getSource() == binaryButton)
        {
            number_system_Field.setText("BIN");

            int num1_converted = Convert.toDecimal(base, tf1.getText());
            int num2_converted = Convert.toDecimal(base, tf2.getText());
            int answer_converted = Convert.toDecimal(base, answerField.getText());
            int remainder_converted = Convert.toDecimal(base, remainder.getText());


            base = 2;

            tf1.setText(Integer.toString(num1_converted, base));
            tf2.setText(Integer.toString(num2_converted, base));
            answerField.setText(Integer.toString(answer_converted, base));
            remainder.setText(Integer.toString(remainder_converted, base));

        }

        if (e.getSource() == quartButton)
        {
            number_system_Field.setText("QUA");

            int num1_converted = Convert.toDecimal(base, tf1.getText());
            int num2_converted = Convert.toDecimal(base, tf2.getText());
            int answer_converted = Convert.toDecimal(base, answerField.getText());
            int remainder_converted = Convert.toDecimal(base, remainder.getText());

            base = 4;

            tf1.setText(Integer.toString(num1_converted, base));
            tf2.setText(Integer.toString(num2_converted, base));
            answerField.setText(Integer.toString(answer_converted, base));
            remainder.setText(Integer.toString(remainder_converted, base));

        }
        if (e.getSource() == octButton)
        {
            number_system_Field.setText("OCT");
            int num1_converted = Convert.toDecimal(base, tf1.getText());
            int num2_converted = Convert.toDecimal(base, tf2.getText());
            int answer_converted = Convert.toDecimal(base, answerField.getText());
            int remainder_converted = Convert.toDecimal(base, remainder.getText());


            base = 8;

            tf1.setText(Integer.toString(num1_converted, base));
            tf2.setText(Integer.toString(num2_converted, base));
            answerField.setText(Integer.toString(answer_converted, base));
            remainder.setText(Integer.toString(remainder_converted, base));

        }
        if (e.getSource() == hexButton)
        {
            number_system_Field.setText("HEX");
            int num1_converted = Convert.toDecimal(base, tf1.getText());
            int num2_converted = Convert.toDecimal(base, tf2.getText());
            int answer_converted = Convert.toDecimal(base, answerField.getText());
            int remainder_converted = Convert.toDecimal(base, remainder.getText());


            base = 16;

            tf1.setText(Integer.toString(num1_converted, base));
            tf2.setText(Integer.toString(num2_converted, base));
            answerField.setText(Integer.toString(answer_converted, base));
            remainder.setText(Integer.toString(remainder_converted, base));

        }


        number1 = Convert.toDecimal(base, tf1.getText());
        number2 = Convert.toDecimal(base, tf2.getText());


        if (e.getSource() == addButton) {
            answer = number1 + number2; //answer is in int and decimal
            answerField.setText(Integer.toString(answer, base));
            remainder.setText("");
        }
        if (e.getSource() == subButton) {
            answer = number1 - number2;
            answerField.setText(Integer.toString(answer, base));
            remainder.setText("");
        }
        if (e.getSource() == mulButton) {
            answer = number1 * number2;
            answerField.setText(Integer.toString(answer, base));
            remainder.setText("");
        }
        if (e.getSource() == divButton) {
            answer = number1 / number2;
            answerField.setText(Integer.toString(answer, base));
            int rem = number1 % number2;
            String remainder_in_system = Integer.toString(rem, base);
            remainder.setText(remainder_in_system);
        }

        //clearing everything
        if (e.getSource() == clrButton)
        {
            tf1.setText("");
            tf2.setText("");
            answerField.setText("");
            remainder.setText("");
        }
    }



    static class Convert {

        //for the alphabets in the hexadecimal system
        static int val(char c) {
            if (c >= '0' && c <= '9')
                return (int) c - '0';
            else
                return (int) c - 'a' + 10;
        }

        //converts number to decimal
        static int toDecimal(int base, String str) {
            int len = str.length();
            int power = 1;
            int num = 0;
            int i;

            for (i = len - 1; i >= 0; i--) {
                if (val(str.charAt(i)) >= base) {
                    System.out.println("Invalid Number");
                    return -1;
                }

                num += val(str.charAt(i)) * power;
                power = power * base;
            }

            return num;
        }
    }
}
