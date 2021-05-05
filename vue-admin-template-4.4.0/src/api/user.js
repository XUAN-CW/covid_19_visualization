import request from '@/utils/request'



export default {
  login(data) {
    return request({
      url: '/user_center/user/login',
      method: 'post',
      data
    })
  },
  register(data) {
    return request({
      url: '/user_center/user/register',
      method: 'post',
      data
    })
  },
  getInfo() {
    return request({
      url: '/user_center/user/getUserInfo',
      method: 'get',
    })
  },
  sendCode(phone) {
    return request({
      url: `/msm/code/send/${phone}`,
      method: 'get'
    })
  },
}

