package com.gluszczykk.playgroundk._2schronisko

import java.lang.IllegalArgumentException

/** Zadanie 1
 *
 * Wstep:1 Utwórz schronisko dla zwierząt, prowadzone prez małżeństwo Bartosza i Elżbiety Bednarzy
 *
 * Wstep:1 Mmaksymalna pojemność schroniska to 1000
 *
 * Schronisko przyjumuje 2 typy zwierząt, Psy i Koty
 *
 * Zapełnij schronisko przez 0.5% kotów i psów
 *
 * Umożliw małżeństwu zajmowanie się zwierzętami poprzez wykonywanie akcji Sprzątania i Wyprowadzania
 *
 * Zasymuluj typowy weekend w schronisku (każdego dnia wszystkie zwierzaki zostają wyprowadzone przez losową osobę, w między czasie druga zajmuje się czyszczeniem klatek)
 *
 * Wypisz stan schroniska oraz akcje wykonane przez daną osobę dla każdego z dnii
 *
 */

const val pojemnosc = 1000

fun main() {
    val listaWlascicieli = listOf( Wlasciciel("Elżbieta"),  Wlasciciel("Bartosz"))

    //imperatywnie
    val listaWlascicieliLiteraI = mutableListOf<Wlasciciel>()
    for (wlasciciel in listaWlascicieli){
        if(wlasciciel.imie.contains("e", ignoreCase = true)){
            listaWlascicieliLiteraI.add(wlasciciel)
        }
    }
    println(listaWlascicieliLiteraI)

    //deklaratywnie
    listaWlascicieli.filter { wlasciciel ->
        wlasciciel.imie.contains("e", ignoreCase = true)
    }.also {
        println(it)
    }
}

data class Wlasciciel(val imie: String, val nazwisko: String = "Bednarz")