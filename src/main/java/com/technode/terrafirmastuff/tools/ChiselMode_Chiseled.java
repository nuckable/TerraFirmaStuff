package com.technode.terrafirmastuff.tools;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.Tools.ChiselMode;
import com.technode.terrafirmastuff.block.BlockBase;
import com.technode.terrafirmastuff.core.ModBlocks;
import com.technode.terrafirmastuff.core.ModDetails;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ChiselMode_Chiseled extends ChiselMode {
    //private static String name;
    private static ResourceLocation resourcelocation = new ResourceLocation(ModDetails.ModID, ModDetails.AssetPathGui + "icons.png");
    private static int textureU, textureV, div;

    public ChiselMode_Chiseled(String n){
        //name = n;
        textureU = 0;
        textureV = 0;
        div = 1;
    }

    @Override
    public ResourceLocation getResourceLocation(){
        return resourcelocation;
    }

    @Override
    public int getTextureU(){
        return textureU;
    }

    @Override
    public int getTextureV(){
        return textureV;
    }

    @Override
    public int getDivX(Block block)
    {
        if(block instanceof BlockBase){
            return div;
        }
        else {
            return 0;
        }
    }

    @Override
    public int getDivY(Block block){
        if(block instanceof BlockBase){
            return div;
        }
        else {
            return 0;
        }
    }

    @Override
    public int getDivZ(Block block){
        if(block instanceof BlockBase){
            return div;
        }
        else {
            return 0;
        }
    }

    @Override
    public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ)
    {
        if(TFC_Core.isNaturalStone(world.getBlock(x, y, z)) && TFC_Core.isNaturalStone(world.getBlock(x, y + 1, z)) && TFC_Core.isNaturalStone(world.getBlock(x, y+2, z))) {
            return false;
        }

        if (world.getBlock(x, y, z) == ModBlocks.clayStained || world.getBlock(x, y, z) == ModBlocks.clayStained2 || world.getBlock(x, y, z) == ModBlocks.mineralBlock) {

            int hasChisel = hasChisel(player);
            if (hasChisel >= 0) {
                if (id == ModBlocks.clayStained) {
                    if (meta < 4) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.clayStainedChiseled, (shiftedMeta | b0), 0x2);
                    } else if (meta < 8) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.clayStainedChiseled2, (shiftedMeta | b0), 0x2);
                    } else if (meta < 12) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.clayStainedChiseled3, (shiftedMeta | b0), 0x2);
                    } else if (meta < 16) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.clayStainedChiseled4, (shiftedMeta | b0), 0x2);
                    }
                } else if (id == ModBlocks.clayStained2) {
                    if (meta < 1) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.clayStainedChiseled5, (shiftedMeta | b0), 0x2);
                    }
                } else if (id == ModBlocks.mineralBlock) {
                    if (meta < 4) {
                        int shiftedMeta = meta & 3;
                        byte b0 = 0;

                        switch (side) {
                            case 0:
                            case 1:
                                b0 = 0;
                                break;
                            case 2:
                            case 3:
                                b0 = 8;
                                break;
                            case 4:
                            case 5:
                                b0 = 4;
                        }
                        world.setBlock(x, y, z, ModBlocks.mineralChiseled, (shiftedMeta | b0), 0x2);
                    }
                }
                player.inventory.mainInventory[hasChisel].damageItem(1, player);
                return true;
            }
        }
        return false;
    }
}