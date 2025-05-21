package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Package.AdvancementGivingPackage;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import com.Harbinger.Spore.Sentities.BaseEntities.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Sentities.Utility.Illusion;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ScannerItem extends BaseItem2 {
    public ScannerItem(Properties properties) {
        super(properties);
    }


    public int getUseDuration(ItemStack p_43419_) {
        return 72000;
    }


    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack tool = player.getItemInHand(hand);
        if (!level.isClientSide) {
            LivingEntity victim = getScannedEntity(player, level);
            if (victim != null) {
                player.playNotifySound(Ssounds.SCANNER_MOB.get(), SoundSource.AMBIENT,1F,1F);
                showInfo(tool, victim, player);
            }else {
                player.playNotifySound(Ssounds.SCANNER_EMPTY.get(), SoundSource.AMBIENT,1F,1F);
            }
            player.getCooldowns().addCooldown(this, 20);
        }
        return InteractionResultHolder.success(tool);
    }

    @Nullable
    public LivingEntity getScannedEntity(Player player, Level level) {
        AABB hitbox1 = getScannerHitBox(player, 32f);
        List<Entity> list = level.getEntities(player, hitbox1, entity -> {
            return entity instanceof LivingEntity;
        });
        Iterator<Entity> var5 = list.iterator();
        double value = Double.MAX_VALUE;
        LivingEntity entity = null;
        while (var5.hasNext()) {
            LivingEntity $$3 = (LivingEntity) var5.next();
            if (player.distanceToSqr($$3) < value) {
                entity = $$3;
                value = player.distanceToSqr($$3);
            }
        }
        return entity;
    }

    @Nullable
    public AABB getScannerHitBox(Player player, double range) {
        Vec3 lookVec = player.getLookAngle();
        Vec3 endVec = player.position().add(lookVec.scale(range));
        return new AABB(player.position(), endVec).inflate(1);
    }

    public void showInfo(ItemStack stack, LivingEntity entity, Player player) {
        if (!(stack.getItem() instanceof ScannerItem)) return;

        ItemStack offhand = player.getOffhandItem();
        boolean writeToBook = offhand.is(Items.WRITABLE_BOOK);

        List<String> lines = new ArrayList<>();

        if (entity instanceof Illusion) {
            sendScanMessage(player, lines, "spore.scanner.line.15");
            return;
        }
        entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 40));
        String name = entity.getCustomName() != null ? entity.getCustomName().getString() : Component.translatable("spore.scanner.line.1").getString();

        lines.add("------------------");
        lines.add(Component.translatable("spore.scanner.line.2").getString() + name);
        lines.add(Component.translatable("spore.scanner.line.3").getString() + Component.translatable(entity.getType().getDescriptionId()).getString());
        lines.add(Component.translatable("spore.scanner.line.4").getString() + entity.getHealth() + "/" + entity.getMaxHealth());

        addExtraInfo(entity, lines);

        String danger = showThreatLevel(entity);
        if (danger != null) {
            lines.add("------------------");
            lines.add(Component.translatable("spore.scanner.line.5").getString() + Component.translatable(danger).getString());
        }

        addDrops(entity, lines);

        if (writeToBook) {
            writeLinesToBook(offhand, lines);
        } else {
            for (String line : lines) {
                player.displayClientMessage(Component.literal(line), false);
            }
        }
    }

    public String showThreatLevel(LivingEntity living) {
        if (living instanceof Calamity) {
            return "spore.scanner.danger.calamity";
        }
        if (living instanceof Hyper) {
            return "spore.scanner.danger.hyper";
        }
        if (living instanceof EvolvedInfected) {
            return "spore.scanner.danger.evolved";
        }
        if (living instanceof Experiment) {
            return "spore.scanner.danger.experiment";
        }
        if (living instanceof Infected) {
            return "spore.scanner.danger.infected";
        }
        if (living instanceof Organoid) {
            return "spore.scanner.danger.organoid";
        }
        if (living instanceof UtilityEntity) {
            return "spore.scanner.danger.utility";
        }
        return null;
    }

    private void sendScanMessage(Player player, List<String> lines, String key) {
        String msg = Component.translatable(key).getString();
        lines.add(msg);
        player.displayClientMessage(Component.literal(msg), false);
    }

    private void addExtraInfo(LivingEntity entity, List<String> lines) {
        if (entity instanceof Infected infected) {
            lines.add(Component.translatable("spore.scanner.line.6").getString() + infected.getKills());
            lines.add(Component.translatable("spore.scanner.line.7").getString() + infected.getEvoPoints());
            if (infected.getEvolutionCoolDown() > 0) {
                lines.add(Component.translatable("spore.scanner.line.8").getString() + infected.getEvolutionCoolDown() + "/" + SConfig.SERVER.evolution_age_human.get());
            }
            if (infected.getHunger() > 0) {
                lines.add(Component.translatable("spore.scanner.line.9").getString() + infected.getHunger() + "/" + SConfig.SERVER.hunger.get());
            }
            lines.add(Component.translatable("spore.scanner.line.10").getString() + infected.getLinked());
            if (infected.getMutation() != null) {
                lines.add(Component.translatable(infected.getMutation()).getString());
            }
            if (infected instanceof Scamper scamper) {
                lines.add(Component.translatable("spore.scanner.line.scamper").getString() + scamper.getAge() + "/" + SConfig.SERVER.scamper_age.get());
            }
        }
    }

    private void addDrops(LivingEntity living, List<String> lines) {
        List<? extends String> itemDrops = null;
        if (living instanceof Infected infected) {
            itemDrops = infected.getDropList();
        } else if (living instanceof UtilityEntity utilityEntity) {
            itemDrops = utilityEntity.getDropList();
        }

        if (itemDrops == null || itemDrops.isEmpty()) {
            lines.add(Component.translatable("spore.scanner.line.13").getString());
        } else {
            lines.add("------------------");
            lines.add(Component.translatable("spore.scanner.line.14").getString());
            for (String string : itemDrops) {
                String[] split = string.split("\\|");
                Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(split[0]));
                if (item != null) {
                    lines.add(Component.translatable(item.getDescriptionId()).getString());
                }
            }
        }
    }

    private void writeLinesToBook(ItemStack bookStack, List<String> lines) {
        var nbt = bookStack.getOrCreateTag();
        var nbtPages = nbt.contains("pages", 9) ? nbt.getList("pages", 8) : new net.minecraft.nbt.ListTag(); // 8 = StringTag

        List<String> pages = new ArrayList<>();
        for (int i = 0; i < nbtPages.size(); i++) {
            pages.add(nbtPages.getString(i));
        }

        StringBuilder lastPage = pages.isEmpty() ? new StringBuilder() : new StringBuilder(pages.remove(pages.size() - 1));

        for (String line : lines) {
            if (lastPage.length() + line.length() + 1 > 256) {
                pages.add(lastPage.toString());
                lastPage = new StringBuilder();
            }
            lastPage.append(line).append("\n");
        }

        if (!lastPage.isEmpty()) {
            pages.add(lastPage.toString());
        }
        if (pages.size() > 50) {
            pages = pages.subList(pages.size() - 50, pages.size());
        }

        net.minecraft.nbt.ListTag newPagesTag = new net.minecraft.nbt.ListTag();
        for (String pageContent : pages) {
            newPagesTag.add(net.minecraft.nbt.StringTag.valueOf(pageContent));
        }

        nbt.put("pages", newPagesTag);
    }

    @Override
    public boolean overrideStackedOnOther(@NotNull ItemStack stack, Slot slot, @NotNull ClickAction clickAction, @NotNull Player player) {
        ItemStack itemStack = slot.getItem();
        if (itemStack.getItem() instanceof OrganItem organItem && clickAction == ClickAction.SECONDARY) {
            player.playNotifySound(Ssounds.SCANNER_ITEM.get(), SoundSource.AMBIENT,1F,1F);
            SporePacketHandler.sendToServer(new AdvancementGivingPackage(organItem.getAdvancementIds(),player.getId()));
            return true;
        }
        return false;
    }

}