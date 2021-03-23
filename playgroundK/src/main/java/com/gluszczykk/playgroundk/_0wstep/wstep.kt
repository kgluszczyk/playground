package com.gluszczykk.playgroundk._0wstep

fun main() {
    val imie = "Krzysiek"
    var imie2 = imie
    imie2 = "Dorota"
    println("Hello world from the Kotlin side! :$imie ${dodaj(b=2, a=3)}")

    val student1 = Student(imie= "Radek", miejsceZamieszkania = "Wrocław", wiek =35)
    val student2 = Student("Radek", "Wrocław", wiek =36)
    val student3 = Student("Radek")

    println("Czy ten sam: ${student1 == student2} $student1")
}

fun dodaj(a : Int, b: Int) =  a + b

data class Student(val imie: String, val miejsceZamieszkania: String="Warszawa", val wiek: Int= 18){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (imie != other.imie) return false
        if (miejsceZamieszkania != other.miejsceZamieszkania) return false

        return true
    }

    override fun hashCode(): Int {
        var result = imie.hashCode()
        result = 31 * result + miejsceZamieszkania.hashCode()
        return result
    }
}