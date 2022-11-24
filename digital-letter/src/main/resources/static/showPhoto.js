function processFiles(files,num) {
	var file = files[0];
	var reader = new FileReader();
	reader.onload = function(e) {
		// Когда это событие активируется, данные готовы.
		// Вставляем их в страницу в элемент <div>
		//var output = document.getElementById("image_letter");
		//output.style.backgroundImage = e.target.result;
		//output.textContent = e.target.result;
		if (num == 1) {
			var output = document.getElementById("image_letter");
		} else {
			var output = document.getElementById("image_letter_2");
		}
		output.style.backgroundImage = "url('" + e.target.result + "')";

};


	
	//reader.readAsText(file);
	reader.readAsDataURL(file);
}

//function processFiles(files, num) {
//	var file = files[0];
//	var reader = new FileReader();
//	reader.onload = function(e) {
//		// Когда это событие активируется, данные готовы.
//		// Вставляем их в страницу в элемент <div>
//		var output = document.getElementById("image_letter_2");
//		//output.style.backgroundImage = e.target.result;
//		//output.textContent = e.target.result;
//
//		if (num == 2) {
//			output.style.backgroundImage = "url('" + e.target.result + "')";
//
//		}
//
//
//
//	};
//
//	//reader.readAsText(file);
//	reader.readAsDataURL(file);
//}