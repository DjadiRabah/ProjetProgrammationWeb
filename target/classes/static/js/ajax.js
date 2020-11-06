function getPojoById(table, id, callBack)
{
	var request = new XMLHttpRequest();
	request.open('GET', table + "?id="+id);
	
	request.onload = function() {
		if(request.status === 200)
		{
			var json = request.responseText;
			if (json === "")
				callBack(null);
			else
				callBack(JSON.parse(json));
		}
		else
		{
			console.log("fail " + request.status);
		}
	};
	request.send();
}

function getPojos(table, callBack)
{
	var request = new XMLHttpRequest();
	request.open('GET', table.toLowerCase() + "s");
	
	request.onload = function() {
		if(request.status === 200)
		{
			var json = request.responseText;
			if (json === "")
				callBack(null);
			else
				callBack(JSON.parse(json));
		}
		else
		{
			console.log("fail " + request.status);
		}
	};
	request.send();
}
function insertPojo(table, jsonObject)
{
	var json = JSON.stringify(jsonObject);
	var url = 
	$.ajax({
        type: "GET",                     
        url:'/insert' + table,  
        data: {json : json},       
        dataType: "json",
        contentType: "application/json",
        success : function(data){
         },
         error : function(data) {
        	 window.location.href = data["responseText"];
         },
         done : function(data)
         {
        	 console.log("DONE");
         }
  });
}

function updatePojo(table, jsonObject)
{
	var json = JSON.stringify(jsonObject);
	var url = 
	$.ajax({
        type: "GET",                     
        url:'/update' + table,  
        data: {json : json},       
        dataType: "json",
        contentType: "application/json",
        success : function(data){
         },
         error : function(data) {
         },
         done : function(data)
         {
         }
  });
}