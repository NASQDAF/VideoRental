package Rent;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static java.lang.Integer.parseInt;

public class Film {
    private String name;
    private String[] Janre;
    private String amount;
    private double price;
    private String date;


    public Film(String name,String date, String[] Janre, double price, String amount){
        this.name = name;
        this.date = date;
        this.Janre = Janre;
        this.price = price;
        this.amount = amount;
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

//    public void setDate(String sDate) throws ParseException { //Поставили дату из стринга
//        SimpleDateFormat f = new SimpleDateFormat("dd.mmm.yyyy");
//        Date date;
//        Calendar cal= Calendar.getInstance();
//        date= f.parse(sDate);
//        cal.setTime(date);
//        this.date = cal.getTime();
//    }

    public String[] getJanre() {////////////////////
        return Janre;
    }

    public void setJanre(String s) {
        String janre[] = s.split(",");
        Janre = janre;
    }

    public double getPrice() {/////////////////////
        return price;
    }

    public void setPrice(String s) {
        double price = Double.parseDouble(s);
        this.price = price;
    }

    public String getAmount() {///////////////
        return amount;
    }

    public void setAmount(String a) {
        int amount = parseInt(a);
        this.amount = a;
    }

    public String[] getStr(){
        String[] s = {name+";", date.toString()+";", Arrays.toString(Janre)+";", Double.toString(price)+";", amount};
        return s;
    }
    public void setStr(String[] a){
        this.name = a[0];
        this.date = a[1];
        this.Janre = a[2].split(",");
        this.price = Double.parseDouble(a[3]);
        this.amount = a[4];
    }
    public void del()
}