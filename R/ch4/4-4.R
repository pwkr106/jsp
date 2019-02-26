# 대한민국 지역별 인구연령 분포
library(dplyr)
library(ggplot2)

kowep2015 <- read.csv('./data/koweps_2015.csv')

# 1. 컬럼명 변경
kowep2015 <- kowep2015 %>% select(h10_g3, h10_g4, h10_g10, h10_g11, h10_eco9, h10_reg7)
kowep2015 <- rename(kowep2015, 
                    gender=h10_g3, 
                    birth=h10_g4,
                    married=h10_g10,
                    religion=h10_g11,
                    job=h10_eco9,
                    region=h10_reg7
                    )

View(kowep2015)

# 2. 지역별 데이터확인
table(kowep2015$region)

list_region <- data.frame(region=c(1:7),
                          region_name=c('서울','수도권(경기/인천)','부산/경남','대구/경북',
                                        '대전/충남','강원/충북','광주/전남/전북/제주'))
View(list_region)

# 3. 지역명 파생변수 추가
kowep2015 <- left_join(kowep2015, list_region, by='region')
View(kowep2015)

# 4. 나이 파생변수 추가
kowep2015$age <- 2019 - kowep2015$birth+1
View(kowep2015)
qplot(kowep2015$age)

# 5. 나이대 파생변수 추가
kowep2015 <- kowep2015 %>% mutate(ageg=ifelse(age < 30, 'young',
                                              ifelse(age < 60, 'middle','old')))
qplot(kowep2015$ageg)

# 6. 지역별 연령대 비율계산
region_ageg <- kowep2015 %>% 
               group_by(region_name, ageg) %>% 
               summarise(n=n()) %>% 
               mutate(tot_group=sum(n)) %>% 
               mutate(per=round(n/tot_group*100, 2))

View(region_ageg)

# 7. 그래프 출력
ggplot(data=region_ageg, aes(x=region_name,y=per, fill=ageg))+geom_col()



