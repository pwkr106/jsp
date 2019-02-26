# 머신러닝 XOR 연산

from sklearn import svm

# 레이블 생성
xor_date = [[0, 0, 0],
            [0, 1, 1],
            [1, 0, 1],
            [1, 1, 0]]

# 학습을 위한 데이터와 레이블 분류
data = []
label = []

for row in xor_date:
    x = row[0]
    y = row[1]
    z = row[2]

    data.append([x, y])
    label.append(z)

print('data :', data)
print('label :', label)

# 데이터 학습시키기
model = svm.SVC()
model.fit(data, label)

# 데이터 예측하기
result = model.predict([[1, 0],[1, 1],[0, 1],[0, 0]])
print('result :', result)

