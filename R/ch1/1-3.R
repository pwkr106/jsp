# 조건문
num1 <- 1

if(num1 > 0){
  print('num1이 0보다 크다.')
}

if(num1 < 2){
  print('num1이 2보다 작다.')
}else{
  print('num1이 2보다 크다.')
}

result <- ifelse( num1 > 3, 'num1이 3보다 크다.', 'num1이 3보다 작다.')
print(result)

for(i in 1:10){
  print(i)
}


for(k in 1:10){
  sum <- sum + k
}
print(sum)


i <- 1
total <- 0
while(i <= 10){
  if(i%%2 == 0){
    total <- total + i
  }
  i <- i +1
}

print(total)

