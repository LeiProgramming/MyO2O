/**
 *
 */
package com.peter.o2o.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peter.o2o.dao.HeadLineDao;
import com.peter.o2o.dto.HeadLineExecution;
import com.peter.o2o.entity.HeadLine;
import com.peter.o2o.enums.HeadLineStateEnum;
import com.peter.o2o.enums.OperationStatusEnum;
import com.peter.o2o.exception.HeadLineOperationException;
import com.peter.o2o.service.HeadLineService;
import com.peter.o2o.util.ImageUtil;
import com.peter.o2o.util.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @Description: 首页头条业务接口实现
 *
 * @author: peter
 * @date: 2018年11月26日
 */
@Service
public class HeadLineServiveImpl implements HeadLineService {

    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headLineCondition) {
        return headLineDao.selectHeadLineList(headLineCondition);
    }

}
