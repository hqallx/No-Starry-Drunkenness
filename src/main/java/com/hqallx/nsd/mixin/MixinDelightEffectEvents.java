package com.hqallx.nsd.mixin;

import com.hqallx.nsd.NsdTargets;
import com.hqallx.nsd.RemovalBypass;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * 让 /removesd 能够真正移除星辉酩酊。
 * <p>
 * Enigmatic Delicacy 通过 {@code DelightEffectEvents#onEffectRemove}(HIGHEST) 与
 * {@code onEffectRemoveLow}(LOWEST, receiveCanceled) 取消 {@code MobEffectEvent.Remove}，
 * 使星辉酩酊免疫常规移除手段（包括牛奶）。
 * 当 {@link RemovalBypass} 被打开时，这里跳过这两个回调的执行，
 * 使原版移除流程得以继续，从而正确清理属性修饰符并同步到客户端。
 */
@Pseudo
@Mixin(targets = "auviotre.enigmatic.delicacy.registries.EnigmaticDelightEffects$DelightEffectEvents")
public abstract class MixinDelightEffectEvents {

    @Inject(
            method = {"onEffectRemove", "onEffectRemoveLow"},
            at = @At("HEAD"),
            cancellable = true,
            require = 1
    )
    private static void nsd$allowForcedRemoval(MobEffectEvent.Remove event, CallbackInfo ci) {
        if (RemovalBypass.isActive() && NsdTargets.isAstralDrunkenness(event.getEffect())) {
            ci.cancel();
        }
    }
}