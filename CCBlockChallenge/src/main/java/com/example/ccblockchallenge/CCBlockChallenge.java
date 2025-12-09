package com.example.ccblockchallenge;

import org.bukkit.Bukkit;
import org.bukkit.boss.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.*;
import org.bukkit.event.block.BlockBreakEvent;

public class CCBlockChallenge extends JavaPlugin implements Listener {

    private int goal = 1000;
    private int broken = 0;
    private BossBar bar;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        bar = Bukkit.createBossBar("§6§lBLOCKS TO BREAK", BarColor.YELLOW, BarStyle.SOLID);
        bar.setVisible(true);
        Bukkit.getOnlinePlayers().forEach(bar::addPlayer);
        updateBar();
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        broken++;
        updateBar();
    }

    private void updateBar() {
        double progress = Math.min(1.0, (double) broken / goal);
        bar.setProgress(progress);
        bar.setTitle("§6§lBLOCKS TO BREAK
§e" + broken + "/" + goal);
    }
}
