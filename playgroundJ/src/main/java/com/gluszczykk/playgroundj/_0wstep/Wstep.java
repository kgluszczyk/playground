package com.gluszczykk.playgroundj._0wstep;

public class Wstep {
    public static void main(String[] args) {
        String imie = "Krzysiek";
        System.out.println("Hello world! " + ":" + imie + " " + dodaj(2,3));

        Student student1 = new Student("Radek",35 , "Wrocław");
        Student student2 = new Student("Radek",35 , "Wrocław");
        boolean czyTenSam = student1 == student2;
        System.out.println("Czy ten sam student:" +czyTenSam + student1);
    }

    public static int dodaj(int a, int b){
        return a+b;
    }
}