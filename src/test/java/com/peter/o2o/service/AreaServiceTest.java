package com.peter.o2o.service;

import com.peter.o2o.BaseTest;
import com.peter.o2o.entity.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class AreaServiceTest extends BaseTest {
    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areas = areaService.getAreaList();
        assertEquals("西区", areas.get(0).getAreaName());
    }
}
