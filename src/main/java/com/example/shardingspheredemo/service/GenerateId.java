package com.example.shardingspheredemo.service;

import com.example.shardingspheredemo.util.SnowflakeIdWorker;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

//@Component
//@Transactional
public class GenerateId implements IdentifierGenerator, Configurable {
    @Resource
    private SessionFactory sessionFactory;
    public String workid;

    public String dataid;

    public SnowflakeIdWorker snowFlakeIdWorker;

    public String getWorkid() {
        return workid;
    }

    public void setWorkid(String workid) {
        this.workid = workid;
    }

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }


    @Override
    public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry) throws MappingException {
//加载配置文件
        InputStream is = GenerateId.class.getResourceAsStream("/snowflake.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MappingException("");
        }
        workid = properties.getProperty("workid");
        dataid = properties.getProperty("dataid");
        if (!StringUtils.isEmpty(dataid) && !StringUtils.isEmpty(workid)) {
            snowFlakeIdWorker = new SnowflakeIdWorker(Long.valueOf(workid), Long.valueOf(dataid));
        }
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Long id = snowFlakeIdWorker.nextId();
        if (id != null) {
            return id;
        }else {
            return null;
        }
    }
}