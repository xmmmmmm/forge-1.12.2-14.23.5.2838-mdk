package com.example.examplemod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Logger;

@Mod(modid = ExampleMod.MODID, name = ExampleMod.NAME, version = ExampleMod.VERSION)
public class ExampleMod
{
    public static final String MODID = "examplemod";
    public static final String NAME = "examplemod";
    public static final String VERSION = "1.0";

    private static Logger logger;

    public static Minecraft minecraft=Minecraft.getMinecraft();


    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS
                .register(new ExampleMod());
    }

    @SubscribeEvent
    public void on(PlayerInteractEvent playerInteractEvent){
        EntityPlayer player=playerInteractEvent.getEntityPlayer();
        System.out.println(player.getName());

        Vec3d vec3d=player.getForward();
        minecraft.effectRenderer.addEffect(new CustomParticle(
                player.world,
                player.getPosition().getX(),
                player.getPosition().getY()+0.5,
                player.getPosition().getZ(),0,0,0));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void textureStitchEventPre(TextureStitchEvent.Pre event)
    {

//        ResourceLocation fire = new ResourceLocation("examplemod:particle/num");
        ResourceLocation fire2 = new ResourceLocation("examplemod:particle/skil4");

//        CustomParticle.largeStarRL1=event.getMap().registerSprite(fire);
        CustomParticle.largeStarRL2=event.getMap().registerSprite(fire2);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {


        // some example code
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
