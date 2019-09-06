package me.projectx.Utilities;

import me.projectx.event.events.EventMove;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovementInput;

public class EntityUtils {
    private static Minecraft mc = Minecraft.getMinecraft();

    public static void setMoveSpeed(EventMove event, double speed) {
        double forward = (double) MovementInput.moveForward;
        double strafe = (double)MovementInput.moveStrafe;
        float yaw = mc.thePlayer.rotationYaw;
        if(forward == 0.0D && strafe == 0.0D) {
            event.x = 0.0D;
            event.z = 0.0D;
        } else {
            if(forward != 0.0D) {
                if(strafe > 0.0D) {
                    yaw += (float)(forward > 0.0D?-45:45);
                } else if(strafe < 0.0D) {
                    yaw += (float)(forward > 0.0D?45:-45);
                }

                strafe = 0.0D;
                if(forward > 0.0D) {
                    forward = 1.0D;
                } else if(forward < 0.0D) {
                    forward = -1.0D;
                }
            }
            event.x = forward * speed * Math.cos(Math.toRadians((double)(yaw + 90.0F))) + strafe * speed * Math.sin(Math.toRadians((double)(yaw + 90.0F)));
            event.z = forward * speed * Math.sin(Math.toRadians((double)(yaw + 90.0F))) - strafe * speed * Math.cos(Math.toRadians((double)(yaw + 90.0F)));
        }

    }
}
