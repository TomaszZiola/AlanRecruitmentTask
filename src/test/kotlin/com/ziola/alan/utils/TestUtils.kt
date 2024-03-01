package com.ziola.alan.utils

object TestUtils {
    fun <V, T> setField(
        entity: T,
        fieldName: String,
        value: V,
    ) {
        val field = entity!!::class.java.getDeclaredField(fieldName)
        field.isAccessible = true
        field.set(entity, value)
    }
}
