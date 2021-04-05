package com.petkevicius.bom.model.service

import com.petkevicius.bom.model.data.ProductSupplier
import com.petkevicius.bom.model.data.Supplier
import com.petkevicius.bom.model.repository.ProductSupplierRepository
import com.petkevicius.bom.model.repository.SupplierRepository
import org.springframework.stereotype.Service

@Service
class SupplierService(val supplierRepository: SupplierRepository,
                      val productSupplierRepository: ProductSupplierRepository) {
    fun findSuppliers(): List<Supplier> = supplierRepository.findAllSuppliers()
    fun saveSupplier(supplier: Supplier): Supplier = supplierRepository.save(supplier)
    fun createProductSupply(productSupplier: ProductSupplier): ProductSupplier? {
        var savedObject: ProductSupplier? = null
        try {
            productSupplier.getId()?.let {
                savedObject = if (productSupplierRepository.existsById(it)) {
                    val existingSuppliers: MutableList<ProductSupplier> = productSupplierRepository.findAll() as MutableList<ProductSupplier>
                    //replace existing with new/merge?
                    existingSuppliers.add(productSupplier)
                    productSupplierRepository.saveAll(existingSuppliers)
                            .find { savedSupplier -> productSupplier.supplierCode == savedSupplier.supplierCode
                                    && productSupplier.productCode == savedSupplier.productCode }

                } else {
                    productSupplierRepository.save(productSupplier)
                }
            }
        } catch (e: Exception) {
            println(String.format("Could not save information about supplied product due to %s\n", e.message))
        }
        return savedObject
    }
    fun findSuppliedProducts(supplierCode: Long): List<ProductSupplier> = productSupplierRepository.findBySupplierCode(supplierCode)
}