package com.example.hse24.data.models
import com.google.gson.annotations.SerializedName


data class ProductListDto(
    @SerializedName("cachingForbidden")
    val cachingForbidden: Boolean,
    @SerializedName("categories")
    val categories: List<CategoryDto>,
    @SerializedName("filter")
    val filter: FilterDto,
    @SerializedName("paging")
    val paging: PagingDto,
    @SerializedName("productResults")
    val productResults: List<ProductResultDto>,
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("topShop")
    val topShop: String
)

data class ProductResultDto(
    @SerializedName("averageStars")
    val averageStars: Int,
    @SerializedName("brandId")
    val brandId: String,
    @SerializedName("brandNameLong")
    val brandNameLong: String,
    @SerializedName("defaultVariationValue")
    val defaultVariationValue: DefaultVariationValueDto,
    @SerializedName("imageUris")
    val imageUris: List<String>,
    @SerializedName("nameShort")
    val nameShort: String,
    @SerializedName("noShippingCosts")
    val noShippingCosts: Boolean,
    @SerializedName("notAllowedInCountry")
    val notAllowedInCountry: Boolean,
    @SerializedName("priceLabel")
    val priceLabel: String,
    @SerializedName("priceValidToTimestamp")
    val priceValidToTimestamp: Long,
    @SerializedName("productPrice")
    val productPrice: ProductPriceDto,
    @SerializedName("referencePriceLabel")
    val referencePriceLabel: String,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("status")
    val status: String
)

data class DefaultVariationValueDto(
    @SerializedName("stockAmount")
    val stockAmount: Int,
    @SerializedName("stockColor")
    val stockColor: String,
    @SerializedName("variationValueName")
    val variationValueName: String
)

data class ProductPriceDto(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("percentDiscount")
    val percentDiscount: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("priceDiscount")
    val priceDiscount: Double,
    @SerializedName("priceLabel")
    val priceLabel: String,
    @SerializedName("priceValidTo")
    val priceValidTo: String,
    @SerializedName("referencePrice")
    val referencePrice: Double,
    @SerializedName("referencePriceLabel")
    val referencePriceLabel: String,
    @SerializedName("shippingCosts")
    val shippingCosts: Double
)

data class FilterDto(
    @SerializedName("filterGroups")
    val filterGroups: List<FilterGroupDto>,
    @SerializedName("resetLink")
    val resetLink: String,
    @SerializedName("selectedItemCount")
    val selectedItemCount: Int
)

data class FilterGroupDto(
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("displayType")
    val displayType: String?,
    @SerializedName("fieldName")
    val fieldName: String,
    @SerializedName("filterItems")
    val filterItems: List<FilterItemDto>,
    @SerializedName("filterName")
    val filterName: String,
    @SerializedName("hidden")
    val hidden: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("resetLink")
    val resetLink: String
)

data class FilterItemDto(
    @SerializedName("childCount")
    val childCount: Int,
    @SerializedName("displayName")
    val displayName: String,
    @SerializedName("filterName")
    val filterName: String,
    @SerializedName("filterValue")
    val filterValue: String,
    @SerializedName("iconImgUrl")
    val iconImgUrl: String?,
    @SerializedName("id")
    val id: String,
    @SerializedName("level")
    val level: Int,
    @SerializedName("link")
    val link: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("resetLink")
    val resetLink: String,
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("rgbCode")
    val rgbCode: String?,
    @SerializedName("selected")
    val selected: Boolean
)

data class PagingDto(
    @SerializedName("numPages")
    val numPages: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageSize")
    val pageSize: Int
)