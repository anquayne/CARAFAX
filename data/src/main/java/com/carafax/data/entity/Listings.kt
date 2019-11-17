package com.carafax.data.entity


import com.google.gson.annotations.SerializedName

data class Listings(
    @SerializedName("accidentHistory")
    val accidentHistory: AccidentHistory,
    @SerializedName("advantage")
    val advantage: Boolean,
    @SerializedName("backfill")
    val backfill: Boolean,
    @SerializedName("badge")
    val badge: String,
    @SerializedName("bedLength")
    val bedLength: String,
    @SerializedName("bodytype")
    val bodytype: String,
    @SerializedName("cabType")
    val cabType: String,
    @SerializedName("certified")
    val certified: Boolean,
    @SerializedName("currentPrice")
    val currentPrice: Int,
    @SerializedName("dealer")
    val dealer: Dealer,
    @SerializedName("dealerType")
    val dealerType: String,
    @SerializedName("displacement")
    val displacement: String,
    @SerializedName("distanceToDealer")
    val distanceToDealer: Double,
    @SerializedName("drivetype")
    val drivetype: String,
    @SerializedName("engine")
    val engine: String,
    @SerializedName("exteriorColor")
    val exteriorColor: String,
    @SerializedName("firstSeen")
    val firstSeen: String,
    @SerializedName("followCount")
    val followCount: Int,
    @SerializedName("following")
    val following: Boolean,
    @SerializedName("fuel")
    val fuel: String,
    @SerializedName("hasViewed")
    val hasViewed: Boolean,
    @SerializedName("id")
    val id: String,
    @SerializedName("imageCount")
    val imageCount: Int,
    @SerializedName("images")
    val images: Images,
    @SerializedName("interiorColor")
    val interiorColor: String,
    @SerializedName("isEnriched")
    val isEnriched: Boolean,
    @SerializedName("listPrice")
    val listPrice: Double,
    @SerializedName("listingStatus")
    val listingStatus: String,
    @SerializedName("make")
    val make: String,
    @SerializedName("mileage")
    val mileage: Int,
    @SerializedName("model")
    val model: String,
    @SerializedName("monthlyPaymentEstimate")
    val monthlyPaymentEstimate: MonthlyPaymentEstimate,
    @SerializedName("mpgCity")
    val mpgCity: Int,
    @SerializedName("mpgHighway")
    val mpgHighway: Int,
    @SerializedName("noAccidents")
    val noAccidents: Boolean,
    @SerializedName("oneOwner")
    val oneOwner: Boolean,
    @SerializedName("onePrice")
    val onePrice: Int,
    @SerializedName("onePriceArrows")
    val onePriceArrows: List<OnePriceArrow>,
    @SerializedName("onlineOnly")
    val onlineOnly: Boolean,
    @SerializedName("ownerHistory")
    val ownerHistory: OwnerHistory,
    @SerializedName("personalUse")
    val personalUse: Boolean,
    @SerializedName("recordType")
    val recordType: String,
    @SerializedName("sentLead")
    val sentLead: Boolean,
    @SerializedName("serviceHistory")
    val serviceHistory: ServiceHistory,
    @SerializedName("serviceRecords")
    val serviceRecords: Boolean,
    @SerializedName("sortScore")
    val sortScore: Double,
    @SerializedName("stockNumber")
    val stockNumber: String,
    @SerializedName("subTrim")
    val subTrim: String,
    @SerializedName("topOptions")
    val topOptions: List<String>,
    @SerializedName("transmission")
    val transmission: String,
    @SerializedName("trim")
    val trim: String,
    @SerializedName("vdpUrl")
    val vdpUrl: String,
    @SerializedName("vehicleCondition")
    val vehicleCondition: String,
    @SerializedName("vehicleUseHistory")
    val vehicleUseHistory: VehicleUseHistory,
    @SerializedName("vin")
    val vin: String,
    @SerializedName("year")
    val year: Int
) {
    data class AccidentHistory(
        @SerializedName("accidentSummary")
        val accidentSummary: List<String>,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("iconUrl")
        val iconUrl: String,
        @SerializedName("text")
        val text: String
    )

    data class Dealer(
        @SerializedName("address")
        val address: String,
        @SerializedName("carfaxId")
        val carfaxId: String,
        @SerializedName("cfxMicrositeUrl")
        val cfxMicrositeUrl: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("dealerAverageRating")
        val dealerAverageRating: Double,
        @SerializedName("dealerInventoryUrl")
        val dealerInventoryUrl: String,
        @SerializedName("dealerLeadType")
        val dealerLeadType: String,
        @SerializedName("dealerReviewComments")
        val dealerReviewComments: String,
        @SerializedName("dealerReviewCount")
        val dealerReviewCount: Int,
        @SerializedName("dealerReviewDate")
        val dealerReviewDate: String,
        @SerializedName("dealerReviewRating")
        val dealerReviewRating: Int,
        @SerializedName("dealerReviewReviewer")
        val dealerReviewReviewer: String,
        @SerializedName("dealerReviewTitle")
        val dealerReviewTitle: String,
        @SerializedName("latitude")
        val latitude: String,
        @SerializedName("longitude")
        val longitude: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("onlineOnly")
        val onlineOnly: Boolean,
        @SerializedName("phone")
        val phone: String,
        @SerializedName("state")
        val state: String,
        @SerializedName("zip")
        val zip: String
    )

    data class Images(
        @SerializedName("baseUrl")
        val baseUrl: String,
        @SerializedName("firstPhoto")
        val firstPhoto: FirstPhoto,
        @SerializedName("large")
        val large: List<String>,
        @SerializedName("medium")
        val medium: List<String>,
        @SerializedName("small")
        val small: List<String>
    ) {
        data class FirstPhoto(
            @SerializedName("large")
            val large: String,
            @SerializedName("medium")
            val medium: String,
            @SerializedName("small")
            val small: String
        )
    }

    data class MonthlyPaymentEstimate(
        @SerializedName("downPaymentAmount")
        val downPaymentAmount: Double,
        @SerializedName("downPaymentPercent")
        val downPaymentPercent: Int,
        @SerializedName("interestRate")
        val interestRate: Int,
        @SerializedName("loanAmount")
        val loanAmount: Double,
        @SerializedName("monthlyPayment")
        val monthlyPayment: Double,
        @SerializedName("price")
        val price: Int,
        @SerializedName("termInMonths")
        val termInMonths: Int
    )

    data class OnePriceArrow(
        @SerializedName("arrow")
        val arrow: String,
        @SerializedName("arrowUrl")
        val arrowUrl: String,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("iconUrl")
        val iconUrl: String,
        @SerializedName("order")
        val order: Int,
        @SerializedName("text")
        val text: String
    )

    data class OwnerHistory(
        @SerializedName("history")
        val history: List<History>,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("iconUrl")
        val iconUrl: String,
        @SerializedName("text")
        val text: String
    ) {
        data class History(
            @SerializedName("city")
            val city: String,
            @SerializedName("endOwnershipDate")
            val endOwnershipDate: String,
            @SerializedName("ownerNumber")
            val ownerNumber: Int,
            @SerializedName("purchaseDate")
            val purchaseDate: String,
            @SerializedName("state")
            val state: String
        )
    }

    data class ServiceHistory(
        @SerializedName("history")
        val history: List<History>,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("iconUrl")
        val iconUrl: String,
        @SerializedName("number")
        val number: Int,
        @SerializedName("text")
        val text: String
    ) {
        data class History(
            @SerializedName("city")
            val city: String,
            @SerializedName("date")
            val date: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("odometerReading")
            val odometerReading: Int,
            @SerializedName("source")
            val source: String,
            @SerializedName("state")
            val state: String
        )
    }

    data class VehicleUseHistory(
        @SerializedName("history")
        val history: List<History>,
        @SerializedName("icon")
        val icon: String,
        @SerializedName("iconUrl")
        val iconUrl: String,
        @SerializedName("text")
        val text: String
    ) {
        data class History(
            @SerializedName("averageMilesPerYear")
            val averageMilesPerYear: Int,
            @SerializedName("ownerNumber")
            val ownerNumber: Int,
            @SerializedName("useType")
            val useType: String
        )
    }
}