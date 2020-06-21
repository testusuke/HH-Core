package net.testusuke.hh.core.Ban.DataBase

import net.testusuke.hh.core.Main
import org.bukkit.entity.Player
import org.bukkit.scheduler.BukkitRunnable
import java.sql.SQLException
import java.sql.Statement
import java.util.*
import kotlin.collections.ArrayList

class BanDataBase(private val main: Main) {

    var uuidBanMap:MutableMap<String,BanData> = mutableMapOf()

    init {
        createTable()

    }

    //  Create Table
    //  sql
    private val createTableSql = "create table ban_list\n" +
            "(\n" +
            "\tname varchar null,\n" +
            "\tuuid varchar not null,\n" +
            "\taddress varchar not null,\n" +
            "\tdate datetime not null\n" +
            "\tstatus boolean not null\n"+
            ");"

    private fun createTable(){
        object : BukkitRunnable() {
            override fun run() {
                val connection = main.dataBase.getConnection()
                if(connection == null){
                    main.logger.info("コネクションが不正です。")
                    return
                }
                try{
                    var statement:Statement = connection.createStatement()
                    statement.execute(createTableSql)
                    statement.close()
                }catch (e:SQLException){
                    main.logger.info("tableの作成に失敗")
                    main.logger.info("sql: $createTableSql")
                }
                connection.close()
            }
        }.runTaskAsynchronously(main)
    }

    fun isBanned(uuid: String):Boolean {

        return false
    }

    fun loadPlayerData(uuid:String):BanData?{
        val sql = "SELECT * FROM ban_list WHERE uuid='${uuid}';"
        val connection = main.dataBase.getConnection() ?: return null
        val statement:Statement = connection.createStatement()
        val resultSet = statement.executeQuery(sql)
        if(!resultSet.next()) return null
        when(resultSet.next()){

        }
        return null
    }

}