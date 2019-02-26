package cd4017be.dimstack;

import cd4017be.lib.BlockItemRegistry;
import cd4017be.lib.ClientInputHandler;
import cd4017be.lib.render.SpecialModelLoader;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import static cd4017be.dimstack.Objects.*;

import cd4017be.dimstack.client.MenuHook;

/**
 * 
 * @author cd4017be
 */
public class ClientProxy extends CommonProxy {

	public MenuHook menuHook = new MenuHook();

	@Override
	public void init() {
		super.init();
		ClientInputHandler.init();
		
	}

	@Override
	public void registerRenderers() {
		super.registerRenderers();
		MinecraftForge.EVENT_BUS.register(menuHook);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent ev) {
		SpecialModelLoader.setMod(Main.ID);
		
		DIM_PIPE.setBlockLayer(BlockRenderLayer.CUTOUT);
		
		BlockItemRegistry.registerRender(PORTAL);
		BlockItemRegistry.registerRender(DIM_PIPE);
	}

}
