<template>
  <div class="login-container">
    <el-form ref="RegisterForm" :model="RegisterForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">

      <div class="title-container">
        <h3 class="title">Register Form</h3>
      </div>

      <el-form-item prop="mobile">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input ref="mobile" v-model="RegisterForm.mobile" placeholder="手机号码" name="mobile" type="text" tabindex="1" auto-complete="on" />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input :key="passwordType" ref="password" v-model="RegisterForm.password" :type="passwordType" placeholder="密码" name="password" tabindex="2" auto-complete="on" @keyup.enter.native="handleRegister" />
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'" />
        </span>
      </el-form-item>

      <el-form-item>
        <el-input ref="mobile" v-model="RegisterForm.code" style="width:250px;" placeholder="验证码" />
        <span style="float:right;padding-top:3px;padding-right:3px">
          <el-button type="primary" style="width:80px;" :disabled="!canClick" @click.native.prevent="getCode">{{content}}</el-button>
        </span>
      </el-form-item>

      <el-button :loading="loading" type="primary" style="width:100%;margin-bottom:30px;" @click.native.prevent="handleRegister">Register</el-button>

      <div class="tips">
        <span style="margin-right:20px;">mobile: admin</span>
        <span> password: any</span>
      </div>

    </el-form>
  </div>
</template>

<script>
import { validmobile } from '@/utils/validate'
import userApi from '@/api/user'

export default {
  name: 'Register',
  data() {
    const validatemobile = (rule, value, callback) => {
      if (!validmobile(value)) {
        callback(new Error('Please enter the correct user name'))
      } else {
        callback()
      }
    }
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('The password can not be less than 6 digits'))
      } else {
        callback()
      }
    }
    return {
      RegisterForm: {
        mobile: '111111111',
        password: '11111111',
        code: '11111111'
      },
      loginRules: {
        mobile: [{ required: true, trigger: 'blur', validator: validatemobile }],
        password: [{ required: true, trigger: 'blur', validator: validatePassword }]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined,
      content: '获取',
      totalTime: 60,
      canClick: true //添加canClick
    }
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    handleRegister() {
      userApi.register(this.RegisterForm).then((res) => {
        console.log(res)
        if(res.code == 20000){
          this.$router.push({ path: this.redirect || '/login' })
        }
      }).catch((err) => {
        console.log(err)
      })
    },

    getCode() {
      this.countDown()
      userApi.sendCode(this.RegisterForm.mobile)
        .then(response => {
          if(response.code == 20000){
            this.countDown()
          }
          this.sending = false
        })
    },

    countDown() {
      let tempTotalTime = this.totalTime
      let tempContent = this.content
      if (!this.canClick) return  //改动的是这两行代码
      this.canClick = false
      this.content = this.totalTime
      let clock = window.setInterval(() => {
        this.totalTime--
        this.content = this.totalTime
        if (this.totalTime < 0) {
          window.clearInterval(clock)
          this.content = tempContent
          this.totalTime = tempTotalTime
          this.canClick = true  //这里重新开启
        }
      }, 1000)
    }


  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg: #283443;
$light_gray: #fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 110px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>
