# 다중 선형회귀 분석

from sklearn.linear_model import LinearRegression

data = [[170, 30], [155, 60], [150, 50], [175, 40], [165, 20]]
label = [65, 50, 45, 70, 55]

# 학습하기
model = LinearRegression()
model.fit(data, label)

# 예측하기
test = [[180, 32], [172, 21], [156, 42]]
pre = model.predict(test)
print('예측 결과값 :', pre)