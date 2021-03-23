package com.gluszczykk.playground._4kolekcjeASekwencje

import assertk.all
import assertk.assertThat
import assertk.assertions.containsOnly
import assertk.assertions.hasSize
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc.Input
import com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc.waliduj
import com.gluszczykk.playgroundk._4kolekcjeASekwencje.Osoba
import com.gluszczykk.playgroundk._4kolekcjeASekwencje.unikalnePelnoletnieImiona
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import kotlin.random.Random

class KotlinUnitTest {

    @Test
    fun `zwroc jedynie pelnoletnie imiona bez powtorzen`() {
        //given
        val osoby =
            mockk<List<Osoba>> {
                mockk<Osoba> {
                    every { imie } returns "Piotr"
                    every { wiek } returns 17
                }
                mockk<Osoba> {
                    every { imie } returns "Ania"
                    every { wiek } returns 18
                }
                mockk<Osoba> {
                    every { imie } returns "Ania"
                    every { wiek } returns 28
                }
                mockk<Osoba> {
                    every { imie } returns "Marek"
                    every { wiek } returns 39
                }
            }
        //when
        val unikalnePelnoletnieImiona = osoby.unikalnePelnoletnieImiona()

        //then
        assertThat(unikalnePelnoletnieImiona).all {
            hasSize(3)
            containsOnly("Ania", "Marek")
        }
    }
}