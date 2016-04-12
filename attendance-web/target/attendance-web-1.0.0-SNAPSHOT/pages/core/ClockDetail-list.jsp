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
function test(){
alert("123");
}
function textchange(){
	$.each($("td[index='4']"), function() {
		if($(this).text().length>2||$(this).text()=="迟到")
		{
			return false;
			}
		var type=typechange($(this).text());
		$(this).text(type);
	});
	$.each($("td[index='6']"), function() {
                if($(this).text().length>2||$(this).text()=="早退")
		{
			return false;
			}
		var type=typechange($(this).text());
		$(this).text(type);
	});
}
$(function (){
    grid = $("#<%=gridId%>");
    form = $("#<%=formId%>");
	PageLoader = {
	    initSearchPanel:function(){
	        	            	                	            	                	            	                	                     var startTimeVal = form.find('#attenceTimeID_start');
	                     var startTime = startTimeVal.parent();
	                     var endTimeVal = form.find('#attenceTimeID_end');
	                     var endTime = endTimeVal.parent();
	                     startTime.datetimepicker({
	                                        language: 'zh-CN',
	                                        format: "yyyy-mm-dd",
	                                        autoclose: true,
	                                        todayBtn: true,
	                                        minView: 2,
	                                        pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(){
	                                 endTime.datetimepicker('setStartDate', startTimeVal.val());
	                           });//加载日期选择器
	                     var yesterday = new Date();
	                     yesterday.setDate(yesterday.getDate() - 30);
	                     endTime.datetimepicker({
	                             language: 'zh-CN',
	                             format: "yyyy-mm-dd",
	                             autoclose: true,
	                             todayBtn: true,
	                             minView: 2,
	                             pickerPosition: 'bottom-left'
	                     }).on('changeDate', function(ev){
	                                startTime.datetimepicker('setEndDate', endTimeVal.val());
	                           }).datetimepicker('setDate', new Date()).trigger('changeDate');//加载日期选择器
	                     startTime.datetimepicker('setDate', yesterday).trigger('changeDate');
	                	            	                	                     var contents = [{title:'请选择', value: ''}];
	                     	                     contents.push({title:'夜班' , value:'2'});
	                     	                     contents.push({title:'白班' , value:'1'});
	                     	                     contents.push({title:'常白班',value:'0'});
	                     	                     form.find('#attendenceType_SELECT').select({
	                                            title: '请选择',
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#attendenceTypeID_').val($(this).getValue());
	                                       });
	                	            var contents = [{title:'请选择', value: ''}];
	                     	                     contents.push({title:'上班打卡正常' , value:'3'});
	                     	                     contents.push({title:'未刷卡' , value:'10'});
	                     	                     contents.push({title:'无效刷卡' , value:'7'});
	                     	                     contents.push({title:'迟到' , value:'5'});
	                     	                     contents.push({title:'无上班打卡记录' , value:'8'});
	                     	                     contents.push({title:'非考勤日上班打卡' , value:'11'});
	                     	                     form.find('#attendenceInType_SELECT').select({
	                                            title: '请选择',
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#attendenceInTypeID_').val($(this).getValue());
	                                       });
                                           var contents = [{title:'请选择', value: ''}];
	                     	                     contents.push({title:'未刷卡' , value:'10'});
	                     	                     contents.push({title:'无效刷卡' , value:'7'});
	                     	                     contents.push({title:'早退' , value:'6'});
	                     	                     contents.push({title:'下班打卡正常' , value:'4'});
	                     	                     contents.push({title:'无下班打卡记录' , value:'9'});
	                     	                     contents.push({title:'非考勤日下班打卡' , value:'12'});
	                     	                     form.find('#attendenceOutType_SELECT').select({
	                                            title: '请选择',
	                                            contents: contents
	                                       }).on('change',function(){
	                                           form.find('#attendenceOutTypeID_').val($(this).getValue());
	                                       });
	                	            	        	     },
	    initGridPanel: function(){
	         var self = this;
	         var width = 120;
	         return grid.grid({
	                identity:"id",
	                buttons: [//{content: '<button class="btn btn-primary" type="button"><span class="glyphicon glyphicon-plus"><span>添加</button>', action: 'add'},
	                        {content: '<button class="btn btn-success" type="button"><span class="glyphicon glyphicon-edit"><span>修改</button>', action: 'modify'},
	                        //{content: '<button class="btn btn-danger" type="button"><span class="glyphicon glyphicon-remove"><span>删除</button>', action: 'delete'}
	                    ],
	                url:"${pageContext.request.contextPath}/ClockDetail/pageJson.koala",
	                columns: [
	                     	     { title: '考勤日期', name: 'attenceTime', width: width},
     	                         { title: '工号', name: 'employeeNo', width: width},
     	                         { title: '姓名', name: 'name', width: width},
     	                         { title: '上班打卡时间', name: 'clockIn', width: width},
     	                         { title: '上班出勤状态', name: 'attendenceInType', width: width},
     	                         { title: '下班打卡时间', name: 'clockOut', width: width},
     	                         { title: '下班出勤状态', name: 'attendenceOutType', width: width},
     	                         { title: '考勤状态', name: 'attendenceType', width: width},
	                         	                         	                    
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
	        $.get('<%=path%>/ClockDetail-add.jsp').done(function(html){
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
	              $.post('${pageContext.request.contextPath}/ClockDetail/add.koala', dialog.find('form').serialize()).done(function(result){
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
	        $.get('<%=path%>/ClockDetail-update.jsp').done(function(html){
	               dialog.find('.modal-body').html(html);
	               self.initPage(dialog.find('form'));
	               $.get( '${pageContext.request.contextPath}/ClockDetail/get/' + id + '.koala').done(function(json){
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
	                    $.post('${pageContext.request.contextPath}/ClockDetail/update.koala?id='+id, dialog.find('form').serialize()).done(function(result){
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
	    	$.post('${pageContext.request.contextPath}/ClockDetail/delete.koala', data).done(function(result){
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
                if($this.attr('type')=="checkbox")
                {
                	if($this.attr("checked")=="checked")
                	{
                		params[name] = $this.val();
                	}
                }
                else
                {
                	if(name){
                    	params[name] = $this.val();
                	}
                }
            });
            debugger;
            var attendenceInTypeStr="";
            var attendenceOutTypeStr="";
            if(params['normal']=="1")
            {
            	attendenceInTypeStr+="'3',";
            	attendenceOutTypeStr+="'4',";
            }
            if(params['weishuaka']=="1")
            {
            	attendenceInTypeStr+="'10',";
            	attendenceOutTypeStr+="'10',";
            }
            if(params['chidao']=="1")
            {
            	attendenceInTypeStr+="'5',";
            }
            if(params['zaotui']=="1")
            {
            	attendenceOutTypeStr+="'6',";
            }
            if(params['feikaoqin']=="1")
            {
            	attendenceInTypeStr+="'11','21','23',";
            	attendenceOutTypeStr+="'12','12','14',";
            }
            if(params['shangbanwu']=="1")
            {
            	attendenceInTypeStr+="'8',";
            }
            if(params['xiabanwu']=="1")
            {
            	attendenceOutTypeStr+="'9',";
            }
            if(params['wuxiao']=="1")
            {
            	attendenceInTypeStr+="'7',";
            	attendenceOutTypeStr+="'7',";
            }
            params['attendenceInType']=attendenceInTypeStr.substring(0,attendenceInTypeStr.length-1);
            params['attendenceOutType']=attendenceOutTypeStr.substring(0,attendenceOutTypeStr.length-1);
            grid.getGrid().search(params);
        });
});

var openDetailsPage = function(id){
        var dialog = $('<div class="modal fade"><div class="modal-dialog"><div class="modal-content"><div class="modal-header"><button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button><h4 class="modal-title">查看</h4></div><div class="modal-body"><p>One fine body&hellip;</p></div><div class="modal-footer"><button type="button" class="btn btn-info" data-dismiss="modal">返回</button></div></div></div></div>');
        $.get('<%=path%>/ClockDetail-view.jsp').done(function(html){
               dialog.find('.modal-body').html(html);
               $.get( '${pageContext.request.contextPath}/ClockDetail/get/' + id + '.koala').done(function(json){
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
        <label class="control-label" style="width:75px;float:left;">出勤状态:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
		      <span>正常</span><input type="checkbox" id="type_normal" name="normal" value="1">
		      <span>未刷卡</span><input type="checkbox" id="type_weishuaka" name="weishuaka" value="1">
		      <span>迟到</span><input type="checkbox" id="type_chidao" name="chidao" value="1">
		      <span>早退</span><input type="checkbox" id="type_zaotui" name="zaotui" value="1">
		      <span>非考勤日打卡</span><input type="checkbox" id="type_feikaoqin" name="feikaoqin" value="1">
		      <span>无上班打卡记录</span><input type="checkbox" id="type_shangbanwu" name="shangbanwu" value="1">
		      <span>无下班打卡记录</span><input type="checkbox" id="type_xiabanwu" name="xiabanwu" value="1">
		      <span>无效刷卡</span><input type="checkbox" id="type_wuxiao" name="wuxiao" value="1">
	      </div>
        <label class="control-label" style="width:100px;float:left;">考勤状态:&nbsp;</label>
    	  <div style="margin-left:15px;float:left;">
	      	<div class="btn-group select" id="attendenceType_SELECT"></div>
	        <input type="hidden" id="attendenceTypeID_" name="attendenceType" />
	      </div>
	    </div>
      <div class="form-group">
          <label class="control-label" style="width:50px;float:left;">工号:&nbsp;</label>
            <div style="margin-left:15px;float:left;">
             <input name="employeeNo" class="form-control" type="text" style="width:180px;" id="employeeNoID"  />
            </div>
          <label class="control-label" style="width:100px;float:left;">考勤日期:&nbsp;</label>
           <div style="margin-left:15px;float:left;">
              <div class="input-group date form_datetime" style="width:160px;float:left;" >
                  <input type="text" class="form-control" style="width:160px;" name="attenceTime" id="attenceTimeID_start" >
                  <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
              </div>
              <div style="float:left; width:10px; margin-left:auto; margin-right:auto;">&nbsp;-&nbsp;</div>
              <div class="input-group date form_datetime" style="width:160px;float:left;" >
                  <input type="text" class="form-control" style="width:160px;" name="attenceTimeEnd" id="attenceTimeID_end" >
                  <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
              </div>
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