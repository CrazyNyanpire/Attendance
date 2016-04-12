<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">开始日期:</label>
                    <div class="col-lg-9">
                           <input name="startDay" style="display:inline; width:94%;" class="form-control"  type="date"  id="startDayID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">开始时间:</label>
                    <div class="col-lg-9">
                           <input name="startTime" style="display:inline; width:94%;" class="form-control"  type="time"  id="startTimeID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">结束日期:</label>
                    <div class="col-lg-9">
                           <input name="endDay" style="display:inline; width:94%;" class="form-control"  type="date"  id="endDayID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">结束时间:</label>
                    <div class="col-lg-9">
                           <input name="endTime" style="display:inline; width:94%;" class="form-control"  type="time"  id="endTimeID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">天数:</label>
                    <div class="col-lg-9">
                           <input name="days" style="display:inline; width:94%;" class="form-control"  type="text"  id="daysID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">请假类型:</label>
                    <div class="col-lg-9">
                           <input name="leaveType" style="display:inline; width:94%;" class="form-control"  type="text"  id="leaveTypeID" />
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
</script>
</body>
</html>