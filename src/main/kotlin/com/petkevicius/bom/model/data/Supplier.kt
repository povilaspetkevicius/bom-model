package com.petkevicius.bom.model.data

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("SUPPLIERS")
data class Supplier(@Id val supplierCode: Long, val supplierDescription: String?)