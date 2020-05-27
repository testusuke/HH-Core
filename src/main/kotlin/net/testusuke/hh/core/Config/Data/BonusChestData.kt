package net.testusuke.hh.core.Config.Data

import net.testusuke.hh.core.Main
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

class BonusChestData(private val main:Main) {
    private lateinit var file:File
    private var config = YamlConfiguration()

    //  変数
    var base64 = ""

    init {

        //  create file
        try {
            val pluginDirectory = main.dataFolder
            if(!pluginDirectory.exists())pluginDirectory.mkdir()
            val dataDirectory = File(pluginDirectory,"/data/")
            if(!dataDirectory.exists())dataDirectory.mkdir()
            //  config file
            file = File(dataDirectory, "bonuschest.yml")
            if(file.exists())file.createNewFile()
            //  Load
            config = YamlConfiguration.loadConfiguration(file)
        }catch (e:IOException){
            e.printStackTrace()
        }
        loadData()
    }

    private fun saveConfig(){
        try {
            config.save(file)
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    private fun getConfig():YamlConfiguration{
        return config
    }

    fun loadData(){
        main.logger.info("BonusChestのアイテムリストを読み込みます。")
        base64 = config.getString("item").toString()
        main.logger.info("BonusChest.item: $base64")
    }

    fun saveData(){
        config.set("item",base64)
        saveConfig()
        main.logger.info("Save Bonus Item List. Base64: $base64")
    }

}