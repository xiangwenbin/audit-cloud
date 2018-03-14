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

    // import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
    import WangeEitor from '../../plugin/wangeditor/dist/js/wangEditor.js';
    import FontSize from '../../plugin/editor/fontSize.js';
    WangeEitor.config.fontsizes = {
        // 格式：'value': 'title'
        3: '16px',
        4: '18px',
        5: '24px',
        6: '32px'
    };
    WangeEitor.config.menus = [
        'bold',
        'underline',
        'italic',
        'strikethrough',
        'eraser',
        'forecolor',
        'bgcolor',
        '|',
        'head',
        'fontsizeX',
        'alignleft',
        'aligncenter',
        'alignright',
        '|',
        'link',
        'unlink',
        '|',
        'table',
        '|',
        'undo',
        'redo',
        'fullscreen'
    ];
    WangeEitor.config.menuFixed = 50;
    //上传图片接口
    wangEditor.config.printLog = false;
    WangeEitor.config.uploadImgUrl="/upload/image";
    WangeEitor.config.hideLinkImg = true;
    WangeEitor.config.uploadImgFileName = 'image';
    WangeEitor.config.pasteFilter = true;
	export default {
		props: ["options"],
		data () {
			return {
			};
		},
		mounted () {
            // ClassicEditor.create( document.querySelector( '#editor' ),{
            //     toolbar: ['justifyleft','justifycenter','justifyright', 'headings', 'bold', 'italic', 'link', 'bulletedList', 'numberedList', 'blockQuote' ],
        
            // } )
            //     .then( editor => {
            //         window.editor = editor;
            //     } )
            //     .catch( err => {
            //         console.error( err.stack );
            //     } );

            this.editor = new WangeEitor('editor');
            this.editor.onchange = ()=>{
                
            };
            this.editor.create();
            
            
           
		},
		computed: {
		},
		methods: {
             onPublished () {
                var _html=this.editor.$txt.html();
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
