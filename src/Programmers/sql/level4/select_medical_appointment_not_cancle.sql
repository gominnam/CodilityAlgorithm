WITH AppointInfo AS (
    SELECT
         AP.APNT_NO,
         PA.PT_NAME,
         AP.PT_NO,
         AP.MCDP_CD,
         AP.APNT_YMD,
         AP.MDDR_ID
    FROM APPOINTMENT AP
    JOIN PATIENT PA
      ON AP.PT_NO = PA.PT_NO
    WHERE
         AP.MCDP_CD = 'CS'
     AND DATE_FORMAT(AP.APNT_YMD, '%Y-%m-%d') = '2022-04-13'
     AND AP.APNT_CNCL_YMD IS NULL
)
SELECT
    AppointInfo.APNT_NO,
    AppointInfo.PT_NAME,
    AppointInfo.PT_NO,
    AppointInfo.MCDP_CD,
    DR.DR_NAME,
    AppointInfo.APNT_YMD
FROM AppointInfo
JOIN DOCTOR DR
  ON AppointInfo.MCDP_CD = DR.MCDP_CD
 AND AppointInfo.MDDR_ID = DR.DR_ID
ORDER BY
    AppointInfo.APNT_YMD ASC
;

/*

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/132204

 */