package com.cerbon.queen_bee;

import com.cerbon.queen_bee.config.QBCommonConfigs;
import com.cerbon.queen_bee.entity.QBEntities;
import com.cerbon.queen_bee.item.QBCreativeModeTabs;
import com.cerbon.queen_bee.item.QBItems;
import com.cerbon.queen_bee.loot.QBLootModifiers;
import com.cerbon.queen_bee.util.QBConstants;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.NotNull;

@Mod(QBConstants.MOD_ID)
public class QueenBeeMod {
    public QueenBeeMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::addCreativeTab);

        QBCreativeModeTabs.register(modEventBus);
        QBItems.register(modEventBus);
        QBEntities.register(modEventBus);
        QBLootModifiers.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, QBCommonConfigs.SPEC, QBConstants.COMMON_CONFIG_NAME);
    }

    private void addCreativeTab(@NotNull BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == QBCreativeModeTabs.QUEEN_BEE_TAB.get()){
            event.accept(QBItems.STINGER);
            event.accept(QBItems.QUEEN_BEE_SPAWN_EGG);
            event.accept(QBItems.STINGER_SWORD);
            event.accept(QBItems.ANTENNA);
        }
    }
}
