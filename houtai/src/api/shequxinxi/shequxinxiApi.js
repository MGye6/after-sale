import request from '@/utils/request';
// list
export const shequxinxiList = (params) => {
    return request({
        url: '/shequxinxi/page',
        method: 'post',
        data: params,
    })
};
export const shequxinxiDetail = (id) => {
    return request({
        url: '/shequxinxi/'+id,
        method: 'get',
    })
};
// add
export const shequxinxiSave = (params) => {
    return request({
        url: '/shequxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const shequxinxiEdit = (params) => {
    return request({
        url: '/shequxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const shequxinxiDelete = (id) => {
    return request({
        url: '/shequxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const shequxinxiDeleteList = (shequxinxis) => {
    return request({
        url: '/shequxinxi/deleteList',
        data:{list:shequxinxis},
        method: 'post',
    })
};
// all
export const shequxinxiAllList = () => {
    return request({
        url: '/shequxinxi',
        method: 'get',
    })
};

