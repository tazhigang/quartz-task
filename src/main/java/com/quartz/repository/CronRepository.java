package com.quartz.repository;

import com.quartz.repository.entity.CronEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:25
 * @Description:
 */
@Repository
public interface CronRepository extends JpaRepository<CronEntity,Long>{
    CronEntity findOneById(Long id);
}
