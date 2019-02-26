# 데이터프레임 select 필터함수
library(dplyr)

df_exam<- read.csv('../data/exan.csv')


# SELECT math FROM df_exam
df_math <- df_exam %>% select(math)
df_eng <- df_exam %>% select(english)
df_sci <- df_exam %>% select(science)
df_exam2 <- df_exam %>% select(-english)
df_exam3 <- df_exam %>% select(id, class, math, science)

View(df_math)
View(df_eng)
View(df_sci)
View(df_exam2)
View(df_exam3)
View(df_exam4)
View(df_exam5)


# SELECT english, math FROM df_exam WHERE class == 1
df_exam4 <- df_exam %>%  filter(class == 1) %>% select( math, science ) 


# SELECT math, english, science FROM df_exam WHERE math > 60 AND math <= 80
df_exam5 <- df_exam %>%  filter(math > 60 & math <= 80) %>% select( math, english ,science ) 
