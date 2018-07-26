package com.example.twoactivity;

public class Validator {
    private boolean fio;
    private boolean age;
    private boolean cash;

    private Validator(boolean fio, boolean age, boolean cash) {
        this.fio = fio;
        this.age = age;
        this.cash = cash;
    }

    Validator() {}

    public Validator valid(String fio, String age, String cash){
        this.fio = !fio.equals("");
        this.age = !age.equals("");
        this.cash = !cash.equals("");
        return new Validator(this.fio,this.age,this.cash);
    }

    public boolean isFio() {
        return fio;
    }

    public boolean isAge() {
        return age;
    }

    public boolean isCash() {
        return cash;
    }
}