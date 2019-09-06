package me.projectx.module.impl.combat;

import me.projectx.ClientBase;
import me.projectx.Utilities.Timer;
import me.projectx.event.EventTarget;
import me.projectx.event.ModuleData;
import me.projectx.event.events.EventTick;
import me.projectx.module.Module;
import me.projectx.module.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Module.Info(
        category = Module.Category.Combat,
        bind = Keyboard.KEY_R,
        name = "Aura"
)
public class Aura extends Module {

    @EventTarget
    public void onTick(EventTick event) {
        this.setSettingName("Randomize");
        this.setSettingName("Switch");
        this.setSettingName("Single");
        this.setSettingName("Resolver");
        this.setSettingName("Tick");
        this.setSettingName("AAC");
    }

    {
    }

    public static EntityLivingBase target, livingplayers, blockTarget;
    public static final String TYPE = "TYPE";
    private final String TARGETMODE = "PRIORITY";
    private final String AUTOBLOCK = "AUTOBLOCK";
    private final String RANGE = "DISTANCE";
    private final String BLOCKRANGE = "BLOCKDISTANCE";
    private final String PLAYERS = "PLAYERS";
    private final String ANIMALS = "OTHERS";
    private final String TEAMS = "TEAMS";
    private final String ESP = "ESP";
    private final String WALLS = "WALLS";
    private final String INVISIBLES = "INVISIBLES";
    private final String MAX = "MAXAPS";
    private final String MIN = "MINAPS";
    private final String ROTATIONS = "ROTATIONS";
    private final String AUTOBLOCKMODE = "AUTOBLOCKMODE";
    private final String MODE = "MODE";
    private final String DEATH = "DEATH";
    private final String INTERACT = "INTERACT";
    private final String TICKBLOCK = "TICKBLOCK";
//pricTE 


    private Timer switchTimer = new Timer();
    public static float sYaw, sPitch, aacB;
    private double Fall;
    int[] Randoms = {0, 1, 0};
    private boolean isBlocking = false;
    public static boolean isSetup = false;
    private Timer newTarget = new Timer();
    private Timer lastStep = new Timer();
    private Timer rtimer = new Timer();
    private List<EntityLivingBase> Loaded = new CopyOnWriteArrayList<EntityLivingBase>();
    private int index, timer, crits, groundTicks;

}