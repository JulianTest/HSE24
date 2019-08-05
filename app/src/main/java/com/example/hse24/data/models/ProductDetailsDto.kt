package com.example.hse24.data.models
import com.google.gson.annotations.SerializedName


data class ProductDetailsDto(
    @SerializedName("additionalInformation")
    val additionalInformation: String,
    @SerializedName("averageStars")
    val averageStars: Double,
    @SerializedName("brandId")
    val brandId: String,
    @SerializedName("brandNameLong")
    val brandNameLong: String,
    @SerializedName("categoryCode")
    val categoryCode: String,
    @SerializedName("deliveryText")
    val deliveryText: String,
    @SerializedName("fromPrice")
    val fromPrice: Boolean,
    @SerializedName("imageUris")
    val imageUris: List<String>,
    @SerializedName("legalText")
    val legalText: String,
    @SerializedName("longDescription")
    val longDescription: String,
    @SerializedName("nameShort")
    val nameShort: String,
    @SerializedName("notAllowedInCountry")
    val notAllowedInCountry: Boolean,
    @SerializedName("picCount")
    val picCount: Int,
    @SerializedName("productPrice")
    val productPrice: ProductPriceDto,
    @SerializedName("reviewers")
    val reviewers: Int,
    @SerializedName("reviewsForbidden")
    val reviewsForbidden: Boolean,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("stockAmount")
    val stockAmount: Int,
    @SerializedName("stockColor")
    val stockColor: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("usps")
    val usps: List<String>,
    @SerializedName("variations")
    val variations: List<VariationDto>
)

data class VariationDto(
    @SerializedName("dimensions")
    val dimensions: DimensionsDto,
    @SerializedName("imageUris")
    val imageUris: List<String>,
    @SerializedName("picCount")
    val picCount: Int,
    @SerializedName("sku")
    val sku: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("stockAmount")
    val stockAmount: Int,
    @SerializedName("stockColor")
    val stockColor: String,
    @SerializedName("variationType")
    val variationType: String
)

data class ProductPriceXDto(
    @SerializedName("country")
    val country: String,
    @SerializedName("currency")
    val currency: String,
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
    val referencePriceLabel: String
)

data class DimensionsDto(
    @SerializedName("COLOR")
    val cOLOR: String
)