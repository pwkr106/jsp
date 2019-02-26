# 로지스틱 회귀분석

a = 0.01617
b = -0.03088
c = 0.97058

def predict(x, y):
    z = a * x + b * y + c
    return  z

data = [[40, 60],
        [50, 80],
        [70, 20],
        [40, 30],
        [60, 40]]

A = predict(data[0][0], data[0][1] )
B = predict(data[1][0], data[1][1] )
C = predict(data[2][0], data[2][1] )
D = predict(data[3][0], data[3][1] )
E = predict(data[4][0], data[4][1] )
# A 값 -0.23541999999999996
# B 값 1.48488
# C 값 1.48488
# D 값 0.69098
# E 값 0.70558


print('A 값', A)
print('B 값', C)
print('C 값', C)
print('D 값', D)
print('E 값', E)

# 그래프 출력
import matplotlib.pyplot as plt
import numpy as np

x = np.arange(0, 100, 1)
y = -1 / b * (a * x + c)

X = [row[0] for row in data]
Y = [row[1] for row in data]

plt.scatter(X, Y)
plt.plot(x, y, color = 'r')
plt.show()