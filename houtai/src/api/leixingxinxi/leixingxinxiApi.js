import request from '@/utils/request';
// list
export const leixingxinxiList = (params) => {
    return request({
        url: '/leixingxinxi/page',
        method: 'post',
        data: params,
    })
};
export const leixingxinxiDetail = (id) => {
    return request({
        url: '/leixingxinxi/'+id,
        method: 'get',
    })
};
// add
export const leixingxinxiSave = (params) => {
    return request({
        url: '/leixingxinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const leixingxinxiEdit = (params) => {
    return request({
        url: '/leixingxinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const leixingxinxiDelete = (id) => {
    return request({
        url: '/leixingxinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const leixingxinxiDeleteList = (leixingxinxis) => {
    return request({
        url: '/leixingxinxi/deleteList',
        data:{list:leixingxinxis},
        method: 'post',
    })
};
// all
export const leixingxinxiAllList = () => {
    return request({
        url: '/leixingxinxi',
        method: 'get',
    })
};

