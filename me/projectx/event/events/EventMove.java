package me.projectx.event.events;

import me.projectx.event.Event;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;

public class EventMove extends Event {
    private Minecraft mc = Minecraft.getMinecraft();

    public double x;
    public double y;
    public double z;

    public EventMove(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private double a() {
        return mc.thePlayer.isSprinting() ? .2806D : .21585D;
    }

    public double b() {
        if(!mc.thePlayer.isPotionActive(Potion.absorption.moveSpeed)) {
            return a();
        } else {
            double var10000 = a() * 1.0D;
            return var10000 + 0.06D * (double)(mc.thePlayer.getActivePotionEffect(Potion.moveSpeed).getAmplifier() + 1);
        }
    }
}
