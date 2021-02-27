# Rust rcon in Java [![](https://jitpack.io/v/Katakurinna/rustrcon.svg)](https://jitpack.io/#Katakurinna/rustrcon)
## Rust rcon api in Java with Events 

`Use this api with jitpak`

You can add suggestions or send problems by creating an issue

## Currently finished

|Event|Description|Contains|
|---|---|---|
|PlayerChatEvent|Event when player speaks| channel, message, userid. username, color, time|
|PlayerDeathEvent|When player has died|player, reason, time|
|PlayerDisconnectEvent|When player has been disconnected| player, ip, reason, timestamp|
|PlayerJoinEvent|When player has been connected|player, ip, so system, timestamp|
|PlayerSpawnEvent| When player has been spawned|player, timestamp|
|PlayerDeathByEntityEvent|When player has been killed by entity| entity, player, reason, time|
|PlayerKillEntityEvent|When player kills entity|entity, player, time|
|PlayerDeathByPlayerEvent|When player kills another player|killer, murdered, reason, time|
|MessageReceiveEvent|All messages received from rust rcon|RustGenericMessage -> (message, identifier, type, stacktrace)|
|MobKilledByPlayerEvent|Event when player kills a mob| entity, player, time|
|PlayerDeathByMobEvent|Event when mob kills a player| entity, player, reason, time|
