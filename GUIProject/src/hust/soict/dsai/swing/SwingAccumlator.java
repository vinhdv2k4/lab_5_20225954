package hust.soict.dsai.swing;
import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SwingAccumlator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0;
    public SwingAccumlator(){
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));
        cp.add(new JLabel("Enter an Integer "));
        tfInput =new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());
        cp.add(new JLabel("The accumlator Sum is "));
        tfOutput = new JTextField(10);
        tfInput.setEditable(false);
        cp.add(tfOutput);
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
public static void main(String[] args) {
    new SwingAccumlator();
}
}
