package com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc

/** Zadanie 2
 *
 * Przekształć formę imperatywną implementacje na deklaratywną
 *
 */

fun List<Input>.waliduj(): List<ValidationError> {
    val result = mutableListOf<Input>()
    for (i in indices) {
        if (this[i].mandatory) {
            result.add(this[i])
        }
    }
    val result2 = mutableListOf<Input>()
    for (i in result.indices) {
        if (result[i] is InputCheckbox || result[i] is Toggle) {
            if (result[i].value?.fromApiBoolean() != true) {
                result2.add(this[i])
            }
        } else if (result[i].value.isNullOrBlank()) {
            result2.add(this[i])
        }
    }
    val result3 = mutableListOf<ValidationError>()
    for (i in result2.indices) {
        result3.add(ValidationError(result2[i].id, "Required"))
    }
    return result3
}