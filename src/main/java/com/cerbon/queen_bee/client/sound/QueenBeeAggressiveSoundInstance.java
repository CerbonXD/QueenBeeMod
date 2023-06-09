package com.cerbon.queen_bee.client.sound;

import com.cerbon.queen_bee.entity.custom.QueenBeeEntity;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class QueenBeeAggressiveSoundInstance extends QueenBeeSoundInstance{
    public QueenBeeAggressiveSoundInstance(QueenBeeEntity queenBee) {
        super(queenBee, SoundEvents.BEE_LOOP_AGGRESSIVE, SoundSource.NEUTRAL);
        this.delay = 0;
    }

    @Override
    protected AbstractTickableSoundInstance getAlternativeSoundInstance() {
        return new QueenBeeFlyingSoundInstance(this.queenBee);
    }

    @Override
    protected boolean shouldSwitchSounds() {
        return !this.queenBee.isAngry();
    }
}
