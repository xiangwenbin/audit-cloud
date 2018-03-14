<#macro css>

</#macro>

<#-- 一个加载等待样式视图 -->
<#macro loading>
<div class="m-loading">
    <div class="el-loading-spinner">
        <svg viewBox="25 25 50 50" class="circular">
            <circle cx="50" cy="50" r="20" fill="none" class="path"></circle>
        </svg>
    </div>
</div>
</#macro>


<#macro meta title="" keywords="" description="" subtitle="" addkeywords="">
<#if title=="">
    <#if subtitle=="">
    <title>财税叨叨-财税爱好者的交流平台</title>
    <#else>
    <title>财税叨叨-${subtitle}</title>
    </#if>
<#else>
<title>${title}</title>
</#if>
<meta charset="UTF-8">
<#if keywords=="">
<meta name="keywords" content="财务报表,财务总监,财务管理,财务软件,财务,会计学,会计证,会计,国家税务局,税务师,审计,税务,注册会计师,叨叨,中汇,中华会计网校,会计从业考试,东奥会计在线,会计培训,会计考试网,会计基础,初级会计${addkeywords}">
<#else>
<meta name="keywords" content="${keywords}">
</#if>
<#if description=="">
<meta name="description" content="财税叨叨是中汇旗下的财会社交平台.这里可找大牛,找师兄师姐,找招聘内推实习信息,还可浏览最新财税政策和资讯">
<#else>
<meta name="description" content="${description}">
</#if>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="baidu-site-verification" content="mLx8I0NFpG" />
<meta name="360-site-verification" content="4d1cb12eb420d79d248f05327926a544" />
<meta name="google-site-verification" content="efZeT7Qz5NLWZt-wcUyIZr0Xws-WwpUxo8uyvJIx6ec" />
<meta name="msvalidate.01" content="893267C2D3711DF5EC9400C73C68DC18" />
<meta name="sogou_site_verification" content="TiVQm972fQ"/>
<meta name="baidu-site-verification" content="mLx8I0NFpG" />
</#macro>


<#-- 浏览器兼容性验证 -->
<#macro init>
{% if(env.NODE_ENV=='production'){ %}
<#--ga统计js-->
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-98866068-1', 'auto');
  ga('send', 'pageview');
  <#if (user??&&user.id>0)>
  ga('set', 'userId','${user.id}');
  </#if>
</script>
<#--友盟统计-->
<script>
var _czc = _czc || [];
_czc.push(["_setAccount", "1264322583"]);
<#if (user??&&user.id>0)>
  _czc.push(["_setCustomVar", "登录用户", "${user.id}", "-1"]);
</#if>
<#if (user??&&user.usertype==2)>
  _czc.push(["_setCustomVar", "官方帐号", "${user.id}", "-1"]);
</#if>
<#if (user??&&user.usertype>=10)>
  _czc.push(["_setCustomVar", "专家帐号", "${user.id}", "-1"]);
</#if>
</script>
<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan style='display:none' id='cnzz_stat_icon_1264322583'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s22.cnzz.com/z_stat.php%3Fid%3D1264322583%26show%3Dpic1' type='text/javascript'%3E%3C/script%3E"));</script>

<#-- 百度站长工具，自动推送 -->
<script>
(function(){
    var bp = document.createElement('script');
    bp.async=1;
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp.src = 'https://zz.bdstatic.com/linksubmit/push.js';        
    }
    else {
        bp.src = 'http://push.zhanzhang.baidu.com/push.js';
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>
<#--360站长工具自动抓取脚本-->
<script>
(function(){
   var bp360 = document.createElement('script');
    bp360.async=1;
    bp360.id="sozz";
    var curProtocol = window.location.protocol.split(':')[0];
    if (curProtocol === 'https') {
        bp360.src = 'https://jspassport.ssl.qhimg.com/11.0.1.js?9c3eb1536895fb3db87cc1396f197cd6';
    }
    else {
        bp360.src = 'http://js.passport.qihucdn.com/11.0.1.js?9c3eb1536895fb3db87cc1396f197cd6';        
    }
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp360, s);
})();
</script>
{% } %}
<script>
    window["g_browser"] = (function (navigator) {
        var userAgent = navigator.userAgent,
            temp,
            match = userAgent.match(/(opera|chrome|safari|firefox|msie|trident(?=\/))\/?\s*(\d+)/i) || [],
            match2 = userAgent.match(/Android|BlackBerry|iPhone|iPad|iPod|IEMobile/);

        if (/trident/i.test(match[1])) {
            temp = /\brv[ :]+(\d+)/g.exec(userAgent) || [];
            return {
                browser: 'IE',
                version: temp[1] || ''
            };
        }

        if (match[1] === 'Chrome') {
            temp = userAgent.match(/\bOPR\/(\d+)/);
            if (temp !== null) {
                return {
                    browser: 'Opera',
                    version: temp[1] || ''
                };
            }
        }

        /**针对 Edge**/
        if (match[1] === 'Chrome') {
            temp = userAgent.match(/\bedge\/(\d+)/i);
            if (temp !== null) {
                return {
                    browser: 'IE',
                    version: temp[1] || ''
                };
            }
        }

        match = match[2] ? [match[1], match[2]] : [navigator.appName, navigator.appVersion, '-?'];

        if ((temp = userAgent.match(/version\/(\d+)/i)) !== null) {
            match.splice(1, 1, temp[1]);
        }

        return {
            browser: match[0] === 'MSIE' ? 'IE' : match[0],
            version: match[1],
            mobile: match2 && match2[0]
        };
    })(navigator);

    /* 浏览器不支持 */
    if (window["g_browser"].browser == "IE" && window["g_browser"].version <= 8) {
        window.location.href = "/browser/support";
    }

    /* 适配移动端浏览器 */
    if (window["g_browser"].mobile) {
        setTimeout(function () {
            var oMeta = document.createElement('meta');
            oMeta.name = "viewport";
            oMeta.content = "width=" + window.innerWidth + "px";
            document.getElementsByTagName('head')[0].appendChild(oMeta);
        }, 0);
    }

    /* 数据初始化 */
    window["g_userinfo"] = ${userJson!'{}'};
    window["g_config"]={
        env:'{{env.NODE_ENV}}',
        rabbit:{% if(env.NODE_ENV=='production'){ %}'https://mq.rabbit.huitax.com:15671/stomp'{%}else{%}'http://10.0.101.15:15674/stomp'{%}%},
    	apiUrl:{% if(env.NODE_ENV=='production'){ %}'http://api.huitax.com'{%}else{%}'http://test14.api.huitax.com'{%}%}
    }
</script>
</#macro>

<#-- 页面顶部内容，包含logo和用户信息 -->
<#macro header style="normal" fixed=true showbtns=true showstate=true>
<div class="m-header ${style} ${fixed?string('fixed','')}">
    <div class="content">
        <a class="g-logo_top" href="/"></a>
        <div class="m-header-bar"></div>
        <#if showbtns>
        <div class="m-header-btns"></div>
        </#if>
        <div class="m-header-search"></div>
        <div class="m-header-right">
            <#if showstate>
            <div class="m-header-user"></div>
            </#if>
        </div>
    </div>
</div>
</#macro>

<#macro footer style="normal" simple=false>
<div class="m-footer ${style} ${simple?string('simple','')}">
    <div class="content">
        <#if simple>
        <p>北京中科汇云科技有限公司版权所有©2016-2017  京ICP备17008139号-1</p>
        <#else>
        <div class="infos">
            <div class="logo">中汇旗下财税爱好者的交流平台</div>
            <div class="links">
                <a href="/help" target="_blank" save>叨叨协议</a>
                <a href="/article/post/adfb3b5faaee43f1b5011347d4c40512" target="_blank" save>关于我们</a>
                <a href="mailto:service@huitax.com">service@huitax.com</a>
            </div>
            <div class="desc">北京中科汇云科技有限公司版权所有©2016-2017  京ICP备17008139号-1</div>
        </div>
        <div class="friendly">
            <a>友情链接</a>
            <a href="https://mooc.huitax.com/" target="_blank" save>汇云课堂</a>
            <a href="http://www.chinatax.gov.cn" target="_blank" save>国家税务总局</a>
            <a href="http://www.canet.com.cn" target="_blank" save>中国会计网</a>
            <a href="http://www.e521.com" target="_blank" save>中华财会网</a>
            <a href="http://www.xue-kuai-ji.com" target="_blank" save>房地产会计网</a>
            <a href="http://www.firstacc.cn" target="_blank" save>第一会计网</a>
            <a href="http://www.topcfo.net" target="_blank" save>首席财务官</a>
            <a href="http://www.cicpa.org.cn" target="_blank" save>中国注册会计师协会</a>
            <a href="http://www.zhcpa.cn" target="_blank" save>中汇会计师事务所</a>
            <a href="http://www.zxxk.com" target="_blank" save>学科网</a>
            <a href="http://www.51job.com" target="_blank" save>前程无忧</a>
            <a href="http://ts.zhaopin.com/jump/index.html" target="_blank" save>智联招聘</a>
            <a href="http://www.shixiseng.com" target="_blank" save>实习僧</a>
            <a href="http://www.yingjiesheng.com" target="_blank" save>应届生</a>
        </div>
        <div class="qrcode">关注微信公众号<div class='img'></div></div>
        </#if>
    </div>
    <div class="m-footer-float"></div>
</div>
</#macro>


