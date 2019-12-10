# -*- coding: utf-8 -*-
#!/usr/bin/python3
import io
import sys
from lxml import etree
import requests
import time

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf8')

whilenum = 1

while True:
	print(whilenum)
	whilenum += 1
	list = ['MR04157591'
			]
	'''
	13818574282
	15121113930
	13661649922
	18621144954
	'''
	headers = {
		'Host': 'mgr.qianxs.com',
		'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:62.0) Gecko/20100101 Firefox/62.0',
		'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
		'Accept-Language': 'zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2',
		'Accept-Encoding': 'gzip, deflate',
		'Cookie': 'username=wangqian; username=huchao; JSESSIONID=CDCD57F89D160E11BEEA95A525C14D72; Hm_lvt_6b57abce4620ce20074f6620052c91a0=1536232865,1537347658; uid=05B4HFqPeF1TyCBqA9sKAg==; Hm_lpvt_6b57abce4620ce20074f6620052c91a0=1537842698',
		'Connection': 'keep-alive',
		'Upgrade-Insecure-Requests': '1'
	}
	# db = pymysql.connect(host="192.168.1.230",port=3306,db="local",user="root",passwd="qianxs.com",charset='utf8')
	# cursor = db.cursor()
	updates = 0
	index = 0
	for mid in list:
		resp = requests.get("http://mgr.qianxs.com/mmgr/memaudit/lookDetail.html?mId="+mid+"&ts=400", headers=headers)
		html = ((resp.content).decode("UTF-8"))
		res = etree.HTML(html)
		#/html/body/div[2]/table/tbody/tr[1]/td[2]
		#mid = res.xpath('//tr[1]/td[2]/text()')
		#/html/body/div[2]/table/tbody/tr[3]/td[5]
		mo = res.xpath('//tr[3]/td[5]/text()')
		# /html/body/div[2]/table/tbody/tr[6]/td[2]
		#/html/body/div[2]/table/tbody/tr[1]/td[5]
		name = res.xpath('//tr[1]/td[5]/text()')
		# 定期
		bal_dingqi = res.xpath('//tr[6]/td[2]/text()')
		bal_huoqi = res.xpath('//tr[7]/td[2]/text()')
		_bal_dingqi = str(bal_dingqi[0]).replace("￥","").replace(",","")
		_bal_huoqi = str(bal_huoqi[0]).replace("￥","").replace(",","")
		bal = float(_bal_dingqi) + float(_bal_huoqi)
		# print(mo[0] + '|' + name[0] + '，您好！钱先生APP推出短信余额提醒服务，您目前账户余额为'+str(bal)+'元，您可打开钱先生APP查询详情 退订T')
		# print(mid,mo,name,bal)


		# sql = "update USR_BLANCE set Bal = " + str(bal) + " where Mid = '" + mid + "';"

		# effect_row = cursor.execute(sql)
		# if effect_row > 0:
		# 	updates += 1
		index += 1
		# print('index=' + str(index),'updates=' + str(updates),sql)
	# db.commit()
	# cursor.close()
	# db.close()
	time.sleep(60)


