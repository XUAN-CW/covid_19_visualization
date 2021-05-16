<template>
  <div class="app-container">
    <el-form ref="report" :model="report" label-width="120px">
      <el-form-item label="车次">
        <el-input v-model="report.train" />
      </el-form-item>
      <el-form-item label="车厢">
        <el-input v-model="report.coach" />
      </el-form-item>
      <el-form-item label="座位">
        <el-input v-model="report.seat" />
      </el-form-item>

      <el-form-item label="发车时间">
        <div class="block">
          <el-date-picker format="yyyy-MM-dd HH:mm" value-format="timestamp" v-model="report.departureTime" type="datetime" placeholder="选择日期时间">
          </el-date-picker>
        </div>
      </el-form-item>

      <el-form-item label="是否感染">
        <el-select v-model="report.isInfect" placeholder="please select your zone">
          <el-option label="未感染" value="false" />
          <el-option label="已感染" value="true" />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">Create</el-button>
        <el-button @click="onCancel">Cancel</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import reportApi from '@/api/report'
export default {
  data() {
    return {

      departureTimeTemp: {
        date: '',
        time: ''
      },
      report: {
        train: '',
        coach: '',
        seat: '',
        departureTime: '',
        isInfect: 'false'
      },
    }
  },
  methods: {
    onSubmit() {
      reportApi.byTrain(this.report).then(response => {
        if(response.code == 20000){
          this.$router.push( '/home')
        }
      }).catch((err) => {
        console.log(err)
      })
    },
    onCancel() {
      this.$message({
        message: 'cancel!',
        type: 'warning'
      })
    }
  }
}
</script>

<style scoped>
.line {
  text-align: center;
}
</style>

