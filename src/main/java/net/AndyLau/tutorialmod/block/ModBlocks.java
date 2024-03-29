package net.AndyLau.tutorialmod.block;

import net.AndyLau.tutorialmod.TutorialMod;
import net.AndyLau.tutorialmod.block.custom.Crop_Block;
import net.AndyLau.tutorialmod.block.custom.Lamp_Block;
import net.AndyLau.tutorialmod.block.custom.Speed_Block;
import net.AndyLau.tutorialmod.item.ModItems;
import net.AndyLau.tutorialmod.item.ModeCreativeModTab;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock("zircon_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,5)),ModeCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> SPEED_BLOCK = registerBlock("speed_block",
            () -> new Speed_Block(BlockBehaviour.Properties.of(Material.STONE).strength(6f).requiresCorrectToolForDrops()),
                    ModeCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> LAMB_BLOCK = registerBlock("lamb_block",
            () -> new Lamp_Block(BlockBehaviour.Properties.of(Material.GLASS).strength(6f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(Lamp_Block.LIT) ? 15 : 0)),
            ModeCreativeModTab.TUTORIAL_TAB);

    public static final RegistryObject<Block> CROP_BLOCK = BLOCKS.register("crop_block",
            () -> new Crop_Block(BlockBehaviour.Properties.copy(Blocks.CARROTS)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static  <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                             CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }


}
