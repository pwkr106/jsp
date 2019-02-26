#행 렬(Matrix) 자료구조
x <- c(1, 2)
y <- c(3, 4)

# rbind : 행결합(row)
# cbind : 열결합(column)
A <- rbind(x, y)
B <- cbind(x, y)
C <- rbind(c(1,2,3), c(4,5,6))
A
B
C

# 행렬원소 출력
A[1, 1]
B[2, 2]
C[2, 3]

#matrix() 행렬
v <- c(1:9)
M1 <- matrix(v, nrow = 3)
M2 <- matrix(v, nrow = 3, byrow=T)
M1
M2

# 행렬연산
D <- A+B
D
D <- A%*%B
D
M3 <- M1%*%M2
M3

# 역행렬
A1 <- solve(A)
A1
E <- A%*%A1
E
A%*%E
MI <- solve(M1)
