package com.gluszczykk.playgroundk._3imperatywnoscADeklaratywnosc

import java.math.BigDecimal

enum class Type(val typeName: String) {
    HEADER("HEADER"),
    HEADER2("HEADER_2"),
    HEADER3("HEADER_3"),
    TEXT("TEXT"),
    INPUT_CHECKBOX("INPUT_CHECKBOX"),
    INPUT_NUMERIC("INPUT_NUMERIC"),
    INPUT_TEXT("INPUT_TEXT"),
    INPUT_TOGGLE("INPUT_TOGGLE"),
    INPUT_DROPDOWN("INPUT_DROPDOWN"),
    REARRANGE_LIST("REARRANGE_LIST"),
    REARRANGE_LIST_ITEM("REARRANGE_LIST_ITEM"),
    ROW("ROW")
}

data class Toggle(
    override val id: Long,
    val title: String,
    val subtitle: String?,
    override val value: String?,
    override val mandatory: Boolean = false,
    override val validation: FormValidation? = null
) : Input(Type.INPUT_TOGGLE)

data class Criterion @JvmOverloads constructor(
    val operator: Operator,
    val criteria: List<Criterion> = emptyList(),
    val values: List<String> = emptyList()
)

data class FormValidation(
    val errorMessage: String,
    val criteria: Criterion
)

sealed class Input(type: Type) : Item(type) {

    abstract val id: Long
    abstract val value: String?
    open val mandatory: Boolean = false
    open val validation: FormValidation? = null
}

data class InputCheckbox(
    override val id: Long,
    val title: String?,
    val subtitle: String?,
    override val value: String?,
    override val mandatory: Boolean = false,
    override val validation: FormValidation? = null
) : Input(Type.INPUT_CHECKBOX)

data class ValidationError(val id: Long, val message: String)

sealed class Item(val type: Type)

fun String.fromApiBoolean() = toBoolean() || this.equals("Yes", ignoreCase = true)

interface Operator {

    fun execute(
        predicate: Predicate,
        criterion: Criterion,
        parameters: Map<String, String>
    ): BigDecimal
}

class Predicate(private val parameters: Map<String, String>) {

    fun evaluate(criterion: Criterion): BigDecimal {
        return runCatching {
            val operator = criterion.operator
            operator.execute(this, criterion, parameters)
        }.onFailure { println("Failed to calculate predicate") }
            .getOrDefault(BigDecimal.ZERO)
    }

    fun evaluateBoolean(criterion: Criterion): Boolean = evaluate(criterion).toInt() != 0
}

