package Rent;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static Rent.Main.fi;
import static java.lang.Integer.parseInt;

public class Users {
    private String name;
    private int days;
    private String pasp;
    private String nfilm;
    private String date;


    public Users(String name, String date, int days, String pasp, String nfilm ){
        this.name = name;
        this.date = date;
        this.days = days;
        this.pasp = pasp;
        this.nfilm = nfilm;
    }


    public String getName() {/////////////////
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate(){/////////////////
        return date;
    }

    public void setDate(String sDate) { //Поставили дату из стринга
        this.date = sDate;
    }

    public String getPasp() {////////////////////
        return pasp;
    }

    public void setPasp(String s) {
        pasp = s;
    }

    public int getDays() {/////////////////////
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public void setNfilm(int n) {// n- это выделенный элемент листа
        String nfil= fi[n].getName();
        this.nfilm = nfil;
    }

    public String[] getStr(){
        String[] s = {name+";", date+";", String.valueOf(days)+";", pasp+";", nfilm};
        return s;
    }
    public void setStr(String[] a){
        this.name = a[0];
        this.date = a[1];
        this.days = parseInt(a[2]);
        this.pasp = a[3];
        this.nfilm = a[4];
    }
}