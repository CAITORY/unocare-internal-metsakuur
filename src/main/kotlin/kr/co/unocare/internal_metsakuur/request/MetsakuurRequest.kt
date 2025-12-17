package kr.co.unocare.internal_metsakuur.request

import com.fasterxml.jackson.annotation.JsonProperty

data class MetsakuurRequest(
    @JsonProperty("APP_VERSION")
    val appVersion: String = "2.0.0",

    @JsonProperty("OS")
    val os: String = "",

    @JsonProperty("SVCNAME")
    val svcName: MetsakuurSVCNAME,

    @JsonProperty("UUID")
    val uuid: String? = null,

    @JsonProperty("CHNL_DV")
    val chnlDv: String? = null,

    @JsonProperty("CUST_NO")
    val custNo: String? = null,

    @JsonProperty("NAME")
    val name: String? = null,

    @JsonProperty("IMAGE")
    val image: String? = null,
)
