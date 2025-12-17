package kr.co.unocare.internal_metsakuur.http

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import kr.co.unocare.internal_metsakuur.request.MetsakuurRequest
import kr.co.unocare.internal_metsakuur.request.MetsakuurSVCNAME
import kr.co.unocare.internal_metsakuur.response.MetsakuurCode
import kr.co.unocare.internal_metsakuur.response.MetsakuurResponse
import kr.co.unocare.internal_metsakuur.response.MetsakuurResponse__EzResponse
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tools.jackson.databind.ObjectMapper


@Tag(name = "메사쿠어")
@RestController
@RequestMapping("/uface_api/face/common")
class MetsakuurHttp(
    private val objectMapper: ObjectMapper,
) {
    private val log = LoggerFactory.getLogger(javaClass)

    @Operation(
        summary = "메사쿠어 얼굴 요청",
        description = "",
    )
    @PostMapping(
        "/json",
        consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
    )
    fun handle(@RequestParam("data") data: String): MetsakuurResponse {
        val request: MetsakuurRequest =
            objectMapper.readValue(data, MetsakuurRequest::class.java)

        log.info("[Metsakuur] svcName={}", request.svcName)

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