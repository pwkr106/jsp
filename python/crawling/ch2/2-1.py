"""
파이썬 파싱연습
"""
from bs4 import BeautifulSoup as bs
import urllib.request as req

URL = 'http://chhak.com/py/test1.html'
html = req.urlopen(URL)

dom = bs(html, 'html.parser')
title = dom.select_one('h1').string
items = dom.select('ul > li')


print('제목 : ', title)

for li in items:
    print('아이템 : ', li.string)