package com.zhc.dubbo.producer.server.service.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhc.dubbo.producer.api.enums.StatusCode;
import com.zhc.dubbo.producer.api.response.BaseResponse;
import com.zhc.dubbo.producer.api.service.IDubboItemService;
import com.zhc.dubbo.producer.model.entity.ItemInfo;
import com.zhc.dubbo.producer.model.mapper.ItemInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

/**
 * @author : sixteenbell
 * @version : 1.0
 * @date : 2020/3/14 6:05 PM
 * @description :
 */
@Service(protocol = {"dubbo", "rest"}, validation = "true", version = "1.0", timeout = 3000)
@Path("moocOne")
public class DubboItemService implements IDubboItemService {
    private static final Logger log = LoggerFactory.getLogger(DubboItemService.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    @Override
    @Path("item/list")
    public BaseResponse listItems() {
        BaseResponse response = new BaseResponse(StatusCode.Success);
        try {
            List<ItemInfo> itemInfoList = itemInfoMapper.selectAll();
            response.setData(itemInfoList);
        } catch (Exception e) {
            log.error("查询列表服务-时间的业务逻辑-异常", e);
            response = new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    @Override
    @Path("item/page/list")
    public BaseResponse listPageItems(@QueryParam("pageNo") Integer pageNo,
                                      @QueryParam("PageSize") Integer PageSize) {
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            //TODO:分页组件-第pageNo页，pageSize条数目数据
            PageHelper.startPage(pageNo,PageSize);
            PageInfo info=new PageInfo<ItemInfo>(itemInfoMapper.selectAll());
            response.setData(info);

        }catch (Exception e){
            log.error("列表查询-分页查询服务-实际的业务实现逻辑-发生异常：",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }

    @Override
    @Path("item/page/list/params")
    public BaseResponse listPageItemsParams(@QueryParam("pageNo") Integer pageNo,
                                            @QueryParam("PageSize") Integer PageSize,
                                            @QueryParam("search") String search) {
        BaseResponse response=new BaseResponse(StatusCode.Success);
        try {
            //TODO:分页组件-第pageNo页，pageSize条数目数据
            PageHelper.startPage(pageNo,PageSize);
            PageInfo info=new PageInfo<ItemInfo>(itemInfoMapper.selectAllByParams(search));
            response.setData(info);

        }catch (Exception e){
            log.error("列表查询-分页查询模糊查询服务-实际的业务实现逻辑-发生异常：",e.fillInStackTrace());
            response=new BaseResponse(StatusCode.Fail);
        }
        return response;
    }
}
