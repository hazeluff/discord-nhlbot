# discord-nhlbot
# Fuck Messier

![NHLBot](https://cdn.discordapp.com/attachments/239331036364931073/239335602191990784/unknown.png)

## Add bot:

Develop: https://discordapp.com/oauth2/authorize?client_id=257345572162371588&scope=bot&permissions=93200
Production: https://discordapp.com/oauth2/authorize?client_id=257345858515894272&scope=bot&permissions=93200

### Permissions for bot

| Permission           | Hex        | Dec   |
|----------------------|------------|-------|
| MANAGE_CHANNELS      | 0x00000010 | 16    |
| READ_MESSAGES        | 0x00000400 | 1024  |
| SEND_MESSAGES        | 0x00000800 | 2048  |
| MANAGE_MESSAGES      | 0x00002000 | 8192  |
| EMBED_LINKS          | 0x00004000 | 16384 |
| READ_MESSAGE_HISTORY | 0x00010000 | 65636 |
| Combined             | 0x00016C10 | 93200 |

## Game Day Channel
- [x] Maintain two game channels. Remove old channels
- [x] Give warnings before the game starts (60/30/10 minutes before).
- [x] Display messages for when goals are scored.
- [x] Special messages for when canucks score.
- [ ] Bot messages during gameplay to cheer on team.

## Commands
`@NHLBot [command]`
- `fuckmessier` Fuck Messier.
- `nextgame` Replies with information about the next game.
- `about` Displays information about bot/author.
- `help` Display list of commands.

### In 'Game Day Channels' only
- `score` Displays score of that game.
- `goals` Displays goals of that game.