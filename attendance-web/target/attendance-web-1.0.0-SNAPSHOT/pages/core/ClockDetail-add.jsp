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
                        <input type="text" class="form-control" style="width:160px;" name="attenceTime" id="attenceTimeID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">工号:</label>
                    <div class="col-lg-9">
                           <input name="employeeNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="employeeNoID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">姓名:</label>
                    <div class="col-lg-9">
                           <input name="name" style="display:inline; width:94%;" class="form-control"  type="text"  id="nameID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">上班打卡时间:</label>
                    <div class="col-lg-9">
                           <input name="clockIn" style="display:inline; width:94%;" class="form-control"  type="text"  id="clockInID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">上班出勤状态̬:</label>
                    <div class="col-lg-9">
                           <input name="attendenceInType" style="display:inline; width:94%;" class="form-control"  type="text"  id="attendenceInTypeID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">下班打卡时间:</label>
                    <div class="col-lg-9">
                           <input name="clockOut" style="display:inline; width:94%;" class="form-control"  type="text"  id="clockOutID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">下班出勤状态:</label>
                    <div class="col-lg-9">
                           <input name="attendenceOutType" style="display:inline; width:94%;" class="form-control"  type="text"  id="attendenceOutTypeID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤状态:</label>
                    <div class="col-lg-9">
                           <input name="attendenceType" style="display:inline; width:94%;" class="form-control"  type="text"  id="attendenceTypeID" />
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
                                                                    </script>
</body>
</html>