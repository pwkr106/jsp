# 데이터프레임 필터함수
install.packages('dplyr')
library(dplyr)

df_exam <- read.csv('../data/exam.csv')
View(df_exam)

# 파이프연산자 멤버함수 
########################################################
# %>% : 파이프연산
# filter() : 조건에 맞는 변수를 필터링
df_class1 <- df_exam %>% filter(class==1)
df_class_not1 <- df_exam %>% filter(class!=1)
View(df_class1)
View(df_class_not1)

# 수학점수 50점 이상
df_math <- df_exam %>% filter(math >= 50)
# 영어점수 60점 이상 이고 80점 미만
df_eng <- df_exam %>% filter(english >= 60 & english < 80)
# 과학점수 60점 이하 또는 80점 이상
df_sic <- df_exam %>% filter(science <= 60 | science >= 80)

View(df_math)
View(df_eng)
View(df_sic)




