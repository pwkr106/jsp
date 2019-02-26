# 나이대별 소득분포
# p1002_8aq1 : 소득컬럼
library(dplyr)
library(ggplot2)

kowep2015 <- read.csv('../data/koweps_2015.csv')

kowep2015 <- kowep2015 %>% select(h10_g3, h10_g4, h10_g10, h10_eco9, p1002_8aq1)
kowep2015 <- rename(kowep2015, 
                    gender=h10_g3,
                    birth=h10_g4,
                    married=h10_g10,
                    job=h10_eco9,
                    income=p1002_8aq1)

View(kowep2015)

# 나이 파생변수 추가
kowep2015$age <- 2015 - kowep2015$birth + 1
View(kowep2015)
summary(kowep2015$age)

age_income <- kowep2015 %>% 
  filter(!is.na(income)) %>%
  group_by(age) %>% 
  summarise(mean_income = mean(income))

View(age_income)
ggplot(data=age_income, aes(x=age, y=mean_income))+geom_line()
