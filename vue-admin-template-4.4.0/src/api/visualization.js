import request from '@/utils/request'



export default {
    queryAWeek() {
        return request({
            url: '/visualization_data/area/queryAWeek',
            method: 'get',
        })
    }
}

