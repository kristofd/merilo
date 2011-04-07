$(function () {
    $.plot($("#graph"), [responsetimeseries], { grid: { hoverable: true } } );

	var size = responsetimeseries.data.length;
    $.plot($("#graph_sorted"), [responsetimeseries_sorted], { xaxis: { ticks: [0, [size*0.1, "10%"], [size*0.25, "25%"], [size*0.5, "50%"], [size*0.75, "75%"]] } } );
	
    var previousPoint = null;
    $("#graph").bind("plothover", function (event, pos, item) {
        if (item) {
			if (previousPoint != item.datapoint) {
				previousPoint = item.datapoint;
				$("#tooltip").remove();
				showTooltip(item.pageX, item.pageY, '<a href="' + urls[item.dataIndex] + '" target="_blank">' + urls[item.dataIndex] + '</a>' + ": " + item.datapoint[1] + " ms")
			}
        } else {
			$("#tooltip").remove();
			previousPoint = null;  
		}
    });

    function showTooltip(x, y, contents) {
        $('<div id="tooltip">' + contents + '</div>').css( {
            position: 'absolute',
            top: y - 20,
            left: x + 5,
            border: '1px solid',
            padding: '2px 5px',
            'background-color': '#fff',
        }).appendTo("body");
    }
});
