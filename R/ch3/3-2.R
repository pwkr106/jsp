# Excel 파일 데이터프레임 생성

# 패키지 설치
install.packages('readxl')

# 패키지 추가
library(readxl)

df_exam <- read_excel('./data/exam.xlsx')
View(df_exam)

# 합 구하기
sum_math <- sum(df_exam$math)
sum_eng <- sum(df_exam$english)
sum_sci <- sum(df_exam$science)
sum_math
sum_eng
sum_sci

# 평균구하기
avg_math <- mean(df_exam$math)
avg_eng <- mean(df_exam$english)
avg_sci <- mean(df_exam$science)
avg_math
avg_eng
avg_sci
