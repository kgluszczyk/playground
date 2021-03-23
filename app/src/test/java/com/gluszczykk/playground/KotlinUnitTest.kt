package com.gluszczykk.playground

import assertk.assertThat
import assertk.assertions.isTrue
import com.gluszczykk.playgroundk._1interop.Helper
import com.gluszczykk.playgroundk._3imperativeVsdeclarative.Input
import com.gluszczykk.playgroundk._3imperativeVsdeclarative.validateMandatoryFields
import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import kotlin.random.Random

class KotlinUnitTest {

    @Test
    fun `no errors while value not empty`() {
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
        val errors = inputs.validateMandatoryFields()

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