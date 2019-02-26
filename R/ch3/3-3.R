# 데이터프레임 파생변수
library(readxl)

df_exam <- read_excel('./data/exam.xlsx')

# 파생변수 생성
# 합
df_exam$sum <- df_exam$math + df_exam$english + df_exam$science

# 평균값
df_exam$mean <- df_exam$sum / 3



# 등급 매기기
df_exam$greade <- ifelse(df_exam$mean >= 90, 'A', 
                         ifelse(df_exam$mean >= 80, 'B',
                          ifelse(df_exam$mean >= 70, 'C',
                            ifelse(df_exam$mean >= 60, 'D','F'))))

# 데이터프레임 뷰
View(df_exam)


# 중앙값
df_exam$median <- median(df_exam$sum)