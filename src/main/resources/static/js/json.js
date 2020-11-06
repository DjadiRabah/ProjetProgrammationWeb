function getJsonKeys(json)
{
	return Object.keys(json);
}


function getJsonLength(json) 
{
    return getJsonKeys(json).length;
}

function addJsonKeysToDiv(div, json)
{
	var row = document.createElement('div');
	row.className = "row";
	var keys = getJsonKeys(json);
	for (key in keys)
	{
		var divKey = document.createElement('div');
		divKey.className = "col-sm-1 panel panel-default";
		divKey.innerHTML += keys[key];
		row.appendChild(divKey);
	}
	var buttonsSize = 12 - getJsonLength(json);
	var divButtons = document.createElement('div');
	divButtons.className = "col-sm-" + buttonsSize;
	divButtons.innerHTML = "Boutons";
	row.appendChild(divButtons);
	div.appendChild(row);
}

function addJsonValuesToDiv(div, json)
{
	var row = document.createElement('div');
	row.className = "row";

	for (key in json)
	{
		var divValue = document.createElement('div');
		divValue.className = "col-sm-1";
		divValue.innerHTML += json[key];
		row.appendChild(divValue);
	}					
	var buttonsSize = 12 - getJsonLength(json);
	var divButtons = document.createElement('div');
	divButtons.className = "col-sm-" + buttonsSize;
	
	var divButtonUpdate = document.createElement('a');
	divButtonUpdate.className = "btn btn-warning btn-lg btn-block";
	divButtonUpdate.innerHTML = "Modifier";
	divButtonUpdate.href = "formCharacter.html?id=" + json["id"];
	
	divButtons.appendChild(divButtonUpdate);
	row.appendChild(divButtons);
	div.appendChild(row);
}