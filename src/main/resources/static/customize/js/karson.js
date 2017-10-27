//userlist delete user
function deleteuser(a){
    	if (confirm("Are you sure to delete ?") == true) {
    		location.href='/user/delete/'+a;
    	}
    }
 
  //userlist dataTables 分页
  $(function () {
    $('#dataTables').DataTable({
      'paging'      : true,
      'lengthChange': true,
      'searching'   : true,
      'ordering'    : true,
      'info'        : true,
      'autoWidth'   : false
    })
  })
  //rolelist delete role
  function deleterole(a){
    	if (confirm("Are you sure to delete ?") == true) {
    		location.href='/role/delete/'+a;
    	}
    }
  function deletesignuprole(a){
  	if (confirm("Are you sure to delete ?") == true) {
  		location.href='/signuprule/delete/'+a;
  	}
  }
   
  function goBack() {
      window.history.back();
  }
 
  
  
	