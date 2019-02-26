# 다중 선형회귀 분석

from sklearn.linear_model import LinearRegression
# 학습 데이터 셋 준비
data = [[170, 30, 1], [155, 60, 2], [150, 50, 2], [175, 40, 1], [165, 20, 1]]
label = [65, 50, 45, 70, 55]

# 학습하기
model = LinearRegression()
model.fit(data, label)

# 예측하기
test = [[180, 27, 1]]
pre = model.predict(test)
print('예측 결과값 :', pre)