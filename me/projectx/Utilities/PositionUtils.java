package me.projectx.Utilities;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;

public class PositionUtils {
    private double x;
    private double y;
    private double z;
    private float yaw;
    private float pitch;

    public PositionUtils(double x, double y, double z, float yaw, float pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public PositionUtils(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0F;
        this.pitch = 0.0F;
    }

    public PositionUtils(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = 0.0F;
        this.pitch = 0.0F;
    }

    public PositionUtils add(int x, int y, int z) {
        this.x += x;
        this.y += y;
        this.z += z;

        return this;
    }

    public PositionUtils add(double x, double y, double z) {
        this.x += x;
        this.y += y;
        this.z += z;

        return this;
    }

    public PositionUtils subtract(int x, int y, int z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;

        return this;
    }

    public PositionUtils subtract(double x, double y, double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;

        return this;
    }

    public net.minecraft.block.Block getBlock() {
        return Minecraft.getMinecraft().theWorld.getBlockState(toBlockPos()).getBlock();
    }

    public double getX() {
        return this.x;
    }

    public PositionUtils setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return this.y;
    }

    public PositionUtils setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return this.z;
    }

    public PositionUtils setZ(double z) {
        this.z = z;
        return this;
    }

    public float getYaw() {
        return this.yaw;
    }

    public PositionUtils setYaw(float yaw) {
        this.yaw = yaw;
        return this;
    }

    public float getPitch() {
        return this.pitch;
    }

    public PositionUtils setPitch(float pitch) {
        this.pitch = pitch;
        return this;
    }

    public static PositionUtils fromBlockPos(BlockPos blockPos) {
        return new PositionUtils(blockPos.getX(), blockPos.getY(), blockPos.getZ());
    }

    public BlockPos toBlockPos() {
        return new BlockPos(getX(), getY(), getZ());
    }
}