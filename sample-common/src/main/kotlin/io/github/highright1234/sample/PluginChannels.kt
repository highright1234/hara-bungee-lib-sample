package io.github.highright1234.sample


/**
 * 플러그인 채널들을 나타냅니다
 * SubChannels 안에 있는 오브젝트들의 이름은
 * 바운드 되는곳을 향합니다
 */
object PluginChannels {
    const val CHANNEL = "sample:main"
    object SubChannels {
        /**
         * broadcast at receiving server
         * sender: any player
         * receiver: a server what you want to broadcast
         *
         * formats:
         * message: string
         */
        const val BROADCAST = "Broadcast"

        object Bukkit {
            // TODO
        }

        object Bungee {
            // TODO
        }
    }
}