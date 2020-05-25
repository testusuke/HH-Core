package net.testusuke.hh.core.Config.Data

import net.testusuke.hh.core.Main
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

class BonusChestData(main:Main) {
    private lateinit var file:File
    private var config = YamlConfiguration()

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

    }

    fun saveConfig(){
        try {
            config.save(file)
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    fun getConfig():YamlConfiguration{
        return config
    }
}