package com.petkevicius.bom.model.controller

import com.petkevicius.bom.model.data.Product
import com.petkevicius.bom.model.data.Supplier
import com.petkevicius.bom.model.service.ProductService
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(val service: ProductService) {
    @GetMapping
    fun getProducts(): ResponseEntity<List<Product>> = ResponseEntity(service.findProducts(), HttpStatus.OK)
    @PostMapping
    fun saveProduct(@RequestBody product: Product): ResponseEntity<Product> = ResponseEntity(service.saveProduct(product), HttpStatus.CREATED)
    @GetMapping("/{code}/suppliers")
    fun getSuppliersOfProduct(@PathVariable("code") productCode: Long): ResponseEntity<List<Supplier?>> {
        val suppliers: List<Supplier> = service.getSupplierDetails(productCode)
        return if (suppliers.isNotEmpty()) {
            ResponseEntity(suppliers, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}