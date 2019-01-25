import urllib.request as req

URL = 'http://chhak.com/py/img/puppy1.jpg'
req.urlretrieve(URL, './puppy1.jpg')

print('다운로드 완료...')