'''
Created on June 3, 2021
Implementation of crawling the graph information of a certain fund portfolio

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.2.0
'''
import requests
import json
import matplotlib.pyplot as plt


def get_json_of_graph_info(code):
    """
    get the json string of the combo graph information which is specified by the code
    :param code: the code of the combo
    :return: json string
    """
    kv = {
        'DataType': 1,
        'IntervalType': 1,
        'SubCustomerNo': code,
        'SubAccountNo': code,
        'deviceid': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'version': '6.4.2',
        'product': 'EFund',
        'plat': 'Iphone',
        'version': '6.4.2',
        'ServerVersion': '6.4.2',
        'UserId': '',
        'CToken': '',
        'MobileKey': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'PhoneType': 'android',
        'Passportid': '',
        'CustomerNo': ''
    }

    url = 'https://tradeapilvs6.1234567.com.cn/User/SubA/SubAProfit'
    header = {
        'User-Agent': 'EMProjJijin/6.4.2',
        'Host': 'tradeapilvs6.1234567.com.cn'
    }

    data_dict = {
        'DataType': 1,
        'IntervalType': 1,
        'SubCustomerNo': code,
        'SubAccountNo': code,
        'deviceid': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'version': '6.4.2',
        'product': 'EFund',
        'plat': 'Iphone',
        'appVersion': '6.4.2',
        'ServerVersion': '6.4.2',
        'UserId': '',
        'CToken': '',
        'MobileKey': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'PhoneType': 'android',
        'Passportid': '',
        'CustomerNo': ''
    }

    r = requests.post(url, data_dict, headers=header, params=kv)
    return r.text


def get_graph_infor_of_combo(code):
    """
    draw the graph of the combo which is specified by the code
    :param code: the code of the combo which is needed to draw its graph
    :return: Null
    """
    result = get_json_of_graph_info(code)
    result_dict = json.loads(result)  # converting JSON string to Python object

    date = []

    # rate_table
    total_rate = []
    index_total_rate = []

    # nav_table
    nav = []
    daily_rate = []

    # profit_table
    total_profit = []

    graphlist = result_dict["Data"]["GraphSpotList"]
    for i in range(365):
        date.append(i)
        total_rate.append(graphlist[i]["AccountNav"]["TotalRate"])
        index_total_rate.append(graphlist[i]["IndexNav"]["TotalRate"])
        nav.append(graphlist[i]["AccountNav"]["Nav"])
        daily_rate.append(graphlist[i]["AccountNav"]["Rate"])
        total_profit.append(graphlist[i]["TotalProfit"])
    fig = plt.figure(figsize=(20, 6), dpi=80)
    ax1 = fig.add_subplot(1, 3, 1)
    ax2 = fig.add_subplot(1, 3, 2)
    ax3 = fig.add_subplot(1, 3, 3)
    ax1.plot(date, total_rate, 'r')
    ax1.plot(date, index_total_rate, 'b')
    ax2.plot(date, nav)
    ax3.plot(date, total_profit)
    ax1.set_title('TIME-TotalRate(Table1)')
    ax1.set_xlabel('TIME')
    ax1.set_ylabel('TotalRate')
    ax2.set_title('TIME-Nav&DailyRate(Table2)')
    ax2.set_xlabel('TIME')
    ax2.set_ylabel('Nav&DailyRate')
    ax3.set_title('TIME-TotalProfit')
    ax3.set_xlabel('TIME')
    ax3.set_ylabel('TotalProfit')
    plt.show()
