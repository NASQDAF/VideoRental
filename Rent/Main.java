package Rent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import javax.swing.JOptionPane;
public class Main{
    public static String Conv(int n){
        String[] str = new String[]{"Crime", "Porno", "Detective", "Scum", "Vestern", "Tarantino", "Serial"};
        return str[n];
    }
    public String Sear(String filtr){
        String count = "";
        for (Film f: Films){
            if(f.getName() == filtr) {
                count = Conv(f.getJanre()) + " " + f.getName(); 
                System.out.println(count);
            }
        }
        return count;
    }

    public static int si(int ar){
        //0 = x, 1 = y
        int x = 700, y = 500, res = 0;

        if (ar == 0) res = x;
        else if(ar == 1) res = y;

        return res;
    }


    static Formatter x;
    private static Film[] Films = new Film[5];
    static Scanner scn;
    static String [][]m = new String[4][5];



    static java.util.List<java.util.List<String>> list = new ArrayList<List<String>>();


    public static void openfile() {
        try{
scn = new Scanner(new File("res//1.txt"));
        }catch (Exception e){ JOptionPane.showMessageDialog(null, "Файл не найден");}
    }


    static String looool = "<html>";

    public static void readfile(){
        //list.add(new ArrayList<String>());
        int inwhl = 0;
        while (scn.hasNext()){
            inwhl++;

            looool += scn.next() + " ";

            if (inwhl>4) {
                looool += "<br>";
                inwhl = 0;}
        }
        looool +="</html>";
    }


    public static String out(){
        //for(int i = 0; i<=looool.length(); i++){
            //for(int j = 0; j<list[i].; j++){
                return looool;
    }

    public static void main(String[] args){
        openfile();
        readfile();
        out();



        try {
            x= new Formatter("res//2.txt");
            scn = new Scanner(System.in);
        }catch (Exception e){};
        Guyi gu = new Guyi("Control Panel");
        gu.setVisible(true);
        gu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gu.setSize(si(0), si(1));

        gu.setResizable(false);
        gu.setLocationRelativeTo(null);



        Films[0] = new Film(3, "Kventin Tarantino");
        Films[1] = new Film(4, "YOU-YOU");
        Films[2] = new Film(3, "Mr.Robot");
        Films[3] = new Film(1, "MOCK- Episode 1");
        Films[4] = new Film(2, "Smartly Uill");


    }
}