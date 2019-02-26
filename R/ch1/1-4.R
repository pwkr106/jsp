#R 기본함수

# c() - 벡터생성

var1 <- c(1,2,3)
print(var1)
print(var1[1])
print(var1[2])
print(var1[3])

var2 <- c(1:10)
print(var2)

for(i in var2){
  print(i)
}

# seq() - 벡터 생성
var3 <- seq(1, 10)
var4 <- seq(1, 10, by=2)

# 벡터의 합과 평균
var3_sum <- sum(var3)
var4_sum <- sum(var4)
var3_mean <- mean(var3)
var4_mean <- mean(var4)

var3_sum
var4_sum
var3_mean
var4_mean

#함수정의
total <- function(a, b){
  x <- sum(a)
  y <- sum(b)
  z <- x + y
  
  return(z)
}

result <- total(var3, var4)
result
