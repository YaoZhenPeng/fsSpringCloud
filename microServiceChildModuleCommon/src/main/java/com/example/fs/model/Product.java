package com.example.fs.model;

import java.io.Serializable;

//这个实体不需要注解，因为整个工程已经pom中被导入到其他工程，这样就可以被spring管理
public class Product implements Serializable {
    private Long pid; //主键
    private String productName; //产品名称
    //来自哪个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同的数据库
    private String dbSource;

    public Product() {
    }

    public Product(Long pid, String productName, String dbSource) {
        this.pid = pid;
        this.productName = productName;
        this.dbSource = dbSource;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
