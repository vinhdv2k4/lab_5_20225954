package hust.soict.dsai.swing; 
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumlator extends JFrame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0;
    public AWTAccumlator(){
        setLayout(new GridLayout(2, 2));
        add(new Label("Enter an Integer "));
        tfInput =new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());
        add(new Label("The accumlator Sum is "));
        tfOutput = new TextField(10);
        tfInput.setEditable(false);
        add(tfOutput);
        setTitle("AWT Accumlator ");
        setSize(350,120);
        setVisible(true);

}
private class TFInputListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent evt){
        int numIN = Integer.parseInt(tfInput.getText());
        sum += numIN;
        tfInput.setText("");
        tfOutput.setText(sum + "");
    }
}
public static void main(String[] args)  {
    new AWTAccumlator();
}
}
