package com.example.quranua.Model

class Sura() {
    var suraindex:Int?=null
    var suraname:String?=null
    var translation:String?=null
    var nameeng:String?=null
    var count:Int?=null
    var verses:ArrayList<Verse>?=null

    constructor(suraindex: Int?, suraname: String?, translation: String?, nameeng:String?, count: Int?, verses: ArrayList<Verse>?):this() {
        this.suraindex = suraindex
        this.suraname = suraname
        this.translation = translation
        this.nameeng=nameeng
        this.count = count
        this.verses = verses
    }

}