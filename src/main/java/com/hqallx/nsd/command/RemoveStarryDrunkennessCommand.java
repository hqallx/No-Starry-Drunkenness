package com.hqallx.nsd.command;

import com.hqallx.nsd.NsdTargets;
import com.hqallx.nsd.RemovalBypass;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import java.util.Collection;
import java.util.List;

/**
 * {@code /removesd}：完全移除目标身上的星辉酩酊。
 */
public final class RemoveStarryDrunkennessCommand {

    private RemoveStarryDrunkennessCommand() {
    }

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("removesd")
                        .requires(source -> source.hasPermission(2))
                        .executes(ctx -> remove(ctx, List.of(ctx.getSource().getPlayerOrException())))
                        .then(Commands.argument("targets", EntityArgument.entities())
                                .executes(ctx -> remove(ctx, EntityArgument.getEntities(ctx, "targets")))));
    }

    private static int remove(CommandContext<CommandSourceStack> ctx, Collection<? extends Entity> targets) {
        MobEffect effect = NsdTargets.astralDrunkenness();
        if (effect == null) {
            ctx.getSource().sendFailure(Component.translatable("commands.nsd.removesd.missing"));
            return 0;
        }

        int removed = 0;
        for (Entity entity : targets) {
            if (!(entity instanceof LivingEntity living) || !living.hasEffect(effect)) {
                continue;
            }
            RemovalBypass.begin();
            try {
                living.removeEffect(effect);
            } finally {
                RemovalBypass.end();
            }
            removed++;
        }

        if (removed == 0) {
            ctx.getSource().sendFailure(Component.translatable("commands.nsd.removesd.none"));
            return 0;
        }

        final int count = removed;
        ctx.getSource().sendSuccess(() -> Component.translatable("commands.nsd.removesd.success", count), true);
        return count;
    }
}