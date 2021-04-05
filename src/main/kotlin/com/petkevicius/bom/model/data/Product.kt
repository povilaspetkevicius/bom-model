package com.petkevicius.bom.model.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("PRODUCTS")
data class Product(@Id
                   val productCode: Long,
                   val parentProductCode: Long?,
                   val productName: String?,
                   val productDescription: String?,
                   @Column("REQUIRED")
                   var isRequired: Boolean?)