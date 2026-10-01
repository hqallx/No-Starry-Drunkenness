package com.hqallx.nsd;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * 统一的注册名常量与查询工具。
 * <p>
 * 全部通过注册表名字符串查找，因此本模组无需在编译期依赖 Enigmatic Legacy 或 Enigmatic Delicacy，
 * 在缺少这两个模组时依旧可以正常加载。
 */
public final class NsdTargets {

    /** Enigmatic Legacy 的天体果实。 */
    public static final ResourceLocation ASTRAL_FRUIT = new ResourceLocation("enigmaticlegacy", "astral_fruit");

    /** Enigmatic Delicacy 的星辉酩酊效果。 */
    public static final ResourceLocation ASTRAL_DRUNKENNESS = new ResourceLocation("enigmaticdelicacy", "astral_drunkenness");

    private NsdTargets() {
    }

    /** 判断物品是否是天体果实。 */
    public static boolean isAstralFruit(ItemStack stack) {
        return !stack.isEmpty() && ASTRAL_FRUIT.equals(BuiltInRegistries.ITEM.getKey(stack.getItem()));
    }

    /** 判断效果是否是星辉酩酊。 */
    public static boolean isAstralDrunkenness(@Nullable MobEffect effect) {
        return effect != null && ASTRAL_DRUNKENNESS.equals(BuiltInRegistries.MOB_EFFECT.getKey(effect));
    }

    /** 获取星辉酩酊效果实例，未安装 Enigmatic Delicacy 时返回 null。 */
    @Nullable
    public static MobEffect astralDrunkenness() {
        return BuiltInRegistries.MOB_EFFECT.get(ASTRAL_DRUNKENNESS);
    }
}