<template>
  <div class="Echarts">
    <div id="roma" style="width: 900px; height: 600px"></div>
  </div>
</template>

<script>
// require('echarts/lib/chart/effectScatter')
// 地图
require("echarts/lib/chart/map");
// 图例
require("echarts/lib/component/legend");
// 提示框
require("echarts/lib/component/tooltip");
// 地图geo
require("echarts/lib/component/geo");
// 中国地图
require("echarts/map/js/china");
export default {
  name: "Echarts",
  props: {
    generalSituation: {},
    checked: {},
  },
  data() {
    return {};
  },
  mounted() {
    if (this.generalSituation.length > 0) {
      this.myEcharts();
    }
  },

  methods: {
    myEcharts() {


      let legendData = Object.keys(this.generalSituation[0])

      // console.log(legendData)

      let seriesItems = [];
      for (let i = 0; i < legendData.length; i++) {
        let seriesItem = {
          name: legendData[i],
          type: "line",
          stack: "总量",
          data: [],
        };
        seriesItems.push(seriesItem);
      }
      // console.log(this.generalSituation)

      for (let i = this.generalSituation.length - 1; i >= 0; i--) {

        for (let j = seriesItems.length - 1; j >= 0; j--) {

          switch (seriesItems[j].name) {
            case "currentConfirm":
              seriesItems[j].data.push(this.generalSituation[i].currentConfirm);
              break;
            case "confirm":
              seriesItems[j].data.push(this.generalSituation[i].confirm);
              break;
            case "suspect":
              seriesItems[j].data.push(this.generalSituation[i].suspect);
              break;
            case "cure":
              seriesItems[j].data.push(this.generalSituation[i].cure);
              break;
            case "dead":
              seriesItems[j].data.push(this.generalSituation[i].dead);
              break
            default:
              break;
          }
        }
      }
      // console.log(seriesItems)

      let xAxisData = [];
      for (let i = this.generalSituation.length - 1; i > 0; i--) {
        xAxisData.push(i + "天前");
      }
      xAxisData.push("今天");
      let unSelectedData = {};
      // console.log(this.checked)
      for (let index = 0; index < legendData.length; index++) {
        if (legendData[index] == this.checked) {
          continue
        }
        let keyValue = {};
        keyValue[legendData[index]] = false;
        Object.assign(unSelectedData, keyValue)
      }


      var myChart = this.$echarts.init(document.getElementById("roma"));

      let options = {
        tooltip: {
          trigger: "axis",
        },
        legend: {
          data: legendData,
          selected: unSelectedData,
        },
        toolbox: {
          show: true,
          feature: {
            mark: { show: true },
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ["line", "bar", "stack", "tiled"] },
            restore: { show: true },
            saveAsImage: { show: true },
          },
        },
        calculable: true,
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: xAxisData,
          },
        ],
        yAxis: [
          {
            type: "value",
          },
        ],
        series: seriesItems,
      };

      // console.log("aaaaaa"+this.resource);
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(options);
    },
  },
};
</script>
    <style>
#roma {
  margin: 20px auto; /* 外边距 */
  width: 1000px;
  height: 720px;
}
</style>

