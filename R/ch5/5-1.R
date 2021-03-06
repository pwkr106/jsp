# 텍스트마이닝

install.packages('rJava')
install.packages('memoise')
install.packages('KoNLP')
install.packages('stringr')

library(KoNLP)
library(dplyr)
library(stringr)

# 형태소 분석을 위한 사전설정
useNIADic()

# 분석용 텍스트파일 읽기
song <- readLines('./data/obama.txt')
View(song)

# 특수문자 제거
song <- str_replace_all(song,'\\w', ' ')

# 명사 단어 추출
noun <- extractNoun(song)
View(noun)

# 단어별 집계
word_count <- table(unlist(noun))
View(word_count)

# 데이터프레임 변환
df_word <- as.data.frame(word_count, stringAsFactorw=F)
View(df_word)

# 변수명 수정
df_word <- rename(df_word, word=Var1, freq=Freq)
View(df_word)


View(df_word)

# 시각화 - 워드클라우드
install.packages('wordcloud')
library(wordcloud)
library(RColorBrewer)

pal <- brewer.pal(8, 'Dark2')
set.seed(1)
wordcloud(words = df_word$word,
          freq = df_word$freq,
          min.freq = 5,
          max.words = 1000,
          random.order = F,
          rot.per = 0.1,
          scale = c(4, 0.3),
          colors = pal)
