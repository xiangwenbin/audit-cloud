<template>
	<div class="m-empty">
        <slot>这里还木有内容哦</slot>
    </div>
</template>

<script>
	export default {
        name: 'my-empty',
		props: ["value"],
		data () {
			return {};
		}
	}
</script>

<style lang="scss">
	.m-empty {
		color: #8798b5;
	    font-size: 14px;
	    text-align: center;
	    background-image: url(/images/empty.png);
	    background-size: 120px;
	    background-repeat: no-repeat;
	    background-position: center 40px;
	    padding: 160px 20px 80px;
	}
	.m-empty4 {
	    width: 400px;
	    height: 200px;
	    color: #8798b5;
	    font-size: 14px;
	    text-align: center;
	    margin: 100px auto;
	    i {
	        display: inline-block;
	        width: 120px;
	        height: 120px;
	        background-image: url(/images/empty.png);
	        background-size: 120px;
	        background-repeat: no-repeat;
	        margin: 20px auto;
	    }
	}
</style>
