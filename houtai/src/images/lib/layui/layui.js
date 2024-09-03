/*!

 @Title: Layui
 @Description������ģ�黯ǰ�˿��
 @Site: www.layui.com
 @Author: ����
 @License��LGPL

 */
 
;!function(win){
  
"use strict";

var Lay = function(){
  this.v = '1.0.7'; //�汾��
};

Lay.fn = Lay.prototype;

var doc = document, config = Lay.fn.cache = {},

//��ȡlayui����Ŀ¼
getPath = function(){
  var js = doc.scripts, jsPath = js[js.length - 1].src;
  return jsPath.substring(0, jsPath.lastIndexOf('/') + 1);
}(),

//�쳣��ʾ
error = function(msg){
  win.console && console.error && console.error('Layui hint: ' + msg);
},

isOpera = typeof opera !== 'undefined' && opera.toString() === '[object Opera]',

//����ģ��
modules = {
  layer: 'modules/layer' //����
  ,laydate: 'modules/laydate' //����
  ,laypage: 'modules/laypage' //��ҳ
  ,laytpl: 'modules/laytpl' //ģ������
  ,layim: 'modules/layim' //webͨѶ
  ,layedit: 'modules/layedit' //���ı��༭��
  ,form: 'modules/form' //����
  ,upload: 'modules/upload' //�ϴ�
  ,tree: 'modules/tree' //���ṹ
  ,slide: 'modules/slide' //�ֲ�/����
  ,table: 'modules/table' //�����
  ,element: 'modules/element' //����Ԫ�ز���
  ,util: 'modules/util' //���߿�
  ,flow: 'modules/flow' //������
  ,code: 'modules/code' //����������
  ,single: 'modules/single' //��ҳӦ��
  ,mobile: 'modules/mobile' //�ƶ���ģ��

  ,jquery: 'lib/jquery' //DOM�⣨��������
  
  ,'layui.mod': 'dest/layui.mod' //PCģ��ϲ���
};

config.modules = {}; //��¼ģ������·��
config.status = {}; //��¼ģ�����״̬
config.timeout = 10; //���Ϲ淶��ģ��������ȴ�����
config.event = {}; //��¼ģ���Զ����¼�

//����ģ��
Lay.fn.define = function(deps, callback){
  var that = this
  ,type = typeof deps === 'function'
  ,mods = function(){
    typeof callback === 'function' && callback(function(app, exports){
      layui[app] = exports;
      config.status[app] = true;
    });
    return this;
  };
  type && (
    callback = deps,
    deps = []
  );
  if(layui['layui.all']){
    return mods.call(that);
  };
  that.use(deps, mods);
  return that;
};

//ʹ���ض�ģ��
Lay.fn.use = function(apps, callback, exports){
  var that = this, dir = config.dir = config.dir ? config.dir : getPath;
  var head = doc.getElementsByTagName('head')[0];

  apps = typeof apps === 'string' ? [apps] : apps;
  
  //���ҳ���Ѿ�����jQuery1.7+�����������ģ������jQuery���򲻼����ڲ�jqueryģ��
  if(window.jQuery && jQuery.fn.on){
    that.each(apps, function(index, item){
      if(item === 'jquery'){
        apps.splice(index, 1);
      }
    });
    layui.jquery = jQuery;
  }
  
  var item = apps[0], timeout = 0;
  exports = exports || [];

  //��̬��Դhost
  config.host = config.host || (dir.match(/\/\/([\s\S]+?)\//)||['//'+ location.host +'/'])[0];
  
  if(apps.length === 0 || (layui['layui.all'] && modules[item])){
    return typeof callback === 'function' && callback.apply(layui, exports), that;
  }

  //�������
  function onScriptLoad(e, url){
    var readyRegExp = navigator.platform === 'PLaySTATION 3' ? /^complete$/ : /^(complete|loaded)$/
    if (e.type === 'load' || (readyRegExp.test((e.currentTarget || e.srcElement).readyState))) {
      config.modules[item] = url;
      head.removeChild(node);
      (function poll() {
        if(++timeout > config.timeout * 1000 / 4){
          return error(item + ' is not a valid module');
        };
        config.status[item] ? onCallback() : setTimeout(poll, 4);
      }());
    }
  }

  //����ģ��
  var node = doc.createElement('script'), url =  (
    modules[item] ? (dir + 'lay/') : (config.base || '')
  ) + (that.modules[item] || item) + '.js';
  node.async = true;
  node.charset = 'utf-8';
  node.src = url + function(){
    var version = config.version === true 
    ? (config.v || (new Date()).getTime())
    : (config.version||'');
    return version ? ('?v=' + version) : '';
  }();
  
  //�״μ���
  if(!config.modules[item]){
    head.appendChild(node);
    if(node.attachEvent && !(node.attachEvent.toString && node.attachEvent.toString().indexOf('[native code') < 0) && !isOpera){
      node.attachEvent('onreadystatechange', function(e){
        onScriptLoad(e, url);
      });
    } else {
      node.addEventListener('load', function(e){
        onScriptLoad(e, url);
      }, false);
    }
  } else {
    (function poll() {
      if(++timeout > config.timeout * 1000 / 4){
        return error(item + ' is not a valid module');
      };
      (typeof config.modules[item] === 'string' && config.status[item]) 
      ? onCallback() 
      : setTimeout(poll, 4);
    }());
  }
  
  config.modules[item] = url;
  
  //�ص�
  function onCallback(){
    exports.push(layui[item]);
    apps.length > 1 ?
      that.use(apps.slice(1), callback, exports)
    : ( typeof callback === 'function' && callback.apply(layui, exports) );
  }

  return that;

};

//��ȡ�ڵ��style����ֵ
Lay.fn.getStyle = function(node, name){
  var style = node.currentStyle ? node.currentStyle : win.getComputedStyle(node, null);
  return style[style.getPropertyValue ? 'getPropertyValue' : 'getAttribute'](name);
};

//css�ⲿ������
Lay.fn.link = function(href, fn, cssname){
  var that = this, link = doc.createElement('link');
  var head = doc.getElementsByTagName('head')[0];
  if(typeof fn === 'string') cssname = fn;
  var app = (cssname || href).replace(/\.|\//g, '');
  var id = link.id = 'layuicss-'+app, timeout = 0;
  
  link.rel = 'stylesheet';
  link.href = href + (config.debug ? '?v='+new Date().getTime() : '');
  link.media = 'all';
  
  if(!doc.getElementById(id)){
    head.appendChild(link);
  }

  if(typeof fn !== 'function') return ;
  
  //��ѯcss�Ƿ�������
  (function poll() {
    if(++timeout > config.timeout * 1000 / 100){
      return error(href + ' timeout');
    };
    parseInt(that.getStyle(doc.getElementById(id), 'width')) === 1989 ? function(){
      fn();
    }() : setTimeout(poll, 100);
  }());
};

//css�ڲ�������
Lay.fn.addcss = function(firename, fn, cssname){
  layui.link(config.dir + 'css/' + firename, fn, cssname);
};

//ͼƬԤ����
Lay.fn.img = function(url, callback, error) {   
  var img = new Image();
  img.src = url; 
  if(img.complete){
    return callback(img);
  }
  img.onload = function(){
    img.onload = null;
    callback(img);
  };
  img.onerror = function(e){
    img.onerror = null;
    error(e);
  };  
};

//ȫ������
Lay.fn.config = function(options){
  options = options || {};
  for(var key in options){
    config[key] = options[key];
  }
  return this;
};

//��¼ȫ��ģ��
Lay.fn.modules = function(){
  var clone = {};
  for(var o in modules){
    clone[o] = modules[o];
  }
  return clone;
}();

//��չģ��
Lay.fn.extend = function(options){
  var that = this;

  //��֤ģ���Ƿ�ռ��
  options = options || {};
  for(var o in options){
    if(that[o] || that.modules[o]){
      error('\u6A21\u5757\u540D '+ o +' \u5DF2\u88AB\u5360\u7528');
    } else {
      that.modules[o] = options[o];
    }
  }
  
  return that;
};

//·��
Lay.fn.router = function(hash){
  var hashs = (hash || location.hash).replace(/^#/, '').split('/') || [];
  var item, param = {
    dir: []
  };
  for(var i = 0; i < hashs.length; i++){
    item = hashs[i].split('=');
    /^\w+=/.test(hashs[i]) ? function(){
      if(item[0] !== 'dir'){
        param[item[0]] = item[1];
      }
    }() : param.dir.push(hashs[i]);
    item = null;
  }
  return param;
};

//���ش洢
Lay.fn.data = function(table, settings){
  table = table || 'layui';
  
  if(!win.JSON || !win.JSON.parse) return;
  
  //���settingsΪnull����ɾ����
  if(settings === null){
    return delete localStorage[table];
  }
  
  settings = typeof settings === 'object' 
    ? settings 
  : {key: settings};
  
  try{
    var data = JSON.parse(localStorage[table]);
  } catch(e){
    var data = {};
  }
  
  if(settings.value) data[settings.key] = settings.value;
  if(settings.remove) delete data[settings.key];
  localStorage[table] = JSON.stringify(data);
  
  return settings.key ? data[settings.key] : data;
};

//�豸��Ϣ
Lay.fn.device = function(key){
  var agent = navigator.userAgent.toLowerCase();

  //��ȡ�汾��
  var getVersion = function(label){
    var exp = new RegExp(label + '/([^\\s\\_\\-]+)');
    label = (agent.match(exp)||[])[1];
    return label || false;
  };

  var result = {
    os: function(){ //�ײ����ϵͳ
      if(/windows/.test(agent)){
        return 'windows';
      } else if(/linux/.test(agent)){
        return 'linux';
      } else if(/iphone|ipod|ipad|ios/.test(agent)){
        return 'ios';
      }
    }()
    ,ie: function(){ //ie�汾
      return (!!win.ActiveXObject || "ActiveXObject" in win) ? (
        (agent.match(/msie\s(\d+)/) || [])[1] || '11' //����ie11��û��msie�ı�ʶ
      ) : false;
    }()
    ,weixin: getVersion('micromessenger')  //�Ƿ�΢��
  };
  
  //�����key
  if(key && !result[key]){
    result[key] = getVersion(key);
  }
  
  //�ƶ��豸
  result.android = /android/.test(agent);
  result.ios = result.os === 'ios';
  
  return result;
};

//��ʾ
Lay.fn.hint = function(){
  return {
    error: error
  }
};

//����
Lay.fn.each = function(obj, fn){
  var that = this, key;
  if(typeof fn !== 'function') return that;
  obj = obj || [];
  if(obj.constructor === Object){
    for(key in obj){
      if(fn.call(obj[key], key, obj[key])) break;
    }
  } else {
    for(key = 0; key < obj.length; key++){
      if(fn.call(obj[key], key, obj[key])) break;
    }
  }
  return that;
};

//��ֹ�¼�ð��
Lay.fn.stope = function(e){
  e = e || win.event;
  e.stopPropagation ? e.stopPropagation() : e.cancelBubble = true;
};

//�Զ���ģ���¼�
Lay.fn.onevent = function(modName, events, callback){
  if(typeof modName !== 'string' 
  || typeof callback !== 'function') return this;
  config.event[modName + '.' + events] = [callback];
  
  //���ٶԶ���¼�������֧��
  /*
  config.event[modName + '.' + events] 
    ? config.event[modName + '.' + events].push(callback) 
  : config.event[modName + '.' + events] = [callback];
  */
  
  return this;
};

//ִ���Զ���ģ���¼�
Lay.fn.event = function(modName, events, params){
  var that = this, result = null, filter = events.match(/\(.*\)$/)||[]; //��ȡ�¼�������
  var set = (events = modName + '.'+ events).replace(filter, ''); //��ȡ�¼�������
  var callback = function(_, item){
    var res = item && item.call(that, params);
    res === false && result === null && (result = false);
  };
  layui.each(config.event[set], callback);
  filter[0] && layui.each(config.event[events], callback); //ִ�й������е��¼�
  return result;
};

win.layui = new Lay();

}(window);

