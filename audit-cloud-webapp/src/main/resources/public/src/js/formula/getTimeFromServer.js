import Request from '../util/request';
export default class GetTimeFromServer extends GC.Spread.CalcEngine.Functions.AsyncFunction {
    constructor(options) {
        super("GETTIMEFROMSERVER", 1, 255);
        this.name = "GETTIMEFROMSERVER";
        this.options = options || {};
        // console.log('constructor', options);
    }

    defaultValue() {
        return "Loading...";
    }

    isContextSensitive() {
        return true;
    }
    evaluate() {
        var context = arguments[0];
        Request.get("/spread/getLongTime").then((_result) => {
            if (_result.code == 200) {
                if (_result.data) {

                    context.setAsyncResult(_result.data);
                    var sheetName = context.ctx.source.getName();
                    // context.source.getSheet(sheetName)
                    var sheet = context.ctx.source.getSheet(sheetName);
                    console.log(sheet);
                    // console.log(this.options.sheet);
                    // console.log(context);
                }

            } else {

            }
        }).catch((error) => {
            console.log(error);
        });
    }

};