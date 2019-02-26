# 데이터전처리
# 결측치(값이 누락된 값) 처리하기

library(dplyr)

df_exam <- read.csv('./data/csv_exam_na.csv')

# 결측치 존재여부 검사
is.na(df_exam)

# 결측치를 갖는 행 제거
new_exam <- df_exam %>% filter(!is.na(math) & !is.na(english) & !is.na(science))
View(new_exam)

new_exam %>% mutate(total= math+english+science) %>% arrange(desc(total))
