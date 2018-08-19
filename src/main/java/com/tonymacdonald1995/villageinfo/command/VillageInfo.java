package com.tonymacdonald1995.villageinfo.command;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.village.Village;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class VillageInfo implements ICommand {

    List<String> aliases = new ArrayList<String>();

    public VillageInfo() {
        aliases.add("villageinfo");
        aliases.add("vi");
    }

    @Override
    public String getName() {
        return "villageinfo";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/villageinfo";
    }

    @Override
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        World world = sender.getEntityWorld();
        BlockPos position = sender.getPosition();
        Village nearestVillage = world.getVillageCollection().getNearestVillage(position, 64);
        if(nearestVillage != null) {
            double numDoors = nearestVillage.getNumVillageDoors();
            double numVillagers = nearestVillage.getNumVillagers();
            double villagersToDoors = numVillagers / numDoors;
            String villagersToDoorsStr = String.format("%.0f", villagersToDoors * 100);
            sender.sendMessage(new TextComponentString("Number of doors: ".concat(String.format("%.0f", numDoors))));
            sender.sendMessage(new TextComponentString("Number of villagers: ".concat(String.format("%.0f" ,numVillagers))));
            sender.sendMessage(new TextComponentString("Percentage of villagers to doors: ".concat(villagersToDoorsStr.concat("%"))));
        }

    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
