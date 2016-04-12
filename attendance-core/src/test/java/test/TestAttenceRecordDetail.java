package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openkoala.koala.util.KoalaBaseSpringTestCase;

import com.acetecsemi.attendance.attendance.core.AttenceRecordDetail;
import com.acetecsemi.attendance.attendance.core.SheduleScope;


public class TestAttenceRecordDetail extends KoalaBaseSpringTestCase { 

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
    	AttenceRecordDetail attenceRecordDetail = new AttenceRecordDetail();
    	List<SheduleScope> querySheduleScopeList =
    	attenceRecordDetail.querySheduleScopeList("2014-08-26", "2014-09-23");
    	System.out.println(querySheduleScopeList.size());
    	//Assert.a.isTrue("1".equals(waferProcessDTO.getCustomerCode()));
    	//dayAttendanceConfirmationCreateApplication.createDayAttendanceConfirmation(0, 5);
    	//monthlyAttendanceConfirmationCreateApplication.createMonthlyAttendanceConfirmation(2014, 5);
    	//Assert.isTrue(pages.getPageCount()==2);
    	//Assert.isTrue(pages.getStart()==10);
    	//Assert.isTrue(pages.getData().size()==1);
    } 
    
    @Test
    public void testQuery(){ 
    	
    } 
    
 }