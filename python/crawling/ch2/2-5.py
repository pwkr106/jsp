import requests as req
from bs4 import BeautifulSoup as bs
from datetime import datetime

res = req.get('http://naver.com')
dom = bs(res.text, 'html.parser')
titles = dom.select('#PM_ID_ct > div.header > div.section_navbar > div.area_hotkeyword.PM_CL_realtimeKeyword_base >'
                    ' div.ah_roll.PM_CL_realtimeKeyword_rolling_base > div > ul > li:nth-of-type(n)')


#for tit in titles:
#    print(tit.text)

fname = "{:%Y-%m-%d-%H-%M.txt}".format(datetime.now())
file = open(fname, mode='w', encoding='utf8')

for tit in titles:
    file.write(tit.text+'\n ')

file.close()