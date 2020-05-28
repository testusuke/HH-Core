package net.testusuke.hh.core.Ban.DataBase

import net.testusuke.hh.core.Main
import java.sql.SQLException
import java.sql.Statement
import kotlin.collections.ArrayList

class BanData(private val main: Main) {

    private var banList = ArrayList<String>()

    init {

    }

    //  Create Table
    //  sql
    val createTableSql = "create table banlist\n" +
            "(\n" +
            "\tname varchar null,\n" +
            "\tuuid varchar not null,\n" +
            "\taddress varchar not null,\n" +
            "\tdate datetime not null\n" +
            ");"
    private fun createTable(){
        var connection = main.dataBase.getConnection()
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

}