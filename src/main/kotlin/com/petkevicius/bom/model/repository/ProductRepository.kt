package com.petkevicius.bom.model.repository

import com.petkevicius.bom.model.data.Product
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long> {
    @Query("select * from products")
    fun findAllProducts(): List<Product>
}