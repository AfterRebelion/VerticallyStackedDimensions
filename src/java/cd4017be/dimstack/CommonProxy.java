package cd4017be.dimstack;

import cd4017be.api.recipes.RecipeScriptContext;
import cd4017be.api.recipes.RecipeScriptContext.ConfigConstants;
import cd4017be.dimstack.worldgen.BedrockRemover;
import cd4017be.dimstack.worldgen.NetherTop;
import cd4017be.dimstack.worldgen.PortalGen;
import cd4017be.lib.TickRegistry;

/**
 * 
 * @author cd4017be
 */
public class CommonProxy {

	PortalGen worldgenPortal;
	BedrockRemover worldgenBedrock;
	NetherTop worldgenNether;

	public void init() {
		TickRegistry.register();
		
		worldgenPortal = new PortalGen();
		worldgenBedrock = new BedrockRemover();
		setConfig();
	}

	private void setConfig() {
		ConfigConstants cfg = new ConfigConstants(RecipeScriptContext.instance.modules.get(Main.ConfigName));
		Object[] arr = cfg.get("linked_dimensions", Object[].class, new Object[0]);
		for (Object o : arr)
			if (o instanceof double[]) {
				double[] vec = (double[])o;
				int[] dims = new int[vec.length];
				for (int i = 0; i < vec.length; i++)
					dims[i] = (int)vec[i];
				PortalConfiguration.link(dims);
			}
		if (cfg.get("gen_topNether", Boolean.class, false))
			worldgenNether = new NetherTop();
	}

	public void registerRenderers() {
	}

}
