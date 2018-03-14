<template>
	<div class="m-index">
        <input type="button" @click="onSave" value="保存"/>
        <input type="button" @click="onReload" value="重新加载"/>
        <div id="formulaBar" contenteditable="true" spellcheck="false" style="border: 1px solid #808080;width:100%;"></div>
        <div id="ss" style="width:100%; height:360px;border: 1px solid gray;"></div>
	</div>
</template>

<script>
	import _ from "lodash";
    import pako from 'pako';
	import EventBus from "../../eventBus";
    import Request from '../../util/request'; 
    import GetTimeFromServer from '../../formula/getTimeFromServer'; 
    
    // function GetTimeFromServer() {
    
    // }
    
    // GetTimeFromServer.prototype = new GC.Spread.CalcEngine.Functions.AsyncFunction("GetTimeFromServer", 1, 255);
    // GetTimeFromServer.prototype.defaultValue = function () { return "Loading..."; };
    // GetTimeFromServer.prototype.isContextSensitive = function () {
    //     return true;
    // }
    // GetTimeFromServer.prototype.evaluate = function (context) {
    //     var args = arguments;
    //     Request.get("/spread/getLongTime").then((_result) => {
    //             if(_result.code==200){
    //                 if(_result.data){

    //                     context.setAsyncResult(_result.data);
    //                     var sheetName = context.ctx.source.getName();
    //                     var sheet = context.ctx.source.getSheet(sheetName);

    //                     console.log(sheet);
    //                 }
                    
    //             }else{
                   
    //             }
    //         }).catch((error)=>{
    //             console.log(error);
    //     });
      
    // }
    
    // 设置全局公式
    GC.Spread.CalcEngine.Functions.defineGlobalCustomFunction("GETTIMEFROMSERVER", new GetTimeFromServer());
	export default {
		props: ["options"],
		data () {
			return {
			};
		},
		mounted () {
            
            // var spread = new GC.Spread.Sheets.Workbook(document.getElementById('ss'), { sheetCount: 1 });
            // var sheet = spread.getActiveSheet();
            // sheet.setValue(1, 1, "=GetTimeFromServer()");
            // sheet.setFormula(2, 2, "=GetTimeFromServer()");
            
            this.spread = new GC.Spread.Sheets.Workbook(document.getElementById("ss"),{sheetCount:3});
            // this.fbx = new GC.Spread.Sheets.FormulaTextBox.FormulaTextBox(document.getElementById('formulaBar'));
            // this.fbx.workbook(this.spread);
            // var sheet=spread.sheets[0];
           
            // spread.addCustomFunction(new GetTimeFromServer());
            // /kemuyuebiao.ssjson
            // /spread/gzip/kemuyuebiao.ssjson
            // /gzip/yingshoulixi.ssjson
            // /spread/yingshoulixi.ssjson"
            
            this.$request.get("/spread/gzip/yingshoulixi.ssjson").then((_result) => {
                    if(_result.code==200){
                        if(_result.data){
                            this.spread.suspendPaint();
                            // var _data=JSON.stringify(_result.data);
                            // _data=_data.replace("获取服务器时间(","=GETTIMEFROMSERVER(")
                            // spread.fromJSON(_result.data);
                            var time=new Date().getTime();
                            this.spread.fromJSON(_result.data);
                            console.log(new Date().getTime()-time,"ms");
                            // for(var index in spread.sheets){
                            //     //设置局部公式
                            //     spread.sheets[index].addCustomFunction(new GetTimeFromServer());
                            // }
                            this.spread.resumePaint();
                            // window.setTimeout(()=>{
                            //     spread.refresh();
                            // },2000)
                        }
                        
                    }else{
                    
                    }
                }).catch((error)=>{
                    console.log(error);
            });
           
		},
		computed: {
		},
		methods: {
            onSave () {
                var serializationOption = {
                    ignoreFormula: true, // indicate to ignore the style when convert workbook to json, default value is false
                    ignoreStyle: true, // indicate to ignore the formula when convert workbook to json, default value is false
                    rowHeadersAsFrozenColumns: false, // indicate to treat the row headers as frozen columns when convert workbook to json, default value is false
                    columnHeadersAsFrozenRows: false // indicate to treat the column headers as frozen rows when convert workbook to json, default value is false
                }
                this.jsonString = JSON.stringify(this.spread.toJSON(serializationOption)); 
                pako
                var binaryString = pako.gzip(this.jsonString, {});
                console.log(binaryString);
                this.$request.post("/spread/save", binaryString,{
                    headers: {
                        'Content-Type': 'application/octet-stream'
                    }
                }).then((_result) => {
                    if(_result.code==200){
                        if(_result.data){
                            console.log(_result.data);
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
            },
            onReload () {
                this.spread.suspendPaint();
                this.spread.fromJSON(JSON.parse(this.jsonString));
                this.spread.resumePaint();
            }

		},
		components: {
		}
	}
</script>
