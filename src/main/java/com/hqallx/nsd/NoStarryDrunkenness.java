package com.hqallx.nsd;

import com.hqallx.nsd.command.RemoveStarryDrunkennessCommand;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * No Starry Drunkenness：阻止食用 Enigmatic Legacy 的天体果实后被 Enigmatic Delicacy
 * 施加「星辉酩酊」（enigmaticdelicacy:astral_drunkenness），并提供 /removesd 命令强制移除该效果。
 * <p>
 * 核心逻辑通过 Mixin 注入 Enigmatic Delicacy 的处理器实现，见 {@code com.hqallx.nsd.mixin} 包。
 */
@Mod(NoStarryDrunkenness.MODID)
public class NoStarryDrunkenness {

    public static final String MODID = "nsd";

    private static final Logger LOGGER = LogUtils.getLogger();

    public NoStarryDrunkenness(FMLJavaModLoadingContext context) {
        MinecraftForge.EVENT_BUS.register(this);
        LOGGER.debug("No Starry Drunkenness loaded");
    }

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        RemoveStarryDrunkennessCommand.register(event.getDispatcher());
    }
}