package com.acetecsemi.attendance.attendance.application.impl;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.dayatang.domain.InstanceFactory;
import org.dayatang.querychannel.Page;
import org.junit.Before;
import org.junit.Test;
import org.openkoala.koala.util.KoalaBaseSpringTestCase;
import org.springframework.util.Assert;

import com.acetecsemi.attendance.attendance.application.core.MonthlyAttendanceConfirmationCreateApplication;


public class TestMonthlyAttendanceConfirmationCreateApplication extends KoalaBaseSpringTestCase { 
  
    @Inject
    private MonthlyAttendanceConfirmationCreateApplication monthlyAttendanceConfirmationCreateApplication;

    @Before
    public void before() throws SQLException {
//        Statement stmt  = null;
//        try{
//            String create = " CREATE TABLE `Employee` ( `id` int(11) DEFAULT NULL, `name` varchar(255) DEFAULT NULL, `age` varchar(255) DEFAULT NULL, `birthDate` date DEFAULT NULL, `gender` varchar(255) DEFAULT NULL )";
//            DataSource dataSource = InstanceFactory.getInstance(DataSource.class);
//            stmt = dataSource.getConnection().createStatement();
//            stmt.execute(create);
//        }catch(Exception e){
//        }finally{
//            stmt.close();
//        }
    }

    @Test
    public void test(){ 
    	//monthlyAttendanceConfirmationCreateApplication.createMonthlyAttendanceConfirmation(2014, 5);
    	//Assert.isTrue(pages.getPageCount()==2);
    	//Assert.isTrue(pages.getStart()==10);
    	//Assert.isTrue(pages.getData().size()==1);
    } 
 }