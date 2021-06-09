'''
Created on June 4, 2021
Implementation of crawling the big-V list and each combo information in the list

@author: jasonzheng (jasonccvx@outlook.com)
@version: 0.1.1
'''
import v_list
import v_details
import json
import v_details_graph


def show_output(alist):
    """
    show the list information to the terminal
    :param alist: a list
    :return: Null
    """
    for i in range(len(alist)):
        print(alist[i])


def __main__():
    """
    get the details of all combos in the big-V list
    :rtype: Null
    """
    json_result = v_list.get_json_of_bigv_list()
    list_dict = json.loads(json_result)

    bigv_list = v_list.extract_list_info(list_dict)
    show_output(bigv_list)
    v_list.output_list_to_file(bigv_list)

    for i in range(len(bigv_list)):
        (table1, table2) = v_details.get_details_dict_of_combo(bigv_list[i][1], bigv_list[i][3])
        print('{:-^40}'.format(table1[0]))
        show_output(table1)
        show_output(table2)

    v_details_graph.get_graph_infor_of_combo('10631134')


__main__()
