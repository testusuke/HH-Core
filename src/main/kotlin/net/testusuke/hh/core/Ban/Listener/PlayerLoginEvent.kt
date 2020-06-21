package net.testusuke.hh.core.Ban.Listener

import com.maxmind.geoip2.DatabaseReader
import com.maxmind.geoip2.model.CityResponse
import net.testusuke.hh.core.Ban.BanMain.Companion.banMain
import net.testusuke.hh.core.Ban.DataBase.BanDataBase
import net.testusuke.hh.core.Main.Companion.plugin
import net.testusuke.hh.core.Permission
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerLoginEvent
import java.io.File
import java.net.InetAddress

object PlayerLoginEvent:Listener {

    @EventHandler
    fun onLogin(e:PlayerLoginEvent){
        val player = e.player
        val name = player.name
        val uuid = player.uniqueId.toString()
        val ip = e.address
        val hostName = e.hostname
        //  Check
        if(banMain.banData!!.uuidBanMap.containsKey(uuid)){

        }

        showPlayerInfo(player,name,uuid,ip,hostName)

    }

    private fun showPlayerInfo(player: Player, name: String, uuid: String, ip: InetAddress, hostName: String) {
        val file = File(plugin.dataFolder,"/GeoLite2-City.mmdb")
        val dbr = DatabaseReader.Builder(file).build()
        val cityResponse = dbr.city(ip)
        val country = cityResponse.country.name
        val msg = """
                    §c===================================
                    player information
                    mcid: $name
                    uuid: $uuid
                    ip: $ip
                    country: $country
                    §c===================================
                """.trimIndent()
        Bukkit.broadcastMessage(msg)
        for (p in Bukkit.getOnlinePlayers()){
            if(p.hasPermission(Permission.admin)){
                p.sendMessage(msg)
            }
        }
    }
}