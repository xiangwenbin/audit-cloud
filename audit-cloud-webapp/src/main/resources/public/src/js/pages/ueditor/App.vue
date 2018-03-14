<template>
	<div class="m-index">
        <input type="button" @click="onPublished" value="保存"/>
		<div class="editor-wrap">
            <div id="editor"></div>
        </div>
	</div>
</template>

<script>
	import _ from "lodash";
	import EventBus from "../../eventBus";

   
	export default {
		props: ["options"],
		data () {
			return {
			};
		},
		mounted () {
             this.editor = UE.getEditor('editor');
		},
		computed: {
		},
		methods: {
             onPublished () {
                var _html=this.editor.getContent();
                console.log(_html);
                this.$request.post("/richtext/save", _.assign({html:_html},{}),{
                }).then((_result) => {
                    if(_result.code==200){
                        if(_result.data){
                        }
                        
                    }else{
                        this.$message({
                            message: _result.msg,
                            duration:2000
                        });
                    }
                }).catch((error)=>{
                    this.$message({
                        message: error.msg,
                        duration:2000,
                        type:'error'
                    });
                });
            }
		},
		components: {
		}
	}
</script>
