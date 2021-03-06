package com.pabji.usecases

import com.pabji.data.repositories.ProductRepository
import com.pabji.domain.Product

class RemoveProduct(private val productRepository: ProductRepository) {

    suspend operator fun invoke(product: Product) = productRepository.removeProduct(product)
}
