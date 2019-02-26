
# 패키지 추가
library(readxl)
library(ggplot2)

df_exam <- read_excel('./data/exam.xlsx')

# 수학
ggplot(data=df_exam, aes(x=id,y=math, fill=math))+geom_col()
# 영어
ggplot(data=df_exam, aes(x=id,y=english, fill=english))+geom_col()
# 과학
ggplot(data=df_exam, aes(x=id,y=science, fill=science))+geom_col()


