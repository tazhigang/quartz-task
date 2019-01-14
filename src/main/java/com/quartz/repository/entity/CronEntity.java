package com.quartz.repository.entity;

import javax.persistence.*;

/**
 * @Author: ittzg
 * @CreateDate: 2019/1/14 15:26
 * @Description:
 */
@Entity
@Table(name = "cron")
public class CronEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String cron;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    @Override
    public String toString() {
        return "CronEntity{" +
                "id=" + id +
                ", cron='" + cron + '\'' +
                '}';
    }
}
