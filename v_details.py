'''
Created on June 3, 2021
Implementation of crawling the basic information of a fund portfolio

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.2.3
'''
import requests
import json


def get_static_combo_details_json_of_combo(code, id):
    """
    get the json string of the combo static information which is specified by the code and id
    :param code: the code of the combo
    :param id: the id of the user which occupies the combo
    :return: json string
    """
    url = 'https://h5.1234567.com.cn/AggregationStaticService/GetCustomBusinessInterfaceWithSchema/ComboDetailOpAggr'
    header = {
        'User-Agent': 'EMProjJijin/6.4.2',
        'Host': 'h5.1234567.com.cn'
    }
    dict_data = {
        'CToken': '',
        'CustomerNo': '',
        'DataType': '1',
        'From': 'detail',
        'FundCode': '43-' + code,
        'Interval': '0',
        'IntervalType': '4',
        'MobileKey': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'Passportid': '',
        'PhoneType': 'android',
        'ServerVersion': '6.4.2',
        'SubAccountNo': code,
        'UToken': '',
        'UserId': '',
        'appVersion': '6.4.2',
        'deviceid': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'plat': 'Iphone',
        'product': 'EFund',
        'uids': id,
        'version': '6.4.2'
    }
    r = requests.post(url=url, data=dict_data, headers=header)
    return r.text


def get_index_details_json_of_combo(code):
    """
    get the json string of the combo basic information which is specified by the code
    :param code: the code of the combo
    :return: json string
    """
    url = 'https://tradeapilvs6.1234567.com.cn/User/SubA/SubAGradingIndexDetailV2'
    header = {
        'User-Agent': 'EMProjJijin/6.4.2',
        'Host': 'h5.1234567.com.cn'
    }
    dict_data = {
        'CToken': '',
        'CustomerNo': '',
        'MobileKey': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'Passportid': '',
        'PhoneType': 'android',
        'ServerVersion': '6.4.2',
        'SubAccountNo': code,
        'UToken': '',
        'UserId': '',
        'appVersion': '6.4.2',
        'deviceid': '013BE7C9-98FA-4A81-9952-5EE372D498E7',
        'plat': 'Iphone',
        'product': 'EFund',
        'version': '6.4.2'
    }
    r = requests.post(url=url, data=dict_data, headers=header)
    return r.text


def get_details_dict_of_combo(code, id):
    """
    get combo information by the code and user id
    :param code: the code of a specified combo
    :param id: the id of user
    :return: the basic information table and score information table of the combo
    """
    json_result = get_static_combo_details_json_of_combo(code, id)
    json_result2 = get_index_details_json_of_combo(code)
    static_combo_details_dict = json.loads(json_result)
    index_details_dict = json.loads(json_result2)

    table_combo_info = []
    table_score_info = []

    # locate the basic information
    name = index_details_dict["Data"]["Name"]
    style = index_details_dict["Data"]["Style"]
    annualized_rate_since_establishment = index_details_dict["Data"]["ZHBIntervalRate"]
    latest_daily_rate = index_details_dict["Data"]["DailyProfit"]
    latest_nav = index_details_dict["Data"]["Nav"]
    latest_total_profit = index_details_dict["Data"]["AssetVol"]
    create_time = index_details_dict["Data"]["GroupCreatTime"]
    user_nickname = static_combo_details_dict["data"]["FZHBatchGetUserInfos"]["Data"][0]["user_nickname"]
    user_fans_count = static_combo_details_dict["data"]["FZHBatchGetUserInfos"]["Data"][0]["user_fans_count"]

    # add basic information into the table_combo_info
    table_combo_info.append(code)
    table_combo_info.append(name)
    table_combo_info.append(style)
    table_combo_info.append(annualized_rate_since_establishment)
    table_combo_info.append(latest_daily_rate)
    table_combo_info.append(latest_nav)
    table_combo_info.append(latest_total_profit)
    table_combo_info.append(create_time)
    table_combo_info.append(user_nickname)
    table_combo_info.append(user_fans_count)

    # locate the score information and add them into the table_score_info
    indexinfo = index_details_dict["Data"]["SubIntervalIndexList"]
    for i in range(len(indexinfo)):
        item = indexinfo[i]["SubIndexList"]
        table_score_info.append([indexinfo[i]["IntervalType"]])
        for j in range(len(item)):
            table_score_info[i].append(item[j]["IndexValue"])

    scoreinfo = static_combo_details_dict["data"]["SubAScoreInfo"]["Data"]["ScoreInfo"]
    for i in range(len(scoreinfo)):
        score = scoreinfo[i]["ScoreDetail"]
        for j in range(len(table_score_info)):
            if table_score_info[j][0] == int(score["IntervalType"]):
                table_score_info[j].append(score["CompositeScore"])

    return table_combo_info, table_score_info

