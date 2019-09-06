package me.projectx.Utilities;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.util.*;

import java.util.Random;

public class AimUtils {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static float[] getAngles(Entity e) {
        return new float[]{getYawChangeToEntity(e) + mc.thePlayer.rotationYaw, getPitchChangeToEntity(e) + mc.thePlayer.rotationPitch};
    }

    public static float[] getRotations(PositionUtils position) {
        double diffX = position.getX() + 0.5D - mc.thePlayer.posX;
        double diffZ = position.getZ() + 0.5D - mc.thePlayer.posZ;
        double diffY = (position.getY() + 0.5D) / 2.0D - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());

        double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
        float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D);

        return new float[]{yaw, pitch};
    }

    public static float[] getRotationsAAC(PositionUtils position) {
        double diffX = position.getX() + 0.5D - mc.thePlayer.posX;
        double diffZ = position.getZ() + 0.5D - mc.thePlayer.posZ;
        double diffY = (position.getY() + 0.5D) / 2.0D - (mc.thePlayer.posY + mc.thePlayer.getEyeHeight());

        double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) * getRandom(-5, 5) - 90.0F;
        float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D) * getRandom(-20, 20);

        return new float[]{yaw, pitch};
    }

    public static int getRandom(int min, int max) {
        return min + new Random().nextInt(max - min);
    }


    public static float[] getRotations(Entity entity) {
        if (entity == null) {
            return null;
        }
        double diffX = entity.posX - mc.thePlayer.posX;
        double diffZ = entity.posZ - mc.thePlayer.posZ;
        double diffY;
        if ((entity instanceof EntityLivingBase)) {
            EntityLivingBase elb = (EntityLivingBase) entity;
            diffY = elb.posY + (
                    elb.getEyeHeight() - 0.4D) - (
                    mc.thePlayer.posY + mc.thePlayer
                            .getEyeHeight());
        } else {
            diffY = (entity.getCollisionBoundingBox().minY + entity.getCollisionBoundingBox().maxY) /
                    2.0D - (
                    mc.thePlayer.posY + mc.thePlayer
                            .getEyeHeight());
        }
        double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        float yaw = (float) (Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
        float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D);

        return new float[]{yaw, pitch};
    }

    public static float[] getRotationsAAC(Entity entity) {
        if (entity == null) {
            return null;
        }
        double diffX = entity.posX - mc.thePlayer.posX;
        double diffZ = entity.posZ - mc.thePlayer.posZ;
        double diffY;
        if ((entity instanceof EntityLivingBase)) {
            EntityLivingBase elb = (EntityLivingBase) entity;
            diffY = elb.posY + (
                    elb.getEyeHeight() - 0.4D) - (
                    mc.thePlayer.posY + mc.thePlayer
                            .getEyeHeight());
        } else {
            diffY = (entity.getCollisionBoundingBox().minY + entity.getCollisionBoundingBox().maxY) /
                    2.0D - (
                    mc.thePlayer.posY + mc.thePlayer
                            .getEyeHeight());
        }
        double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        float yaw = ((float) (Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F) * getRandom(-5, 5);
        float pitch = (float) -(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D) * getRandom(-15, 15);

        return new float[]{yaw, pitch};
    }

    public static float getYawChangeToEntity(Entity entity) {
        double deltaX = entity.posX - mc.thePlayer.posX;
        double deltaZ = entity.posZ - mc.thePlayer.posZ;
        double yawToEntity;
        if ((deltaZ < 0.0D) && (deltaX < 0.0D)) {
            yawToEntity = 90.0D + Math.toDegrees(Math.atan(deltaZ / deltaX));
        } else {
            if ((deltaZ < 0.0D) && (deltaX > 0.0D)) {
                yawToEntity = -90.0D +
                        Math.toDegrees(Math.atan(deltaZ / deltaX));
            } else {
                yawToEntity = Math.toDegrees(-Math.atan(deltaX / deltaZ));
            }
        }

        return
                MathHelper.wrapAngleTo180_float(-(mc.thePlayer.rotationYaw - (float) yawToEntity));
    }

    public static float getPitchChangeToEntity(Entity entity) {
        double deltaX = entity.posX - mc.thePlayer.posX;
        double deltaZ = entity.posZ - mc.thePlayer.posZ;
        double deltaY = entity.posY - 1.6D + entity.getEyeHeight() - 0.4D -
                mc.thePlayer.posY;
        double distanceXZ = MathHelper.sqrt_double(deltaX * deltaX + deltaZ *
                deltaZ);

        double pitchToEntity = -Math.toDegrees(Math.atan(deltaY / distanceXZ));

        return -MathHelper.wrapAngleTo180_float(mc.thePlayer.rotationPitch -
                (float) pitchToEntity);
    }

    public static float[] getBlockRotations(int x, int y, int z, net.minecraft.util.EnumFacing facing) {
        Entity temp = new net.minecraft.entity.projectile.EntitySnowball(mc.theWorld);
        ((EntitySnowball) temp).posX = (x + 0.5D);
        temp.posY = (y + 0.5D);
        temp.posZ = (z + 0.5D);
        return getAngles(temp);
    }

    public static float[] getRotationsBlock(BlockPos pos) {
        Minecraft mc = Minecraft.getMinecraft();
        double d0 = (double)pos.getX() - mc.thePlayer.posX;
        double d1 = (double)pos.getY() - (mc.thePlayer.posY + (double)mc.thePlayer.getEyeHeight());
        double d2 = (double)pos.getZ() - mc.thePlayer.posZ;
        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        float f = (float)(MathHelper.func_181159_b(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
        float f1 = (float)(-(MathHelper.func_181159_b(d1, d3) * 180.0D / 3.141592653589793D));
        return new float[]{f, f1};
    }

    public static EnumFacing getFacingDirection(BlockPos pos) {
        EntityPlayerSP p = mc.thePlayer;
        EnumFacing direction = null;
        if(!mc.theWorld.getBlockState(pos.add(0, 1, 0)).getBlock().isBlockNormalCube())
            direction = EnumFacing.UP;
        else if(!mc.theWorld.getBlockState(pos.add(0, -1, 0)).getBlock().isBlockNormalCube())
            direction = EnumFacing.DOWN;
        else if(!mc.theWorld.getBlockState(pos.add(1, 0, 0)).getBlock().isBlockNormalCube())
            direction = EnumFacing.EAST;
        else if(!mc.theWorld.getBlockState(pos.add(-1, 0, 0)).getBlock().isBlockNormalCube())
            direction = EnumFacing.WEST;
        else if(!mc.theWorld.getBlockState(pos.add(0, 0, 1)).getBlock().isBlockNormalCube())
            direction = EnumFacing.SOUTH;
        else if(!mc.theWorld.getBlockState(pos.add(0, 0, 1)).getBlock().isBlockNormalCube())
            direction = EnumFacing.NORTH;

        MovingObjectPosition rayResult = mc.theWorld.rayTraceBlocks(new Vec3(p.posX, p.posY + (double)p.getEyeHeight(), p.posZ), new Vec3((double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D));
        return rayResult != null && rayResult.getBlockPos() == pos?rayResult.sideHit:direction;
    }
}
