package Rent;

public class Film {
    private String name;
    private int Janre;


    public Film(int Janre, String name){
        this.Janre = Janre;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJanre() {
        return Janre;
    }

    public void setJanre(int janre) {
        Janre = janre;
    }
}