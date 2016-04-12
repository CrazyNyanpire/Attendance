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
                        <input type="datetime-local" class="form-control" style="display:inline; width:94%;" name="attDate" id="attenceTimeID" dataType="Require">
                        <span class="required">*</span>
                     </div>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤状态:</label>
                    <div class="col-lg-9">
                    <div class="btn-group select" id="attenceTypeID"></div>
                           <input name="attenceType" type="hidden"  id="attenceTypeID_" dataType="Require"/>
                           <span class="required">*</span>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">工号:</label>
                    <div class="col-lg-9">
                           <input name="employeeNo" style="display:inline; width:94%;" class="form-control"  type="text"  id="employeeNoID" dataType="Require"/>
                           <span class="required">*</span>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">姓名:</label>
                    <div class="col-lg-9">
                           <input name="empolyeeName" style="display:inline; width:94%;" class="form-control"  type="text"  id="empolyeeNameID" dataType="Require"/>
                           <span class="required">*</span>
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
    var contents = [{title:'请选择', value: ''}];
	$.ajax({
		async:false,
		url: '/AttenceRecordDetail/getAttendanceType.koala',
		type: 'GET',
		dataType: 'json',
	})
	.done(function(msg) {
		for (a in msg)
		{
			contents.push({title:msg[a] , value: a});
		}
		selectItems['attenceTypeID'] = contents;
	});
</script>
</body>
</html>