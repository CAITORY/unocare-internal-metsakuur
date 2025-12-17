package kr.co.unocare.internal_metsakuur.http

import kr.co.unocare.internal_metsakuur.request.MetsakuurRequest
import kr.co.unocare.internal_metsakuur.request.MetsakuurSVCNAME
import kr.co.unocare.internal_metsakuur.response.MetsakuurCode
import kr.co.unocare.internal_metsakuur.response.MetsakuurResponse
import kr.co.unocare.internal_metsakuur.response.MetsakuurResponse__EzResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import tools.jackson.databind.ObjectMapper


@Controller
@RequestMapping("/uface_api/face/common")
class MetsakuurHttp(
    private val objectMapper: ObjectMapper,
) {
    @PostMapping(
        "/json",
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
    )
    fun handle(@RequestParam("data") data: String): MetsakuurResponse {
        val request: MetsakuurRequest =
            objectMapper.readValue(data, MetsakuurRequest::class.java)

        return when(request.svcName) {
            MetsakuurSVCNAME.REGIST -> {
                MetsakuurResponse(
                    code = MetsakuurCode.OK,
                    msg = "",
                    ezResponse = MetsakuurResponse__EzResponse(),
                )
            }
            else -> {
                MetsakuurResponse(
                    code = MetsakuurCode.FAIL,
                    msg = "",
                    ezResponse = MetsakuurResponse__EzResponse(),
                )
            }
        }
    }
}