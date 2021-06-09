'''
Created on June 9, 2021
Implementation of interfaces that get the all tables in the database relational schema

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.1.2
'''
import v_list
import v_details
import v_details_graph


def get_bigv_table():
    """
    get the bigv table in the database relational schema
    :return bigv_table: each records contain bigv name and the num of his fans, separately
    """
    bigv_table = []
    bigv_list = v_list.get_bigv_list()

    for i in range(len(bigv_list)):
        fans_count = v_details.get_user_fans_count(bigv_list[i][0], bigv_list[i][1])
        bigv_table.append([bigv_list[i][2], fans_count])

    return bigv_table


def get_combo_and_phased_infor_table():
    """
    get combo_table and phased_infor_table in the database relational schema
    :return combo_table: each records contains basic information of the combo, separately
    :return phased_infor_table: each records contains phased information of the combo, separately
    """
    combo_table = []
    phased_infor_table = []
    bigv_list = v_list.get_bigv_list()

    for i in range(len(bigv_list)):
        basic_infor, static_infor = v_details.get_basic_and_static_infor_of_combo(bigv_list[i][0], bigv_list[i][1])
        combo_table.append(basic_infor)
        phased_infor_table = phased_infor_table + static_infor

    return combo_table, phased_infor_table


def get_daily_infor_table():
    """
    get total_rate_table, nav_table and total_profit_table in the database relational schema
    :return total_rate_table: each records contains total rate and index total rate of the recent one year, separately
    :return nav_table: each records contains nav and daily rate of the recent one year, separately
    :return total_profit_table: each records contains total profit of the recent one year, separately
    """
    total_rate_table = []
    nav_table = []
    total_profit_table = []
    bigv_list = v_list.get_bigv_list()

    for i in range(len(bigv_list)):
        total_rate_infor, nav_infor, total_profit_infor = v_details_graph.get_graph_infor_of_combo(bigv_list[i][0])
        name = bigv_list[i][2]
        for j in range(len(total_rate_infor)):
            total_rate_infor[j].insert(0, name)
            nav_infor[j].insert(0, name)
            total_profit_infor[j].insert(0, name)
        total_rate_table = total_rate_table + total_rate_infor
        nav_table = nav_table + nav_infor
        total_profit_table = total_profit_table + total_profit_infor

    return total_rate_table, nav_table, total_profit_table
