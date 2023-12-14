import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class maGui extends JFrame implements ActionListener{
    private JLabel lbl;
    private JTextField tfIn;
    private JButton btn;
    private int ROUNDCOUNT = 10;
    private int counter = 1;
    private int number;
    private int guess;
    private int min = 1;
    private int max = 100;

    public maGui(String title){
        setTitle(title);
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout());

        btn = new JButton("Button");
        btn.addActionListener(this);
        tfIn = new JTextField(8);

        lbl = new JLabel();

        add(tfIn);
        add(btn);
        add(lbl);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(counter == 1){
            number = Integer.parseInt(tfIn.getText());
            guess = (int)(Math.random()*100 + 1);
            lbl.setText("Computer's guess: "+Integer.toString(guess)+"|min " + min +"|max "+ max+ "|counter " + counter+ "|number "+ number);
        }
        else if(counter > 1 && counter <= ROUNDCOUNT){
            if(tfIn.getText().equals("up")){     
                if(number <= guess){
                    lbl.setText("YOU CHEATED!!!");
                }
                else{
                    if(min < guess) min = guess;
                    guess = (int)(Math.random()*(max-min) + min);
                    lbl.setText("Computer's guess: "+Integer.toString(guess)+"|min " + min +"|max "+ max+ "|counter " + counter+ "|number "+ number);
                }
            }
            else if(tfIn.getText().equals("down")){
                 if(number >= guess){
                    lbl.setText("YOU CHEATED!!!");
                }
                else{
                    if(max > guess)max = guess;
                    guess = (int)(Math.random()*(max-min) + min);    
                    lbl.setText("Computer's guess: "+Integer.toString(guess)+ "|min " + min +"|max "+ max+ "|counter " + counter+ "|number "+ number);
                }
            }
            else if(tfIn.getText().equals("correct")){
                if(guess != number) lbl.setText("YOU CHEATED it is not correct");
                else lbl.setText("Computer wins!!");
            }
        }
        else if(counter >= ROUNDCOUNT){
            lbl.setText("Game over you win! Computer lose");
        }
        
        counter++;
        tfIn.setText("");
    }

    public static void main(String[] args){
        maGui gui = new maGui("First enter a number between 1-100||Then write one of :'up' | 'down' | 'correct'");
    }
}
