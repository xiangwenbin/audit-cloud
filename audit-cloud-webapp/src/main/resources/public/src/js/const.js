export default {
    PATTERN:{
        mobile:/^1((3[0-9])|(4[57])|(5[0-35-9])|(7[0135678])|(8[0-9]))\d{8}$/,
        email:/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/,
        //匹配中文，英文字母和数字及_-:
        nickname:/^[\u4e00-\u9fa5_\-a-zA-Z0-9]{2,20}$/,
        //匹配中文，英文字母:
        realname:/^[\u4e00-\u9fa5]{1,8}$|^[\sA-Za-z]{1,16}$/,
        //匹配英文字母和数字及_-:
        domainname:/^[\w\-]{4,30}$/,
        //中文，英文，数字，括号
        circlename:/^[\u4e00-\u9fa5_\-a-zA-Z0-9\（\）\(\)]{2,10}$/
    },

    OW365ID: 12710,

    // 官方圈子
    OFFICIALGROUP: 21
}
