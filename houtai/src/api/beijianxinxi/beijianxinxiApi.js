import request from '@/utils/request';
// list
export const beijianxinxiList = (params) => {
    return request({
        url: '/beijianxinxi/page',
        method: 'post',
        data: params,
    })
};
export const beijianxinxiDetail = (id) => {
    return request({
        url: '/beijianxinxi/'+id,
        method: 'get',
    })
};
// add
export const beijianxinxiSave = (params) => {
    return request({
        url: '/beijianxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const beijianxinxiEdit = (params) => {
    return request({
        url: '/beijianxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const beijianxinxiDelete = (id) => {
    return request({
        url: '/beijianxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const beijianxinxiDeleteList = (beijianxinxis) => {
    return request({
        url: '/beijianxinxi/deleteList',
        data:{list:beijianxinxis},
        method: 'post',
    })
};
// all
export const beijianxinxiAllList = () => {
    return request({
        url: '/beijianxinxi',
        method: 'get',
    })
};

