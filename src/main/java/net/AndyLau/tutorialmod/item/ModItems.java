package net.AndyLau.tutorialmod.item;

import net.AndyLau.tutorialmod.TutorialMod;
import net.AndyLau.tutorialmod.block.ModBlocks;
import net.AndyLau.tutorialmod.item.custom.ModItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> TESTITEM = ITEMS.register("testitem",
            () -> new Item(new Item.Properties().tab(ModeCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item>  MODITEM = ITEMS.register("moditem",
            () -> new ModItem(new Item.Properties().tab(ModeCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item>  CROP_SEEDS = ITEMS.register("crop_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CROP_BLOCK.get(), new Item.Properties().tab(ModeCreativeModTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> CROP = ITEMS.register("crop", ()-> new Item(new Item.Properties().tab(ModeCreativeModTab.TUTORIAL_TAB)
            .food(new FoodProperties.Builder().nutrition(2).saturationMod(3f).build())));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
