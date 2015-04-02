<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="modal fade"  id="myModal" >
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header ">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h1 class="modal-title "><strong>添加</strong></h1>
      </div>
      <div class="modal-body">
      		<form class="form-horizontal"    method="post" id="save" action="<%=basePath%>my/tborder/save.html">
			<h2 style="margin-left:250px;" ></h2>
			<div class="form-group" >
				<label for="inNumdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inNumdiv">
					<input type="text" class="form-control" id="inNum" name="inNum" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="userIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="userIddiv">
					<input type="text" class="form-control" id="userId" name="userId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inPaymentdiv" class="col-sm-2 control-label" >
					<strong>0--支付宝  1--货到付款：</strong>
				</label>
				<div class="input-group col-sm-6" id="inPaymentdiv">
					<input type="text" class="form-control" id="inPayment" name="inPayment" placeholder="0--支付宝  1--货到付款"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inReceiptIddiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inReceiptIddiv">
					<input type="text" class="form-control" id="inReceiptId" name="inReceiptId" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="addressdiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="addressdiv">
					<input type="text" class="form-control" id="address" name="address" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inCommitTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inCommitTimediv">
					<input type="text" class="form-control" id="inCommitTime" name="inCommitTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inStatediv" class="col-sm-2 control-label" >
					<strong>0--待付款 1--待发货 2--配送中 3--待评价 4--交易完成 5--退款中 6--交易关闭：</strong>
				</label>
				<div class="input-group col-sm-6" id="inStatediv">
					<input type="text" class="form-control" id="inState" name="inState" placeholder="0--待付款 1--待发货 2--配送中 3--待评价 4--交易完成 5--退款中 6--交易关闭"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inSendTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inSendTimediv">
					<input type="text" class="form-control" id="inSendTime" name="inSendTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inReceiptTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inReceiptTimediv">
					<input type="text" class="form-control" id="inReceiptTime" name="inReceiptTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inRefundTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inRefundTimediv">
					<input type="text" class="form-control" id="inRefundTime" name="inRefundTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inRefundFinishTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inRefundFinishTimediv">
					<input type="text" class="form-control" id="inRefundFinishTime" name="inRefundFinishTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inRefundMoneydiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inRefundMoneydiv">
					<input type="text" class="form-control" id="inRefundMoney" name="inRefundMoney" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inCarriagediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inCarriagediv">
					<input type="text" class="form-control" id="inCarriage" name="inCarriage" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inInvoiceTypediv" class="col-sm-2 control-label" >
					<strong>0--不要发票 1--个人 2--公司：</strong>
				</label>
				<div class="input-group col-sm-6" id="inInvoiceTypediv">
					<input type="text" class="form-control" id="inInvoiceType" name="inInvoiceType" placeholder="0--不要发票 1--个人 2--公司"     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inInvoiceCompanydiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inInvoiceCompanydiv">
					<input type="text" class="form-control" id="inInvoiceCompany" name="inInvoiceCompany" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inCancelTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inCancelTimediv">
					<input type="text" class="form-control" id="inCancelTime" name="inCancelTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inPrivilegeMoneydiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inPrivilegeMoneydiv">
					<input type="text" class="form-control" id="inPrivilegeMoney" name="inPrivilegeMoney" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inOriginalMoneydiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inOriginalMoneydiv">
					<input type="text" class="form-control" id="inOriginalMoney" name="inOriginalMoney" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inNowMoneydiv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inNowMoneydiv">
					<input type="text" class="form-control" id="inNowMoney" name="inNowMoney" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inZfTimediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inZfTimediv">
					<input type="text" class="form-control" id="inZfTime" name="inZfTime" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inNamediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inNamediv">
					<input type="text" class="form-control" id="inName" name="inName" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			<div class="form-group" >
				<label for="inReceiptPhonediv" class="col-sm-2 control-label" >
					<strong>：</strong>
				</label>
				<div class="input-group col-sm-6" id="inReceiptPhonediv">
					<input type="text" class="form-control" id="inReceiptPhone" name="inReceiptPhone" placeholder=""     required   onkeydown="if(event.keyCode==32) return false"    >
				</div> 
			</div>
			</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger btn-xl" data-dismiss="modal">
  			<span class="glyphicon glyphicon-remove"></span> 取消
   		</button>
        <button type="button" class="btn btn-primary btn-xl" onclick="add();">
  			<span class="glyphicon glyphicon-saved"></span> 添加
   		</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->