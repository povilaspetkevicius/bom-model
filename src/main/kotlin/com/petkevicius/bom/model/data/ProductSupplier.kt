package com.petkevicius.bom.model.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.sql.Date
import java.util.*

@Table("PRODUCT_SUPPLIERS")
data class ProductSupplier(
        val productCode: Long,
        val suppliedFromDate: Date?,
        val suppliedToDate: Date?
) {
    var supplierCode: Long = -1
    @Id
    private val id: Long? = null
    fun getId(): Long? {
        return id
    }
}