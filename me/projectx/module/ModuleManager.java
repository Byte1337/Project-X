package me.projectx.module;

import me.projectx.module.impl.movement.Sprint;
import me.projectx.module.impl.render.Fullbright;
import me.projectx.module.impl.render.hud;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    private List<Module> activatedModuleList;
    private List<Module> moduleList;

    public ModuleManager() {
        activatedModuleList = new ArrayList<Module>();
        moduleList = new ArrayList<Module>();

        // === MOVEMENT === //
        registerModule(new Sprint());

        // === RENDER === //
        registerModule(new Fullbright());

        // === NONE === //
        registerModule(new hud());

    }

    public List<Module> getActivatedModuleList() { return activatedModuleList; }
    public List<Module> getModuleList() { return moduleList; }

    public void registerActivatedModule(Module module) { activatedModuleList.add(module); }
    public void unregisterActivatedModule(Module module) { activatedModuleList.remove(module); }

    public void registerModule(Module module) { moduleList.add(module); }
    public void unregisterModule(Module module) { moduleList.remove(module); }

    public Module getModule(String modName) {
        return moduleList.stream().filter(module -> module.getName().equalsIgnoreCase(modName)).findFirst().orElse(null);
    }

}
