/**
 * 
 */
 
 function getEmployeeDetails(){
	var req = new XMLHttpRequest();
	var eid = request.getParameter("eid").value;
		req.open("GET","http://localhost:8022/MyWebApplication/EmployeeController?eid="+eid,true);
		  req.onreadystatechange = function() {
			if(req.readyState == 4 && req.status == 200) { 
		           var result = req.responseText;
		     		var arr = result.split(" ");
		     		document.getElementById("eid") = arr[0];
		     		document.getElementById("ename") = arr[1];    
		     		document.getElementById("esalary") = arr[2];
		     		document.getElementById("dno")= arr[3]; 
		     }
			

		    };
		    req.send();
}