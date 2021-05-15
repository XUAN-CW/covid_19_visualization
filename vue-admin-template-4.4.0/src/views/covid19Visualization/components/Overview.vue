<template>
  <div id="overview" v-if="today">
    <ul>
      <li>
        <div class="overviewBox" lable="currentConfirm" @click="set_covidType($event)">
          <div class="overviewBox_case">现有确诊</div>
          <div class="overviewBox_number">{{today.currentConfirm}}</div>
          <span>昨日</span><span>{{today.currentConfirm - yesterday.currentConfirm}}</span>
        </div>
      </li>
      <li>
        <div class="overviewBox" lable="confirm" @click="set_covidType($event)">
          <div class="overviewBox_case">累计确诊</div>
          <div class="overviewBox_number">{{today.confirm}}</div>
          <span>昨日</span><span>{{today.currentConfirm - yesterday.currentConfirm}}</span>
        </div>
      </li>
      <li>
        <div class="overviewBox" lable="suspect" @click="set_covidType($event)">
          <div class="overviewBox_case">现有疑似</div>
          <div class="overviewBox_number">{{today.suspect}}</div>
          <span>昨日</span><span>{{today.suspect - yesterday.suspect}}</span>
        </div>
      </li>
      <li>
        <div class="overviewBox" lable="cure" @click="set_covidType($event)">
          <div class="overviewBox_case">累计治愈</div>
          <div class="overviewBox_number">{{today.cure}}</div>
          <span>昨日</span><span>{{today.cure - yesterday.cure}}</span>
        </div>
      </li>
      <li>
        <div class="overviewBox" lable="dead" @click="set_covidType($event)">
          <div class="overviewBox_case">累计死亡</div>
          <div class="overviewBox_number">{{today.dead}}</div>
          <span>昨日</span><span>{{today.dead - yesterday.dead}}</span>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    today: {},
    yesterday: {},
    currentType: ''
  },
  data() {
    return {

    };
  },
  methods: {

    set_covidType(e) {
      // console.log(e.currentTarget.getAttribute("lable"))// 当前元素
      this.set_covidTypeHelper(e.currentTarget.getAttribute("lable"))
    },
    set_covidTypeHelper(covidType) {
      this.$parent.setCurrentType(covidType)
    }
  },

};
</script>

<style>
.overviewBox {
  padding-top: 10px;
  padding-bottom: 10px;
}

.overviewBox:hover {
  background-color: whitesmoke;
  border-radius: 20px;
}

.selected {
  background-color: red;
  border-radius: 20px;
}

.overviewBox_number {
  font-size: 25px;
  padding-top: 5px;
  padding-bottom: 5px;
}

/**********************************************************************************************************/
#overview {
  margin: 20px auto; /* 外边距 */
  width: 1000px;
  overflow: hidden;
}

ul {
  display: table; /*这里是关键步骤：*/
  margin: 0 auto; /*让ul在div中水平居中 */
}
ul::after {
  /*清除浮动 */
  content: "";
  display: inline-block;
  clear: both;
}
ul li {
  float: left; /*让li浮动起来 横向排列*/
  list-style: none; /*隐藏序号*/
  text-align: center; /*让li在ul中水平居中*/
  width: 150px; /*任意设置li的宽度，不设置宽度的话也可以设置padding*/
}
</style>