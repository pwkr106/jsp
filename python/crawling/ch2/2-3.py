import requests as req
from bs4 import BeautifulSoup as bs

sess = req.session()

id = 'ksb0503'
pw = '123456789'
login_check_url = 'https://here.busan.com/bbs/login_check.php'
sess.post(login_check_url, data={'mb_id' : id ,'mb_password' : pw})

mypage_url = 'http://here.busan.com/member/member_mypage.php'
res = sess.get(mypage_url)

dom = bs(res.text,'html.parser')
id = dom.select_one('#design_contents > dl > dd > span.id')
point = dom.select_one('#design_contents > div.point > font:nth-of-type(1)')

print('아이디 :', id.string)
print('포인트 :', point.string)