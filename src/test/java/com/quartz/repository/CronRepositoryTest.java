package com.quartz.repository;

import com.quartz.repository.entity.CronEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:29
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CronRepositoryTest {
    @Autowired
    private CronRepository cronRepository;
    @Test
    public void findOne() throws Exception {
        CronEntity one = cronRepository.findOneById(1L);

    }

}