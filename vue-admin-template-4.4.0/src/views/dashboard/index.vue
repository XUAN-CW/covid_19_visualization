<template>
  <div style="padding-left:50px" class="dashboard-container">
    <el-table :data="byTrainHistoryList" style="width: 100%">
      <el-table-column prop="departureTime" label="日期">
      </el-table-column>
      <el-table-column prop="train" label="车次" width="180">
      </el-table-column>
      <el-table-column prop="coach" label="车厢">
      </el-table-column>
      <el-table-column prop="seat" label="座位">
      </el-table-column>
    </el-table>
  </div>
</template>

<script>

import reportApi from '@/api/report'
export default {
  name: 'Dashboard',
  data() {
    return {
      byTrainHistoryList: []
    }
  },

  created() {
    reportApi.getByTrainHistory().then(response => {
      if (response.code == 20000) {
        this.byTrainHistoryList = response.data.byTrainHistoryList;
        this.byTrainHistoryList.forEach(element => {
          element.departureTime = this.dateToString(element.departureTime)
        })
      }
    }).catch((err) => {
      console.log(err)
    })
  },

  methods: {
    dateToString(time) {
      var date = new Date(time);
      let Y = date.getFullYear() + '-';
      let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
      let D = date.getDate() + ' ';
      let h = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':';
      let m = date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes();
      return Y + M + D + h + m;
    }
  }
}
</script>

<style lang="scss" scoped>
</style>
