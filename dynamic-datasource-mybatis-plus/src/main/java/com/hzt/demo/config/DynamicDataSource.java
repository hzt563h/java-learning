package com.hzt.demo.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName DynamicDataSource.java
 * @Description TODO
 * @createTime 2021年03月22日 19:43:00
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHolder.getDbType();
    }
}
