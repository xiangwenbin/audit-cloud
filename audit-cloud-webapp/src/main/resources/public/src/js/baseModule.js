import '../scss/base.scss';
import '../scss/module.scss';
import '../scss/unit.scss';
import 'element-ui/lib/theme-default/index.css';
import '../scss/element.scss';

import Vue from 'vue';
import ElementUI from 'element-ui';
import RequestPlugin from './plugin/requestPlugin';
import RegionPicker from './plugin/vue-region-picker';
import CHINA_REGION from 'china-area-data';
import Cookies from 'js-cookie';
import _ from 'lodash';
import Stomp from 'webstomp-client';
import SockJS from 'sockjs-client';
import "babel-polyfill";
import "./util/filter";

import EventBus from "./eventBus";

Vue.use(ElementUI);
Vue.use(RequestPlugin);
Vue.use(RegionPicker, {
    region: CHINA_REGION,
    vueVersion: 2
});



function _getUserId() {
    let _userId = Cookies.get("userid") || 0;
    if (!_userId && window["g_userinfo"]) {
        _userId = window["g_userinfo"].id || 0;
    }
    return _userId;
};

function _getUserDomain() {
    let domain = Cookies.get("userdomain") || 0;
    if (!domain && window["g_userinfo"]) {
        domain = window.g_userinfo.domainname;
    }
    return domain;
};

//全局混合
Vue.mixin({
    methods: {
        //求和函数
        sum(list) {
            return _.sumBy(list, this.parseNumber);
        },
        parseNumber(value) {
            let num = value;
            if (!value) {
                num = 0;
            } else if (value && isNaN(new Number(value))) {
                num = 0;
            }
            return new Number(num);
        },
        // 获取当前用户id
        getUserId() {
            return _getUserId();
        },
        // 获取当前用户域名
        getUserDomain() {
            return _getUserDomain();
        },
        // 是否登录
        isLogin() {
            return !!Cookies.get("TT_TOKEN");
        },
        // 当前用户是否已经绑定手机号码
        hasUserMobile () {
            if (window.g_userinfo) {
                if (window.g_userinfo.virtual)
                    return true;
                return !!window.g_userinfo.mobile;
            }
            return false;
        },
        // 是否登录
        getToken() {
            return Cookies.get("TT_TOKEN") || null;
        },
        needLogin() {
            return new Promise((resolve, reject) => {
                if (this.isLogin()) {
                    resolve();
                } else {
                    this.showLoginDialog({
                        success: () => {
                            resolve();
                        }
                    });
                }
            });
        },
        /**
         *  获取字符长度，中文占2个字符
         *  @param {String} str 
         */
        charLength(str) {
            if (!str) return 0;
            if (typeof str != "string") {
                str += "";
            }
            // 把双字节的替换成两个单字节的然后再获得长度
            return str.replace(/[^\x00-\xff]/g, "01").length;
        },
        getLimitText(text, limit) {
            if (text || text === 0) {
                let length = this.charLength(text);
                if (length < limit)
                    return text;
                let chs = text.split("");
                let temps = [];
                let len = 0;
                for (let i = 0, l = chs.length; i < l; i++) {
                    let ch = chs[i];
                    len += /[\x00-\xff]/.test(ch) ? 1 : 2;
                    if (len <= limit)
                        temps.push(ch);
                    else
                        break;
                }
                return temps.join("");
            }
            return "";
        },
        /**
         * 显示消息提示
         * @msg 提示信息，默认“出错了！”，如果msg是一个对象（异步错误信息）自动提取msg
         * @type 消息类型，默认“error”，可选：success/warning/info/error
         * @duration 延迟自动关闭时间，默认2000ms
         */
        showMsg(msg, type, duration) {
            if (msg) {
                if (msg instanceof Error)
                    msg = msg.toString();
                else if (typeof msg != "string")
                    msg = msg.hasOwnProperty("msg") ? msg.msg : msg;
            }
            msg = msg || "出错了！";
            type = type || "error";
            duration = duration || 2000;
            if (["error", "success", "info", "warning"].indexOf(type) < 0)
                type = "error";
            return this.$message({ message: msg, type: type, duration: duration });
        },
        showConsultDialog(userId) {
            this.needLogin().then(() => {
                EventBus.$emit("show_consultdialog", userId);
            });
        },
        showPletterDialog(uid, uname) {
            //私信事件
            this.needLogin().then(() => {
                EventBus.$emit("show_pletter", uid, uname)
            });
        },
        showLoginDialog(params) {
            EventBus.$emit("show_logindialog", params);
        }
    }
});

export default class BaseModule {
    constructor(options) {
        this.options = options || {};
        // console.log('constructor', options);
    }

    init(...vueConfigs) {
        this.initFrameVue();

        _.each(vueConfigs, (item) => {
            new Vue(item);
        });

        
    }

    initFrameVue() {
        
    }

};