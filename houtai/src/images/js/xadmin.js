$(function () {
    //���ص�����
    layui.use(['form','element'],
    function() {
        layer = layui.layer;
        element = layui.element();
    });

	//���绯����
	function bgint () {
    	if(localStorage.bglist){
            var arr = JSON.parse(localStorage.bglist);// 
            // console.log(arr);
            //ȫ�ֱ���ͳһ
            if(arr['bgSrc']){
                $('body').css('background-image', 'url('+arr['bgSrc']+')');

                //��ʼ�������㱳��
            }
            //���������߼�
            // if(arr[location.href]){
            //     $('body').css('background-image', 'url('+arr[location.href]+')');
            // }
    	}
    }

    bgint();

	//�������⹦��
	var changerlist = new Swiper('.changer-list', {
		initialSlide :5,
        effect: 'coverflow',
        grabCursor: true,
        centeredSlides: true,
        slidesPerView: 'auto',
        coverflow: {
            rotate: 50,
            stretch: -10,
            depth: 100,
            modifier: 1,
            slideShadows : false
        }
    });

    //�ж��Ƿ���ʾ���˵�
    $(window).resize(function(){
        width=$(this).width();
        if(width>1024){
            $('#side-nav').show();
        }
    });

	//������������չʾ
    is_show_change=true;
    $('#changer-set').click(function(event) {
    	if(is_show_change){
            $('.bg-out').show();
    		$('.bg-changer').animate({top: '0px'}, 500);
    		is_show_change=false;
    	}else{
    		$('.bg-changer').animate({top: '-110px'}, 500);
    		is_show_change=true;
    	}
    	
    });

    //���������л�
    $('.bg-changer img.item').click(function(event) {
    	if(!localStorage.bglist){
    		arr = {};
    	}else{
    		arr = JSON.parse(localStorage.bglist);
    	}
    	var src = $(this).attr('src');
    	$('body').css('background-image', 'url('+src+')');

    	url = location.href;

        // ���������߼�
    	// arr[url]=src;
        
        // ȫ�ֱ���ͳһ
        arr['bgSrc'] = src;
        // console.log(arr);

    	localStorage.bglist = JSON.stringify(arr);

    });

    //������ʼ��
    $('.reset').click(function  () {
        localStorage.clear();
        layer.msg('���绯�ɹ�',function(){});
    });


    //�����л�����հ���������
    $('.bg-out').click(function  () {
        $('.bg-changer').animate({top: '-110px'}, 500);
            is_show_change=true;
        $(this).hide();
    })


    //խ���µ����˵�����Ч��
    $('.container .open-nav i').click(function(event) {
        $('#side-nav').toggle(400);
        // $('.wrapper .left-nav').toggle(400)
    });

    //���˵�Ч��
    $('.left-nav #nav li').click(function () {
        if($(this).hasClass('open')){
            $(this).removeClass('open');
            $(this).find('.nav_right').html('&#xe697;');
            $(this).children('.sub-menu').slideUp();
            // $(this).siblings().children('.sub-menu').slideUp();
        }else{
            $(this).addClass('open');
            $(this).find('.nav_right').html('&#xe6a6;');
            $(this).children('.sub-menu').slideDown();
            $(this).siblings().children('.sub-menu').slideUp();
            $(this).siblings().removeClass('open');
        }
        
    })

    //��ʼ���˵�չ����ʽ
    $('.left-nav #nav li .opened').siblings('a').find('.nav_right').html('&#xe6a6;');

    





    
})

/*������*/
/*
    �������ͣ�
    title   ����
    url     �����url
    id      ��Ҫ����������id
    w       �������ȣ�ȱʡ��Ĭ��ֵ��
    h       ������߶ȣ�ȱʡ��Ĭ��ֵ��
*/
function x_admin_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=800;
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //���̶�
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
}

/*�رյ������*/
function x_admin_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}
