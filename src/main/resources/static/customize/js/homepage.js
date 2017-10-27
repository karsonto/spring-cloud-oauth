$(document).ready(function() {
	setTimeout(checkmums, 10000);
});


function checkmums(){
	$.post("/checking/mums",function(data) {
		  if(data=="200"){
			  alert(data);
			  $(#mums).removeClass().addClass("callout").addClass("callout-success");
			  $(#mums p).html("This is a health.");
		  }else{
			  $(#mums).removeClass().addClass("callout").addClass("callout-danger");
			  $(#mums p).html("This is a not health.");
		  }
		});
	
}