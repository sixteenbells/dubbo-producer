package com.zhc.dubbo.producer.api.service;
/**
 * Created by Administrator on 2019/1/13.
 */

import com.zhc.dubbo.producer.api.response.BaseResponse;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/1/13 14:20
 **/
public interface IDubboItemService {

    BaseResponse listItems();

    BaseResponse listPageItems(Integer pageNo, Integer pageSize);

    BaseResponse listPageItemsParams(Integer pageNo, Integer pageSize, String search);

}
