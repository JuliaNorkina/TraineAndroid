package com.example.twoactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {
    private String fio;
    private String age;
    private String cash;

    Customer(String fio, String age, String cash) {
        this.fio = fio;
        this.age = age;
        this.cash = cash;
    }

    private Customer(Parcel in) {
        fio = in.readString();
        age = in.readString();
        cash = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fio);
        dest.writeString(age);
        dest.writeString(cash);
    }

    @Override
    public String toString() {
        return "FIO: " + fio + ". Age: " + age + ". Cash: " + cash + ".\n";
    }
}