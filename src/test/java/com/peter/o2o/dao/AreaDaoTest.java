package com.peter.o2o.dao;

import com.peter.o2o.BaseTest;
import com.peter.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void testQueryArea(){
        List<Area> areas = areaDao.queryArea();
        assertEquals(2, areas.size());
    }
}
