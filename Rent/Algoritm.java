package Rent;

import javax.swing.*;

import static Rent.Main.*;
import static java.lang.Integer.parseInt;

import java.io.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Algoritm {

    /*for (Film f: Films){
        if(f.getJanre() == 3) {
            System.out.println(Conv(f.getJanre()) + " " + f.getName());
        }
        System.out.println(Conv(f.getJanre()) + " " + f.getName());
    }*/
    int iter = 0;
    int []k ;
    Main m = new Main();
    public boolean perebor(String s, String str) {
        int d = 0;
        boolean verify = false;
        char [] ch = s.toCharArray(), sch = str.toCharArray();
        for (int i = 0; i < ch.length; i++)
            if (ch[i] == sch[0]) {
                if (sch.length > 1 && ch.length - i - sch.length>=0) {
                    for (int j = 0; j < sch.length; j++) {
                        if (ch[i + j] == sch[j]) {
                            d++;
                        } else break;
                    }
                    if (d == sch.length){
                        verify = true;
                        break;
                    }
                }
                d=0;
            }
        return verify;
    }
    public Integer poisk(String str){
        int ff = -1;
        for(;iter<m.ou().size(); iter++){
            if(perebor(m.ou().get(iter).toString(), str)== true) {
                ff = iter;
                break;
            }
        }
        return ff;
    }

    public int[] mpos(String s){
        int sis=0;
        if (Guyi.check ==1)
        sis = fi.length;
        else sis = us.length;

        int [] mas = new int[sis];
        int k = 0;

        for (int i = 0; i<sis; i++){ //Инициализация ниже 0-я
            mas[i] = -1;
        }

        for (iter = 0; iter<sis;iter++, k++){ //Объявление переменных выше нуля
            int po = poisk(s);
            if(po!=-1){
                mas[k] = po;
            }
        }

        int j=0;
        for (int i =0;i<sis;i++){ // получение целевого размера
            if (mas[i]!=-1){
                j++;
            }
        }
        int mass[] = new int[j];

        for(int b = 0; b<j;b++) // инициализация в соответствующий массив
            mass[b]=mas[b];
        if (mas[0]== -1) JOptionPane.showMessageDialog(null, "Нет совпадений");
        return mass;
    }

    public int[] expir(String[] s) throws ParseException {
        String y="";
        SimpleDateFormat f = new SimpleDateFormat("dd.mmm.yyyy");
        Date date;
        Calendar cal= Calendar.getInstance();
        for(int i= 0;i<s.length;i++){
            String [] sp = s[i].split("; ");
            String fgh = sp[1];
            date= f.parse(fgh);
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, parseInt(sp[2].toString()));
            // System.out.println(cal.getTime());
            if(cal.getTime().compareTo(Calendar.getInstance().getTime())==-1)
                y+=i+";";
        }

        String[] ff = y.split(";");
        int[] yu=new int[ff.length];
        for(int i = 0;i<ff.length;i++)
            yu[i]= parseInt(ff[i]);
        return yu;

        //  System.out.println(date);
    }

    public String [] ref(String s) throws ParseException {
        String pathus="res//users.txt", pathfilm="res//1.txt"; //ArrayList<List<String>> mas;
        String[] ars = new String[0];
        if (s == "f"){
            m.gtn();
            m.rfile(1);
            ars= new String[fi.length];
            for(int i = 0;i<fi.length;i++) {
                ars[i] = Arrays.toString(fi[i].getStr()).replaceAll("\\[", "").replaceAll("]","").replaceAll(";,",";");
                }
        }
        else if(s == "u"){
            m.gtn();
            m.rfile(0);
                ars= new String[us.length];
                for(int i = 0;i<us.length;i++) {
                    ars[i] = Arrays.toString(us[i].getStr()).replaceAll("\\[", "").replaceAll("]","").replaceAll(";,",";");
                }
            }
            return ars;
        }
    String[] x;
    public String[] temparr(String []li, String s){
        int [] ma = mpos(s);
        x = new String[ma.length];
        for(int i=0; i<ma.length;i++){
           x[i] = li[ma[i]];
        }
        return x;
    }

    public Algoritm(){

    }
}