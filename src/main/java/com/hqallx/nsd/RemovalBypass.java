package com.hqallx.nsd;

/**
 * 强制移除星辉酩酊时的旁路开关。
 * <p>
 * Enigmatic Delicacy 会在 {@code MobEffectEvent.Remove} 中取消对星辉酩酊的移除请求，
 * 使常规的 {@code LivingEntity#removeEffect} 失效。执行本模组的移除命令时会短暂打开此开关，
 * 对应 mixin 在此期间跳过 Delicacy 的取消逻辑，从而复用原版的完整移除流程（属性修正清理 + 客户端同步）。
 * <p>
 * 命令在主线程执行，因此这里使用普通静态标记即可。
 */
public final class RemovalBypass {

    private static boolean active;

    private RemovalBypass() {
    }

    public static boolean isActive() {
        return active;
    }

    public static void begin() {
        active = true;
    }

    public static void end() {
        active = false;
    }
}