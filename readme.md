# bom-model
## Implementation of BOM conceptual data model (TBD)
I was watching some interview on Youtube about __Kotlin__ and I thought it would be a good idea to try implementing [this BOM model](http://www.databaseanswers.org/data_models/bom/index.htm) in it.<br>
Run it in a console: `./mvnw clean spring-boot:run` <br>
Provided resources:
- GET/api/suppliers - get existing suppliers list
- POST/api/suppliers - add a supplier to an existing suppliers list
- GET/api/suppliers/{code}/products - get products supplied by a single supplier. Supplier code has to be provided as a path variable.
- POST/api/suppliers/{code}/products - add a product supplied by a supplier. Supplier code has to be provided as a path variable.
- GET/api/products - get existing products list
- POST/api/products - add a product to an existing product list
- GET/api/products/{code}/suppliers - get suppliers of product. Product code has to be provided as a path variable.