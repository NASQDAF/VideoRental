package Rent;
import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import javax.swing.JOptionPane;

import static java.lang.Integer.parseInt;

public class Main{
    public static String pathfilm="res//1.txt";
    public static String pathus="res//users.txt";
    public static String Conv(int n){
        String[] str = new String[]{"Crime", "Porno", "Detective", "Scum", "Vestern", "Tarantino", "Serial"};
        return str[n];
    }

    static Film[] fi;
    static Users[] us;
    public static int si(int ar){
        //0 = x, 1 = y
        int x = 700, y = 500, res = 0;

        if (ar == 0) res = x;
        else if(ar == 1) res = y;

        return res;
    }
    public void WrvF(String str, String path){

        File file = new File(path);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            fw.write(str);
        }
        catch (IOException e) {e.printStackTrace();}
        finally {
            try {fw.close();}
            catch (IOException e) {e.printStackTrace();}
        }
    }

    static Formatter x;
    private static Film[] Films = new Film[5];
    static Scanner scn;
    static String [][]m = new String[4][5];

static Date gd (String s) throws ParseException {
    SimpleDateFormat f = new SimpleDateFormat("dd.mmm.yyyy");
    Date date;
    Calendar cal= Calendar.getInstance();
    date= f.parse(s);
    cal.setTime(date);
    return cal.getTime();
}

    static java.util.List<java.util.List<String>> list = new ArrayList<List<String>>();


    static String looool="";
    static ArrayList<List<String>> group = new ArrayList<List<String>>();

    public static void getQue(int path/*1f0u*/){
        String pathfile = "";
        if(path == 1){ // films
            pathfile = pathfilm;
            fi = null;
        }
        else if (path == 0){
            pathfile = pathus;
            us=null;
        }
        try{
            scn = new Scanner(new File(pathfile));
        }catch (Exception e){ JOptionPane.showMessageDialog(null, "Файл не найден");}
        int intej = 0;
        while (scn.hasNextLine()){
            if (scn.nextLine()==""){
                scn.close();
                break;
            }
            intej++;
        }

        if(path==1)
            fi = new Film[intej];
        if(path==0)
            us = new Users[intej];
    }

    public static void rfile(int path) throws ParseException {
        String pathfile = "";
        if(path == 1){ // films
            pathfile = pathfilm;
            fi = null;
        }
        else if (path == 0){
            pathfile = pathus;
            us=null;
        }
        getQue(path); ////////////////////

        int iw = 0;

        try{
            scn = new Scanner(new File(pathfile));
        }catch (Exception e){ JOptionPane.showMessageDialog(null, "Файл не найден");}

        while (scn.hasNextLine()){
            looool = scn.nextLine();
            String string = looool;
            String[] mas = string.split(";", 6);
            if (mas.length == 5){
                if(path == 1)
                    fi[iw] = new Film(mas[0], mas[1], mas[2].split(","), Double.parseDouble(mas[3]), mas[4]); //2
                if (path == 0)
                    us[iw] = new Users(mas[0], mas[1], parseInt(mas[2]), mas[3], mas[4]); //2
                group.add(Arrays.asList(mas[0], mas[1], mas[2], mas[3], mas[4])); //2
            }
            else if(mas.length != 5)
                for(int i =0; i<mas.length;i++)
                    mas[i] = null;
            iw++;
        }
    }



    public static String ofi(int h) {
        try {
            scn = new Scanner(new File("res//1.txt"));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Файл не найден");
        }
        String lol="";
        int iw=0;
        String string ="";
        String cpls = System.getProperty("line.separator");
        while (scn.hasNextLine()){
            if (iw==h){}
            else {
                lol = scn.nextLine();
                string += lol+ cpls;

                iw++;}
        }
        return string;
    }



    public static List<List<String>> ou(){
        return group;
    }
    public static void gtn(){
        group= null;
        group = new ArrayList<List<String>>();
    }
    public static void redl(ArrayList<List<String>> g){
        group = g;
    }

    public static String out(){
        String vivod ="<html>" ;
        for (List<String> u : group){
            vivod+= "<p>"+u +"<br>";
        }
        vivod.toString();
        vivod =  vivod.replaceAll("\\[", "");
        vivod = vivod.replaceAll("\\]", "");
        vivod =  vivod.replaceAll(";", "");
                return vivod;
    }


    public static void main(String[] args) throws ParseException {
        rfile(1);
        Algoritm a = new Algoritm();
        //String[] asd = a.ref("f");
        for (int i = 0; i<fi.length;i++)
        System.out.println("["+i+"] "+Arrays.toString(fi[i].getJanre()));
        System.out.println(ou().size() + " - size");

        Guyi gu = new Guyi("Syuka bliatt'");
        gu.setVisible(true);
        gu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gu.setSize(si(0), si(1)); //Размер

        gu.setResizable(false);
        gu.setLocationRelativeTo(null);


//	  Films[0] = new Film(3, "Kventin Tarantino");

//        Films[1] = new Film(4, "YOU-YOU");

//        Films[2] = new Film(3, "Mr.Robot");

//        Films[3] = new Film(1, "MOCK- Episode 1");

//        Films[4] = new Film(2, "Smartly Uill");
//        Films[5] = new Film("","","","","");

    }
}