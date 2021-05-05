<template>

  <div class="right-menu">
    <div v-if="!isLogin">
      <router-link to="/login">
        登录
      </router-link>
      <router-link to="/register">
        注册
      </router-link>
    </div>
    <div v-if="isLogin">
      <el-dropdown class="avatar-container" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar" class="user-avatar">
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown" class="user-dropdown">
          <router-link to="/home">
            <el-dropdown-item>
              Home
            </el-dropdown-item>
          </router-link>
          <el-dropdown-item @click.native="logout">
            <span style="display:block;">退出</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'
import userApi from '@/api/user'
import Cookies from 'js-cookie'


export default {

  data() {
    return {
      avatar: '',
      isLogin: false
    }
  },
  components: {
    Breadcrumb,
    Hamburger
  },
  computed: {
    ...mapGetters([
      'sidebar',
    ])
  },

  created() {
    this.isLogin = (Cookies.get('token') != null)

    this.getInfoByToken()
  },

  methods: {
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar')
    },
    getInfoByToken() {
      if (this.isLogin) {
        userApi.getInfo().then(response => {
          if (response.code == 20000) {
            console.log(response)
            this.avatar = response.data.userInfo.avatar
          } else {
            console.log(response)
          }
        }).catch((err) => {
          console.log(err)
        })
      }
    },
    logout(){
      Cookies.remove('token');
      this.isLogin=!this.isLogin
      this.$router.push({ path: this.redirect || '/' })
    }
  }
}
</script>

<style lang="scss" scoped>
.hamburger-container {
  line-height: 46px;
  height: 100%;
  float: left;
  cursor: pointer;
  transition: background 0.3s;
  -webkit-tap-highlight-color: transparent;

  &:hover {
    background: rgba(0, 0, 0, 0.025);
  }
}

.breadcrumb-container {
  float: left;
}

.right-menu {
  float: right;
  height: 100%;
  line-height: 50px;

  &:focus {
    outline: none;
  }

  .right-menu-item {
    display: inline-block;
    padding: 0 8px;
    height: 100%;
    font-size: 18px;
    color: #5a5e66;
    vertical-align: text-bottom;

    &.hover-effect {
      cursor: pointer;
      transition: background 0.3s;

      &:hover {
        background: rgba(0, 0, 0, 0.025);
      }
    }
  }

  .avatar-container {
    margin-right: 30px;

    .avatar-wrapper {
      margin-top: 5px;
      position: relative;

      .user-avatar {
        cursor: pointer;
        width: 40px;
        height: 40px;
        border-radius: 10px;
      }

      .el-icon-caret-bottom {
        cursor: pointer;
        position: absolute;
        right: -20px;
        top: 25px;
        font-size: 12px;
      }
    }
  }
}
</style>
