package com.impact.util;

import appeng.api.AEApi;
import appeng.api.storage.data.IAEFluidStack;
import net.minecraftforge.fluids.*;

public class FluidUtil {

	public static IAEFluidStack createAEFluidStack(Fluid fluid) {
		return createAEFluidStack(new FluidStack(fluid,
				FluidContainerRegistry.BUCKET_VOLUME));
	}

	public static IAEFluidStack createAEFluidStack(Fluid fluid, long amount) {
		return createAEFluidStack(fluid.getID(), amount);
	}

	public static IAEFluidStack createAEFluidStack(FluidStack fluid) {
		return AEApi.instance().storage().createFluidStack(fluid);
	}

	public static IAEFluidStack createAEFluidStack(int fluidId, long amount) {
		return createAEFluidStack(new FluidStack(FluidRegistry.getFluid(fluidId), 1)).setStackSize(
				amount);
	}
}	