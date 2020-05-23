package net.testusuke.hh.core.Command

import net.testusuke.hh.core.Main.Companion.mode
import net.testusuke.hh.core.Main.Companion.moduleData
import net.testusuke.hh.core.Main.Companion.plugin
import net.testusuke.hh.core.Main.Companion.prefix
import net.testusuke.hh.core.Permission
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object CoreCommand:CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if(sender !is Player || !sender.hasPermission(Permission.general))return false

        if(args.isEmpty()){
            sendHelp(sender)
            return true
        }

        when(args[0]){
            "help" -> sendHelp(sender)

            "reload" -> {
                if(!hasAdmin(sender)){
                    sendNotPermission(sender)
                    return false
                }
                plugin.saveMode()
                plugin.reloadConfig()
                plugin.loadMode()
                moduleData.loadData()
                sender.sendMessage("${prefix}§aコンフィグを再読み込みしました。")
            }
            "on" -> {
                if (!hasAdmin(sender)) {
                    sendNotPermission(sender)
                    return false
                }
                if (mode) {
                    sender.sendMessage("${prefix}§cすでに有効です。")
                    return true
                }
                mode = true
                sender.sendMessage("${prefix}§a有効になりました。")
                return true
            }
            "off" -> {
                if (!hasAdmin(sender)) {
                    sendNotPermission(sender)
                    return false
                }
                if (!mode) {
                    sender.sendMessage("${prefix}§cすでに無効です。")
                    return true
                }
                mode = false
                sender.sendMessage("${prefix}§a無効になりました。")
                return true
            }

        }
        return false
    }

    private fun hasAdmin(player: Player):Boolean{return player.hasPermission(Permission.admin)}
    private fun sendNotPermission(player: Player){player.sendMessage("${prefix}§c権限がありません。")}

    private fun sendHelp(player: Player){


    }
}