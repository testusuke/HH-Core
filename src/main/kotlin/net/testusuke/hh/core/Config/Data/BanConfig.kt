package net.testusuke.hh.core.Config.Data

import net.testusuke.hh.core.Ban.BanMain
import net.testusuke.hh.core.Main
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

class BanConfig(private val main:Main,private val banMain: BanMain) {

    private lateinit var file: File
    private var config = YamlConfiguration()

    init {

        //  create file
        try {
            val pluginDirectory = main.dataFolder
            if(!pluginDirectory.exists())pluginDirectory.mkdir()
            val dataDirectory = File(pluginDirectory,"/data/")
            if(!dataDirectory.exists())dataDirectory.mkdir()
            //  config file
            file = File(dataDirectory, "ban.yml")
            if(file.exists())file.createNewFile()
            //  Load
            config = YamlConfiguration.loadConfiguration(file)
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    private fun saveConfig(){
        try {
            config.save(file)
        }catch (e: IOException){
            e.printStackTrace()
        }
    }

    private fun getConfig(): YamlConfiguration {
        return config
    }

    fun loadMode(){
        banMain.mode = config.getBoolean("mode")
    }

    fun saveMode(){
        config.set("mode",banMain.mode)
        saveConfig()
    }
}