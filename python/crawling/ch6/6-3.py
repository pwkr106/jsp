# 단순 선형회귀 분석

from scipy import stats, polyval
import numpy as np
import matplotlib.pyplot as plt

x_data = [170, 155, 150, 175, 165]
y_data = [65, 50, 45, 70, 55]

# 학습하기 기울기, 절편,
slope, intercept, r, p, std = stats.linregress(x_data, y_data)
print('slope:', slope)
print('intercept:', intercept)

# 예측하기
def predict(x):
    return slope * x + intercept

w172 = predict(172)
w180 = predict(180)
w182 = predict(182)
w192 = predict(192)

print('키 172에 대한 예측값(몸무게) : ', w172)
print('키 180에 대한 예측값(몸무게) : ', w180)
print('키 182에 대한 예측값(몸무게) : ', w182)
print('키 192에 대한 예측값(몸무게) : ', w192)

# 그래프로 출력
x = np.arange(150, 180, 1)
y = slope * x + intercept

plt.scatter(x_data, y_data)
plt.plot(x, y)
plt.show()