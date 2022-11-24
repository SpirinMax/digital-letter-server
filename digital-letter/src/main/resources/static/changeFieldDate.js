var value_select;

document.getElementById("search_select").onchange = function() {
	value_select = document.getElementById("search_select").value;

	if (value_select == 1) {
		document.getElementById("field_search_date").style.display = "";
		document.getElementById("field_search").style.display = "none";		
	} else {
		document.getElementById("field_search_date").style.display = "none";
		document.getElementById("field_search").style.display = "";
	}
	
};



