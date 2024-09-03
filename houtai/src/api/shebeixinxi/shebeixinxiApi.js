import request from '@/utils/request';
// list
export const shebeixinxiList = (params) => {
    return request({
        url: '/shebeixinxi/page',
        method: 'post',
        data: params,
    })
};
export const shebeixinxiDetail = (id) => {
    return request({
        url: '/shebeixinxi/'+id,
        method: 'get',
    })
};
// add
export const shebeixinxiSave = (params) => {
    return request({
        url: '/shebeixinxi',
        method: 'post',
        data: params,
    })
};
// updt
export const shebeixinxiEdit = (params) => {
    return request({
        url: '/shebeixinxi',
        method: 'put',
        data: params,
    })
};
// delete
export const shebeixinxiDelete = (id) => {
    return request({
        url: '/shebeixinxi/'+id,
        method: 'delete',
    })
};
// pldel
export const shebeixinxiDeleteList = (shebeixinxis) => {
    return request({
        url: '/shebeixinxi/deleteList',
        data:{list:shebeixinxis},
        method: 'post',
    })
};
// all
export const shebeixinxiAllList = () => {
    return request({
        url: '/shebeixinxi',
        method: 'get',
    })
};

