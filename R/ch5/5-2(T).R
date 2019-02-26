#MongoDB 실습
install.packages('mongolite')
library(mongolite)

conn <- mongolite::mongo(collection = 'NAVER',
                         db='chhak',
                         url = 'mongodb://chhak:1234@192.168.111.101:27017',
                         verbose = TRUE,
                         options = ssl_options())

df_naver <- conn$find()
#df_naver_20190219 <- conn$find(paste0('{"rdate":{"$gte":"2019-01-19","$lt":"2019-02-20"}}'))
#View(df_naver_20190219)

# wordcloud 만들기
install.packages('tidyverse')
install.packages('tidyr')
library(tidyverse)
library(tidyr)

df_naver_unit<- unite(data=df_naver, col=unite, 1,2,3,4,5,6,7,8,9,10, sep=' ')
View(df_naver_unit)

noun <- extractNoun(df_naver_unit$unite)
words <- table(unlist(noun))
View(words)

#데이터 프레임으로 변환 
df_word <- as.data.frame(words, stringsAsFactors = F)
View(df_word)

#변수명 수정
df_word <- rename(df_word, word=Var1, freq=Freq)

#두글자 이상 단어 추출
df_word <- filter(df_word, nchar(word) >= 2)

# 상위 20위 확인 
top_20 <- df_word %>% arrange(desc(freq)) %>% head(20)
View(top_20)

#시각화 - 워드클리우드
pal <- brewer.pal(8, "Dark2")
set.seed(1)

wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 2,
          max.words = 200,
          random.order = F,
          rot.per = .1,
          scale = c(4, 0.3),
          colors = pal)
