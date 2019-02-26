# 데이터 전처리 - 이상치 처리하기
# 이상치(정상적인 데이터 범위를 벗어난 값) 처리하기

library(dplyr)

df_exam <- read.csv('./data/csv_exam_outlier.csv')
View(df_exam)

# 데이터정제 : 이상치 -> 결측치로 수정
df_exam$math <- ifelse(df_exam$math > 100 | df_exam$math < 0, NA, df_exam$math)
df_exam$english<- ifelse(df_exam$english > 100 | df_exam$english < 0, NA, df_exam$english)
df_exam$science <- ifelse(df_exam$science > 100 | df_exam$science < 0, NA, df_exam$science)

View(df_exam)

# 결측치 0으로 대체하기

df_exam[is.na(df_exam)] <- 0
