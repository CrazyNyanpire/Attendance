<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤日期:</label>
                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" readonly class="form-control" style="width:160px;" name="attenceTime" id="attenceTimeID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">工号:</label>
                    <div class="col-lg-9">
                           <input name="employeeNo" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="employeeNoID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">姓名:</label>
                    <div class="col-lg-9">
                           <input name="name" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="nameID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">上班打卡时间:</label>
                    <div class="col-lg-9">
                           <input name="clockIn" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="clockInID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">下班打卡时间:</label>
                    <div class="col-lg-9">
                           <input name="clockOut" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="clockOutID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤状态:</label>
                    <div class="col-lg-9">
                           <input name="attendenceType" readonly style="display:inline; width:94%;" class="form-control"  type="text"  id="attendenceTypeID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">上班出勤状态:</label>
                    <div class="col-lg-9">
                           <div class="btn-group select" id="attendenceInTypeID"></div>
	                       <input type="hidden" id="attendenceInTypeID_"  name="attendenceInType" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">下班出勤状态:</label>
                    <div class="col-lg-9">
                           <div class="btn-group select" id="attendenceOutTypeID"></div>
	                       <input type="hidden" id="attendenceOutTypeID_"  name="attendenceOutType" />
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
        var contents = [{title:'请选择', value: ''}];
        contents.push({title:'未刷卡' , value:'10'});
         contents.push({title:'无效刷卡' , value:'7'});
         contents.push({title:'早退' , value:'6'});
         contents.push({title:'下班打卡正常' , value:'4'});
         contents.push({title:'无下班打卡记录' , value:'9'});
         contents.push({title:'非考勤日下班打卡' , value:'12'});
        selectItems['attendenceOutTypeID'] = contents;
        var contents = [{title:'请选择', value: ''}];
        contents.push({title:'上班打卡正常' , value:'3'});
         contents.push({title:'未刷卡' , value:'10'});
         contents.push({title:'无效刷卡' , value:'7'});
         contents.push({title:'迟到' , value:'5'});
         contents.push({title:'无上班打卡记录' , value:'8'});
         contents.push({title:'非考勤日上班打卡' , value:'11'});
        selectItems['attendenceInTypeID'] = contents;
        </script>
</body>
</html>