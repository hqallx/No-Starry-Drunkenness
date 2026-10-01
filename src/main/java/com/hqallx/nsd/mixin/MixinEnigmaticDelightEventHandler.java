package com.hqallx.nsd.mixin;

import com.hqallx.nsd.NsdTargets;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/**
 * 阻止 Enigmatic Delicacy 在玩家食用天体果实后施加星辉酩酊。
 * <p>
 * Delicacy 的 {@code EnigmaticDelightEventHandler#onFoodFinish} 逻辑为：
 * 若食用物品属于 {@code enigmaticdelicacy:celestial_fruit_food} 标签（其中包含 {@code enigmaticlegacy:astral_fruit}），
 * 就按叠加规则施加/强化星辉酩酊。该方法内只有一处 {@code ItemStack#is(TagKey)} 调用，即标签判定本身，
 * 因此这里重定向该判定：食用天体果实时返回 false，直接跳过施加分支，
 * 同时保留该方法后半段「星辉调味瓶」的营养加成逻辑。
 */
@Pseudo
@Mixin(targets = "auviotre.enigmatic.delicacy.handlers.EnigmaticDelightEventHandler")
public abstract class MixinEnigmaticDelightEventHandler {

    @Redirect(
            method = "onFoodFinish",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/item/ItemStack;is(Lnet/minecraft/tags/TagKey;)Z"
            ),
            require = 1
    )
    private boolean nsd$skipAstralDrunkenness(ItemStack stack, TagKey<Item> tag) {
        if (NsdTargets.isAstralFruit(stack)) {
            return false;
        }
        return stack.is(tag);
    }
}