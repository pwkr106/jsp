# 로지스틱 회귀분석 라이브러리 활용

from sklearn.linear_model import LogisticRegression

data = [[40, 30],
        [30, 80],
        [20, 70],
        [70, 40],
        [60, 20]]

label = [+1, -1, -1, +1, +1]

# 학습하기
model = LogisticRegression()
model.fit(data, label)

# 예측하기
pre = model.predict(data)
print('예측결과 : ', pre)

test = [[40, 60],
        [50, 80],
        [70, 20],
        [40, 30],
        [60, 40]]

test_pre = model.predict(test)
print('test 개체 결과 : ', test_pre)