import request from '@/utils/request';
// list
export const yuyuexinxiList = (params) => {
    return request({
        url: '/yuyuexinxi/page',
        method: 'post',
        data: params,
    })
};
export const yuyuexinxibeijianList = (params) => {
    return request({
        url: '/yuyuexinxi/beijianList',
        method: 'get',
        params: {wangdianmingcheng:params},
    })
};
export const yuyuexinxiDetail = (id) => {
    return request({
        url: '/yuyuexinxi/'+id,
        method: 'get',
    })
};
// add
export const yuyuexinxiSave = (params) => {
    return request({
        url: '/yuyuexinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const yuyuexinxiEdit = (params) => {
    return request({
        url: '/yuyuexinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const yuyuexinxiDelete = (id) => {
    return request({
        url: '/yuyuexinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const yuyuexinxiDeleteList = (yuyuexinxis) => {
    return request({
        url: '/yuyuexinxi/deleteList',
        data:{list:yuyuexinxis},
        method: 'post',
    })
};
// all
export const yuyuexinxiAllList = () => {
    return request({
        url: '/yuyuexinxi',
        method: 'get',
    })
};

export const yuyuexinxi_tj_leixingmingcheng = () => {return request({url: '/yuyuexinxi/yuyuexinxi_tj_leixingmingcheng',method: 'get',})};

