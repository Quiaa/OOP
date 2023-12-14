import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class myGuessingGui extends JFrame implements ActionListener{
    private JLabel lbl;
    private JTextField jtfIn;
    private JButton btn;
    private int randNumber;
    private int counter = 1;

    public myGuessingGui(String title){
        setTitle(title);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(400,400);
        lbl = new JLabel();
        btn = new JButton("Confirm");
        btn.addActionListener(this);
        jtfIn = new JTextField(3);

        randNumber = (int)(Math.random()*100 + 1);

        add(jtfIn);
        add(btn);
        add(lbl);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int guess = Integer.parseInt(jtfIn.getText());
        if(counter <= 10){
            if(guess > randNumber) lbl.setText("Your guess is big" + "(cheat: " + randNumber+")");
            else if(guess < randNumber) lbl.setText("Your guess is small"+ "(cheat: " + randNumber+")");
            else lbl.setText("You found it you won");
            counter++;
        }
        else lbl.setText("10 turns passed you lose!");
    }

    public static void main(String[] args){
        new myGuessingGui("Guess the number between 1-100");
    }
    
}
