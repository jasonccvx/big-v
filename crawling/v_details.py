'''
Created on June 3, 2021
Implementation of crawling the basic information of a fund portfolio

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.3.3
'''
import requests
import json


def get_static_combo_details_json_of_combo(code, id):
    """
    get the json string of the combo static information which is specified by the code and id
    :param code: the code of the combo
    :param id: the id of the user which occupies the combo
    :return r.text: json string
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
    :return r.text: json string
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


def get_user_fans_count(code, id):
    """
    get the num of one's fans
    :param code: for a user
    :param id: the id of the user
    :return user_fans_count: the num of the user's fans
    """
    json_result = get_static_combo_details_json_of_combo(code, id)
    static_combo_details_dict = json.loads(json_result)
    user_fans_count = static_combo_details_dict["data"]["FZHBatchGetUserInfos"]["Data"][0]["user_fans_count"]
    return user_fans_count


def get_combo_name(code):
    """
    get the name of the combo specified by the code
    :param code: the code of one combo
    :return name: the name of the specifed combo
    """
    json_result = get_index_details_json_of_combo(code)
    index_details_dict = json.loads(json_result)
    name = index_details_dict["Data"]["Name"]
    return name


def perc_to_decimal(data):
    """
    change the percentage data to a string of decimal data
    :param data: percentage data
    :return data: a string, containing the decimal data
    """
    if data[-1] == '%':
        data = data[:-1]
        tmp = float(data)
        tmp *= 0.01
        tmp = round(tmp, 4)
        return str(tmp)
    else:
        return data


def get_basic_and_static_infor_of_combo(code, id):
    """
    get combo basic information and static data of the combo
    :param code: the code of the combo
    :param id: the id of the user
    :return basic_info: contains basic information
    :return phased_info: contains static data
    """
    json_result = get_static_combo_details_json_of_combo(code, id)
    json_result2 = get_index_details_json_of_combo(code)
    static_combo_details_dict = json.loads(json_result)
    index_details_dict = json.loads(json_result2)

    basic_info = []

    # locate the basic information
    name = index_details_dict["Data"]["Name"]
    style = index_details_dict["Data"]["Style"]
    annualized_rate_since_establishment = index_details_dict["Data"]["ZHBIntervalRate"]
    latest_daily_rate = index_details_dict["Data"]["DailyProfit"]
    latest_nav = index_details_dict["Data"]["Nav"]
    latest_total_profit = index_details_dict["Data"]["AssetVol"]
    create_time = index_details_dict["Data"]["GroupCreatTime"]
    user_nickname = static_combo_details_dict["data"]["FZHBatchGetUserInfos"]["Data"][0]["user_nickname"]

    # add basic information into the basic_info
    basic_info.append(name)
    basic_info.append(user_nickname)
    basic_info.append(style)
    basic_info.append(annualized_rate_since_establishment)
    basic_info.append(latest_daily_rate)
    basic_info.append(latest_nav)
    basic_info.append(latest_total_profit)
    basic_info.append(create_time)

    phased_info = []

    # locate the phased information and add them into the phased_info
    indexinfo = index_details_dict["Data"]["SubIntervalIndexList"]
    for i in range(len(indexinfo)):
        item = indexinfo[i]["SubIndexList"]
        phased_info.append([name, indexinfo[i]["IntervalType"]])
        for j in range(len(item)):
            phased_info[i].append(perc_to_decimal(item[j]["IndexValue"]))

    scoreinfo = static_combo_details_dict["data"]["SubAScoreInfo"]["Data"]["ScoreInfo"]
    for i in range(len(scoreinfo)):
        score = scoreinfo[i]["ScoreDetail"]
        for j in range(len(phased_info)):
            if phased_info[j][1] == int(score["IntervalType"]):
                phased_info[j].append(score["CompositeScore"])

    return basic_info, phased_info
