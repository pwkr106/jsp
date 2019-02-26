import pandas as pd

# 데이터프레임
df1 = pd.DataFrame([[1, 2, 3], [4, 5, 6], [7, 8, 9]])
print('df1 :', df1)

# 컬럼명을 지정한 데이터프레임
df2 = pd.DataFrame({
    'name': ['김유신', '김춘추', '강감찬', '이순신'],
    'age' : [19, 21, 32, 43],
    'height' : [171, 178, 181, 175],
})

print('df2 : ', df2)

# 데이터 출력
print('name : ', df2['name'])
print('age : ', df2['age'])
print('height : ', df2['height'])