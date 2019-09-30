package com.example.quranua.Model

class Bookmark() {
    var suraname:String?=null
    var suraIndex:Int?=null
    var suraNumber:Int?=null
    var translation:String?=null
    var ayanumber:String?=null
    var ukr:String?=null
    var arab:String?=null
    var loved:String?=null
    constructor(suraname: String?, suraindex:Int, suraNumber:Int, translation:String?, ayanumber: String?, ukr: String?, arab: String?,loved:String):this() {
        this.suraname = suraname
        this.suraIndex=suraindex
        this.suraNumber=suraNumber
        this.translation=translation
        this.ayanumber = ayanumber
        this.ukr = ukr
        this.arab = arab
        this.loved=loved

    }




}