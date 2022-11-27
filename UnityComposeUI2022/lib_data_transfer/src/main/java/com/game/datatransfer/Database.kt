package com.game.datatransfer

import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class PigGame:RealmObject{
    @PrimaryKey
    var data_guid: Int=0
    var data_json:String = ""
}

object Database {
    val config = RealmConfiguration.Builder(schema = setOf(PigGame::class))
        .build()
    val realm: Realm = Realm.open(config)
    //
    var data_guid_101 = 101
    fun InsertDefault(){
        var count = GetCount()
        if (count == 0) {
            realm.writeBlocking {
                copyToRealm(PigGame().apply {
                    data_guid = data_guid_101
                    data_json = "unity data"
                })
            }
        }
        //database path
        var path = realm.configuration.path
        println("数据库路径=")
        println(path)
    }

    fun GetCount():Int{
        val items: RealmResults<PigGame> = realm.query<PigGame>("data_guid == $0", data_guid_101).find()
        if (items == null){
            return 0
        }

        return  items.count()
    }

    fun UnityGameUpdate(data_json:String){
        var id = 101
        realm.writeBlocking {
            // fetch a frog from the realm by primary key
            val frog: PigGame? =this.query<PigGame>("data_guid == $0", id).first().find()
            // modify the frog's age in the write transaction to persist the new age to the realm
            frog?.data_json = data_json
        }
    }

    fun GetInfo():String{
        // all items in the realm
        val items: RealmResults<PigGame> = realm.query<PigGame>("data_guid == $0", data_guid_101).find()
        if (items == null){
            InsertDefault()
            return PigGame().data_json
        }

        if (items.count() > 0){
            var row = items[0]
            return  row.data_json
        }else{
            InsertDefault()
            println("没查询到数据")
            return PigGame().data_json
        }

    }
}

//=/data/user/0/com.gameforce.unitycomposeui2022/files/default.realm