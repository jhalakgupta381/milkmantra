package model;

public class Customer_Add_Provider_model {
    String Name,Cow_Morning,Cow_Evening,Buffelow_Morning,Buffelow_Evening,Other_Morning,Other_Evening;
    String Vacation_Mode;

    public void setName(String name) {
        Name = name;
    }

    public void setCow_Morning(String cow_Morning) {
        Cow_Morning = cow_Morning;
    }

    public void setCow_Evening(String cow_Evening) {
        Cow_Evening = cow_Evening;
    }

    public void setBuffelow_Morning(String buffelow_Morning) {
        Buffelow_Morning = buffelow_Morning;
    }

    public void setBuffelow_Evening(String buffelow_Evening) {
        Buffelow_Evening = buffelow_Evening;
    }

    public void setOther_Morning(String other_Morning) {
        Other_Morning = other_Morning;
    }

    public void setOther_Evening(String other_Evening) {
        Other_Evening = other_Evening;
    }

    public void setVacation_Mode(String vacation_Mode) {
        Vacation_Mode = vacation_Mode;
    }

    public Customer_Add_Provider_model(String name, String cow_Morning, String cow_Evening, String buffelow_Morning, String buffelow_Evening, String other_Morning, String other_Evening, String vacation_Mode) {
        Name = name;
        Cow_Morning = cow_Morning;
        Cow_Evening = cow_Evening;
        Buffelow_Morning = buffelow_Morning;
        Buffelow_Evening = buffelow_Evening;
        Other_Morning = other_Morning;
        Other_Evening = other_Evening;
        Vacation_Mode = vacation_Mode;
    }

    public String getName() {
        return Name;
    }

    public String getCow_Morning() {
        return Cow_Morning;
    }

    public String getCow_Evening() {
        return Cow_Evening;
    }

    public String getBuffelow_Morning() {
        return Buffelow_Morning;
    }

    public String getBuffelow_Evening() {
        return Buffelow_Evening;
    }

    public String getOther_Morning() {
        return Other_Morning;
    }

    public String getOther_Evening() {
        return Other_Evening;
    }

    public String getVacation_Mode() {
        return Vacation_Mode;
    }
}
