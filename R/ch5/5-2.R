# R MySQL 실습하기
install.packages('RMySQL')
library(RMySQL)

conn <- dbConnect(MySQL(),
                  user='kjh',
                  password='1234',
                  dbname='kjh',
                  host='192.168.0.126')

sql <- 'SELECT * FROM USER'

df_user <- dbGetQuery(conn, statement = sql)
# 데이터 종류 확인
class(df_user)

Encoding(df_user$name) <- 'UTF-8'
Encoding(df_user$addr) <- 'UTF-8'
Encoding(df_user$pos) <- 'UTF-8'

View(df_user)

