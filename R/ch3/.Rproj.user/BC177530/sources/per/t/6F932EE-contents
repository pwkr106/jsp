# 데이터프레임 mutate 필터함수
library(dplyr)

df_exam <- read.csv('../data/exam.csv')

df1 <- df_exam %>% mutate(total=math+english+science)

df2 <- df_exam %>% mutate(total=math+english+science, 
                          avg=total/3)
df3 <- df_exam %>% mutate(total=math+english+science,
                          avg=total/3,
                          result=ifelse(avg>=60, 'PASS', 'FAIL'))

View(df1)
View(df2)
View(df3)
