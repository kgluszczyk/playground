package com.gluszczykk.playground._3imperatywnoscADeklaratywnosc

import assertk.assertThat
import assertk.assertions.isTrue
import com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc.Input
import com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc.waliduj
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import kotlin.random.Random

class KotlinUnitTest {

    @Test
    fun `brak błędu gdy wartośći są puste`() {
        //given
        val inputs = (1..10).map {
            mockk<Input> {
                every { id } returns it.toLong()
                every { value } returns (Random.nextInt(50) + 1).getRandomString()
                every { mandatory } returns true
                every { validation } returns null
            }
        }
        //when
        val errors = inputs.waliduj()

        //then
        assertThat(errors.isEmpty()).isTrue()
    }
}

fun Int.getRandomString(): String {
    val allowedChars = ('A'..'Z') + ('a'..'z')
    return (1..this)
        .map { allowedChars.random() }
        .joinToString("")
}