import request from '@/utils/request';
// list
export const wangdianxinxiList = (params) => {
    return request({
        url: '/wangdianxinxi/page',
        method: 'post',
        data: params,
    })
};
export const wangdianxinxiDetail = (id) => {
    return request({
        url: '/wangdianxinxi/'+id,
        method: 'get',
    })
};
// add
export const wangdianxinxiSave = (params) => {
    return request({
        url: '/wangdianxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const wangdianxinxiEdit = (params) => {
    return request({
        url: '/wangdianxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const wangdianxinxiDelete = (id) => {
    return request({
        url: '/wangdianxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const wangdianxinxiDeleteList = (wangdianxinxis) => {
    return request({
        url: '/wangdianxinxi/deleteList',
        data:{list:wangdianxinxis},
        method: 'post',
    })
};
// all
export const wangdianxinxiAllList = () => {
    return request({
        url: '/wangdianxinxi',
        method: 'get',
    })
};

