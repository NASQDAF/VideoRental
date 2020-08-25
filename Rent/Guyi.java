package Rent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Guyi extends JFrame{


    JButton poisk, addic;
    JLabel dataread, l2, l3, l4;
    JTextField search, t2;
    int i, k;
    String a, b;

eHandler handler = new eHandler();

    public Guyi(String s){
        super(s);
        setLayout(null);

        Main mm = new Main();

        poisk = new JButton("Найти");
        poisk.setBounds(20, 20, 80, 30);


        addic = new JButton("Подключить");
        addic.setBounds(20, 60, 110, 30);


        dataread = new JLabel("<html>Lable <br> dfghjkll</html>");
        dataread.setBounds(0, 80, mm.si(0), mm.si(1)-80);

        l2 = new JLabel("Input second num,");
        l3 = new JLabel("");
        l4 = new JLabel("");


        search = new JTextField(10);
        search.setBounds(110, 20, 150, 30);


        t2 = new JTextField(10);


        add(addic);
        add(dataread);
        add(search);
        add(l2);
        add(t2);
        add(l3);
        add(l4);
        addic.addActionListener(handler);
        poisk.addActionListener(handler);
    }
    public class eHandler implements ActionListener{
        Main mm = new Main();
        int arp = 0;
        public void actionPerformed(ActionEvent e) {
            try{
                if (e.getSource() == addic){
                /*i = Integer.parseInt(t1.getText());
                k = Integer.parseInt(t2.getText());
                i++;
                k++;
                a=""+i;
                b=""+k;
                l3.setText(a);
                l4.setText(b);*/
                mm.openfile();
                mm.readfile();
                dataread.setText(mm.out());
                l4.setText(search.getText());
                if (arp==0) {
                    arp = 1;
                    add(poisk);
                }

                //System.out.println(mm.Sear(search.getText()));
                //System.out.println(search.getText());

                    java.util.List<java.util.List<String>> list = new ArrayList<List<String>>();
                    list.add(new ArrayList<String>());
                    list.get(0).add("a");

                }
                if(e.getSource()==poisk){
                search.setText(null);
                t2.setText(null);
                l3.setText(null);
                l4.setText(null);
                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Insert number instead of text");
            }
        }
    }
}
