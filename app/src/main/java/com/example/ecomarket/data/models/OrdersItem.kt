package com.example.ecomarket.data.models

data class OrdersItem(
    var address: String? = null,
    var comments: String? = null,
    var created_at: String? = null,
    var delivery_cost: Int? = null,
    var order_number: Int? = null,
    var ordered_products: List<OrderedProduct?>? = null,
    var phone_number: String? = null,
    var reference_point: String? = null,
    var total_amount: String? = null
)