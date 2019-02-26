# 파이썬 matplotlib 실습하기

import matplotlib.pyplot as plt

# 기본 플로차트
plt.title('Plot1')
plt.plot([1, 3, 4, 9, 10, 16])
plt.show()

# x축 값을 지정
plt.title('Plot2')
plt.plot([10, 20, 30, 40, 50],
         [1, 3, 5, 9, 16])
plt.show()

# 그래프 스타일
plt.title('Plot3')
plt.plot([10, 20, 30, 40, 50],
         [1, 5, 3, 7, 6],
         'rs--')
plt.grid(True)
plt.show()

plt.title('Plot4')
plt.plot([10, 20, 30, 40, 50],  # x축 값
         [1, 5, 3, 7, 6],       # y축 값
         c='r',                 # 선 색깔
         ls='--',               # 선 스타일
         marker='s')            # 마커 종류
plt.show()