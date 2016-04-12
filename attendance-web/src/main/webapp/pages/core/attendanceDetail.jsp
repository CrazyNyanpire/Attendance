<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
	<title>文件明细信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="/pages/common/header.jsp"%>
	<script src="/js/bootstrap-pagy.js"></script>
</head>
<body>
	<script>
		var page="<%=request.getParameter("page")%>";
		$(document).ready(function() {
			var filename="<%=request.getParameter("fileName")%>";
			var filetime="<%=request.getParameter("importTime")%>";
			var id="<%=request.getParameter("ID")%>";
			if(page=="null")
				{
					page=1;
				}
			$("#filename").text(filename);
			$.ajax({
				url: 'AttenceRecordFile/attendanceDetailAjax.koala',
				type: 'POST',
				data: {ID:id,Page:page,Pagesize:30},
			})
			.done(function(msg) {
				//alert(msg["result"]);
				debugger;
				var obj=eval('('+msg["result"].replace(/[\r\n]/g,"")+')');
				for(var i=0;i<obj["data"].length;i++)
				{
					$("#table").append("<tr><td>"+obj["data"][i]["employeeNo"]+"</td><td>"+obj["data"][i]["empolyeeName"]+"</td><td>"+obj["data"][i]["attenceTime"]+"</td><td>"+obj["data"][i]["attenceType"]+"</td></tr>");
				}
				var totalpage=obj["totalpage"];
				var url="/pages/core/attendanceDetail.jsp?fileName=" + filename + "&importTime="+filetime+"&ID="+id;
				$(".pagination").pagy({
					totalPages: totalpage,
					currentPage: page,
					page: function(page) {
						openTab(url+"&page="+page,"考勤数据明细","mku231");
					}
			    });
			})
			.fail(function() {
				alert("error");
			})		
		});
	</script>
	<div class="col-md-12">
		<div style="font-size:larger;">
			<label for="">导入时间：<span id="filename"></span></label>
		</div>
		<div class="grid-body" style="width: 1053px;">
			<div class="grid-table-head" style="min-width: 1054px; width: 1054px;">
				<table class="table table-bordered">
				<tbody>
				<tr>
					<th>员工编号</th>
					<th>员工姓名</th>
					<th>打卡时间</th>
					<th>类型</th>
				</tr>
				</tbody>
				</table>
			</div>
			<div class="grid-table-body" style="width: 1053px; height: 331.258064516129px; position: relative;">
				<table class="table table-responsive table-bordered table-hover table-striped" id="table">
				</table>
			</div>
			<div class="pagination" style="float: right;">
				<ul class="pagination">
				</ul>
			</div>
		</div>
	</div>
</body>
</html>