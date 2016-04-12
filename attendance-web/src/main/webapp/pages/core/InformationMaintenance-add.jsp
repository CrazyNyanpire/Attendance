<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">姓名:</label>
                    <div class="col-lg-9">
                           <input name="name" style="display:inline; width:94%;" class="form-control"  type="text"  dataType="Chinese"  id="nameID" />
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">工号:</label>
                    <div class="col-lg-9">
                           <input name="employeeNo" style="display:inline; width:94%;" class="form-control"  type="text"  dataType="Number"  id="employeeNoID" />
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">上月调休余额:</label>
                    <div class="col-lg-9">
                           <input name="lastMounthRest" style="display:inline; width:94%;" class="form-control"  type="text" value="0"  id="lastMounthRestID" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">本月调休余额:</label>
                    <div class="col-lg-9">
                           <input name="thisMounthRest" style="display:inline; width:94%;" class="form-control"  type="text" value="0" id="thisMounthRestID" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">入职日期:</label>
                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="entryDate" id="entryDateID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">本月可享年假:</label>
                    <div class="col-lg-9">
                           <input name="annualVacation" style="display:inline; width:94%;" class="form-control"  type="text" value="0" id="annualVacationID" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">本月年假剩余:</label>
                    <div class="col-lg-9">
                           <input name="annualVacationBalance" style="display:inline; width:94%;" class="form-control"  type="text" value="0" id="annualVacationBalanceID" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">本月可享病假:</label>
                    <div class="col-lg-9">
                           <input name="sickLeave" style="display:inline; width:94%;" class="form-control"  type="text" value="3" id="sickLeaveID" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">本月病假剩余:</label>
                    <div class="col-lg-9">
                           <input name="sickLeaveBalance" style="display:inline; width:94%;" class="form-control"  type="text"  id="sickLeaveBalanceID" value="3" dataType="Number"/>
                           <span class="required">*</span> 
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
                                                                            </script>
</body>
</html>