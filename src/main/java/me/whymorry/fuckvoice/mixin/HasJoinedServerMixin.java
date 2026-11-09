package me.whymorry.fuckvoice.mixin;

import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import java.net.InetAddress;
import java.util.HashMap;
import me.whymorry.fuckvoice.FuckVoice;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = YggdrasilMinecraftSessionService.class, remap = false)
public abstract class HasJoinedServerMixin {

    @Redirect(
        method = "hasJoinedServer",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/HashMap;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;",
            ordinal = 2
        ),
        remap = false
    )
    private Object fuckvoice$skipIpParam(
        HashMap<Object, Object> map,
        Object key,
        Object value
    ) {
        FuckVoice.LOGGER.debug(
            "[FuckVoice] Suppressed '{}' param in hasJoinedServer (was: {})",
            key,
            value
        );

        return null;
    }
}
