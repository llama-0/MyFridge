package com.pabji.myfridge.ui.productList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pabji.myfridge.model.ItemProduct
import com.pabji.myfridge.model.toItemProduct
import com.pabji.myfridge.ui.common.BaseViewModel
import com.pabji.usecases.GetMyProducts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductListViewModel(private val getMyProducts: GetMyProducts) : BaseViewModel() {

    private val _productList = MutableLiveData<List<ItemProduct>>()
    val productList: LiveData<List<ItemProduct>> = _productList

    fun getProductList() {
        launch {
            val result = withContext(Dispatchers.IO) { getMyProducts() }
            _productList.value = result.map { product -> product.toItemProduct() }
        }
    }

}