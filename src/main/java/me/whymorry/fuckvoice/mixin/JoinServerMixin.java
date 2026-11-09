package me.whymorry.fuckvoice.mixin;

import com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService;
import java.net.InetAddress;
import me.whymorry.fuckvoice.FuckVoice;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = YggdrasilMinecraftSessionService.class, remap = false)
public abstract class JoinServerMixin {

    @Redirect(
        method = "hasJoinedServer",
        at = @At(
            value = "INVOKE",
            target = "Ljava/net/InetAddress;getHostAddress()Ljava/lang/String;"
        ),
        remap = false
    )
    private String fuckvoice$fakeHostAddress(InetAddress address) {
        FuckVoice.LOGGER.debug(
            "[FuckVoice] Intercepted InetAddress.getHostAddress(), returning empty to bypass IP check"
        );
        return "";
    }
}
