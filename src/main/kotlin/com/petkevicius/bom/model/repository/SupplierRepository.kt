package com.petkevicius.bom.model.repository

import com.petkevicius.bom.model.data.Supplier
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface SupplierRepository : CrudRepository<Supplier, Long> {
    @Query("select * from suppliers")
    fun findAllSuppliers(): List<Supplier>
}