<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">attendenceTime:</label>
                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="attendenceTime" id="attendenceTimeID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">headcount:</label>
                    <div class="col-lg-9">
                           <input name="headcount" style="display:inline; width:94%;" class="form-control"  type="text"  id="headcountID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">normalInClock:</label>
                    <div class="col-lg-9">
                           <input name="normalInClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="normalInClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">lateClock:</label>
                    <div class="col-lg-9">
                           <input name="lateClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="lateClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">normalOutClock:</label>
                    <div class="col-lg-9">
                           <input name="normalOutClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="normalOutClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">earlyClock:</label>
                    <div class="col-lg-9">
                           <input name="earlyClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="earlyClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">noNeedInClock:</label>
                    <div class="col-lg-9">
                           <input name="noNeedInClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="noNeedInClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">noNeedOutClock:</label>
                    <div class="col-lg-9">
                           <input name="noNeedOutClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="noNeedOutClockID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">erroClock:</label>
                    <div class="col-lg-9">
                           <input name="erroClock" style="display:inline; width:94%;" class="form-control"  type="text"  id="erroClockID" />
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
                                                                            </script>
</body>
</html>