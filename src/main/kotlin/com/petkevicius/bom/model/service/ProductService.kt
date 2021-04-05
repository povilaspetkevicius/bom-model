package com.petkevicius.bom.model.service

import com.petkevicius.bom.model.data.Product
import com.petkevicius.bom.model.data.Supplier
import com.petkevicius.bom.model.repository.ProductRepository
import com.petkevicius.bom.model.repository.ProductSupplierRepository
import com.petkevicius.bom.model.repository.SupplierRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(val repository: ProductRepository,
                     val productSupplierRepository: ProductSupplierRepository,
                     val supplierRepository: SupplierRepository) {
    fun findProducts(): List<Product> = repository.findAllProducts()
    fun saveProduct(product: Product): Product = repository.save(product)
    fun getSupplierDetails(productCode: Long): List<Supplier> {
        val supplierCodes: List<Long> = productSupplierRepository.findAllSuppliersByProductCode(productCode)
        return supplierCodes.mapNotNull { code -> supplierRepository.findByIdOrNull(code) }
    }
}