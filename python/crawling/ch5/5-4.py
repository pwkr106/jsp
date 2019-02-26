import pandas as pd
# CSV 파일 분석

df_exam = pd.read_csv('./data/exam.csv')

# 수학점수가 60점 이상
df_exam2 = df_exam[df_exam.math >= 60]
print('수학점수가 60점 이상')
print(df_exam2)

# 정렬 오름차순
df_exam3 = df_exam2.sort_values(by='math')
print('수학점수가 60점 이상이고 오름차순')
print(df_exam3)

# 정렬 내림차순
df_exam4 = df_exam2.sort_values(by='math', ascending=False)
print('수학점수가 60점 이상이고 내림차순')
print(df_exam4)

# head(), tail()
# 헤드함수
print('상위 5개 데이터 출력')
print(df_exam.head())

print('하위 5개 데이터 출력')
print(df_exam.tail())

#describe()
print('요약 통계확인')
print(df_exam.describe())

# loc(), iloc()
df1= df_exam.loc()[:, ['math', 'science']]
print('수학, 과학 컬럼만 갖는 데이터프레임')
print(df1)

df2= df_exam.loc()[1:4, ['english', 'math']]
print('1번째에서 4번째 영어, 수학 컬럼만 갖는 데이터프레임')
print(df2)

df3= df_exam.iloc()[1:5, 2:4]
print('1번째에서 4번째 2번째, 4번째 컬럼만 갖는 데이터프레임')
print(df3)

df4= df_exam.iloc()[:, 2:4]
print('2번째, 4번째 컬럼의 모든 데이터프레임')
print(df4)