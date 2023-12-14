import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class mygui extends JFrame{
    private JLabel label;
    private ImageIcon image;
    private JRadioButton rbIcardi;
    private JRadioButton rbWilfred;
    private JRadioButton rbZiyech;
    private JRadioButton rbKerem;

    public  class Pressed implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(rbIcardi.isSelected()){
                image = new ImageIcon(getClass().getResource("icardii.jpeg"));
            }
            else if (rbWilfred.isSelected()){
                image = new ImageIcon(getClass().getResource("wilfred.jpeg"));
            }
            else if(rbZiyech.isSelected()){
                image = new ImageIcon(getClass().getResource("ziyech.jpeg"));
            }
            else if(rbKerem.isSelected()){
                image = new ImageIcon(getClass().getResource("kerem.jpeg"));
            }
            label.setIcon(image);
        }
    }
    public mygui(String title){
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300,300);
        Pressed p = new Pressed();

        setLayout( new FlowLayout());
        rbIcardi = new JRadioButton("Icardi");
        rbIcardi.addActionListener(p);
        rbWilfred = new JRadioButton("Wilfred");
        rbWilfred.addActionListener(p);
        rbZiyech = new JRadioButton("Ziyech");
        rbZiyech.addActionListener(p);
        rbKerem = new JRadioButton("Kerem");
        rbKerem.addActionListener(p);

        ButtonGroup grp = new ButtonGroup();
        label = new JLabel(image);

        grp.add(rbIcardi);
        grp.add(rbWilfred);
        grp.add(rbZiyech);
        grp.add(rbKerem);

        JPanel rbPanel = new JPanel(new GridLayout(0,1));

        rbPanel.add(rbIcardi);
        rbPanel.add(rbWilfred);
        rbPanel.add(rbZiyech);
        rbPanel.add(rbKerem);
        rbPanel.setBorder(BorderFactory.createTitledBorder("Stars"));

        add(rbPanel, BorderLayout.LINE_START);
        add(label);

    }
}
