package com.technode.terrafirmastuff;

import com.technode.terrafirmastuff.core.proxy.IProxy;
import com.technode.terrafirmastuff.core.ModDetails;
import com.technode.terrafirmastuff.core.handler.ConfigurationHandler;
import com.technode.terrafirmastuff.core.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModDetails.ModID, name = ModDetails.ModName, version = ModDetails.ModVersion, guiFactory = ModDetails.GUI_FACTORY_CLASS)
public class TerraFirmaStuff
{
    @Instance(ModDetails.ModID)
    public static TerraFirmaStuff instance;
  //  public static final String AssetPath = "/assets/" + ModDetails.ModID + "/";
    //public static final String AssetPathGui = "textures/gui";

    @SidedProxy(clientSide = ModDetails.CLIENT_PROXY_CLASS, serverSide = ModDetails.SERVER_PROXY_CLASS)
    public static IProxy proxy;

 //   public File getMinecraftDirectory() { return proxy.getMinecraftDirectory(); }

    @EventHandler
    public void preInitialize(FMLPreInitializationEvent e)
    {
        instance = this;
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
        LogHelper.info("Pre Initialization Complete");
    }

    @EventHandler
    public void initialize(FMLInitializationEvent e)
    {
        LogHelper.info("Initialization Complete");
    }

    @EventHandler
    public void postInitialize(FMLPostInitializationEvent e)
    {
        LogHelper.info("Post Initialization Complete");
    }
}