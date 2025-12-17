package kr.co.unocare.internal_metsakuur.response

data class MetsakuurResponse(
    val code: MetsakuurCode,
    val msg: String,
    val ezResponse: MetsakuurResponse__EzResponse,
)