package com.example.twoactivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Customer implements Parcelable {
    private String fio;
    private int age;
    private int cash;

    public Customer(String fio, int age, int cash) {
        this.fio = fio;
        this.age = age;
        this.cash = cash;
    }

    public Customer(Parcel in) {
        fio = in.readString();
        age = in.readInt();
        cash = in.readInt();
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
        dest.writeInt(age);
        dest.writeInt(cash);
    }

    @Override
    public String toString() {
        return "FIO: " + fio + ". Age: " + age + ". Cash: " + cash + ".\n";
    }
}