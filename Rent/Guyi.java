package Rent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.AreaAveragingScaleFilter;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.*;
import java.util.List;

import static Rent.Main.*;

public class Guyi extends JFrame{







    JButton poisk, addic, turn, addu, dele, reda, accep, addmen, turnuf;
    JLabel dataread, l2, l3, l4, lname, lpass, ldat, lday, lfilm;
    JTextField search, tfilm, tname, tpass, tdat, tday;
    int p;
    int i;
    int k;
    int y=30;
    int x=20;
    int lx=5;
    int lp;
    static int check = 1;
    int ispoisk = 0;
    int t2gre; int [] tempindex;
    String a, b, write;
    String [] wril;String pathus="res//users.txt", pathfilm="res//1.txt"; String cpls = System.getProperty("line.separator");
    JList list;
    eHandler handler = new eHandler();
    int element;

    int co(int n){
        int fg, c= 5;

        fg= (y+c)*(n-1)+20;
        return fg;
    }

    private void reloadListFile() throws FileNotFoundException, UnsupportedEncodingException {
        Main mm = new Main();
        String s= "", pa = "";String [][] asst = new String[0][];
        int l=0;
        if(check == 1){
            pa = pathfilm;
            l=fi.length;
             asst = new String[l][];
            for(int i = 0; i<fi.length;i++)
                asst[i]= fi[i].getStr();
        }
        else if (check == 0){
            pa = pathus;
            l=us.length;
            asst = new String[l][];
            for(int i = 0; i<us.length;i++)
                asst[i]= us[i].getStr();
        }
        
        PrintWriter writer = new PrintWriter(pa, "UTF-8");
        writer.close();

        for(int i = 0; i<asst.length;i++){
            for(int j = 0;j<asst[i].length;j++){
                s+=asst[i][j];
//                if (j!=asst[i].length-1)
//                    s+=";";
                if (j==asst[i].length-1){
                    s= s.replaceAll("  ", " ").replaceAll("\\[", "").replaceAll("]", "");
                    s+=cpls;
                }
            }
            mm.WrvF(s, pa);
            s="";
        }
    }
    public int gimmeint(int i){
        int ae = tempindex[i];
        return ae;
    }
    public String[] sshow(int a){
        String [] see = new String[0];

        if(a == 1){
            see = new String[fi.length];
            for(int i =0;i<fi.length;i++){
                see[i] = Arrays.toString(fi[i].getStr()).replaceAll("\\[", "").replaceAll("]","").replaceAll(";,",";");
            }

        }
        if (a == 0){
            see = new String[us.length];
            for(int i =0;i<us.length;i++){
                see[i] = Arrays.toString(us[i].getStr()).replaceAll("\\[", "").replaceAll("]","").replaceAll(";,",";");
            }

        }
        return see;
    }

    int t2g(){
        int t2g; // temp to global
        int listpoint = list.getSelectedIndex();
        if (ispoisk == 1) t2g = gimmeint(listpoint);
        else t2g = listpoint;//
        return t2g;
    }

    private String [][] getAF() throws ParseException {
        Algoritm a = new Algoritm();
        String [][] tempstr = new String[0][];
        if (check == 0){
            tempstr= new String[us.length][];
            for (int i = 0;i<a.ref("u").length;i++)
                tempstr[i] = us[i].getStr();
        }
        else if(check == 1){
            tempstr= new String[fi.length][];
            for (int i = 0;i<a.ref("f").length;i++)
                tempstr[i] = fi[i].getStr();
        }
        return tempstr;
    }
    
    public Guyi(String s){
        super(s);
        setLayout(null);

        Main mm = new Main();

        poisk = new JButton("Найти");
        poisk.setBounds(x, co(1), 80, y);


        addic = new JButton("Просроченные");
        addic.setBounds(co(14), co(5), 160, y);

        turn = new JButton("Дополнительно");
        turn.setBounds(co(14), co(1), 160, y);

        dele = new JButton("Удалить");
        dele.setBounds(co(14), co(2), 160, y);

        reda = new JButton("Редактировать");
        reda.setBounds(co(14), co(3), 160, y);

        accep = new JButton("Принять изменения");
        accep.setBounds(co(14), co(3), 160, y);

        addmen = new JButton("Добавить клиента");
        addmen.setBounds(co(14), co(2), 160, y);

        turnuf = new JButton("Добавить фильм");
        turnuf.setBounds(co(14), co(4), 160, y);

        addu = new JButton("Добавить");
        addu.setBounds(x, co(6), 100, y);

        l2 = new JLabel("Input second num,");
        l3 = new JLabel("");
        l4 = new JLabel("");


        dataread = new JLabel("<html>Lable <br> dfghjkll</html>");
        dataread.setBounds(0, co(4)-5, mm.si(0), mm.si(1)-80);

        search = new JTextField(10);
        search.setBounds(co(5), co(1), 300, 30);
        poisk.setBounds(x, co(1), 80, y);

        tname = new JTextField(10);
        tname.setBounds(co(5), co(1), 300, 30);
        lname = new JLabel("Имя");
        lname.setBounds(x, co(1)+lx, 140, 20);

        tdat = new JTextField(10);
        tdat.setBounds(co(5), co(2), 300, 30);
        ldat = new JLabel("Дата получения");
        ldat.setBounds(x, co(2)+lx,140, 20);

        tday = new JTextField(10);
        tday.setBounds(co(5), co(3), 300, 30);
        lday = new JLabel("Срок одалживания");
        lday.setBounds(x, co(3)+lx,140, 20);

        tpass = new JTextField(10);
        tpass.setBounds(co(5), co(4), 300, 30);
        lpass = new JLabel("Паспортные данные");
        lpass.setBounds(x, co(4)+lx,140, 20);

        tfilm = new JTextField(10);
        tfilm.setBounds(co(5), co(5), 300, 30);
        lfilm = new JLabel("Название фильма");
        lfilm.setBounds(x, co(5)+lx,140, 20);

        l3.setBounds(0, co(7), mm.si(0), mm.si(1)-co(7));


        list=  new JList();
        list.setBounds(x, co(3), mm.si(0)- co(2), mm.si(1)-co(3));
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);



        add(addic);addic.setVisible(false);
        //add(dataread);
        add(search);
        add(addu);add(tname);add(tdat);add(tday);add(tpass);add(tfilm);
        tname.setVisible(false);
        tdat.setVisible(false);
        tday.setVisible(false);
        tpass.setVisible(false);
        tfilm.setVisible(false);
        addu.setVisible(false);

        add(reda); reda.setVisible(false);

        add(lname);lname.setVisible(false);
        add(ldat);ldat.setVisible(false);
        add(lday); lday.setVisible(false);
        add(lpass); lpass.setVisible(false);
        add(lfilm); lfilm.setVisible(false);
        add(accep); accep.setVisible(false);
        add(l4);
        add(turn);
        add(poisk);
        add(dele);dele.setVisible(false);
        add(list);
        add(addmen);
        add(turnuf);turnuf.setVisible(false);

        addu.addActionListener(handler);
        addic.addActionListener(handler);
        poisk.addActionListener(handler);
        turn.addActionListener(handler);
        dele.addActionListener(handler);
        reda.addActionListener(handler);
        accep.addActionListener(handler);
        addmen.addActionListener(handler);
        turnuf.addActionListener(handler);


        list.setListData(sshow(1));

        list.setSelectedIndex(0);
    }
    
    public class eHandler implements ActionListener{
        Algoritm a = new Algoritm();
        int arp = 0;
        public void actionPerformed(ActionEvent e) {
            try{
                Main mm = new Main();
                if (e.getSource() == addic){ //Просроченные

                    ArrayList<List<String>> glob = new ArrayList<List<String>>();
                    tempindex = a.expir(sshow(0));
                    for (int i = 0; i<tempindex.length;i++)
                        glob.add(i, Arrays.asList(sshow(0)[tempindex[i]]));
                    list.setListData(glob.toArray());
                    check = 0;
                }
                if(e.getSource()==poisk){ //Вызов алгоритма поиска
                    String[] t;
                    if(check == 1) {
                        t = new String[fi.length];
                    if(check == 0)
                        t = new String[us.length];

                    String s = search.getText().toString();
                    if(check == 1) {
                        t = a.temparr(a.ref("f"), s);
                    }
                    else if (check == 0){
                        t = a.temparr(a.ref("u"), s);
                    }

                    list.setListData(t);
                    ispoisk=1;
                    list.setSelectedIndex(0);
                    tempindex = a.mpos(s);
                    }
                }

                if(e.getSource()==addu) { //Добавление  пользоавтеля
                    String[] er;
                    int d = 0;
                    write = tname.getText() + ";" + tdat.getText() + ";" + tday.getText() + ";" + tpass.getText() + ";" + tfilm.getText()+cpls;
                    wril = new String[]{tname.getText(), tdat.getText(), tday.getText(), tpass.getText(), tfilm.getText()};
                    String pa;
                    if(check == 1)
                        d = fi.length;
                    else if (check == 0)
                        d= us.length;
                    er = new String[d];

                    if(check == 1) {
                        pa = pathfilm;
                        mm.WrvF(write, pa);
                        er = a.ref("f");
                    }
                    else if (check == 0){
                        pa = pathus;
                        mm.WrvF(write, pa);
                        er = a.ref("u");
                    }
                    list.setListData(er);
                    ispoisk = 0;
                }


                if(e.getSource() == reda){ //Редактировать
                    t2gre = t2g();

                    //List<List<String>> grp = new List<List<String>>(mm.ou()) {
                    int i = 0;
                    tname.setText(mm.ou().get(t2gre).get(i).toString()); i++;
                    tdat.setText(mm.ou().get(t2gre).get(i).toString()); i++;
                    tday.setText(mm.ou().get(t2gre).get(i).toString()); i++;
                    tpass.setText(mm.ou().get(t2gre).get(i).toString()); i++;
                    tfilm.setText(mm.ou().get(t2gre).get(i).toString()); i++;
                    accep.setVisible(true);
                    reda.setVisible(false);
                }

                if(e.getSource() == accep){ //Принять изменение
                    String []s; String c = "";
                    s = new String[] {tname.getText(), tdat.getText(), tday.getText(), tpass.getText(), tfilm.getText()};
                   
                    if (check == 1){fi[t2gre].setStr(s); c="f";}
                    else if(check == 0){us[t2gre].setStr(s);c="u";}
                    
                    tname.setText(null);
                    tdat.setText(null);
                    tday.setText(null);
                    tpass.setText(null);
                    tfilm.setText(null);
                    
                    reloadListFile();
                    
                    list.setListData(a.ref(c));
                    ispoisk = 0;
                    reda.setVisible(true);
                    accep.setVisible(false);
                }


                if(e.getSource() == addmen){ //Перенести фильм и добавить пользователя
                    tfilm.setText(null);
                    int t2g = t2g();
                    tfilm.setText(a.ref("f")[t2g].split(";")[0]);
                    list.setListData(a.ref("u"));
                    turn.setText("Скрыть");
                    turn.doClick();
                    ispoisk = 0;
                }

                if(e.getSource() == turnuf){ //Переключиться между добавлением фильма и клиента
                    if(check == 0) {
                        check = 1;

                        lname.setText("Название");
                        ldat.setText("Год");
                        lday.setText("Жанры(через запятую)");
                        lpass.setText("Цена");
                        lfilm.setText("Количество");
                        tname.setText(tfilm.getText());
                        tfilm.setText(null);
                        turnuf.setText("Добавить клиента");
                        list.setListData(a.ref("f"));
                        addic.setVisible(false);
                        ispoisk = 0;
                    }
                    else if(check==1){
                        check = 0;

                        lname.setText("Имя");
                        ldat.setText("Дата получения");
                        lday.setText("Срок одалживания");
                        lpass.setText("Паспортные данные");
                        lfilm.setText("Название фильма");
                        addic.setVisible(true);
                        tfilm .setText(tname.getText());
                        tname.setText(null);
                        turnuf.setText("Добавить фильм");
                        list.setListData(a.ref("u"));
                        ispoisk = 0;
                    }
                    //tfilm tpass tday tdat  tname
                }
// poisk(ком)   0
// int [] i poisk
//i[] 0, 2
// tempmas [0, 2]
// list.setDate(tempmas)
//
//

                if(e.getSource() == dele){ //Удалить пользователя
                    int t2g = t2g();
                   // String[][] temp = getAF();

                    String [][] tempstr = new String[0][];
                    if (check == 0){
                        tempstr= new String[us.length][];
                        for (int i = 0;i<a.ref("u").length;i++)
                            if (t2g!=i)
                                tempstr[i] = us[i].getStr();
                        us = null;
                        getQue(0);
                        for (int i = 0;i<tempstr.length;i++)
                            us[i].setStr(tempstr[i]);
                    }

                    else if(check == 1){
                        tempstr= new String[fi.length][];
                        for (int i = 0;i<a.ref("f").length;i++)
                            if (t2g!=i)
                                tempstr[i] = fi[i].getStr();
                        fi = null;
                        getQue(1);
                        fi[0] = new Film(tempstr[0][0], tempstr[0][1], tempstr[0][2].split(","),Double.parseDouble(tempstr[0][3]),tempstr[0][4]);
                        for (int i = 0;i<tempstr.length;i++)
                            fi[i].setStr(tempstr[i]);
                    }
                    reloadListFile();
                    list.setListData(tempstr);
                    ispoisk = 0;
                }

                if(e.getSource()==turn){ //Смена интерфейса
                    if(arp==0) {

                        tname.setVisible(true); // Второе меню
                        tdat.setVisible(true);
                        tday.setVisible(true);
                        tpass.setVisible(true);
                        tfilm.setVisible(true);

                        addu.setVisible(true);
                        reda.setVisible(true);
                        dele.setVisible(true);
                        addic.setVisible(true);
                        turnuf.setVisible(true);

                        ldat.setVisible(true);
                        lname.setVisible(true);
                        lday.setVisible(true);
                        lpass.setVisible(true);
                        lfilm.setVisible(true);


                        //Первое меню
                        //dataread.setVisible(false);
                        addmen.setVisible(false);
                        search.setText("");
                        search.setBounds(co(7), co(6), 300, 30);
                        poisk.setBounds(co(4), co(6), 80, y);

                        turn.setText("Скрыть");

                        list.setListData(a.ref("u"));
                        list.setBounds(x, co(7), mm.si(0)- co(2), mm.si(1)-co(7));
                        ispoisk = 0;
                        check = 0;
                        arp=1;
                    }else if(arp==1){

                        tname.setVisible(false); //Второе меню
                        tdat.setVisible(false);
                        tday.setVisible(false);
                        tpass.setVisible(false);
                        tfilm.setVisible(false);

                        addu.setVisible(false);
                        reda.setVisible(false);
                        dele.setVisible(false);
                        addic.setVisible(false);
                        turnuf.setVisible(false);

                        //dataread.setVisible(true);
                        ldat.setVisible(false);
                        lname.setVisible(false);
                        lday.setVisible(false);
                        lpass.setVisible(false);
                        lfilm.setVisible(false);

                        search.setText("");
                        search.setBounds(co(5), co(1), 300, 30);
                        poisk.setBounds(x, co(1), 80, y);

                        addmen.setVisible(true);
                        turn.setText("Дополнительно");
                        check=1;
                        list.setListData(a.ref("f"));
                        list.setBounds(x, co(3), mm.si(0)- co(2), mm.si(1)-co(3));
                        ispoisk = 0;
                        arp=0;
                    }

                }
            }catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Insert number instead of text");
            }
        }
    }
}
