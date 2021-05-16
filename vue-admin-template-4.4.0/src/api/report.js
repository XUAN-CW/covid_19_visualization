import request from '@/utils/request'

export default {
    byTrain(data) {
        return request({
            url: '/report/by-train/byTrain',
            method: 'post',
            data
        })
    },
    getByTrainHistory() {
        return request({
            url: '/report/by-train/getByTrainHistory',
            method: 'get',
        })
    },
}

