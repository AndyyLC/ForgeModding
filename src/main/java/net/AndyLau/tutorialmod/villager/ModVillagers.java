package net.AndyLau.tutorialmod.villager;

import com.google.common.collect.ImmutableSet;
import net.AndyLau.tutorialmod.TutorialMod;
import net.AndyLau.tutorialmod.block.ModBlocks;
import net.AndyLau.tutorialmod.block.custom.Speed_Block;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.spongepowered.tools.obfuscation.ObfuscationEnvironment;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, TutorialMod.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, TutorialMod.MOD_ID);

    public static final RegistryObject<PoiType> SPEED_BLOCK_POI = POI_TYPES.register("speed_block_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SPEED_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1,1));


    public static void registerPOIs() {



        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, SPEED_BLOCK_POI.get());
        } catch(InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventbus) {
        POI_TYPES.register(eventbus);
        VILLAGER_PROFESSIONS.register(eventbus);
    }
}
