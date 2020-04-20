package com.zhc.dubbo.producer.api.service;

import com.zhc.dubbo.producer.api.request.PushOrderDto;
import com.zhc.dubbo.producer.api.response.BaseResponse;

/**
 * Created by Administrator on 2019/1/14.
 */
public interface IDubboRecordService {

    public BaseResponse pushOrder(PushOrderDto dto);

}
