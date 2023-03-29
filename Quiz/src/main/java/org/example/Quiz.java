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

   char answer;
   char guess;
   int index;
   int correctGuess = 0;
   int totalQuestion = questions.length; // keeps the program dynamic with the ".length". I can add and remove questions
   int result;
   int seconds = 10;

   JFrame frame = new JFrame();
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



   char[] answer = {
                       'A','B','C'
                  };


    public Quiz() {
    }
    public void nextQuestion(){

    }
    @Override
    public void actionPreformed(ActionEvent e) {

    }
    public void displayAnswer() {   // displays the answer

    }
    public void results(){ // method for the results
    }

}







