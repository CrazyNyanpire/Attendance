<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/pages/common/header.jsp"%><!--引入权限系统该页面需无须引用header.jsp -->
<%@ page import="java.util.Date"%>
<% String formId = "form_" + new Date().getTime();
   String gridId = "grid_" + new Date().getTime();
   String path = request.getContextPath()+request.getServletPath().substring(0,request.getServletPath().lastIndexOf("/")+1);
%>
<script type="text/javascript">
var grid;
var form;
var _dialog;
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	   //
	    initSearchPanel:function(){
	        	            	                	            	                	                     var contents = [{title:'请选择', value: ''}];
	                     	                     contents.push({title:'满勤' , value:'满勤'});
	                     	                     contents.push({title:'缺勤' , value:'缺勤'});
	                     	                     form.find('#is_full_hours_SELECT').select({
	                                            title: '请选择',
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#is_full_hoursID_').val($(this).getValue());
	                                       });
	                	            	     var contents = [{title:'请选择', value: ''}];
						     contents.push({title:'常白班' , value:'1'});
	                     	                     contents.push({title:'轮班A' , value:'11'});
	                     	                     contents.push({title:'轮班B' , value:'12'});
                                                     contents.push({title:'轮班C' , value:'13'});
						     contents.push({title:'轮班D' , value:'14'});
	                     	                     form.find('#attendancetype_SELECT').select({
	                                            title: '请选择',
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#attendancetypeID_').val($(this).getValue());
	                                       });
	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 40;
	         return grid.grid({
	                identity:"id",
	                buttons: [
	                        {content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
	                        {content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
	                    ],
	                url:"${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/pageJson.koala",
	                columns: [
	                     	 { title: '姓名', name: 'name', width: 60},

	                         { title: '工号', name: 'employeeNo', width: width},

	                         { title: '应出勤（白班）', name: 'stakeclass_d', width: width},

	                         { title: '实出勤（白班）', name: 'atakeclass_d', width: width},

	                         { title: '餐补（白班）', name: 'mealAllowanced_d', width: width},

	                         { title: '应出勤（夜班）', name: 'stakeclass_n', width: width},

	                         { title: '实出勤（夜班）', name: 'atakeclass_n', width: width},

	                         { title: '餐补（夜班）', name: 'mealAllowanced_n', width: width},

	                         { title: '应出勤（常白班）', name: 'stakeclass_nor', width: width},

	                         { title: '实出勤（常白班）', name: 'atakeclass_nor', width: width},

	                         { title: '餐补（常白班）', name: 'mealAllowanced_nor', width: width},

	                         { title: '交补', name: 'travelAllowance', width: width},
				
				 { title: '出差补助', name: 'installationAllowance', width: width},

	                         { title: '平时-加班', name: 'overtime_work', width: width},

	                         { title: '周末-加班', name: 'overtime_week', width: width},

	                         { title: '节假日-加班', name: 'overtime_holiday', width: width},

	                         { title: '加班调休', name: 'overtime_Rest', width: width},

	                         { title: '事假', name: 'rest_personal', width: width},

	                         { title: '病假', name: 'rest_sickness', width: width},

	                         { title: '婚假', name: 'rest_marry', width: width},

	                         { title: '产假', name: 'rest_maternity', width: width},

	                         { title: '丧假', name: 'rest_funeral', width: width},

	                         { title: '计生假', name: 'rest_plan_maternity', width: width},

	                         { title: '工伤假', name: 'rest_bruise', width: width},

	                         { title: '调休-请假', name: 'rest_rest', width: width},

	                         { title: '年假', name: 'rest_annual', width: width},

	                         { title: '未出勤', name: 'notakeclass', width: width},

	                         { title: '迟到', name: 'late', width: width},

	                         { title: '早退', name: 'leave_early', width: width},

	                         { title: '未刷卡', name: 'nocredit_card', width: width},

	                         { title: '上月调休余额', name: 'lastMounthRest', width: width},

	                         { title: '本月调休余额', name: 'thisMounthRest', width: width},

	                         { title: '入职后满一年', name: 'entryDate', width: 110},

	                         { title: '上月年假余额', name: 'annualVacation', width: width},

	                         { title: '本月剩余年假', name: 'annualVacationBalance', width: width},

	                         { title: '上月剩余全薪病假', name: 'sickLeave', width: width},

	                         { title: '本月剩余全薪病假', name: 'sickLeaveBalance', width: width},

	                         { title: '是否满勤', name: 'is_full_hours', width: width}

	                ]
	         }).on({
	                   'add': function(){
	                       self.add($(this));
	                   },
	                   'modify': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                type: 'warning',
	                                content: '请选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                        if(indexs.length > 1){
	                            $this.message({
	                                type: 'warning',
	                                content: '只能选择一条记录进行修改'
	                            })
	                            return;
	                        }
	                       self.modify(indexs[0], $this);
	                    },
	                   'delete': function(event, data){
	                        var indexs = data.data;
	                        var $this = $(this);
	                        if(indexs.length == 0){
	                            $this.message({
	                                   type: 'warning',
	                                   content: '请选择要删除的记录'
	                            });
	                            return;
	                        }
	                        var remove = function(){
	                            self.remove(indexs, $this);
	                        };
	                        $this.confirm({
	                            content: '确定要删除所选记录吗?',
	                            callBack: remove
	                        });
	                   }
	         });
	    },
	    add: function(grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog">'
	        	+'<div class="modal-content"><div class="modal-header"><button type="button" class="close" '
	        	+'data-dismiss="modal" aria-hidden="true">&times;</button>'
	        	+'<h4 class="modal-title">新增</h4></div><div class="modal-body">'
	        	+'<p>One fine body&hellip;</p></div><div class="modal-footer">'
	        	+'<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>'
	        	+'<button type="button" class="btn btn-success" id="save">保存</button></div></div>'
	        	+'</div></div>');
	        $.get('<%=path%>/MonthlyAttendanceConfirmation-add.jsp').done(function(html){
	            dialog.modal({
	                keyboard:false
	            }).on({
	                'hidden.bs.modal': function(){
	                    $(this).remove();
	                }
	            }).find('.modal-body').html(html);
	            self.initPage(dialog.find('form'));
	        });
	        dialog.find('#save').on('click',{grid: grid}, function(e){
	              if(!Validator.Validate(dialog.find('form')[0],3))return;
	              $.post('${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/add.koala', dialog.find('form').serialize()).done(function(result){
	                   if(result.result == 'success'){
	                        dialog.modal('hide');
	                        e.data.grid.data('koala.grid').refresh();
	                        e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                         });
	                    }else{
	                        dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                        });
	                     }
	              });
	        });
	    },
	    modify: function(id, grid){
	        var self = this;
	        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">修改</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-default" data-dismiss="modal">取消</button><button type="button" class="btn btn-success" id="save">保存</button></div></div></div></div>');
	        $.get('<%=path%>/MonthlyAttendanceConfirmation-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/get/' + id + '.koala').done(function(json){
	                       json = json.data;
	                        var elm;
	                        for(var index in json){
	                            elm = dialog.find('#'+ index + 'ID');
	                            if(elm.hasClass('select')){
	                                elm.setValue(json[index]);
	                            }else{
	                                elm.val(json[index]);
	                            }
	                        }
	                });
	                dialog.modal({
	                    keyboard:false
	                }).on({
	                    'hidden.bs.modal': function(){
	                        $(this).remove();
	                    }
	                });
	                dialog.find('#save').on('click',{grid: grid}, function(e){
	                    if(!Validator.Validate(dialog.find('form')[0],3))return;
	                    $.post('${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
	                        if(result.result == 'success'){
	                            dialog.modal('hide');
	                            e.data.grid.data('koala.grid').refresh();
	                            e.data.grid.message({
	                            type: 'success',
	                            content: '保存成功'
	                            });
	                        }else{
	                            dialog.find('.modal-content').message({
	                            type: 'error',
	                            content: result.actionError
	                            });
	                        }
	                    });
	                });
	        });
	    },
	    initPage: function(form){
	              form.find('.form_datetime').datetimepicker({
	                   language: 'zh-CN',
	                   format: "yyyy-mm-dd",
	                   autoclose: true,
	                   todayBtn: true,
	                   minView: 2,
	                   pickerPosition: 'bottom-left'
	               }).datetimepicker('setDate', new Date());//加载日期选择器
	               form.find('.select').each(function(){
	                    var select = $(this);
	                    var idAttr = select.attr('id');
	                    select.select({
	                        title: '请选择',
	                        contents: selectItems[idAttr]
	                    }).on('change', function(){
	                        form.find('#'+ idAttr + '_').val($(this).getValue());
	                    });
	               });
	    },
	    remove: function(ids, grid){
	    	var data = [{ name: 'ids', value: ids.join(',') }];
	    	$.post('${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/delete.koala', data).done(function(result){
	                        if(result.result == 'success'){
	                            grid.data('koala.grid').refresh();
	                            grid.message({
	                                type: 'success',
	                                content: '删除成功'
	                            });
	                        }else{
	                            grid.message({
	                                type: 'error',
	                                content: result.result
	                            });
	                        }
	    	});
	    }
	}
	PageLoader.initSearchPanel();
	PageLoader.initGridPanel();
	form.find('#search').on('click', function(){
            if(!Validator.Validate(document.getElementById("<%=formId%>"),3))return;
            var params = {};
            form.find('input').each(function(){
                var $this = $(this);
                var name = $this.attr('name');
                if(name){
                    params[name] = $this.val();
                }
            });
		var attendancemonth=$("#selyear option:selected").text()+"-"+$("#selmonth option:selected").text();
		params['attendancemonth']=attendancemonth;
            grid.getGrid().search(params);
        });
});

var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/MonthlyAttendanceConfirmation-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/MonthlyAttendanceConfirmation/get/' + id + '.koala').done(function(json){
                       json = json.data;
                        var elm;
                        for(var index in json){
                           dialog.find('#'+ index + 'ID').html(json[index]);
                        }
               });
                dialog.modal({
                    keyboard:false
                }).on({
                    'hidden.bs.modal': function(){
                        $(this).remove();
                    }
                });
        });
}
</script>
<style>
table .table th{
text-align: center;
}
</style>
</head>
<body>
<div style="width:98%;margin-right:auto; margin-left:auto; padding-top: 15px;">
<!-- search form -->
<form name=<%=formId%> id=<%=formId%> target="_self" class="form-horizontal">
<input type="hidden" name="page" value="0">
<input type="hidden" name="pagesize" value="10">
<table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td>
    	<div class="form-group">
          <label class="control-label" style="width:50px;float:left;">工号:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
            	<input name="employeeNo" class="form-control" type="text" style="width:180px;" id="employeeNoID"  dataType="Number" require="false" />
            </div>
          <label class="control-label" style="width:90px;float:left;">满勤状况:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
		      <div class="btn-group select" id="is_full_hours_SELECT"></div>
		      <input type="hidden" id="is_full_hoursID_" name="is_full_hours" />
		  </div>
		  		  <label class="control-label" style="width:60px;float:left;">日期:&nbsp;</label>
		  	<div style="margin-left:15px;float:left;">
				<select style="margin-top: 5px;" name="year" id="selyear">
					<option value="2014">2014</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
				</select>
				<select name="month" id="selmonth">
					<option value="01">01</option>
					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
			</div>
	  	  <label class="control-label" style="width:80px;float:left;">考勤类型:&nbsp;</label>
    	  	<div style="margin-left:15px;float:left;">
		      <div class="btn-group select" id="attendancetype_SELECT"></div>
		        <input type="hidden" id="attendancetypeID_" name="attendancetype" />
		      </div>
          </div>
       </td>
       <td style="vertical-align: bottom;"><button id="search" type="button" style="position:relative; margin-left:35px; top: -15px" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button></td>
  </tr>
</table>	
</form>
<!-- grid -->
<div id=<%=gridId%>></div>
</div>
</body>
</html>
