package com.gluszczykk.playgroundj._0wstep;

import java.util.Objects;

public class Student {
    String imie;
    int wiek;
    String miastoZamieszkania;

    public Student(String imie, int wiek, String miastoZamieszkania) {
        this.imie = imie;
        this.wiek = wiek;
        this.miastoZamieszkania = miastoZamieszkania;
    }

    @Override
    public String toString() {
        return "Student{}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return wiek == student.wiek &&
                Objects.equals(imie, student.imie) &&
                Objects.equals(miastoZamieszkania, student.miastoZamieszkania);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imie, wiek, miastoZamieszkania);
    }
}
