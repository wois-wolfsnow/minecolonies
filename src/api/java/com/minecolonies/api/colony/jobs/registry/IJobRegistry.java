package com.minecolonies.api.colony.jobs.registry;

import com.minecolonies.api.IMinecoloniesAPI;
import com.minecolonies.api.colony.ICitizenData;
import com.minecolonies.api.colony.jobs.IJob;
import net.minecraft.nbt.CompoundNBT;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;

public interface IJobRegistry
{
    static IJobRegistry getInstance()
    {
        return IMinecoloniesAPI.getInstance().getJobRegistry();
    }

    /**
     * Add a given Job mapping.
     *
     * @param name        name of job class.
     * @param jobFunction class of job.
     */
    void registerNewJobMapping(String name, @NotNull Class<?> jobClass, @NotNull Function<ICitizenData, IJob<?>> jobFunction);

    /**
     * Create a Job from saved CompoundNBT data.
     *
     * @param citizen  The citizen that owns the Job.
     * @param compound The CompoundNBT containing the saved Job data.
     * @return New Job created from the data, or null.
     */
    @Nullable
    IJob createFromNBT(ICitizenData citizen, @NotNull CompoundNBT compound);

    @NotNull
    Map<Class<?>, String> getClassToNameMap();
}