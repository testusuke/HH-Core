package net.testusuke.hh.core.Ban.Command

import net.testusuke.hh.core.Main.Companion.plugin
import net.testusuke.hh.core.Main.Companion.prefix
import net.testusuke.hh.core.Permission
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object BanCommand:CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args : Array<out String>): Boolean {
        if(sender !is Player || !sender.hasPermission(Permission.admin))return false

        if(args.isEmpty()){
            sendHelp(sender)
            return true
        }

        when(args[0]){
            "help" -> sendHelp(sender)
            "on" -> changeMode(sender,true)
            "off" -> changeMode(sender,false)
            "ban" -> {
                if(args.size != 2){
                    sender.sendMessage("${prefix}§c使い方が不正です。")
                    sendHelp(sender)
                    return false
                }
                val name = args[1]
                val offlinePlayer = Bukkit.getOfflinePlayer(name)
                val uuid = offlinePlayer.uniqueId.toString()
                //  SendMessage
                sender.sendMessage("${prefix}§6${name}§aの情報を問い合わせています... §6uuid: $uuid")

            }
            "unban" -> {
                if(args.size != 2){
                    sender.sendMessage("${prefix}§c使い方が不正です。")
                    sendHelp(sender)
                    return false
                }
                val name = args[1]
                val offlinePlayer = Bukkit.getOfflinePlayer(name)
                val uuid = offlinePlayer.uniqueId.toString()
                //  SendMessage
                sender.sendMessage("${prefix}§6${name}§aの情報を問い合わせています... §6uuid: $uuid")

            }
        }
        return false
    }

    private fun sendHelp(player: Player){

    }

    private fun changeMode(player: Player,boolean: Boolean){
        if(plugin.banMain.mode  == boolean){
            player.sendMessage("${prefix}§cすでに${boolean}になっています。")
        }
        plugin.banMain.mode = boolean
        player.sendMessage("${prefix}§aBan機能を${boolean}に変更しました。")
    }

}