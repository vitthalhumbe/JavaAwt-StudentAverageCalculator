import java.awt.*;
import java.awt.event.*;

public class FirstGUI extends WindowAdapter {
    private final Frame frame = new Frame("Student Average Calculator");
    private final Label messageBox;
    private final TextField studentName;
    private final TextField javaMarks;
    private final TextField pythonMarks;
    private final TextField cppMarks;

    public FirstGUI() {
        messageBox = new Label();
        studentName = new TextField();
        javaMarks = new TextField();
        pythonMarks = new TextField();
        cppMarks = new TextField();
        Label studentNameLabel = new Label("Name : ");
        Label javaLabel = new Label("Java :");
        Label pythonLabel = new Label("Python : ");
        Label cppLabel = new Label("C++ : ");

        studentNameLabel.setBounds(20, 80, 60, 25);
        studentName.setBounds(90, 80, 200, 25);

        javaLabel.setBounds(20, 110, 60, 25);
        javaMarks.setBounds(90, 110, 200, 25);

        pythonLabel.setBounds(20, 145, 60, 25);
        pythonMarks.setBounds(90, 145, 200, 25);

        cppLabel.setBounds(20, 190, 60, 25);
        cppMarks.setBounds(90, 190, 200, 25);

        SubmitButton submit = new SubmitButton("Submit");
        submit.setBounds(20, 230, 65, 40);

        ClearButton clear = new ClearButton("Clear");
        clear.setBounds(95, 230, 65, 40);

        messageBox.setBounds(20, 260, 450, 40);

        frame.add(studentName);
        frame.add(studentNameLabel);
        frame.add(javaLabel);
        frame.add(javaMarks);
        frame.add(pythonLabel);
        frame.add(pythonMarks);
        frame.add(cppLabel);
        frame.add(cppMarks);
        frame.add(submit);
        frame.add(clear);
        frame.add(messageBox);

        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.addWindowListener(this);
        frame.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.dispose();
        System.exit(0);
    }
    public static void main(String[] args) {
        new FirstGUI();
    }

    class ClearButton extends Button {
        public ClearButton(String label) {
            super(label);
            enableEvents(AWTEvent.ACTION_EVENT_MASK);
        }

        @Override
        protected void processActionEvent(ActionEvent e) {
            studentName.setText("");
            javaMarks.setText("");
            pythonMarks.setText("");
            cppMarks.setText("");
            messageBox.setText("");
        }
    }
    class SubmitButton extends Button {
        public SubmitButton(String label) {
            super(label);
            enableEvents(AWTEvent.ACTION_EVENT_MASK);
        }

        @Override
        protected void processActionEvent(ActionEvent e) {
            try {
                String[] dataArray = new String[4];
                dataArray[0] = studentName.getText();
                dataArray[1] = javaMarks.getText();
                dataArray[2] = pythonMarks.getText();
                dataArray[3] = cppMarks.getText();

                for (String c : dataArray) {
                    System.out.print(c + "   ");
                }
                System.out.println(" ");

                int Java_marks = Integer.parseInt(javaMarks.getText());
                int Python_marks = Integer.parseInt(pythonMarks.getText());
                int CPlusPlus_marks = Integer.parseInt(cppMarks.getText());
                double avg = (double) (Java_marks + Python_marks + CPlusPlus_marks) / 3;

                messageBox.setText("Average = " + avg);
            }
            catch (Exception n) {
                messageBox.setText("Exception occurred : " + n);
            }

        }

    }

}