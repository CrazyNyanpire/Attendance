<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form class="form-horizontal">
	           <div class="form-group">
                    <label class="col-lg-3 control-label">文件名称:</label>
                    <div class="col-lg-9">
                           <input name="fileName" style="display:inline; width:94%;" class="form-control"  type="text" dataType="Require" id="fileNameID" />
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">导入时间:</label>
                 <div class="col-lg-9">
                    <div class="input-group date form_datetime" style="width:160px;float:left;" >
                        <input type="text" class="form-control" style="width:160px;" name="importTime" id="importTimeID" dataType="Require">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                     </div>
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">总记录数:</label>
                    <div class="col-lg-9">
                           <input name="record" style="display:inline; width:94%;" class="form-control"  type="text" dataType="Require" id="recordID" />
<span class="required">*</span>    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">实际导入记录数:</label>
                    <div class="col-lg-9">
                           <input name="recordSuccess" style="display:inline; width:94%;" class="form-control"  type="text"  id="recordSuccessID" />
    </div>
</div>
	           <div class="form-group">
                    <label class="col-lg-3 control-label">文件路径:</label>
                    <div class="col-lg-9">
                           <input name="path" style="display:inline; width:94%;" class="form-control"  type="text"  id="pathID" />
    </div>
</div>
</form>
<script type="text/javascript">
    var selectItems = {};
                                            </script>
</body>
</html>