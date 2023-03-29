package org.example;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Quiz implements ActionListener{
    String[] questions = { "Which is a principle of OOP?", "Test","Test Test"
                         }; // hold all questions

   String[][] options = {
                                    {"Test1", "Test2", "Test3", "Test4"},
                                    {"Test1", "Test2", "Test3", "Test4"},
                                    {"Test1", "Test2", "Test3", "Test4"},
                        }; // contains quiz options
    char[] answers = {
            'A','B','C'
                     };
   char guess;
   int index;
   int correctGuess = 0;
   int totalQuestion = questions.length; // keeps the program dynamic with the ".length". I can add and remove questions
   int result;
   int seconds = 10;

   JFrame frame = new JFrame(); // creates an object of the JFrame called frame
   JTextField  textField = new JTextField();
   JTextArea textArea = new JTextArea();
   JButton buttonA = new JButton();
   JButton buttonB = new JButton();
   JButton buttonC = new JButton();
   JButton buttonD = new JButton();
   JLabel answerLabelA = new JLabel();
   JLabel answerLabelB = new JLabel();
   JLabel answerLabelC = new JLabel();
   JLabel answerLabelD= new JLabel();
   JLabel timeL = new JLabel();
   JLabel secondsLeft = new JLabel();
   JTextField numberRight = new JTextField();
   JTextField percentage = new JTextField();






    public Quiz() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(220,223,228)); // sets background color
        frame.setLayout(null);
        frame.setResizable(false);

        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,100,0));
        textField.setFont(new Font("Ink Free", Font.BOLD,30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);


        textArea.setBounds(0,50,650,50);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("MV Boli", Font.BOLD,25));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);



        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD,35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD,35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD,35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD,35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");




        answerLabelA.setBounds(125,100,500,100);
        answerLabelA.setBackground(new Color(220,223,228));
        answerLabelA.setForeground(new Color(25,255,0));
        answerLabelA.setFont(new Font("MV Boli", Font.PLAIN,35));


        answerLabelB.setBounds(125,200,500,100);
        answerLabelB.setBackground(new Color(220,223,228));
        answerLabelB.setForeground(new Color(25,255,0));
        answerLabelB.setFont(new Font("MV Boli", Font.PLAIN,35));


        answerLabelC.setBounds(125,300,500,100);
        answerLabelC.setBackground(new Color(220,223,228));
        answerLabelC.setForeground(new Color(25,255,0));
        answerLabelC.setFont(new Font("MV Boli", Font.PLAIN,35));


        answerLabelD.setBounds(125,400,500,100);
        answerLabelD.setBackground(new Color(220,223,228));
        answerLabelD.setForeground(new Color(25,255,0));
        answerLabelD.setFont(new Font("MV Boli", Font.PLAIN,35));


        secondsLeft.setBounds(535,510,100,100);
        secondsLeft.setBackground(new Color(25,25,25));
        secondsLeft.setForeground(new Color(255,0,0));
        secondsLeft.setFont(new Font("Ink Free",Font.BOLD,60));
        secondsLeft.setBorder(BorderFactory.createBevelBorder(1));
        secondsLeft.setOpaque(true);
        secondsLeft.setHorizontalAlignment(JTextField.CENTER);
        secondsLeft.setText(String.valueOf(seconds));


        frame.add(secondsLeft);  // ---------------------------------------//
        frame.add(answerLabelA);
        frame.add(answerLabelB);
        frame.add(answerLabelC);
        frame.add(answerLabelD);


        frame.add(buttonA);  
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);  // --------Adds to the frame ---------------//

        frame.add(textArea);
        frame.add(textField);  // ---------------------------------------//
        frame.setVisible(true);
    }
    public void nextQuestion(){

    }

    public void displayAnswer() {   // displays the answer

    }
    public void results(){ // method for the results
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}







