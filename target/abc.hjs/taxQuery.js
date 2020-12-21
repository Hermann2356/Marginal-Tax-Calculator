$(function() {

	let formatNumber = function(num) {
		return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,');
	};
	
	let yearCategory = function() {
		console.log("You clicked on the year");
		$(".year").removeClass("selected");
		$(this).addClass("selected");
		let dataYear = $(this).data("year");
		$("#year").val(dataYear);
	}

	let statusCategory = function() {
		console.log("You clicked on the status");
		$(".status").removeClass("selected");
		$(this).addClass("selected");
		let dataStatus = $(this).data("status");
		$("#status").val(dataStatus);
	}

	
	$(".year").click(yearCategory);
	$(".status").click(statusCategory);
	
	$( "#salary" ).keyup(function() {
		let value = $(this).val();
		value = formatNumber(value);
		$("#formattedSalary").text(value);
	});
})