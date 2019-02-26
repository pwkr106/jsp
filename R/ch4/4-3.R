# 막대그래프
install.packages('ggplot2')
library(ggplot2)

score <- c(80, 72, 60, 78, 82, 94)

df_exam <- read.csv('./data/exam.csv')

barplot(score)

qplot(id, math, data=df_exam, geom = 'col')

# R 내장 데이터프레임 사용
View(economics)
qplot(date, unemploy, data=economics, geom='line')
