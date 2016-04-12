<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤类别:</label>
                    <div class="col-lg-9">
                           <div class="btn-group select" id="scheduleTypeID"></div>
	                       <input type="hidden" id="scheduleTypeID_"  name="scheduleType" dataType="Require"/>
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">组别:</label>
                    <div class="col-lg-9">
                           <div class="btn-group select" id="dutyTypeID"></div>
	                       <input type="hidden" id="dutyTypeID_"  name="dutyType" dataType="Require"/>
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">考勤日期:</label>
                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="scheduleDate" id="scheduleDateID" >
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
            var contents = [{title:'请选择', value: ''}];
        contents.push({title:'夜班' , value:'2'});
        contents.push({title:'白班' , value:'1'});
        contents.push({title:'长白班' , value:'0'});
        selectItems['scheduleTypeID'] = contents;
                var contents = [{title:'请选择', value: ''}];
        contents.push({title:'长白班' , value:'1'});
        contents.push({title:'C班' , value:'13'});
        contents.push({title:'D班' , value:'14'});
        contents.push({title:'A班' , value:'11'});
        contents.push({title:'B班' , value:'12'});
        selectItems['dutyTypeID'] = contents;
                </script>
</body>
</html>