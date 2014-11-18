$('.form_date').datetimepicker({
        language:  'zh-CN',
        format: 'yyyy-MM-dd',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		endDate:new Date(),
		forceParse: 0
    });
    $('#start').datetimepicker().on('changeDate', function(ev){
    	$('#end').datetimepicker('setStartDate',$('#start-value').val());
	});
	 $('#end').datetimepicker().on('changeDate', function(ev){
    	$('#start').datetimepicker('setEndDate',$('#end-value').val());
	});