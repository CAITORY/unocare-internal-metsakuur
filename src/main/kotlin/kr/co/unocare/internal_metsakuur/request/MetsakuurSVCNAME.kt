package kr.co.unocare.internal_metsakuur.request

/**
 * - API 용도를 나타내는 문자열로 다음의 의미를 갖음
 * - REGIST : 안면데이터 등록
 * - VERIFY : CUST_NO 에 설정된 값과 IMAGE 에 설정된 이미지 데이터가 동일인인지 판단
 * - BULKVERIFY : IMAGE 에 설정된 이미지 데이터와 가장 일치하는 CUST_NO(loginId) 조회(일치율을 만족하지 않는 경우 존재하지 않는다는 결과 반환)
 * - DELETE : CUST_NO 에 설정된 값에 해당하는 안면데이터 삭제
 * - CHECK : CUST_NO 에 설정된 값에 해당하는 안면데이터 관련 정보 조회
 */
enum class MetsakuurSVCNAME {
    REGIST,
    VERIFY,
    BULKVERIFY,
    DELETE,
    CHECK,
}
