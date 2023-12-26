
let newDiv = document.createElement("div");
newDiv.id = 'demo'
document.body.appendChild(newDiv);

var myChart = echarts.init(newDiv, null, {
    renderer: 'canvas',
    useDirtyRect: false,
    width: 800,
    height: 600
});

var option =  JSON.parse(arguments[0])
if (option && typeof option === 'object') {
    myChart.setOption(option);
}


