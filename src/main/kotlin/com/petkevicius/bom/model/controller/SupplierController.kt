package com.petkevicius.bom.model.controller

import com.petkevicius.bom.model.data.ProductSupplier
import com.petkevicius.bom.model.data.Supplier
import com.petkevicius.bom.model.service.SupplierService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/suppliers")
class SupplierController(val service: SupplierService) {
    @GetMapping
    fun getSuppliers(): ResponseEntity<List<Supplier>> = ResponseEntity(service.findSuppliers(), HttpStatus.OK)
    @PostMapping
    fun saveSupplier(@RequestBody supplier: Supplier): ResponseEntity<Supplier> = ResponseEntity(service.saveSupplier(supplier), HttpStatus.CREATED)
    @PostMapping("/{code}/products")
    fun saveSuppliedProduct(@PathVariable("code") supplierCode: Long, @RequestBody details: ProductSupplier): ResponseEntity<ProductSupplier> {
        details.supplierCode = supplierCode
        val savedDetails: ProductSupplier? = service.createProductSupply(details)
        return if (savedDetails != null) {
            ResponseEntity(savedDetails, HttpStatus.CREATED)
        } else {
            ResponseEntity(HttpStatus.CONFLICT)
        }
    }
    @GetMapping("/{id}/products")
    fun getSuppliedProducts(@PathVariable("id") supplierCode: Long): ResponseEntity<List<ProductSupplier>> = ResponseEntity(service.findSuppliedProducts(supplierCode), HttpStatus.OK)
}