import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.Scanner;

public class Calculator {
    private JTextField sumField;
    private JTextField averageField;
    private JTextArea text1;
    private JPanel MyPanel;


    public Calculator() {
        text1.getDocument().addDocumentListener(new   DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String s = text1.getText();
                Scanner reader = new Scanner(s);

                int count = 0;
                double avg,sum = 0;

                while (reader.hasNextDouble()){
                    count++;
                    sum+=reader.nextDouble();
                }

                avg = sum/count;

                sumField.setText(String.valueOf(sum));
                averageField.setText(String.valueOf(avg));
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("和与平均值");
        frame.setContentPane(new Calculator().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}