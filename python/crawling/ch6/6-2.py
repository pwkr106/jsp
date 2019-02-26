# 경사하강법 실습하기

x_data = [170, 155, 150, 175, 165]
y_data = [65, 50, 45, 70, 55]

a = 0
b = 0
eta = 0.0000075

while True:
    # new_a = 제곱된 a 를 미분
    new_a = a - eta * (x_data[0] * 2 * (a * x_data[0] + b - y_data[0]) +
                       x_data[1] * 2 * (a * x_data[1] + b - y_data[1]) +
                       x_data[2] * 2 * (a * x_data[2] + b - y_data[2]) +
                       x_data[3] * 2 * (a * x_data[3] + b - y_data[3]) +
                       x_data[4] * 2 * (a * x_data[4] + b - y_data[4]))
    new_b = b - eta * (2 * b + 2 * (x_data[0] * a - y_data[0]) +
                       2 * b + 2 * (x_data[1] * a - y_data[1]) +
                       2 * b + 2 * (x_data[2] * a - y_data[2]) +
                       2 * b + 2 * (x_data[3] * a - y_data[3]) +
                       2 * b + 2 * (x_data[4] * a - y_data[4]))
    if a == new_a:
        break

    a = new_a
    b = new_b

    print('a : %.12f, b : %.12f' % (a, b))

print('기울기 a :', a)
print('y 절편 b :', b)

