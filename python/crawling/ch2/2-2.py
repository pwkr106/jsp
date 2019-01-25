"""
네이버 뉴스 파싱
"""
from bs4 import BeautifulSoup as bs
import urllib.request as req

URL = 'https://news.naver.com/'
html = req.urlopen(URL)

dom = bs(html, 'html.parser')

strong = dom.select('#text_today_main_news_801001 > li > div > a > strong')

print('이시간 주요뉴스')
for s in strong:
    print('제목 : ', s.string)

strong = dom.select('#section_economy > div.com_list > div > ul > li > a > strong')

print('경제')
for s in strong:
    print('제목 : ', s.string)

strong = dom.select('#section_society > div.com_list > div > ul > li > a > strong')

print('사회')
for s in strong:
    print('제목 : ', s.string)

