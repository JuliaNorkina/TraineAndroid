package com.example.twoactivity;

public class Validator {
    private String fioError;
    private String ageError;
    private String cashError;

    Validator(String fioError, String ageError, String cashError) {
        this.fioError = fioError;
        this.ageError = ageError;
        this.cashError = cashError;
    }

    public boolean valid(String fio, String age, String cash) {
        if (!fio.equals("")) fioError = "";
        if (!age.equals("")) ageError = "";
        if (!cash.equals("")) cashError = "";
        return !fio.equals("") && !age.equals("") && !cash.equals("");
    }

    public String getFioError() {
        return fioError;
    }

    public String getAgeError() {
        return ageError;
    }

    public String getCashError() {
        return cashError;
    }
}