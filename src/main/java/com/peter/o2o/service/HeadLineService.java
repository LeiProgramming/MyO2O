package com.peter.o2o.service;

import com.peter.o2o.dto.HeadLineExecution;
import com.peter.o2o.entity.HeadLine;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Description: 首页头条业务接口
 * @author: peter
 * @date: 2018年11月26日
 */

public interface HeadLineService {
    /**
     * 根据条件查询头条列表
     *
     * @param headLineCondition
     * @return
     * @throws IOException
     */
    List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;


}
