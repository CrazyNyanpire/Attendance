<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/pages/common/header.jsp"%>
	<!--引入权限系统该页面需无须引用header.jsp -->
	<%@ page import="java.util.Date"%>
	<script src="/js/bootstrap-pagy.js"></script>
	<style>
	.table td{
		vertical-align: middle;
	}
	</style>
</head>
<script>
	function attendanceDatebaseCreat()
	{
		$.ajax({
			url: 'MonthlyAttendanceConfirmation/attendanceDatebaseCreat.koala',
			type: 'POST',
			dataType: 'json',
			data: {value: ''},
		})
		.done(function(msg) {
			if(msg["result"]=="successed")
			alert("月度考勤确认单生成完毕");
			else
			alert("月度考勤确认单生成失败");
		})
		.fail(function() {
			alert("月度考勤确认单生成失败");
		})
	}
	function attendanceDatebaseGet()
	{
		var page="<%=request.getParameter("page")%>";
		if(page=="null")
				{
					page=1;
				}
		var url="/pages/core/MonthlyAttendanceConfirmation.jsp";
		if($("#attendanceDate").val()=="")
		{
			alert("请选择日期");
			return false;
		}
		else{
			var src="<%=request.getContextPath()%>birtReportView/frameset?__report=new_report.rptdesign&date="+$("#attendanceDate").val()+"&type="+$("#attendanceType option:selected").val();
			iframsrcchange(src);
		}
	}
	function iframsrcchange(srcc){
		$("#mainifram").attr("src",srcc);
	}
	$(function(){
		$("#mainifram").css("height",document.body.scrollHeight-50);
	});
	</script>
<body>
	<div id="">
		<div class="table-responsive">
			<table class="table table-responsive table-bordered grid">
				<thead>
					<tr>
						<th>
						<div style="height:30px;">
							<input class="btn btn-info" type="button" value="月度考勤数据生成" onclick="attendanceDatebaseCreat()">
							<div style="float:right;">
							<label for="attendanceDate">日期：</label>
							<input id="attendanceDate" style="line-height: 16px;" type="month">
							<select id="attendanceType" class="select" style="height:22px">
								<option value="1">常白班</option>
								<option value="11">轮班A</option>
								<option value="12">轮班B</option>
								<option value="13">轮班C</option>
								<option value="14">轮班D</option>
							</select>
							<input class="btn btn-info" type="button" onclick="attendanceDatebaseGet()" value="查找">
							</div>
						</div>
						<div style="text-align: center;">
							<h3><span id="titleMonth"></span>月度考勤确认单</h3>
						</div>
						<div class="btn-group buttons"></div>
							<div class="search" style="display:none;">
								<div class="btn-group select " data-role="condition"></div>
								<div class="input-group" style="width:180px;">
									<input type="text" class="input-medium form-control" placeholder="Search" data-role="searchValue">
									<div class="input-group-btn">
										<button type="button" class="btn btn-default" data-role="searchBtn">
											<span class="glyphicon glyphicon-search"></span>
										</button>
									</div>
								</div>
							</div>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<div class="colResizePointer"></div>
							<div class="grid-body" style="width: 1053px;">
								<div class="grid-table-head" style="min-width: 1053px; left: 0px;"></div>
								<div class="grid-table-body" style="width: 1053px; height:100%; position: relative;">
									<iframe id='mainifram' style="width:100%" src="" frameborder="0"></iframe>
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>