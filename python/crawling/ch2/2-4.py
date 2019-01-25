from selenium import webdriver

browser = webdriver.Chrome('./chromedriver.exe')

browser.get('http://naver.com')

login_btn = browser.find_element_by_css_selector('#account > div > a')
login_btn.click()

input_id = browser.find_element_by_id('id')
input_pw = browser.find_element_by_id('pw')

input_id.send_keys('ksb830503')
input_pw.send_keys('1q2w3e4r')

login_btn = browser.find_element_by_css_selector('#account > div > a')
login_btn.click('#frmNIDLogin > fieldset > input')