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

function updatePojo(table, json)
{
	var request = new XMLHttpRequest();
	request.open('GET', "update" + table);
	
	request.onload = function() {
		if(request.status === 200)
		{
			request.responseText;
		}
		else
		{
			console.log("fail " + request.status);
		}
	};
	request.send();
}

function insertPojo(table, json)
{
	console.log(json);
	$.ajax({
        type: "GET",                     
        url:'/insert' + table,  
        data: {json : json},       
        dataType: "json",
        contentType: "application/json",
        success : function(data){            
         },
         error : function(data) {
         }
  });
}