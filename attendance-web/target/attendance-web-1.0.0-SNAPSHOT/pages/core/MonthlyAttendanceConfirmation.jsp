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
			$.ajax({
				url: 'MonthlyAttendanceConfirmation/attendanceDatebaseGet.koala',
				type: 'POST',
				dataType: 'json',
				data: {date:$("#attendanceDate").val(),type:$("#attendanceType option:selected").val(),Page:page,Pagesize:$("#pagesize option:selected").val()},
			})
			.done(function(msg) {
			debugger;
				var obj = eval('('+msg["result"].replace(/[\r\n]/g,"")+')');
				$("#titleMonth").text($("#attendanceDate").val());
				$(".appended").remove();
				for(var i=0;i<obj['data'].length;i++)
				{
					for(var tag in obj['data'][i]){
					
						if(obj['data'][i][tag]=="null")
						{
							obj['data'][i][tag]="";
						}
					
					}
					$("#attendanceMainTable").append("<tr class='appended'><td>"+obj["data"][i]["name"]+"/"+obj["data"][i]["employeeNo"]+"</td><td>"+obj["data"][i]["stakeclass_d"]+"</td><td>"+obj["data"][i]["atakeclass_d"]+"</td><td>"+obj["data"][i]["mealAllowanced_d"]+"</td><td>"+obj["data"][i]["stakeclass_n"]+"</td><td>"+obj["data"][i]["atakeclass_n"]+"</td><td>"+obj["data"][i]["mealAllowanced_n"]+"</td><td>"+obj["data"][i]["stakeclass_nor"]+"</td><td>"+obj["data"][i]["atakeclass_nor"]+"</td><td>"+obj["data"][i]["mealAllowanced_nor"]+"</td><td>"+obj["data"][i]["travelAllowance"]+"</td><td>"+obj["data"][i]["installationAllowance"]+"</td><td>"+obj["data"][i]["overtime_work"]+"</td><td>"+obj["data"][i]["overtime_week"]+"</td><td>"+obj["data"][i]["overtime_holiday"]+"</td><td>"+obj["data"][i]["overtime_Rest"]+"</td><td>"+obj["data"][i]["rest_personal"]+"</td><td>"+obj["data"][i]["rest_sickness"]+"</td><td>"+obj["data"][i]["rest_marry"]+"</td><td>"+obj["data"][i]["rest_maternity"]+"</td><td>"+obj["data"][i]["rest_funeral"]+"</td><td>"+obj["data"][i]["rest_plan_maternity"]+"</td><td>"+obj["data"][i]["rest_bruise"]+"</td><td>"+obj["data"][i]["rest_rest"]+"</td><td>"+obj["data"][i]["rest_annual"]+"</td><td>"+obj["data"][i]["notakeclass"]+"</td><td>"+obj["data"][i]["late"]+"</td><td>"+obj["data"][i]["leave_early"]+"</td><td>"+obj["data"][i]["nocredit_card"]+"</td><td>"+obj["data"][i]["lastMounthRest"]+"</td><td>"+obj["data"][i]["thisMounthRest"]+"</td><td>"+obj["data"][i]["entryDate"]+"</td><td>"+obj["data"][i]["annualVacation"]+"</td><td>"+obj["data"][i]["annualVacationBalance"]+"</td><td>"+obj["data"][i]["sickLeave"]+"</td><td>"+obj["data"][i]["sickLeaveBalance"]+"</td><td>"+obj["data"][i]["is_full_hours"]+"</td></tr>");
				}
				var totalpage=obj["totalpage"];
				if(!obj["totalpage"])
				{
					totalpage=1;
				}
				$(".pagination").pagy({
					totalPages: totalpage,
					currentPage: page,
					page: function(page) {
						openTab(url+"?page="+page+"&date="+$("#attendanceDate").val()+"&pagesize="+$("#pagesize option:selected").val(),"月度考勤数据确认单","menuMark22");
					}
			    });
				
			})
			.fail(function() {
				alert("查询出错");
			});
		}
	}
</script>
<script language=javascript>
function doPrint(){ 
	bdhtml=window.document.body.innerHTML; 
	sprnstr="<!--startprint-->"; 
	eprnstr="<!--endprint-->"; 
	prnhtml=bdhtml.substr(bdhtml.indexOf(sprnstr)+17); 
	prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr)); 
	window.document.body.innerHTML=prnhtml; 
	window.print(); 
}
function exclecreat(tableid){
	try{
   		window.clipboardData.setData("Text",document.all(tableid).outerHTML);
   		try
		{
			var ExApp = new ActiveXObject("Excel.Application")
			var ExWBk = ExApp.workbooks.add()
			var ExWSh = ExWBk.worksheets(1)
			ExApp.DisplayAlerts = false
			ExApp.visible = true
		}  
		catch(e)
		{
			alert("请打开Excle表格将内容通过'ctrl+v'粘贴进去");
			return false
		} 
   	}
   	catch(e)
   	{
   		alert("您的浏览器不兼容该方法,请手动复制");
   	}
	ExWBk.worksheets(1).Paste;	 
}
$(function() {
	var page="<%=request.getParameter("page")%>";
	var date="<%=request.getParameter("date")%>";
	var pagesize="<%=request.getParameter("pagesize")%>";
	if(page!="null")
	{
		$("#pagesize").val(pagesize);
		$("#attendanceDate").val(date);
		attendanceDatebaseGet();
	}
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
							<input class="btn btn-info" type="button" value="打印" onClick="doPrint()">
							<input class="btn btn-info" type="button" value="导出Excle" onClick="exclecreat('attendanceMainTable')">
							<div style="float:right;">
							<label for="attendanceDate">日期：</label>
							<input id="attendanceDate" style="line-height: 16px;" type="month">
							<select id="attendanceType" class="select">
								<option value="1">常白班</option>
								<option value="11">轮班A</option>
								<option value="12">轮班B</option>
								<option value="13">轮班C</option>
								<option value="14">轮班D</option>
								<option value="8">白班</option>
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
								<!--startprint-->
									<table id="attendanceMainTable" class="table table-responsive table-bordered table-hover table-striped" style="width:1526px;text-align: center;">
										<tbody>
											<tr>
												<td width="86" style="vertical-align: middle;"></td>
												<td colspan="3" width="90" style="vertical-align: middle;">白班(D)</td>
												<td colspan="3" width="90" style="vertical-align: middle;">夜班(D)</td>
												<td colspan="3" width="90" style="vertical-align: middle;">常白班(D)</td>
												<td rowspan="2" width="30" style="vertical-align: middle;">交补</td>
												<td rowspan="2" width="30" style="vertical-align: middle;">出差补助</td>
												<td colspan="3" width="121" style="border-left-style: none;vertical-align: middle;">加班-计费（h）</td>
												<td rowspan="2" width="35" style="vertical-align: middle;">加班调休（h）</td>
												<td colspan="9" width="302" style="border-left-style: none;vertical-align: middle;">本月请假情况（h）</td>
												<td colspan="4" width="130" style="border-left-style: none;vertical-align: middle;">异常</td>
												<td rowspan="2" width="45" style="vertical-align: middle;">上月调休余额（h）</td>
												<td rowspan="2" width="47" style="vertical-align: middle;">本月剩余调休时间（h）</td>
												<td rowspan="2" width="84" style="vertical-align: middle;">入职后满一年</td>
												<td rowspan="2" width="35" style="vertical-align: middle;">上月年假余额</td>
												<td rowspan="2" width="35" style="vertical-align: middle;">本月剩余年假</td>
												<td rowspan="2" width="36" style="vertical-align: middle;">上月剩余全薪病假（D）</td>
												<td rowspan="2" width="43" style="vertical-align: middle;">本月剩余全薪病假（D）</td>
												<td rowspan="2" width="36" style="vertical-align: middle;">是否满勤</td>
											</tr>
											<tr>
												<td width="55" style="border-top-style: none; border-left-style: none;vertical-align: middle;">姓名/工号</td>
												<td width="35" style="border-top-style: none; border-left-style: none;vertical-align: middle;">应出勤</td>
												<td width="35" style="border-top-style: none; border-left-style: none;vertical-align: middle;">实出勤</td>
												<td width="31" style="border-top-style: none; border-left-style: none;vertical-align: middle;">餐补</td>
												<td width="36" style="border-top-style: none; border-left-style: none;vertical-align: middle;">应出勤</td>
												<td width="35" style="border-top-style: none; border-left-style: none;vertical-align: middle;">实出勤</td>
												<td width="31" style="border-top-style: none; border-left-style: none;vertical-align: middle;">餐补</td>
												<td width="33" style="border-top-style: none; border-left-style: none;vertical-align: middle;">应出勤</td>
												<td width="29" style="border-top-style: none; border-left-style: none;vertical-align: middle;">实出勤</td>
												<td width="29" style="border-top-style: none; border-left-style: none;vertical-align: middle;">餐补</td>
												<td width="39" style="border-top-style: none; border-left-style: none;vertical-align: middle;">平时</td>
												<td width="43" style="border-top-style: none; border-left-style: none;vertical-align: middle;">周末</td>
												<td width="40" style="border-top-style: none; border-left-style: none;vertical-align: middle;">节假日</td>
												<td width="40" style="border-top-style: none; border-left-style: none;vertical-align: middle;">事假(h)</td>
												<td width="36" style="border-top-style: none; border-left-style: none;vertical-align: middle;">病假</td>
												<td width="29" style="border-top-style: none; border-left-style: none;vertical-align: middle;">婚假</td>
												<td width="33" style="border-top-style: none; border-left-style: none;vertical-align: middle;">产假</td>
												<td width="28" style="border-top-style: none; border-left-style: none;vertical-align: middle;">丧假</td>
												<td width="29" style="border-top-style: none; border-left-style: none;vertical-align: middle;">计生假</td>
												<td width="27" style="border-top-style: none; border-left-style: none;vertical-align: middle;">工伤假</td>
												<td width="40" style="border-top-style: none; border-left-style: none;vertical-align: middle;">调休(h)</td>
												<td width="33" style="border-top-style: none; border-left-style: none;vertical-align: middle;">年假</td>
												<td width="36" style="border-top-style: none; border-left-style: none;vertical-align: middle;">入职/离职缺勤数</td>
												<td width="27" style="border-top-style: none; border-left-style: none;vertical-align: middle;">迟到</td>
												<td width="27" style="border-top-style: none; border-left-style: none;vertical-align: middle;">早退</td>
												<td width="27" style="border-top-style: none; border-left-style: none;vertical-align: middle;">未刷卡</td>
											</tr>
										</tbody>
									</table>
								<!--endprint-->
								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div style="float: left;margin-top: 45px;">
		每页显示：
		<select id="pagesize" onchange="attendanceDatebaseGet()">
			<option value="10">10</option>
			<option value="30">30</option>
			<option value="50">50</option>
			<option value="100">100</option>
		</select>
		页
	</div>
	<div class="pagination" style="float: right;">
		<ul class="pagination">
		</ul>
	</div>
</body>
</html>