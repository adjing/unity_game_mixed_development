package com.game.datatransfer


class DataTransferStation {

    fun GetInfo(txt: String): String {
        println(txt);
        Database.UnityGameUpdate(txt)
        return "db json-----"
    }

}


//https://github.com/realm/realm-kotlin/
//https://github.com/realm/realm-kotlin-samples

//https://kotlinlang.org/docs/collections-overview.html#map

/*
把Unity game嵌入 android compose
android compose 混合开发

https://blog.csdn.net/weixin_44819566/article/details/122460239
ViewModel

https://www.youtube.com/watch?v=DH82yWilJSk

* */