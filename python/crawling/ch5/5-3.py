import pandas as pd
# CSV 파일 분석

df_exam = pd.read_csv('./data/exam.csv')
print(df_exam)

# 슬라이싱
print('df_exam[2:4] 출력')
print(df_exam[2:4])

print('df_exam[3:] 출력')
print(df_exam[3:])

# 파생변수
df_exam['total'] = df_exam.math + df_exam.english + df_exam.science
print(df_exam)
df_exam['mean'] = (df_exam.math + df_exam.english + df_exam.science) / 3
print(df_exam)