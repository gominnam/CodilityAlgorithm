WITH colonyRanks AS (
    SELECT
        ID,
        RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS colony_rank,
            COUNT(ID) OVER() AS total_rank
    FROM
        ECOLI_DATA
)
SELECT
    ED.ID,
    CASE
        WHEN (colonyRanks.colony_rank / colonyRanks.total_rank) * 100 <= 25 THEN 'CRITICAL'
        WHEN (colonyRanks.colony_rank / colonyRanks.total_rank) * 100 <= 50 THEN 'HIGH'
        WHEN (colonyRanks.colony_rank / colonyRanks.total_rank) * 100 <= 75 THEN 'MEDIUM'
        ELSE 'LOW'
        END AS COLONY_NAME
FROM ECOLI_DATA AS ED
         INNER JOIN colonyRanks
                    ON ED.ID = colonyRanks.ID
ORDER BY
    ED.ID ASC;

/*

Thinking:

1) With 절을 사용하여 비율 구하기
- RANK() OVER(ORDER BY SIZE_OF_COLONY DESC) AS colony_rank,
  전체 결과 집합에 대해 순위 매기기
- RANK() OVER(PARTITION BY COLUMN_NAME ORDER BY SIZE_OF_COLONY DESC) AS colony_rank,
  PARTITION BY를 사용하여 특정 컬럼에 대해 순위 매기기

2) CASE-WHEN-ELSE-END 문 사용하기

 */