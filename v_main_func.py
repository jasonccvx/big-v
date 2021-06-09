'''
Created on June 4, 2021
Implementation of testing the output of the tables

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.2.1
'''
import v_get


def show_output(alist):
    """
    show the list information to the terminal
    :param alist: a list
    :rtype: Null
    """
    for i in range(len(alist)):
        print(alist[i])


def __main__():
    """
    get all table data loaded to the database
    :rtype: Null
    """
    table1 = v_get.get_bigv_table()
    table2, table3 = v_get.get_combo_and_phased_infor_table()
    table4, table5, table6 = v_get.get_daily_infor_table()


__main__()
