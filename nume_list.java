package com.exemple.android.schoolbox;

public class nume_list {
    private String nume;
    private String eticheta;
    private String email;
    private int number;
    public nume_list(String nume, String eticheta, String email, int number){
        this.nume = nume;
        this.eticheta = eticheta;
        this.email= email;
        this.number = number;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEticheta() {
        return eticheta;
    }

    public void setEticheta(String eticheta) {
        this.eticheta = eticheta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
