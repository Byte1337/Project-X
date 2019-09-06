package me.projectx.module.impl.render.Hud;

import me.projectx.ClientBase;
import me.projectx.module.Module;
import me.projectx.module.impl.render.hud;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class hudGui extends GuiIngame {

    public hudGui(Minecraft mcIn) {
        super(mcIn);
    }

    public void renderGameOverlay(float partialTicks) {
        super.renderGameOverlay(partialTicks);
        ScaledResolution scaledresolution = new ScaledResolution(ClientBase.mc);
        ClientBase.mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();

        int count = 0;
    
        
        if (ClientBase.moduleHandler.getModule("HUD").isEnabled()) {
            for(Module module : ClientBase.moduleHandler.getActivatedModuleList()) {
                if (module.getCategory().equals(Module.Category.NONE) && !hud.showNone) continue;
                ClientBase.mc   .fontRendererObj.drawString(module.getSettingName(), scaledresolution.getScaledWidth() - ClientBase.mc.fontRendererObj.getStringWidth(module.getSettingName()) - 1, count * 10, 0x40036b);
                count++;
            }
        }
       // if @OnRender
        	

    }

}
