package com.petkevicius.bom.model.repository

import com.petkevicius.bom.model.data.ProductSupplier
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface ProductSupplierRepository: CrudRepository<ProductSupplier, Long> {
    @Query("select * from product_suppliers where supplier_code = :supplier_code")
    fun findBySupplierCode(@Param("supplier_code") supplierCode: Long): List<ProductSupplier>
    @Query("select supplier_code from product_suppliers where product_code = :product_code")
    fun findAllSuppliersByProductCode(@Param("product_code") productCode: Long): List<Long>
}