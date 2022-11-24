var value_select;
var index;

document.getElementById("sorting").onchange = function() {
	value_select = document.getElementById("sorting").value;
	index = value_select.selectedIndex;
	document.getElementById("sorting_form").submit();
};



