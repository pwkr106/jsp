# 데이터프레임 arrange 필터함수
library(dplyr)
library(readxl)

df_exam <- read_excel('../data/exam.xlsx')

df_exam1 <- df_exam %>% arrange(math)
View(df_exam1)

df_exam2 <- df_exam %>% arrange(desc(math))
View(df_exam2)

# SELECT class, id, math FROM df_exam WHERE math >= 60 ORDER BY math DESC LIMIT 3;
#filter() => WHERE , arrange() => ORDER BY , head() => LIMIT
df_exam3 <- df_exam %>% select(class, id, math) %>% 
                        filter(math >= 60) %>% 
                        arrange(desc(math)) %>% 
                        head(3)
View(df_exam3)

#
