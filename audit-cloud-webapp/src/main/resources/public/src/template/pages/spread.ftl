<@compress single_line=true>
<#escape x as x?html>
<#include "../common/macro.ftl">
<!DOCTYPE html>
<html lang="zh">
<head>
    <@meta/>
	<meta name="spreadjs culture" content="zh-cn" />
	<link href="/dist/static/css/core.css?{{webpack.hash}}" rel="stylesheet" type="text/css"/>
	<link href="/js/spread/css/gc.spread.sheets.11.0.0.css?{{webpack.hash}}" rel="stylesheet" type="text/css"/>
	<@init/>
</head>
<body class="g-doc">
	<div class="g-bd">
	    <div class="app-container"></div>
	</div>
	<#noescape>
	<script>
	</script>
	</#noescape>
	<script type="text/javascript" src="http://127.0.0.1:8081/js/spread/js/gc.spread.sheets.all.11.0.0.min.js?{{webpack.hash}}"></script>
	<script type="text/javascript" src="http://127.0.0.1:8081/js/spread/resources/zh/gc.spread.sheets.resources.zh.11.0.0.min.js?{{webpack.hash}}"></script>
	<script type="text/javascript" src="/dist/static/js/vendor.js?{{webpack.hash}}"></script>
  	<script type="text/javascript" src="/dist/static/js/core.js?{{webpack.hash}}"></script>
  	<script type="text/javascript" src="/dist/static/js/spread.js?{{webpack.hash}}"></script>
</body>
</html>
</#escape>
</@compress>
