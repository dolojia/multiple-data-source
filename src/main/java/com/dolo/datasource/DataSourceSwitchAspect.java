package com.dolo.datasource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Order;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import groovy.util.logging.Slf4j;

@Component
@Aspect
@Order(-100) //这是为了保证AOP在事务注解之前生效,Order的值越小,优先级越高
@Slf4j
public class DataSourceSwitchAspect {

    protected Logger logger = LogManager.getLogger(this.getClass());

    @Pointcut("execution(* com.dolo.service.db1.impl..*.*(..))")
    private void dataSource1Aspect() {
    }

    @Pointcut("execution(* com.dolo.service.db2.impl..*.*(..))")
    private void dataSource2Aspect() {
    }

    @Before("dataSource1Aspect()")
    public void dataSource1() {
        logger.info("dataSource1 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.dataSource1);
    }

    @Before("dataSource2Aspect()")
    public void wechatDataSource2() {
        logger.info("dataSource2 数据源...");
        DbContextHolder.setDbType(DBTypeEnum.dataSource2);
    }
}