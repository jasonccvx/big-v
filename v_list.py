'''
Created on June 3, 2021
Implementation of crawling the big-V list and each combo information in the list

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.2.2
'''
import requests
import json
import csv


def get_json_of_bigv_list():
    """
    get the json string of the big-V list
    :return: Null
    """
    url = 'https://appconfig2.1234567.com.cn/config/ComboDataDetail'
    header = {
        'User-Agent': 'EMProjJijin/6.4.2',
        'Host': 'appconfig2.1234567.com.cn'
    }
    dict_data = {
        'MobileKey': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'appVersion': '6.4.2',
        'cltype': '007'
    }

    r = requests.post(url=url, data=dict_data, headers=header)
    return r.text


def extract_list_info(data_dict):
    """
    extract the big-V list from the dict
    :param data_dict: a dict converted from the json file of big-V list
    :return: a big-V list containing needed information
    """
    ans = []
    strategytotallist = data_dict["datas"]["StrategyTotalList"]
    # three types of combo
    for i in range(len(strategytotallist)):
        strategylist = strategytotallist[i]["StrategyList"]
        # each combo in the specified type
        # the display2 is the recent three months score
        for j in range(len(strategylist)):
            item = strategylist[j]
            ans.append([str(i+1), item["FCode"], item["ShortName"], item["PassportID"], item["UserNickname"], item["Display2"]])
    return ans


def output_list_to_file(alist):
    """
    output the result to a csv file
    :return: Null
    """
    with open("C:/code/py_crawling/test.csv", "w+", newline="") as csvfile:
        writer = csv.writer(csvfile)
        for i in range(len(alist)):
            writer.writerow(alist[i])

