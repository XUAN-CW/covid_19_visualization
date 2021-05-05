import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user_center/user/login',
    method: 'post',
    data
  })
}

export default {
  login(data) {
    return request({
      url: '/user_center/user/login',
      method: 'post',
      data
    })
  },
  getInfo(token) {
    return request({
      url: '/user_center/user/getUserInfo',
      method: 'get',
      params: { token }
    })
  },
  logout() {
    return request({
      url: '/vue-admin-template/user/logout',
      method: 'post'
    })
  }
}

