<template>
  <div>
    <Avatar></Avatar>
    <h1>疫情数据可视化主页面</h1>
    <router-link to="/login">
      login
    </router-link>
    <router-link to="/register">
      register   {{a}}
    </router-link>
  </div>
</template>

<script>
import Avatar from '@/layout/components/Avatar'
export default {
  name: 'Covid19Visualization',
  components: {
    Avatar
  },
  data() {
    return {
      a: 'aa',
    }
  }

}
</script>
